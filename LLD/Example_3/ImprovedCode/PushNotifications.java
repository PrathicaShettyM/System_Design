package Example_3.ImprovedCode;

public class PushNotifications implements Notifications{
    @Override
    public void sendMessage(String message){
        System.out.println("Send Push Notification: " + message);
    }
}
