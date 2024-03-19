package project.expenses_tracking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import project.expenses_tracking.model.Transaction;
import project.expenses_tracking.service.TransactionServiceImpl;

import java.time.LocalDate;
import java.time.YearMonth;
import java.util.List;

@RestController
@RequestMapping("/transaction")
public class TransactionController {
    private final TransactionServiceImpl service;
    @Autowired
    public TransactionController(TransactionServiceImpl service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Transaction>> getAllTransactions(@RequestHeader("USER_ID") String user_id) {
        List<Transaction> found = service.readAll(user_id);
        return (found == null || found.isEmpty())
                ? new ResponseEntity<>(HttpStatus.NOT_FOUND)
                : new ResponseEntity<>(found, HttpStatus.OK);
    }

    @GetMapping("/month")
    public ResponseEntity<List<Transaction>> getThisMonth(@RequestHeader("USER_ID") String user_id) {
        List<Transaction> found = service.readTimeBracket(user_id, YearMonth.now().atDay(1), LocalDate.now());
        return (found == null || found.isEmpty())
                ? new ResponseEntity<>(HttpStatus.NOT_FOUND)
                : new ResponseEntity<>(found, HttpStatus.OK);
    }
}
