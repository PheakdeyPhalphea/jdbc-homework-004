package service;

import model.User;
import repository.UserRepository;

import java.util.List;

public class UserServiceIml implements UserService {
    private final UserRepository userRepository;
    public UserServiceIml(){
        userRepository = new UserRepository();
    }
    @Override
    public List<User> getAllUser() {
        return userRepository.userData();
    }

    @Override
    public void insertUser(User user) {
        userRepository.insertUser(user);
    }

    @Override
    public void deleteById(Integer id) {
        userRepository.deleteById(id);
    }

    @Override
    public void updateUser(User user) {
        userRepository.updateUser(user);
    }
}