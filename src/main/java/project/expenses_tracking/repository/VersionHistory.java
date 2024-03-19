package project.expenses_tracking.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import project.expenses_tracking.model.Version;

public interface VersionHistory extends MongoRepository<Version, String> {
    Version findFirstByOrderByIdDesc();
}
