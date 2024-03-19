package project.expenses_tracking.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import project.expenses_tracking.model.Transaction;
import project.expenses_tracking.repository.TransactionRepository;

import java.time.LocalDate;
import java.util.List;

@Service
public class TransactionServiceImpl implements TransactionService{
    private final TransactionRepository transactionRepository;
    @Autowired
    public TransactionServiceImpl(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    @Override
    @Cacheable(value = "all_transaction_cache", key = "user_id")
    public List<Transaction> readAll(String user_id) {
        return transactionRepository.findAllByUserId(user_id);
    }

    @Override
    public List<Transaction> readTimeBracket(String user_id, LocalDate from, LocalDate to) {
        return transactionRepository.findAllByTimeBracket(user_id, from, to);
    }
}
