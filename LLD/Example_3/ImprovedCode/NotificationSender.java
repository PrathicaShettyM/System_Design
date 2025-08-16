package Example_3.ImprovedCode;

import java.util.List;

public class NotificationSender {
    public void sendNotifications(List<Notifications> notifications, String message){
        for(Notifications notificationType : notifications){
            notificationType.sendMessage(message);
        }
    }
}

// Now this follows the OCP: Open CLosed Principle
// So this means in some of the cases, we shd not keep changing/updating a class rather make tht class extensible

// For example: Payments system
// suppose now u support only credit card payment, tomorrow u introduce UPI, Netbanking etc
// then u shd make tht class which handles all these extensible rather than making change to the code evertime a new payment method comes up
// u just need to alter a function and it shd be working fine with all the other piece of code
// its ok if u impact a single class, but it shd not be like u impact every class


// In good words
// how to improve?
// we shd try to think tht if further alteration in the requirements can unnecessarily impact code of a class, its violating the OCP

// whts the improvement here: 
// 1. we made an INTERFACE instead of a class or enum to handle send Notification message, which can be overriden instead of writing same repititive code
// 2. individual type of notifications IMPLEMENTING the interface
// 3. Instead of being tightly coupled to type of notifications, we now depend on the notifications interface
// 4. even if we add or remove the notifications, sender class isnt affected
// 5 its a good idea to depend on abstractions rather than concrete classes(which has exact logic like separate class for email, sms etc)