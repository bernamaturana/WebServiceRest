package cl.kvz.pruebaBSI.ServicioRest;

import org.springframework.data.jpa.repository.JpaRepository;

interface ITransactionRespository extends JpaRepository<Transaction, Long>{

}