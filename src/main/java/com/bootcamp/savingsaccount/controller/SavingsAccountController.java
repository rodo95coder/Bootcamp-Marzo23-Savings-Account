package com.bootcamp.savingsaccount.controller;

import com.bootcamp.savingsaccount.exceptions.GeneralException;
import com.bootcamp.savingsaccount.model.SavingsAccount;
import com.bootcamp.savingsaccount.model.dto.GlobalResponse;
import com.bootcamp.savingsaccount.service.SavingsAccountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/v1")
@Slf4j
public class SavingsAccountController {

    @Autowired
    private SavingsAccountService savingsAccountService;

    @GetMapping("/findAll")
    public List<SavingsAccount> findAll() {
        log.info("All savings account were consulted");

        return savingsAccountService.findAll();
    }

    @GetMapping("/findById/{id}")
    public Optional<SavingsAccount> findById(@PathVariable("id") String id) {
        log.info("Savings account consulted by id " + id);
        return savingsAccountService.findById(id);

    }

    @PostMapping("/save")
    public ResponseEntity<GlobalResponse> save(@RequestBody SavingsAccount savingsAccount) {
        log.info("A savings account was created");
        try {
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(GlobalResponse.builder()
                            .data(savingsAccountService.save(savingsAccount)
                                    .get()).message("Registrado con exito")
                            .build());

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(GlobalResponse.builder()
                            .data(GeneralException.builder()
                                    .message(e.getMessage())
                                    .build())
                            .build());
        }
    }


}
