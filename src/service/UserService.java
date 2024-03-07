package service;

import model.User;

import java.util.List;

public interface UserService {
   public   List<User> getAllUser();
   void insertUser (User user);
   void deleteById(Integer id);
   void updateUser (User user);
}
