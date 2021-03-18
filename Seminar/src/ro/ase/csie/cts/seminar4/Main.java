package ro.ase.csie.cts.seminar4;


import java.math.BigInteger;
import java.util.Random;

import ro.ase.csie.cts.seminar4.banking.Bank;
import ro.ase.csie.cts.seminar4.banking.BankAccount;
import ro.ase.csie.cts.seminar4.banking.CreditBankAccount;
import ro.ase.csie.cts.seminar4.banking.DebitBankAccount;
import ro.ase.csie.cts.seminar4.banking.EmailNotificationService;
import ro.ase.csie.cts.seminar4.banking.InsuficientFundsException;
import ro.ase.csie.cts.seminar4.banking.NotificationService;
import ro.ase.csie.cts.seminar4.banking.Person;

public class Main {

	public static void main(String[] args) {
		NotificationService emailService = new EmailNotificationService();

		Person p3 = new Person("Van Damme");
		p3.setEmail("van@damme.com");
		p3.setMobile("+44534634423");
		
		

		CreditBankAccount b = CreditBankAccount.createCreditBankAccountWithBalance(emailService, "INGB2423423", p3, 100);
		
		CreditBankAccount b1 = CreditBankAccount.createCreditBankAccount(emailService, "RFZ234234234", p3); 
		
		BigInteger bi = new BigInteger(24, 11, new Random());
		BigInteger bi2 = BigInteger.probablePrime(12, new Random());
		
		Boolean value = Boolean.valueOf(false);
		
		b.deposit(50);
		
		System.out.println(b.toString());
		
		Elvis elvis = Elvis.getInstance();
		elvis.sing();
		
		Elvis elvis2 = Elvis.getInstance();
		
		System.out.println(elvis == elvis2);
		
		ElvisV2 elvisV2 = ElvisV2.INSTANCE;
		elvisV2.sing();
		
		Bank bank = Bank.getInstance();
		
		Person adult = new Person("Van Damme");
		adult.setEmail("van@damme.com");
		adult.setMobile("+44534634423");
		adult.setAge(30);
		adult.setNotificationType(Person.NotificationType.EMAIL);
		
		Person child = new Person("Van Damme Junior");
		child.setEmail("vanjr@damme.com");
		child.setMobile("+44534634423");
		child.setAge(14);
		
		
		DebitBankAccount debit1 = bank.openDebitAccount(adult);
		
		DebitBankAccount debit2 = bank.openDebitAccount(child);
		
		debit1.deposit(20);
		debit2.deposit(5);
		try {
			debit1.withdraw(15);
			debit2.withdraw(3);
		} catch (InsuficientFundsException e) {
			System.out.println(e.getMessage());
		}
		
		System.out.println(debit1);
		System.out.println(debit2);
		
	}

}
