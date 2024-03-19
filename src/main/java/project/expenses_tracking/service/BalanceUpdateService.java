package project.expenses_tracking.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import project.expenses_tracking.model.Account;
import project.expenses_tracking.model.Transaction;
import project.expenses_tracking.repository.AccountRepository;
import project.expenses_tracking.repository.TransactionRepository;

import java.util.List;

@Service
public class BalanceUpdateService {
    private final AccountRepository accountRepository;
    private final TransactionRepository transactionRepository;
    @Autowired
    public BalanceUpdateService(AccountRepository accountRepository, TransactionRepository transactionRepository) {
        this.accountRepository = accountRepository;
        this.transactionRepository = transactionRepository;
    }
    @Async
    @Scheduled(cron = "0 * * * * *")
    protected void balanceUpdate() {
        List<Account> accounts = accountRepository.findAll();
        for (Account current : accounts) {
            Double balance = current.getBalance();
            List<Transaction> transactions = transactionRepository.findAllByAccountId(current.getId());
            for (Transaction transaction : transactions) {
                balance += transaction.getValue();
            }
            current.setBalance(balance);
            accountRepository.save(current);
        }
    }
}
