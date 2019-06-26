package com.example.axon.axondemo.service;

import com.example.axon.axondemo.command.CreateAccountCommand;
import com.example.axon.axondemo.command.CreditMoneyCommand;
import com.example.axon.axondemo.command.DebitMoneyCommand;
import com.example.axon.axondemo.dto.AccountCreateDTO;
import com.example.axon.axondemo.dto.MoneyCreditDTO;
import com.example.axon.axondemo.dto.MoneyDebitDTO;
import lombok.AllArgsConstructor;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;

@Service
@AllArgsConstructor
public class AccountCommandServiceImpl implements AccountCommandService {

    @Autowired
    private final CommandGateway commandGateway;

    @Override
    public CompletableFuture<String> createAccount(AccountCreateDTO accountCreateDTO) {
        return commandGateway.send(new CreateAccountCommand(
            UUID.randomUUID().toString(), accountCreateDTO.getStartingBalance(), accountCreateDTO.getCurrency()
        ));
    }

    @Override
    public CompletableFuture<String> creditMoneyToAccount(String accountNumber, MoneyCreditDTO moneyCreditDTO) {
        return commandGateway.send(new CreditMoneyCommand(
            accountNumber, moneyCreditDTO.getCreditAmount(), moneyCreditDTO.getCurrency()
        ));
    }

    @Override
    public CompletableFuture<String> debitMoneyFromAccount(String accountNumber, MoneyDebitDTO moneyDebitDTO) {
        return commandGateway.send(new DebitMoneyCommand(
            accountNumber, moneyDebitDTO.getDebitAmount(), moneyDebitDTO.getCurrency()
        ));
    }
}
