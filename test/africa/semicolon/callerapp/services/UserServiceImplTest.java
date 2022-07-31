package africa.semicolon.callerapp.services;

import africa.semicolon.callerapp.data.repositories.UserRepository;
import africa.semicolon.callerapp.data.repositories.UserRepositoryImpl;
import africa.semicolon.callerapp.dtos.requests.AddContactRequest;
import africa.semicolon.callerapp.dtos.requests.RegisterRequest;

import exception.UserExistsException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class UserServiceImplTest {

    private UserService userService;
    private UserRepository userRepository = new UserRepositoryImpl();
    private ContactService contactService = new ContactServiceImpl();
    RegisterRequest registerRequest;
    AddContactRequest contactRequest;

    @BeforeEach
    void setUp(){
        registerRequest = new RegisterRequest();
        contactRequest = new AddContactRequest();

        userService = new UserServiceImpl(userRepository, contactService);

    }
    @Test
    public void registerTest() {

        //given
        //there is a request form

        registerRequest.setEmail("test1@example.com");
        registerRequest.setUsername("dummy1");
        registerRequest.setPassword("password");
        //when
        userService.registerUser(registerRequest);
        //i try to register a user
        //repositories
        assertEquals(1, userService.numberOfUsers());
    }

    @Test
    public void duplicateEmailThrowsExceptionIfAlreadyRegistered() {

        //given
        //there is a request form

        registerRequest.setEmail("test2@example.com");
        registerRequest.setUsername("dummy1");
        registerRequest.setPassword("password");
        //when
        userService.registerUser(registerRequest);

//        registerRequest2.setEmail("test3@example.com");
//        registerRequest2.setUsername("dummy1");
//        registerRequest2.setPassword("password");
        //when
        RegisterRequest registerRequest2 = new RegisterRequest();
        registerRequest2.setEmail("test2@example.com");
        registerRequest2.setUsername("dummy1");
        registerRequest2.setPassword("password");
        userService.registerUser(registerRequest2);
        //when
        // userService.registerUser(request2);
        assertEquals(1, userService.numberOfUsers());
        assertThrows(UserExistsException.class, () -> userService.registerUser(registerRequest));
    }
    @Test
    public void addContactTest(){

        //given
        //there is a request form

        registerRequest.setEmail("test4@example.com");
        registerRequest.setUsername("dummy1");
        registerRequest.setPassword("password");
        //when
        userService.registerUser(registerRequest);
//        RegisterRequest registerRequest2 = new RegisterRequest();
//        registerRequest2.setEmail("test@example.com");
//        registerRequest2.setUsername("dummy2");
//        registerRequest2.setPassword("password");
//        userService.registerUser(registerRequest2);



        contactRequest.setEmail("tst@example.com");
        contactRequest.setFirstName("ajo ");
        contactRequest.setLastName("test");
        contactRequest.setPhoneNumber("08099");
        contactRequest.setUserEmail("test4@example.com");
        userService.addContact(contactRequest);




        assertEquals(1,userService.findContactsBelongingTo("test4@example.com").size());
    }

}
