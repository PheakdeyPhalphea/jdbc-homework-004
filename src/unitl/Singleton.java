package unitl;

import controller.UserController;
import org.nocrala.tools.texttablefmt.Table;
import service.UserService;
import service.UserServiceIml;

import javax.swing.*;
import java.util.Scanner;

public class Singleton {
    private static Scanner scanner;
    private static UserController userController;
    private static UserService userService;

    public static Scanner scanner (){
        if(scanner ==  null){
            scanner = new Scanner(System.in);
        }
        return scanner;
    }
    public static UserService userService (){
        if(userService ==  null){
            userService = new UserServiceIml();
        }
        return userService;
    }
    public static UserController userController (){
        if(userController ==  null){
            userController = new UserController();
        }
        return userController;
    }
}
