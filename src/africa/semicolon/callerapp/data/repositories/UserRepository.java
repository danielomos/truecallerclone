package africa.semicolon.callerapp.data.repositories;

import africa.semicolon.callerapp.data.models.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface UserRepository extends MongoRepository<User, String> {
   User findUserByEmail(String emailAddress);
}
