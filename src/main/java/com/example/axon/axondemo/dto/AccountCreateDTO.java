package com.example.axon.axondemo.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AccountCreateDTO {
    private double startingBalance;
    private String currency;
}
