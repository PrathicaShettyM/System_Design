package Example_3.ImprovedCode;

public class WhatsAppNotification implements Notifications{
    @Override
    public void sendMessage(String message){
        System.out.println("Send WhatsApp Notification: " + message);
    }
}
