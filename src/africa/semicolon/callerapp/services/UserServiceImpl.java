package africa.semicolon.callerapp.services;

import africa.semicolon.callerapp.data.models.Contact;
import africa.semicolon.callerapp.data.models.User;
import africa.semicolon.callerapp.data.repositories.ContactRepository;
import africa.semicolon.callerapp.data.repositories.UserRepository;
import africa.semicolon.callerapp.dtos.requests.AddContactRequest;
import africa.semicolon.callerapp.dtos.requests.RegisterRequest;
import africa.semicolon.callerapp.dtos.responses.AddContactResponse;
import africa.semicolon.callerapp.dtos.responses.AllContactResponse;
import africa.semicolon.callerapp.dtos.responses.RegisterUserResponse;
import africa.semicolon.callerapp.utils.Mapper;
import exception.UserExistsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private final UserRepository userRepository;
    private RegisterUserResponse uResponse = new RegisterUserResponse();
    private AddContactResponse contactResponse = new AddContactResponse();
    @Autowired
   private final ContactService contactService;

   public UserServiceImpl(UserRepository userRepository, ContactService contactService) {
       this.userRepository = userRepository;
       this.contactService = contactService;
   }





    @Override
    public RegisterUserResponse registerUser(RegisterRequest request){
       validate(request.getEmail());

        User user = new User();
        Mapper.map(request, user);
        userRepository.save(user);
        uResponse.setMessage(String.format("%s successfully registered", request.getEmail()));
//        ("User" + user.getUsername()+ "Added Successfully");
//
        return uResponse;
    }

    private void validate(String email) throws UserExistsException{
        User savedUser = userRepository.findUserByEmail(email);
        if(savedUser != null) throw new UserExistsException(email + "already exists");

    }

    @Override
    public AddContactResponse addContact(AddContactRequest request) {


        Contact contact = new Contact();
        Mapper.map(request, contact);

        Contact savedContact = contactService.saveContact(contact);


        User user = userRepository.findUserByEmail(savedContact.getUserEmail());
        user.getContacts().add(savedContact);
        userRepository.save(user);
        contactResponse.setMessage(String.format("%s has been added to the contact list.", contact.getFirstName()));
        return contactResponse;

    }

    @Override
    public int numberOfUsers() {
        return (int) userRepository.count();
    }

    @Override
    public int getContactCount(String userEmail) {
        User user = userRepository.findUserByEmail(userEmail);
    return user.getContacts().size();

    }

    @Override
    public List<AllContactResponse> findContactsBelongingTo(String userEmail) {
       User user = userRepository.findUserByEmail(userEmail);

       List<Contact> AllUserContact = user.getContacts();
       List<AllContactResponse> response = new ArrayList<>();
       for (var contact : AllUserContact) {
           AllContactResponse singleResponse = new AllContactResponse();
         Mapper.map(contact,singleResponse);
           response.add(singleResponse);

       }
return response;
    }

//    public int getNumberOfUsers() {
//        return userRepository.count();
//    }
}
