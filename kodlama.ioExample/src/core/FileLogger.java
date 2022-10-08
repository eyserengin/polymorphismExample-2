package core;

public class FileLogger implements Logger{
    @Override
    public void Log(String data) {
        System.out.println("Logged to File: " + data);
    }
}
