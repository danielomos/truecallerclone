package africa.semicolon.callerapp.services;

import africa.semicolon.callerapp.dtos.requests.AddContactRequest;
import africa.semicolon.callerapp.dtos.requests.RegisterRequest;
import africa.semicolon.callerapp.dtos.responses.AddContactResponse;
import africa.semicolon.callerapp.dtos.responses.AllContactResponse;
import africa.semicolon.callerapp.dtos.responses.RegisterUserResponse;

import java.util.List;

public interface UserService {
    public RegisterUserResponse  registerUser(RegisterRequest request);

    AddContactResponse addContact(AddContactRequest request);

    int numberOfUsers();

    int getContactCount(String userEmail);

    List<AllContactResponse> findContactsBelongingTo(String userEmail);

}
