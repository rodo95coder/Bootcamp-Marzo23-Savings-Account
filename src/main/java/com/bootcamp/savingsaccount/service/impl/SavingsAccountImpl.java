package com.bootcamp.savingsaccount.service.impl;

import com.bootcamp.savingsaccount.model.SavingsAccount;
import com.bootcamp.savingsaccount.repository.SavingsAccountRepository;
import com.bootcamp.savingsaccount.service.SavingsAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.List;
import java.util.Optional;

@Service
public class SavingsAccountImpl implements SavingsAccountService {
    @Autowired
    SavingsAccountRepository savingsAccountRepository;

    @Override
    public List<SavingsAccount> findAll() {
        return savingsAccountRepository.findAll();
    }

    @Override
    public Optional<SavingsAccount> findById(String id) {
        return savingsAccountRepository.findById(id);
    }

    @Override
    public Optional<SavingsAccount> save(SavingsAccount savingsAccount) {
        //Un cliente personal solo puede tener un máximo de una cuenta de ahorro, una cuenta corriente o cuentas a plazo fijo.
        //Un cliente empresarial no puede tener una cuenta de ahorro o de plazo fijo, pero sí múltiples cuentas corrientes.

        SavingsAccount savingsAccount1 = savingsAccountRepository.findSavingsAccountByAccountNumberAndCustomerType(savingsAccount.getAccountNumber(), savingsAccount.getCustomerType());

        if (!ObjectUtils.isEmpty(savingsAccount1) && savingsAccount1.getCustomerType().equals("PERSONAL")) {
            throw new RuntimeException("No se puede realizar el registro, ya existe una cuenta de ahorros para el cliente personal!");
        } else if (savingsAccount.getCustomerType().equals("EMPRESARIAL") && (savingsAccount.getAccountType().equals("SA") || savingsAccount.getAccountType().equals("FTA"))) {
            throw new RuntimeException("Un cliente empresarial no puede tener una cuenta de ahorro o de plazo fijo!");
        } else {
            return Optional.of(this.savingsAccountRepository.save(savingsAccount));
        }
    }

}
