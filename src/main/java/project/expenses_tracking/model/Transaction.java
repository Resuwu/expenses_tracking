package project.expenses_tracking.model;

import jdk.jshell.Snippet;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Getter
@Setter
@Document
public class Transaction {
    @Id
    private String id;
    private String user_id;
    private Double value;
    private String account_id;
    private Category category;
    private String status;
    private LocalDate date;
    Transaction(@NonNull String user_id, @NonNull Double value, @NonNull String account_id, @NonNull Category category, @NonNull String status, @NonNull LocalDate date) {
        this.user_id = user_id;
        this.value = value;
        this.account_id = account_id;
        this.category = category;
        this.status = status;
        this.date = date;
    }
}
