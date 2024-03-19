package project.expenses_tracking.model;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Document
public class Account {
    @Id
    String id;
    String user_id;
    String name;
    Double balance;
    Account(@NonNull String user_id, @NonNull String name, @NonNull Double balance) {
        this.user_id = user_id;
        this.name = name;
        this.balance = balance;
    }
}
