package com.bootcamp.savingsaccount.repository;

import com.bootcamp.savingsaccount.model.SavingsAccount;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface SavingsAccountRepository
    extends MongoRepository<SavingsAccount,String> {

    SavingsAccount findSavingsAccountByAccountNumberAndCustomerType(String accountNumber, String customerType);

}
