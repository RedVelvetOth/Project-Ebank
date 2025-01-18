package com.example.projectebank.sevices;

import com.example.projectebank.entities.BankAccount;
import com.example.projectebank.entities.CurrentAccount;
import com.example.projectebank.entities.SavingAccount;
import com.example.projectebank.repositories.BankAccountRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.function.Supplier;
import java.util.logging.Logger;

@Service
@Transactional
public class BankService {
    @Autowired
    private BankAccountRepository bankAccountRepository;
    Logger logger = Logger.getLogger(BankService.class.getName());
    public void consulter(){
        BankAccount bankAccount =
                bankAccountRepository.findById("1bffc836-8bd0-47b5-9dbe-0851c1e8007a").orElse(null);
        if (bankAccount == null) {
            logger.info("****************");
            logger.info(bankAccount.getId());
            logger.info(String.valueOf(bankAccount.getBalance()));
            logger.info(String.valueOf(bankAccount.getStatus()));
            logger.info((Supplier<String>) bankAccount.getCreateAcc());
            logger.info(bankAccount.getClient().getName());
            logger.info(bankAccount.getClass().getSimpleName());
            if (bankAccount instanceof CurrentAccount){
                logger.info("This is a current Account");
                logger.info("Overdraft is: " + ((CurrentAccount) bankAccount).getOverDraft());
            } else if (bankAccount instanceof SavingAccount){
                logger.info("This is a savings account");
                logger.info("Interest Rate is: " + ((SavingAccount) bankAccount).getInterestRate());
            }
        }
        bankAccount.getAccountOperations().forEach(op -> {
            logger.info("****************");
            logger.info(String.valueOf(op.getType()));
            logger.info(String.valueOf(op.getAmount()));
            logger.info((Supplier<String>) op.getOperationDate());
        });
    }
}
