package dataAccess;

public class JdbcDataBase implements DataBaseManager{
    @Override
    public void save() {
        System.out.println("Jdbc DataBase");
    }
}
