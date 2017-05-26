package desafio.maisvidas.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import desafio.maisvidas.model.User;
import desafio.maisvidas.repository.UserRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{
    @Autowired
    private UserRepository userRepository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        if(!user.getIsActive()){
        	user = null;
        }

		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), null);
    }
}