package business;

import core.Logger;
import dataAccess.DataBaseManager;
import entities.Courses;
import entities.Teachers;

public class CourseManager {


    Logger[] loggers;
    DataBaseManager[] dataBaseManager;
    Teachers teachers;
    Courses courses;

    public CourseManager(Teachers teachers, Courses courses, DataBaseManager[] dataBaseManager,Logger[] loggers) {
        this.teachers = teachers;
        this.courses = courses;
        this.dataBaseManager = dataBaseManager;
        this.loggers = loggers;
    }

    //Eğer bu kursu verebilecek düzeyde bir öğretmen var ise kurs açılıyor. Eğer var ise true dönüyor ve aşağıda kaydediliyor.
    boolean courseExist() {
        if (teachers.getBranch() == courses.getName()) {
            return true;
        }
        else{
            return false;
        }

    }

    public void save() throws Exception {
        if(courseExist()){
            System.out.println();
            for (DataBaseManager dataBaseManager1 : dataBaseManager) {
                System.out.print("Course added to: "); dataBaseManager1.save();
            }

            for (Logger logger : loggers) {
                logger.Log(courses.getName());
            }
        }

        else
            throw new Exception("Please give a exist course");
    }
}
