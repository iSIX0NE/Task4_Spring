package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
    public static void main(String[] args) throws SQLException {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        UserService userService = context.getBean(UserService.class);

        User user1 = new User("Ivan", "Ivanov", "ivanivanov007@gmail.com");
        User user2 = new User("Sanek", "Filatov", "assafil23@gmail.com");
        User user3 = new User("Alexey", "Loshaev", "loshAeb234@gmail.com");
        User user4 = new User("Oleg", "Konoplev", "eOlegss293@gmail.com");
        User user5 = new User("Ivan", "Kuznecov", "ivankuznec21@gmail.com");

        Car car1 = new Car("Volvo", 1965);
        Car car2 = new Car("Mazda", 1998);
        Car car3 = new Car("Honda", 2003);
        Car car4 = new Car("Lada", 2000);
        Car car5 = new Car("Mercedes-Benz", 2005);

        userService.add(user1.setCars(car1).setUser(user1));
        userService.add(user2.setCars(car2).setUser(user2));
        userService.add(user3.setCars(car3).setUser(user3));
        userService.add(user4.setCars(car4).setUser(user4));
        userService.add(user5.setCars(car5).setUser(user5));


        for (User user : userService.listUsers()) {
            System.out.println(user);

        }
        System.out.println("Владелец автомобиля: ");
        System.out.println(userService.getUserByCar("Lada",2000));

        context.close();
    }
}
