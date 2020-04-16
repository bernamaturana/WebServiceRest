package cl.kvz.pruebaBSI.ServicioRest;

// import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

// @Data
@Entity
public class Transaction {

  private @Id @GeneratedValue Long id;
  private long primaryAccountNumber;
  private int cvv2;
  private int expirationDate;

  Transaction() {
  }

  Transaction(long primaryAccountNumber, int cvv2, int expirationDate) {
    this.primaryAccountNumber = primaryAccountNumber;
    this.cvv2 = cvv2;
    this.expirationDate = expirationDate;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public long getPrimaryAccountNumber() {
    return primaryAccountNumber;
  }

  public void setPrimaryAccountNumber(long primaryAccountNumber) {
    this.primaryAccountNumber = primaryAccountNumber;
  }

  public int getCvv2() {
    return cvv2;
  }

  public void setCvv2(int cvv2) {
    this.cvv2 = cvv2;
  }

  public int getExpirationDate() {
    return expirationDate;
  }

  public void setExpirationDate(int expirationDate) {
    this.expirationDate = expirationDate;
  }

}