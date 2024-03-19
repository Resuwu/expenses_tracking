package project.expenses_tracking.service;

import project.expenses_tracking.model.Account;

import java.util.List;

public interface AccountService {
    List<Account> readAll(String user_id);
}
