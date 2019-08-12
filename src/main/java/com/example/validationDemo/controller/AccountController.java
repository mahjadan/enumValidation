package com.example.validationDemo.controller;

import com.example.validationDemo.domain.Account;
import com.example.validationDemo.domain.AccountRequestBody;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class AccountController {

    @PostMapping(value = "/account" , consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Account> createAccount(@Valid @RequestBody AccountRequestBody body ){

        Account account = body.toDomaion();

        return new ResponseEntity<>(account ,HttpStatus.CREATED);
    }

}
