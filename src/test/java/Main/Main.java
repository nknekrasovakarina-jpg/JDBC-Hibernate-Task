////package Main;
//
//import DAO.UserDaoJDBCImpl;
//import jm.task.core.jdbc.model.User;
//
//public class Main {
//    public static void main(String[] args) {
//        UserDaoJDBCImpl userDao = new UserDaoJDBCImpl();
//
//        // 1. Создание таблицы пользователей
//        userDao.createUsersTable();
//
//        // 2. Добавление 4 пользователей
//        userDao.saveUser("Илон", "Маск", (byte) 50);
//        userDao.saveUser("Сева", "Курцвейл", (byte) 65);
//        userDao.saveUser("Найк", "Борзов", (byte) 55);
//        userDao.saveUser("Рената", "Литвинова", (byte) 50);
//
//        System.out.println("\nСписок пользователей:");
//
//        // 3. Получение и вывод всех пользователей
//        userDao.getAllUsers(); // теперь вывод происходит внутри метода getAllUsers
//
//        // 4. Очистка таблицы
//        userDao.cleanUsersTable();
//        System.out.println("Таблица очищена.\n");
//
//        // 5. Удаление таблицы
//        userDao.dropUsersTable();
//        System.out.println("Таблица удалена.");
//    }
//}