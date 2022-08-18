package ryndrappf.apiproduct.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import ryndrappf.apiproduct.models.entities.AppUser;
import ryndrappf.apiproduct.models.repos.AppUserRepo;
import ryndrappf.apiproduct.util.PasswordEncoder;

import javax.transaction.Transactional;

@Service
@Transactional
public class AppUserService implements UserDetailsService {

    @Autowired
    private AppUserRepo appUserRepo;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;


    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        return appUserRepo.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException(String.format("user with email '%s' not found", email)));
    }

    public AppUser registerAppUser(AppUser user){
        boolean userExist = appUserRepo.findByEmail(user.getEmail()).isPresent();
        if (userExist){
            throw new RuntimeException(
                    String.format("User with email '%s' already exist", user.getEmail())
            );
        }
        String encodedPassword = bCryptPasswordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        return appUserRepo.save(user);
    }
}
