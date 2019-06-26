package com.example.axon.axondemo.service;

import com.example.axon.axondemo.dto.AccountCreateDTO;
import com.example.axon.axondemo.dto.MoneyCreditDTO;
import com.example.axon.axondemo.dto.MoneyDebitDTO;

import java.util.concurrent.CompletableFuture;

public interface AccountCommandService {

    CompletableFuture<String> createAccount(AccountCreateDTO accountCreateDTO);

    CompletableFuture<String> creditMoneyToAccount(String accountNumber, MoneyCreditDTO moneyCreditDTO);

    CompletableFuture<String> debitMoneyFromAccount(String accountNumber, MoneyDebitDTO moneyDebitDTO);
}
