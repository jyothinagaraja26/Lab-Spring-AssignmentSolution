package in.greatlearning.collegefest.service;

import in.greatlearning.collegefest.entities.User;
import in.greatlearning.collegefest.repository.UserRepository;
import in.greatlearning.collegefest.security.MyUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user=userRepository.getByUsername(username);
        return new MyUserDetails(user);
    }
}
