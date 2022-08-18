package ryndrappf.apiproduct.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ryndrappf.apiproduct.dto.AppUserData;
import ryndrappf.apiproduct.dto.ResponseData;
import ryndrappf.apiproduct.models.entities.AppUser;
import ryndrappf.apiproduct.services.AppUserService;

@RestController
@RequestMapping("/api/users")
public class AppUserController {

    @Autowired
    private AppUserService appUserService;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping("/register")
    public ResponseEntity<ResponseData<AppUser>> registerUser(@RequestBody AppUserData userData){

        ResponseData<AppUser> responseData = new ResponseData<>();
        AppUser appUser = modelMapper.map(userData, AppUser.class);
        responseData.setPayLoad(appUserService.registerAppUser(appUser));
        responseData.setStatus(true);
        responseData.getMessages().add("AppUser saved");
        return ResponseEntity.ok(responseData);
    }


}
