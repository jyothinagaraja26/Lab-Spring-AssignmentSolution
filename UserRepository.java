package in.greatlearning.collegefest.repository;

import in.greatlearning.collegefest.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User,Long> {

    User getByUsername(String username);
   // User getByPassword(String password);
}
