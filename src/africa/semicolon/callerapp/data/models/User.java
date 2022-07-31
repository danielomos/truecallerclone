package africa.semicolon.callerapp.data.models;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
@Data
public class User {
    private int id;
    private String username;
    private String password;
    private String email;

    private List<Contact> contacts = new ArrayList<Contact>();


}
