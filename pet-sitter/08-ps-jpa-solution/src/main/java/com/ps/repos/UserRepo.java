package com.ps.repos;

import com.ps.ents.User;

import java.util.List;
import java.util.Set;

public interface UserRepo {

    List<User> findAll();

    User findById(Long id);

    List findAllByUserName(String username, boolean exactMatch);

    List<User> findAllByLastName(String username);

    List<String> findAllFirstNames();

    String findUsernameById(Long id);

    long countUsers();

    void save(User user);

    void updatePassword(Long userId, String newPass);

    void updateUsername(Long userId, String username);

    void deleteById(Long userId);

    void save(Set<User> users);

    public void deleteAll();
}