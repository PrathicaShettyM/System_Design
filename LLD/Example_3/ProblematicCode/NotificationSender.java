package Example_3.ProblematicCode;

import java.util.List;

public class NotificationSender {
    public void sendNotifications(List<NotificationType> notificationTypes, String message){
        for(NotificationType notificationType : notificationTypes){
            switch (notificationType) {
                case SMS:
                    notificationType.sendSMSNotification(message);
                    break;
                
                case EMAIL:
                    notificationType.sendEmailNotification(message);
                    break;

                case PUSH:
                    notificationType.sendPushNotification(message);
                    break;

                case WHATSAPP:
                    notificationType.sendWhatsAppNotification(message);
                    break;

                default:
                    break;
            }
        }
    }
}


// the problem with this code
// 1. no need to segregate each of the notifications to separate class as it does n't make much difference
// 2. this class will be modified everythime we introduce or remove any type of notifications - which is a clear violation of OCP



// This gets us to the 2nd principle: OCP - Open Closed Principle
// this is one the most important principles


// It says: "A class should be open for extensions but clised for modifications"
