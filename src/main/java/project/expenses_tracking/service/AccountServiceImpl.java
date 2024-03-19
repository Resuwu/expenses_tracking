package project.expenses_tracking.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.expenses_tracking.model.Account;
import project.expenses_tracking.repository.AccountRepository;

import java.util.List;

@Service
public class AccountServiceImpl implements AccountService{
    private final AccountRepository accountRepository;
    @Autowired
    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public List<Account> readAll(String user_id) {
        return accountRepository.findAllByUserId(user_id);
    }
}