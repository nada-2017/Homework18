package com.example.homework17.Repository;

import com.example.homework17.Model.MyUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<MyUser,Integer> {

    @Query("select s from MyUser s where s.password = ?1 and s.username = ?2")
    MyUser getUserByPasswordAndUsername(String password, String username);


    @Query("select s from MyUser s where s.email = ?1")
    MyUser getUserByEmail(String email);

    @Query("select s from MyUser s where s.role = ?1")
    List<MyUser> getUsersByRole(String role);

    @Query("select s from MyUser s where s.age > ?1 or s.age = ?1 ")
    List<MyUser> getUsersByAgeOrAbove(Integer age);

}
