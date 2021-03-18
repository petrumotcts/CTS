package ro.ase.csie.cts.seminar4.banking;

public class SMSNotificationService implements NotificationService {

	@Override
	public void sendNotification(Person destination, String msg) {
		System.out.println("Sending sms to " + destination.getMobile());
		System.out.println(msg);

	}

}
