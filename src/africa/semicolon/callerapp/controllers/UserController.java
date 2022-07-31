package africa.semicolon.callerapp.controllers;

import africa.semicolon.callerapp.data.models.Contact;
import africa.semicolon.callerapp.data.models.User;
import africa.semicolon.callerapp.dtos.requests.AddContactRequest;
import africa.semicolon.callerapp.dtos.requests.RegisterRequest;
import africa.semicolon.callerapp.dtos.responses.AddContactResponse;
import africa.semicolon.callerapp.dtos.responses.RegisterUserResponse;
import africa.semicolon.callerapp.services.UserService;
import africa.semicolon.callerapp.services.UserServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    private UserService userService = new UserServiceImpl();
    @PostMapping("/user")
    public RegisterUserResponse registerUSer(@RequestBody RegisterRequest request){
        return  userService.registerUser(request);
    }
    @PatchMapping("/user")
    public AddContactResponse addContact(@RequestBody AddContactRequest request){
        return userService.addContact(request);
    }
    @GetMapping("/user/{userEmail}/contacts")
    public List<Contact> findContactsBelongingTo(@PathVariable String userEmail){
        return userService.findContactsBelongingTo(userEmail);
    }

//    @GetMapping("/user/{userEmail}")
//    public List<User> findAllUsers(@PathVariable String userEmail){
//      
//
//    }
}
