package business;

import core.Logger;
import dataAccess.DataBaseManager;
import entities.Courses;
import entities.Teachers;

public class TeachersManager {
    Logger[] loggers;
    DataBaseManager[] dataBaseManager;
    Courses courses;
    Teachers teachers;

    public TeachersManager(Logger[] loggers, DataBaseManager[] dataBaseManager, Courses courses, Teachers teachers) {
        this.loggers = loggers;
        this.dataBaseManager = dataBaseManager;
        this.courses = courses;
        this.teachers = teachers;
    }


    public void save() throws Exception {
        if (courses.getPrice() < 0) {
            throw new Exception("Price is not least than 0");
        }
        else {
            for (DataBaseManager dataBaseManager1 : dataBaseManager) {
                System.out.print("Teachers added to: ");  dataBaseManager1.save();
                System.out.println("Open the course: " + courses.getName());
            }

            for (Logger logger : loggers) {
                logger.Log(teachers.getName());
            }
        }
    }

}
