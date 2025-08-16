package Example_3.BetterCode;

import java.util.List;

public class NotificationSender {
    public void sendNotifications(List<String> notificationTypes, String message){
        for(String notificationType : notificationTypes){
            switch (notificationType) {
                case "SMS":
                    SMSNotification sms = new SMSNotification();
                    sms.sendSMSNotification(message);
                    break;
                
                case "EMAIL":
                    EmailNotification email = new EmailNotification();
                    email.sendEmailNotification(message);
                    break;

                case "PUSH":
                    PushNotifications push = new PushNotifications();
                    push.sendPushNotification(message);
                    break;
                
                case "WHATSAPP":
                WhatsAppNotification whatsapp = new WhatsAppNotification();
                    whatsapp.sendWhatsAppNotification(message);
                    break;    

                default:
                    break;
            }
        }
    }
}


// the problem with this code
// 1. this is a better code but still it feels like some redundant tasks


// This gets us to the 2nd principle: OCP - Open Closed Principle
// this is one the most important principles


// It says: "A class should be open for extensions but clised for modifications"
