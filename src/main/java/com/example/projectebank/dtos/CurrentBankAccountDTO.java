package com.example.projectebank.dtos;


import com.example.projectebank.enums.AccountStatus;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

@EqualsAndHashCode(callSuper = true)
@Data
public class CurrentBankAccountDTO extends BankAccountDTO{
    private String id;
    private double balance;
    private Date createAcc;
    private AccountStatus status;
    private ClientDTO clientDTO;
    private double overDraft;
}
