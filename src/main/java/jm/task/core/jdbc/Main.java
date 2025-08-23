package jm.task.core.jdbc;
import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;

public class Main {
    public static void main(String[] args) {
        UserService userService = new UserServiceImpl();

        //1. таблица из 4 пользователей
        userService.createUsersTable();

        // 2. добавление 4 пользователей
        userService.saveUser("Илон", "Маск", (byte) 50);
        userService.saveUser("Сева", "Курцвейл", (byte) 65);
        userService.saveUser("Найк", "Борзов", (byte) 55);
        userService.saveUser("Рената", "Литвинова", (byte) 50);

        System.out.println("\nСписок пользователей:");
        for (User user : userService.getAllUsers()) {
            System.out.println(user);
        }

        // 4. Очистка таблицы
        userService.cleanUsersTable();
        System.out.println("Таблица очищена.\n");

        // 5. Удаление таблицы
        userService.dropUsersTable();
        System.out.println("Таблица удалена.");
    }
}