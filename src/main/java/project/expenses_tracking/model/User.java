package project.expenses_tracking.model;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Setter
@Getter
@Document
public class User {
    @Id
    private String id;
    private String name;
    User(@NonNull String name) { this.name = name; };
}
