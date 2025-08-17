/*
 It states that high-level modules should not depend on low-level modules. Both should depend on abstractions.
 Dpeendency Inversion Principle (DIP) for abstarction
  High level modules should always be in a abstarct state then only it won't tightly coupled.
*/

/*
   What it means:
            High-level modules (business logic) shouldn't depend on low-level modules (implementation details).
   Both should depend on abstractions (interfaces).Abstractions should not depend on details; details should depend on abstractions.

    How to spot it in code review:
        Look for high-level classes directly creating instances of concrete low-level classes
    using new(). This creates tight coupling.
*/

//violation code
class EmailService{
    public void sendEmail(String message) {
        System.out.println("Sending email: " + message);
    }
}
class MotionSensor{
    EmailService emailService;
    MotionSensor(EmailService service){
        this.emailService = service;
    }
    public void detectMotion() {
        System.out.println("Motion detected!");
        emailService.sendEmail("Motion detected at your home!");
    }
}


//Non-Violatied code
interface Notifier{
    void notify(String message);
}

class EmailNotifier implements Notifier {
    @Override
    public void notify(String message) {
        System.out.println("Sending email: " + message);
    }
}

class SMSNotifier implements Notifier {
    @Override
    public void notify(String message) {
        System.out.println("Sending SMS: " + message);
    }
}

class MotionSensorWithNotifier {
    private Notifier notifier;

    MotionSensorWithNotifier(Notifier notifier) {
        this.notifier = notifier;
    }

    public void detectMotion() {
        System.out.println("Motion detected!");
        notifier.notify("Motion detected at your home!");
    }
}


public class DependencyInversionPrinciple {
    public static void main(String[] args) {
        // Using the EmailService directly (Violation of DIP) violation code
        EmailService emailService = new EmailService();
        MotionSensor motionSensor = new MotionSensor(emailService);
        motionSensor.detectMotion();

        // Using Notifier abstraction (Adhering to DIP) non violation code
        Notifier emailNotifier = new EmailNotifier();
        MotionSensorWithNotifier motionSensorWithEmail = new MotionSensorWithNotifier(emailNotifier);
        motionSensorWithEmail.detectMotion();

        Notifier smsNotifier = new SMSNotifier();
        MotionSensorWithNotifier motionSensorWithSMS = new MotionSensorWithNotifier(smsNotifier);
        motionSensorWithSMS.detectMotion();
    }
}