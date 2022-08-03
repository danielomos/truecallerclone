package africa.semicolon.callerapp.controllers;

import africa.semicolon.callerapp.dtos.requests.AddContactRequest;
import africa.semicolon.callerapp.dtos.requests.RegisterRequest;
import africa.semicolon.callerapp.dtos.responses.AddContactResponse;
import africa.semicolon.callerapp.dtos.responses.AllContactResponse;
import africa.semicolon.callerapp.dtos.responses.RegisterUserResponse;
import africa.semicolon.callerapp.services.UserService;
import africa.semicolon.callerapp.services.UserServiceImpl;
import exception.UserExistsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
@Autowired
    private UserService userService;
    @PostMapping("/user")
    public ResponseEntity<?> registerUSer(@RequestBody RegisterRequest request){
        try {
            RegisterUserResponse response = userService.registerUser(request);
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        }
        catch(UserExistsException ex){
            return new ResponseEntity<>(ex.getMessage(),HttpStatus.BAD_REQUEST);
        }
//    public RegisterUserResponse registerUSer(@RequestBody RegisterRequest request){
//        return  userService.registerUser(request);
    }
    @PatchMapping("/user")
    public AddContactResponse addContact(@RequestBody AddContactRequest request){
        return userService.addContact(request);

    }
    @GetMapping("/user/{userEmail}")
    public List<AllContactResponse> findContactsBelongingTo(@PathVariable String userEmail){
        return userService.findContactsBelongingTo(userEmail);
    }

//    @GetMapping("/user/{userEmail}")
//    public List<User> findAllUsers(@PathVariable String userEmail){
//      
//
//    }
}
