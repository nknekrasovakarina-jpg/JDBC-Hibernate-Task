//package DAO;
//
//
//import jm.task.core.jdbc.util.Util;
//import jm.task.core.jdbc.model.User;
//import java.sql.*;
//import java.util.ArrayList;
//import java.util.List;
//
//public class UserDaoJDBCImpl implements UserDao {
//
//    @Override
//    public void createUsersTable() {
//        String sql = "CREATE TABLE IF NOT EXISTS users (" +
//                "id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY," +
//                "name VARCHAR(50) NOT NULL," +
//                "lastName VARCHAR(50) NOT NULL," +
//                "age TINYINT NOT NULL" +
//                ")";
//        try (Connection connection = Util.getConnection();
//             Statement statement = connection.createStatement()) {
//            statement.execute(sql);
//            System.out.println("Таблица 'users' создана или уже существует.");
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//
//    @Override
//    public void dropUsersTable() {
//        String sql = "DROP TABLE IF EXISTS users";
//        try (Connection connection = Util.getConnection();
//             Statement statement = connection.createStatement()) {
//            statement.executeUpdate(sql);
//            System.out.println("Таблица 'users' успешно удалена.");
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//
//    @Override
//    public void saveUser(String name, String lastName, byte age) {
//        String sql = "INSERT INTO users (name, lastName, age) VALUES (?, ?, ?)";
//        try (Connection connection = Util.getConnection();
//             PreparedStatement ps = connection.prepareStatement(sql)) {
//            ps.setString(1, name);
//            ps.setString(2, lastName);
//            ps.setByte(3, age);
//            ps.executeUpdate();
//            System.out.println("Пользователь " + name + " " + lastName + " добавлен.");
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//
//    @Override
//    public void removeUserById(long id) {
//        String sql = "DELETE FROM users WHERE id = ?";
//        try (Connection connection = Util.getConnection();
//             PreparedStatement ps = connection.prepareStatement(sql)) {
//            ps.setLong(1, id);
//            int rows = ps.executeUpdate();
//            if (rows > 0) {
//                System.out.println("Пользователь с ID " + id + " удалён.");
//            } else {
//                System.out.println("Пользователь с ID " + id + " не найден.");
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//
//    @Override
//    public List<User> getAllUsers() {
//        String sql = "SELECT * FROM users";
//        List<User> users = new ArrayList<>();
//
//        try (Connection connection = Util.getConnection();
//             Statement statement = connection.createStatement();
//             ResultSet resultSet = statement.executeQuery(sql)) {
//
//            while (resultSet.next()) {
//                long id = resultSet.getLong("id");
//                String name = resultSet.getString("name");
//                String lastName = resultSet.getString("lastName");
//                byte age = resultSet.getByte("age");
//
//                User user = new User(id, name, lastName, age);
//                users.add(user);
//
//                // выводим пользователя сразу в читаемом виде
//                System.out.println("ID: " + id + ", Name: " + name +
//                        ", LastName: " + lastName + ", Age: " + age);
//            }
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//
//        return users;
//    }
//
//    @Override
//    public void cleanUsersTable() {
//        String sql = "TRUNCATE TABLE users";
//        try (Connection connection = Util.getConnection();
//             Statement statement = connection.createStatement()) {
//            statement.executeUpdate(sql);
//            System.out.println("Таблица 'users' очищена.");
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//}
//            // Если хочешь быстрее очистить таблицу, можно использовать TRUNCATE TABLE
//            // String truncateSql = "TRUNCATE TABLE " + tableName;
//            // try (Statement statement = connection.createStatement()) {
//            //     statement.executeUpdate(truncateSql);
//            //     System.out.println("Таблица " + tableName + " очищена (TRUNCATE)");
//            // }
