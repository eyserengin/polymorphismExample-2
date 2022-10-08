package core;

public class MailLogger implements Logger {
    @Override
    public void Log(String data) {
        System.out.println("Logged to Mail: " + data);
    }
}
