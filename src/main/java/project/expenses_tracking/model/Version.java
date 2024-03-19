package project.expenses_tracking.model;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Document
public class Version {
    @Id
    String id;
    String version;
    Version(@NonNull String version) { this.version = version; }
}
