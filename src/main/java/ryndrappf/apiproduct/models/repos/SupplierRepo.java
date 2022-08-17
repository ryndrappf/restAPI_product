package ryndrappf.apiproduct.models.repos;

import org.springframework.data.repository.CrudRepository;
import ryndrappf.apiproduct.models.entities.Supplier;

import java.util.List;

public interface SupplierRepo extends CrudRepository<Supplier, Long> {

    Supplier findByEmail(String email);

    List<Supplier> findByNameContainsOrderByIdDesc(String name);

    public List<Supplier> findByNameStartingWith(String prefix);

    List<Supplier> findByNameContainsOrEmailContains(String name, String email);
}
