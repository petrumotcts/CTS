package ro.ase.csie.cts.seminar2;

import java.math.BigDecimal;

import ro.ase.csie.cts.seminar2.solid.BankAccount;
import ro.ase.csie.cts.seminar2.solid.FeeBankAccount;
import ro.ase.csie.cts.seminar2.solid.InsuficientFundsException;
import ro.ase.csie.cts.seminar2.solid.Person;

public class Main {

	public static void main(String[] args) {
		
		
		Person p = new Person("Petru");
		BankAccount account = new BankAccount("INGB123242342", p);
		
		account.deposit(100);
		try {
			account.withdraw(30);
			account.withdraw(40);
			account.withdraw(70);

		} catch (InsuficientFundsException e) {
			System.out.println(e.getMessage());
		}
			
		System.out.println(account.getBalance());
		
		
		account = new FeeBankAccount("INGB123123234234", p);
		
		account.deposit(500);
		
		try {
			account.withdraw(100);
		} catch (InsuficientFundsException e) {
			System.out.println(e.getMessage());
		}
		
		System.out.println(account.getBalance());
		


	}

}
