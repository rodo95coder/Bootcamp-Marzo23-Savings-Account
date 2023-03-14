package com.bootcamp.savingsaccount.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Slf4j
@Document(collection = "savingsAccount")
public class SavingsAccount {

  @Id
  private String id = UUID.randomUUID().toString();
  private String accountType; //tipo de cuenta
  private String customerType; //tipo de cliente
  private String accountNumber; //numero de cuenta
  private Float accountingBalance; //saldo contable
  private Integer maintenance; //comision de mantenimiento
  private Integer movementLimit; //limite de movimientos

}
