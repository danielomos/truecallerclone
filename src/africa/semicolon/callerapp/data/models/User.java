package africa.semicolon.callerapp.data.models;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;
@Data
@NoArgsConstructor
@Document
public class User {
    @Id
    private String id;
    private String username;
    private String password;
    private String email;

    @DBRef
    private List<Contact> contacts = new ArrayList<Contact>();


}
