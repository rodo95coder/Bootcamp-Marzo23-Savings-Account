package com.bootcamp.savingsaccount.service;


import com.bootcamp.savingsaccount.model.SavingsAccount;

import java.util.List;
import java.util.Optional;

public interface SavingsAccountService {

  List<SavingsAccount> findAll();

  Optional<SavingsAccount> findById(String id);

  Optional<SavingsAccount> save(SavingsAccount savingsAccount);


}
