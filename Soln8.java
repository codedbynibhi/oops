import java.util.*;

interface Notification {
    void send(String message);
}

class EmailNotification implements Notification {
    @Override
    public void send(String message) {
        System.out.println("EMAIL: " + message);
    }
}

class SMSNotification implements Notification {
    @Override
    public void send(String message) {
        System.out.println("SMS: " + message);
    }
}

class PushNotification implements Notification {
    @Override
    public void send(String message) {
        System.out.println("PUSH: " + message);
    }
}

class NotificationService {
    void sendNotification(Notification notification, String message) {
        notification.send(message);
    }
}
public class Soln8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        NotificationService service = new NotificationService();
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String message = sc.nextLine().trim();
            Notification notification;
            if (type.equals("EMAIL")) {
                notification = new EmailNotification();
            } else if (type.equals("SMS")) {
                notification = new SMSNotification();
            } else {
                notification = new PushNotification();
            }

            service.sendNotification(notification, message);
        }
    }
}