package com.bci.users.repository;

import com.bci.users.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends CrudRepository<User,String>{

    public int countByEmail(String email);
    public User findAllByName(String name);
    public int countByName(String name);
    public User findAllById(String id);
}