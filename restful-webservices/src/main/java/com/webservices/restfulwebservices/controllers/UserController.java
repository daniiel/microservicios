package com.webservices.restfulwebservices.controllers;

import com.webservices.restfulwebservices.dao.UserDaoService;
import com.webservices.restfulwebservices.exceptions.UserNotFoundException;
import com.webservices.restfulwebservices.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;


@RestController
public class UserController {

    // Spring creates an instance of the UserDaoService and autowired it in here.
    @Autowired
    private UserDaoService daoService;

    @GetMapping("/users")
    public List<User> findAllUsers() {
        return daoService.findAll();
    }

    @GetMapping("/users/{userId}")
    public User findUserById(@PathVariable Integer userId) {
        User user = daoService.findById(userId);
        if (user == null) {
            throw new UserNotFoundException("Not found user by userId: " + userId);
        }
        return user;
    }

//    @GetMapping("/users/hateoas/{userId}")
//    public EntityModel<User> hateoasFindUserById(@PathVariable Integer userId) {
//        User user = daoService.findById(userId);
//        if (user == null) {
//            throw new UserNotFoundException("Not found user by userId: " + userId);
//        }
//        /**
//         * Add a link to refer all the users paths ('serverPath/users'). The link is that the method 'findAllUsers' expose
//         */
//        EntityModel<User> entityModel = new EntityModel<>(user);
//        entityModel.add(
//                linkTo(methodOn(this.getClass()).findAllUsers()).withSelfRel());
//
//        return entityModel;
//    }

    @PostMapping("/users")
    public ResponseEntity<Object> createUser(@Valid @RequestBody User user) {
        User userCreated = daoService.addUser(user);
        // Take the current URL '/users' and append '{userId}' -> '/users/{userId}'
        // currentRequest avoids to hardcode '/users'
        // Path method allows to append something to the URI
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{userId}").buildAndExpand(userCreated.getId()).toUri();

        return ResponseEntity.created(uri).build();
    }

    @DeleteMapping("/users/{userId}")
    public void deleteUserById(@PathVariable Integer userId) {
        User user = daoService.deleteUserById(userId);
        if (user == null) {
            throw new UserNotFoundException("Not found user by userId: " + userId);
        }
    }
}
