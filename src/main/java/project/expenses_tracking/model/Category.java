package project.expenses_tracking.model;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Document
public class Category {
    @Id
    String name;
    String type;
    Category(@NonNull String name, @NonNull String type) {
        this.name = name;
        this.type = type;
    }
}
