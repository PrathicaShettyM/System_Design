package Example_3.ImprovedCode;

public class EmailNotification implements Notifications {
    @Override
    public void sendMessage(String message){
        System.out.println("Send Email Notification: " + message);
    }
}
