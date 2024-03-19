package project.expenses_tracking.service;

import project.expenses_tracking.model.Category;

import java.util.List;

public interface CategoryService {
    List<Category> readAll();
}
