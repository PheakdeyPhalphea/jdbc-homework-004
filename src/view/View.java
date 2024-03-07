package view;

import controller.UserController;
import model.User;
import unitl.Singleton;
import unitl.UntilTable;

import java.util.Scanner;
import java.util.UUID;

public class View {
    private final Scanner scanner;
    private final User user;
    private final UntilTable untilTable;
    private final UserController userController;
    public View(){
        user = new User();
        untilTable = new UntilTable();
        scanner = Singleton.scanner();
        userController = Singleton.userController();
    }
    public void ui (){
        System.out.println( "=".repeat(20) +" Welcome " + "=".repeat(20));
        UntilTable.welcomeTable();
    }
    public User insertUser (){
        return getUser();
    }
    public User updateUser (){
        System.out.print("Enter Id To Update :");
        user.setUserId(Integer.parseInt(scanner.nextLine()));

        return getUser();
    }

    private User getUser() {
        System.out.print("Enter UserName :");
        user.setUserName(scanner.nextLine());
        System.out.print("Enter Email :");
        user.setUserEmail(scanner.nextLine());
        System.out.print("Enter password :");
        user.setUserPassword(scanner.nextLine());
        user.setUserUUID(UUID.randomUUID().toString());
        user.setIsDeleted(false);
        user.setIsVerified(false);
        return user;
    }

    public Integer deleteById (){
        System.out.print("Enter Id to Delete");
       try{
           return Integer.parseInt(scanner.nextLine());

           }catch (NumberFormatException e) {
           System.out.println(e.getMessage());
       }
       return null;
    }
    public void UserDesire (){
        System.out.print("Insert Option: ");
       try{
           int userInput =  Integer.parseInt(scanner.nextLine());
           switch (userInput) {
               case 1 -> untilTable.displayUserTable();
               case 2 -> userController.updateByUser(updateUser());
               case 3 -> userController.deleteById(deleteById());
               case 4 -> userController.insertUser(insertUser());
               case 5 -> System.exit(0);
               default -> System.out.println("Only Option Above");
           }
       }catch (NumberFormatException e) {
           System.out.println(e.getMessage());
       }
    }
    }
