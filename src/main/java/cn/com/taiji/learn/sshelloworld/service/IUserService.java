package cn.com.taiji.learn.sshelloworld.service;

import cn.com.taiji.learn.sshelloworld.domain.User;
import cn.com.taiji.learn.sshelloworld.exception.EmailExistsException;

public interface IUserService {

    User registerNewUser(User user) throws EmailExistsException;

    User updateExistingUser(User user) throws EmailExistsException, EmailExistsException;

}
