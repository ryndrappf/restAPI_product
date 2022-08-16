package ryndrappf.apiproduct.models.repos;

import org.springframework.data.repository.CrudRepository;
import ryndrappf.apiproduct.models.entities.Category;

public interface CategoryRepo extends CrudRepository<Category, Long> {
}
