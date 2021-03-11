package ro.ase.csie.cts.seminar3;

import java.util.HashMap;
import java.util.Map;

public class Main {

	public static void main(String[] args) {
		
		
		
		NotificationService smsService = new SMSNotificationService();
		NotificationService emailService = new EmailNotificationService();
		
		Map<Person, Receivable> employees = new HashMap<>();

		Person p1 = new Person("Chuck Norris");
		p1.setEmail("chuck@norris.com");
		p1.setMobile("+4234230423");
		CreditBankAccount b1 = new CreditBankAccount(smsService, "RFZ123123123", p1, -500);
		
		Person p2 = new Person("Arnold");
		p2.setEmail("arnold@arnold.com");
		p2.setMobile("+3453454230423");
		DebitBankAccount b2 = new FeeBankAccount(emailService, "INGB12432423", p2);
		
		Person p3 = new Person("Van Damme");
		p3.setEmail("van@damme.com");
		p3.setMobile("+44534634423");
		DebitBankAccount b3 = new DebitBankAccount(emailService, "BT12312323", p3);
		
		
		employees.put(p1, b1);
		employees.put(p2, b2);
		employees.put(p3, b3);
		
		for(Receivable a : employees.values()) {
			a.deposit(1000);
		}
		
		Map<Person, Payable> union = new HashMap<>();
		
		union.put(p2, b2);
		union.put(p3, b3);
		
		for(Payable a : union.values()) {
			try {
				a.withdraw(10);
			} catch (InsuficientFundsException ex) {
				System.out.println(ex.getMessage());
			}
		}
		
		
		System.out.println("\n\n");
		
		try {
			b2.transfer(b3, 200);
		} catch (InsuficientFundsException e) {
			System.out.println(e.getMessage());
		}
		
	}

}
