package business;


import entities.Courses;
import dataAccess.DataBaseManager;
import core.Logger;
import entities.Customers;

public class CustomersManager {
    Logger[] loggers;
    DataBaseManager[] dataBaseManager;
    Courses courses;
    Customers customers;

    public CustomersManager(Logger[] loggers, DataBaseManager[] dataBaseManager, Courses courses, Customers customers) {
        this.loggers = loggers;
        this.dataBaseManager = dataBaseManager;
        this.courses = courses;
        this.customers = customers;
    }


    public void save() throws Exception {
        if (courses.getPrice() < 0) {
            throw new Exception("Price is not least than 0");
        }
        else {
            for (DataBaseManager dataBaseManager1 : dataBaseManager) {
                System.out.println("Customers added to: " + courses.getName());
                System.out.print("Customers saved to: ");dataBaseManager1.save();

            }

            for (Logger logger : loggers) {
                logger.Log(customers.getName());
            }
        }
    }
}
