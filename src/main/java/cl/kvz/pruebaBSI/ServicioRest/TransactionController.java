package cl.kvz.pruebaBSI.ServicioRest;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
class TransactionController {

    private final ITransactionRespository repository;

    TransactionController(ITransactionRespository repository) {
        this.repository = repository;
    }

    // Aggregate root

    @GetMapping("/transactions")
    List<Transaction> all() {
        return repository.findAll();
    }

    @PostMapping("/transactions")
    Transaction newTransaction(@RequestBody Transaction newTransaction) {
        return repository.save(newTransaction);
    }

    // Single item

    @GetMapping("/transactions/{id}")
    Transaction one(@PathVariable Long id) {
        try {
            return repository.findById(id).orElseThrow(() -> new Exception("Transaccion" + id + " no encontrada."));
        } catch (Exception e) {
            // e.printStackTrace();
            return null;
        }
    }

    @PutMapping("/transactions/{id}")
    Transaction replaceTransaction(@RequestBody Transaction newTransaction, @PathVariable Long id) {

        return repository.findById(id).map(Transaction -> {
            Transaction.setPrimaryAccountNumber(newTransaction.getPrimaryAccountNumber());
            Transaction.setExpirationDate(newTransaction.getExpirationDate());
            Transaction.setCvv2(newTransaction.getCvv2());
            return repository.save(Transaction);
        }).orElseGet(() -> {
            newTransaction.setId(id);
            return repository.save(newTransaction);
        });
    }

    @DeleteMapping("/transactions/{id}")
    void deleteTransaction(@PathVariable Long id) {
        repository.deleteById(id);
    }
}