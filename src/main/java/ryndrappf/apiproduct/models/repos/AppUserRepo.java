package ryndrappf.apiproduct.models.repos;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import ryndrappf.apiproduct.models.entities.AppUser;
import ryndrappf.apiproduct.models.entities.AppUserRole;

import java.util.Optional;

public interface AppUserRepo extends PagingAndSortingRepository<AppUser, Long> {


    Optional<AppUser> findByEmail(String email);

}
