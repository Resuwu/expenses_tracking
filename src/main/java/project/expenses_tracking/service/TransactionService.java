package project.expenses_tracking.service;

import project.expenses_tracking.model.Account;
import project.expenses_tracking.model.Transaction;

import java.time.LocalDate;
import java.util.List;

public interface TransactionService {
    List<Transaction> readAll(String user_id);
    List<Transaction> readTimeBracket(String user_id, LocalDate from, LocalDate to);
}
