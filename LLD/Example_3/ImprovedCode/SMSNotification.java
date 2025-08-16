package Example_3.ImprovedCode;

public class SMSNotification implements Notifications {
    @Override
    public void sendMessage(String message){
        System.out.println("Send SMS Notification: " + message);
    }
}
