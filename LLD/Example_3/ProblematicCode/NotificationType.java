package Example_3.ProblematicCode;

public enum NotificationType {
    SMS,
    EMAIL,
    PUSH,
    WHATSAPP;

    public void sendSMSNotification(String message){
        System.out.println("SMS: " + message);
    } 

    public void sendEmailNotification(String message){
        System.out.println("email: " + message);
    } 

    public void sendPushNotification(String message){
        System.out.println("Push: " + message);
    } 

    public void sendWhatsAppNotification(String message){
        System.out.println("WhatsApp: " + message);
    } 
}
