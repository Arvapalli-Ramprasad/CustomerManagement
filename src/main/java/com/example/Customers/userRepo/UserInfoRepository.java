package com.example.Customers.userRepo;

import com.example.Customers.userentity.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
//Repo to save the user info
public interface UserInfoRepository extends JpaRepository<UserInfo, Integer> {

    //finding user using finfByName method
    Optional<UserInfo> findByName(String username);
}
