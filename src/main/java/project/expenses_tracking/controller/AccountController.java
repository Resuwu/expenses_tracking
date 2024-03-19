package project.expenses_tracking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import project.expenses_tracking.model.Account;
import project.expenses_tracking.service.AccountServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/account")
public class AccountController {
    private final AccountServiceImpl service;
    @Autowired
    public AccountController(AccountServiceImpl service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Account>> getAccounts(@RequestHeader("USER_ID") String user_id) {
        List<Account> found = service.readAll(user_id);
        return (found == null || found.isEmpty())
                ? new ResponseEntity<>(HttpStatus.NOT_FOUND)
                : new ResponseEntity<>(found, HttpStatus.OK);
    }
}
