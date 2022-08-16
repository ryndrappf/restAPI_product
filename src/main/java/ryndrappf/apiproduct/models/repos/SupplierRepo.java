package ryndrappf.apiproduct.models.repos;

import org.springframework.data.repository.CrudRepository;
import ryndrappf.apiproduct.models.entities.Supplier;

public interface SupplierRepo extends CrudRepository<Supplier, Long> {
}
