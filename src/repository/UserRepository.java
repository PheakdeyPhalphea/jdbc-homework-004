package repository;

import model.User;
import unitl.LoadProperties;
import unitl.Singleton;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;

public class UserRepository {

        public  List<User> userData () {
            String sql = "SELECT * FROM users";
            List<User> users = new ArrayList<>();
            LoadProperties.loadProperties();
            try (
                    Connection connection = DriverManager.getConnection(
                        LoadProperties.properties.getProperty("database_URL"),
                        LoadProperties.properties.getProperty("database_username"),
                        LoadProperties.properties.getProperty("database_password"));
                    Statement statement = connection.createStatement();
                    ResultSet resultSet = statement.executeQuery(sql);
                    ) {
                    while (resultSet.next()){
                        users.add( new User(
                                resultSet.getInt("user_id"),
                                resultSet.getString("user_uuid"),
                                resultSet.getString("user_name"),
                                resultSet.getString("user_email"),
                                resultSet.getString("user_password"),
                                resultSet.getBoolean("is_deleted"),
                                resultSet.getBoolean("is_verified")
                        ));
                    }
            }
            catch (SQLException e) {

            }
            return  users;
        }
        public User insertUser (User user){
            LoadProperties.loadProperties();
           String sql = "INSERT INTO users (user_uuid, user_name, user_email, user_password, is_deleted, is_verified) VALUES (?, ?, ?, ?, ?, ?)";
            try (
                    Connection connection = DriverManager.getConnection(
                            LoadProperties.properties.getProperty("database_URL"),
                            LoadProperties.properties.getProperty("database_username"),
                            LoadProperties.properties.getProperty("database_password"));
                   PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ){
                preparedStatement.setString(1, user.getUserUUID());
                preparedStatement.setString(2, user.getUserName());
                preparedStatement.setString(3, user.getUserEmail());
                preparedStatement.setString(4, user.getUserPassword());
                preparedStatement.setBoolean(5, user.getIsDeleted());
                preparedStatement.setBoolean(6, user.getIsVerified());
                try (ResultSet resultSet = preparedStatement.executeQuery()){
                        while (resultSet.next()) {
                            return new User(
                                    resultSet.getInt("user_id"),
                                    resultSet.getString("user_uuid"),
                                    resultSet.getString("user_name"),
                                    resultSet.getString("user_email"),
                                    resultSet.getString("user_password"),
                                    resultSet.getBoolean("is_deleted"),
                                    resultSet.getBoolean("is_verified")
                            );
                        }
                }

            }
            catch (SQLException e){
            }
            return new User();
        }
        public Integer deleteById (Integer id) {
            String sql = "DELETE FROM users WHERE user_id = ?";
            try (
                    Connection connection = DriverManager.getConnection(
                            LoadProperties.properties.getProperty("database_URL"),
                            LoadProperties.properties.getProperty("database_username"),
                            LoadProperties.properties.getProperty("database_password"));
                    PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ) {
                preparedStatement.setInt(1, id);
                preparedStatement.executeUpdate();
            } catch (SQLException e) {

            }
            return id;
        }
        public User updateUser (User user)  {
            LoadProperties.loadProperties();
            String sql = "update users SET user_uuid = ?,  user_name = ?, user_email = ? , user_password = ?, is_deleted = ?, is_verified = ? where user_id = ?";
            try (
                    Connection connection = DriverManager.getConnection(
                            LoadProperties.properties.getProperty("database_URL"),
                            LoadProperties.properties.getProperty("database_username"),
                            LoadProperties.properties.getProperty("database_password"));
                    PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ){
                preparedStatement.setString(1, user.getUserUUID());
                preparedStatement.setString(2, user.getUserName());
                preparedStatement.setString(3, user.getUserEmail());
                preparedStatement.setString(4, user.getUserPassword());
                preparedStatement.setBoolean(5, user.getIsDeleted());
                preparedStatement.setBoolean(6, user.getIsVerified());
                preparedStatement.setInt(7, user.getUserId());
                try (ResultSet resultSet = preparedStatement.executeQuery()){
                    while (resultSet.next()) {
                        return new User(
                                resultSet.getInt("user_id"),
                                resultSet.getString("user_uuid"),
                                resultSet.getString("user_name"),
                                resultSet.getString("user_email"),
                                resultSet.getString("user_password"),
                                resultSet.getBoolean("is_deleted"),
                                resultSet.getBoolean("is_verified")
                        );
                    }
                }
            }
            catch (SQLException e) {
            }
            return  user;
        }

}
