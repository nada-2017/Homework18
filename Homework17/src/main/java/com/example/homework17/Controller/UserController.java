package com.example.homework17.Controller;

import com.example.homework17.Model.MyUser;
import com.example.homework17.Service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/user")
public class UserController {

    private final UserService userService;

    @GetMapping("/get")
    public ResponseEntity getAllUsers(){
        return ResponseEntity.status(200).body(userService.getAllUsers());
    }

    @PostMapping("/add")
    public ResponseEntity addUser(@Valid@RequestBody MyUser user, Errors errors){
        if(errors.hasErrors())
            return ResponseEntity.status(400).body(errors.getFieldError().getDefaultMessage());
        userService.addAllUser(user);
        return ResponseEntity.status(200).body("User added");
    }


    @PutMapping("/update/{id}")
    public ResponseEntity updateUser(@PathVariable Integer id, @Valid@RequestBody MyUser user, Errors errors){
        if(errors.hasErrors())
            return ResponseEntity.status(400).body(errors.getFieldError().getDefaultMessage());
        if (userService.updateUser(id,user))
            return ResponseEntity.status(200).body("User updated");
        return ResponseEntity.status(400).body("Not found");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteUser(@PathVariable Integer id){
        if (userService.deleteUser(id))
            return ResponseEntity.status(200).body("User deleted");
        return ResponseEntity.status(400).body("Not found");
    }

    //-------------------------------------------------------Homework18-------------------------------------------------------

    @GetMapping("/get-password-username/{password}/{username}")
    public ResponseEntity getUserByPasswordAndUsername(@PathVariable String password,@PathVariable String username){
        return ResponseEntity.status(200).body(userService.getUserByPasswordAndUsername(password, username));
    }

    @GetMapping("/get-email/{email}")
    public ResponseEntity getUserByEmail(@PathVariable String email){
        return ResponseEntity.status(200).body(userService.getUserByEmail(email));
    }

    @GetMapping("/get-role/{role}")
    public ResponseEntity getUsersByRole(@PathVariable String role){
        return ResponseEntity.status(200).body(userService.getUsersByRole(role));
    }

    @GetMapping("/get-age/{age}")
    public ResponseEntity getUsersByAgeOrAbove(@PathVariable Integer age){
        return ResponseEntity.status(200).body(userService.getUsersByAgeOrAbove(age));
    }

}
