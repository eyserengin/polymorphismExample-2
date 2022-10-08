import business.CourseManager;
import business.CustomersManager;
import business.TeachersManager;
import core.FileLogger;
import core.Logger;
import core.MailLogger;
import entities.Courses;
import dataAccess.DataBaseManager;
import dataAccess.HiberNateDataBase;
import dataAccess.JdbcDataBase;
import entities.Customers;
import entities.Teachers;

public class Main {
    public static void main(String[] args) throws Exception {

        Customers customers = new Customers(18, "EYSER", "ENGIN");

        Teachers teachers = new Teachers(32, "Engin", "Demiroğ", "Python");

        Courses courses = new Courses(90, "Python");

        Logger[] loggers = new Logger[]{new FileLogger(), new MailLogger()};

        DataBaseManager[] dataBaseManagers = new DataBaseManager[]{new JdbcDataBase(), new HiberNateDataBase()};

        CustomersManager customersManager = new CustomersManager(loggers, dataBaseManagers, courses, customers );

        TeachersManager teachersManager = new TeachersManager(loggers, dataBaseManagers, courses, teachers);

        CourseManager courseManager = new CourseManager(teachers, courses, dataBaseManagers, loggers);

        courseManager.save();
        System.out.println("*".repeat(30));
        teachersManager.save();
        System.out.println("*".repeat(30));
        customersManager.save();

    }
}
