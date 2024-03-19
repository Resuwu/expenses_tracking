package project.expenses_tracking.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import project.expenses_tracking.model.Category;

public interface CategoryRepository extends MongoRepository<Category, String> {}