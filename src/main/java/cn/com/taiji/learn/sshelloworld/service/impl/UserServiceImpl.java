package cn.com.taiji.learn.sshelloworld.service.impl;

import cn.com.taiji.learn.sshelloworld.dao.UserRepository;
import cn.com.taiji.learn.sshelloworld.domain.User;
import cn.com.taiji.learn.sshelloworld.exception.EmailExistsException;
import cn.com.taiji.learn.sshelloworld.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserRepository repository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Transactional
    @Override
    public User registerNewUser(final User user) throws EmailExistsException {
        if (emailExist(user.getEmail())) {
            throw new EmailExistsException("There is an account with that email address: " + user.getEmail());
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return repository.save(user);
    }

    private boolean emailExist(String email) {
        final User user = repository.findByEmail(email);
        return user != null;
    }

    @Transactional
    @Override
    public User updateExistingUser(User user) throws EmailExistsException {
        final Long id = user.getId();
        final String email = user.getEmail();
        final User emailOwner = repository.findByEmail(email);
        if (emailOwner != null && !id.equals(emailOwner.getId())) {
            throw new EmailExistsException("Email not available.");
        }
        if (user.getPassword() != null) {
            user.setPassword(passwordEncoder.encode(user.getPassword()));
        }
        return repository.save(user);
    }

}