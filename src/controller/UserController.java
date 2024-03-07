package controller;

import model.User;
import service.UserService;
import unitl.Singleton;

import java.util.List;

public class UserController {
    private final UserService userService;
    public UserController(){
        userService = Singleton.userService();
    }
public  List<User> getUser (){
    return userService.getAllUser();
}
public void insertUser (User user){
    userService.insertUser(user);
}
public void deleteById(Integer id) {
    userService.deleteById(id);
}
public void updateByUser (User user){
    userService.updateUser(user);
}
}
