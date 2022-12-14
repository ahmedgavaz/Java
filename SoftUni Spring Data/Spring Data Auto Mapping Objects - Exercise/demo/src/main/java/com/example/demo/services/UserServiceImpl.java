package com.example.demo.services;

import com.example.demo.entities.Game;
import com.example.demo.entities.RegisterUser;
import com.example.demo.entities.User;
import com.example.demo.repositories.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static com.example.demo.constants.Messages.*;

@Service
public class UserServiceImpl implements UserService {
    private User user;
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
        modelMapper = new ModelMapper();
    }

    @Override
    public Optional<User> findByEmailAndPassword(String email, String password) {
        return this.userRepository.findByEmailAndPassword(email, password);
    }

    @Override
    public void registerUser(String[] args) {
        try {
            if (findByEmailAndPassword(args[1], args[2]).isEmpty()) {
                RegisterUser registerUser = new RegisterUser(args[1], args[2], args[3], args[4]);
                User user = modelMapper.map(registerUser, User.class);
                if (this.userRepository.count() == 0) {
                    user.setAdministrator(true);
                }else{
                    user.setAdministrator(false);
                }
                System.out.printf(user.successfulRegistration());
                this.userRepository.save(user);
            }
        }catch (Exception e){
            System.out.printf(e.getMessage());
        }
    }

    @Override
    public void loginUser(String[] args) {
        try {
            if (findByEmailAndPassword(args[1], args[2]).isPresent() && this.user ==null) {
                user = findFirstByEmailAndPassword(args[1],args[2]);
                    System.out.println(user.successfulLogin());

            }else{
                System.out.println(loggedInUser);
            }
        }catch (Exception e){
            System.out.printf(e.getMessage());
        }
    }

    @Override
    public User findFirstByEmailAndPassword(String email, String password) {
        return this.userRepository.findFirstByEmailAndPassword(email,password);
    }

    @Override
    public void logoutUser() {
        if (this.user==null){
            System.out.println(cannotLogout);
        }else {
            System.out.println(user.successfulLogout());
        }
        this.user=null;
    }

    @Override
    public boolean isUserLogged() {
        if(this.user==null){
            return false;
        }else {
            return true;
        }
    }

    public User getUser() {
        return user;
    }

    @Override
    public void addGame(Game game) {
        if (this.user==null){
            throw new IllegalArgumentException(userIsNotLoggedIn);
        }
        user.getGames().add(game);
        this.userRepository.save(user);
        System.out.println();
    }

    @Override
    public void ownedGames() {
        if (this.user==null){
            throw new IllegalArgumentException(userIsNotLoggedIn);
        }
        user.getGames().forEach(e-> System.out.println(e.getTitle()));
    }
}
