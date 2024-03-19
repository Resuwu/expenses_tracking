package project.expenses_tracking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import project.expenses_tracking.model.Category;
import project.expenses_tracking.service.CategoryServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {
    private final CategoryServiceImpl service;
    @Autowired
    public CategoryController(CategoryServiceImpl service) {
        this.service = service;
    }
    @GetMapping
    public ResponseEntity<List<Category>> getCategories() {
        List<Category> found = service.readAll();
        return (found == null || found.isEmpty())
                ? new ResponseEntity<>(HttpStatus.NOT_FOUND)
                : new ResponseEntity<>(found, HttpStatus.OK);
    }
}
