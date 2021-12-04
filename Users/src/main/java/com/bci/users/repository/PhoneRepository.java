package com.bci.users.repository;

import java.util.List;
import java.util.UUID;

import com.bci.users.entity.Phone;
import com.bci.users.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PhoneRepository extends JpaRepository<Phone,UUID>{

    public List <Phone> findAllByUser(User userId);
}