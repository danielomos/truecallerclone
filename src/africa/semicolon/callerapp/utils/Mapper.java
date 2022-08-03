package africa.semicolon.callerapp.utils;

import africa.semicolon.callerapp.data.models.Contact;
import africa.semicolon.callerapp.data.models.User;
import africa.semicolon.callerapp.dtos.requests.AddContactRequest;
import africa.semicolon.callerapp.dtos.requests.RegisterRequest;
import africa.semicolon.callerapp.dtos.responses.AllContactResponse;

public class Mapper {
    public static void map(RegisterRequest request, User user) {
        user.setUsername(request.getUsername());
        user.setPassword(request.getPassword());
        user.setEmail(request.getEmail());
    }
    public static void map(Contact contact, Contact newContact) {
        newContact.setFirstName(contact.getFirstName());
        newContact.setLastName(contact.getLastName());
        newContact.setEmail(contact.getEmail());
        newContact.setPhoneNumber(contact.getPhoneNumber());
        newContact.setUserEmail(contact.getUserEmail());
    }

    public static void map(AddContactRequest request, Contact newRequest) {
//        newRequest.setId((request.getId());
        newRequest.setFirstName(request.getFirstName());
        newRequest.setLastName(request.getLastName());
        newRequest.setEmail(request.getEmail());
        newRequest.setPhoneNumber(request.getPhoneNumber());
        newRequest.setUserEmail(request.getUserEmail());
    }

    public static void map(Contact contact, AllContactResponse singleResponse) {
        singleResponse.setId(contact.getId()+"");
        singleResponse.setFirstName(contact.getFirstName());
        singleResponse.setLastName(contact.getLastName());
    }
}
