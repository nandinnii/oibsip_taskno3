package Task;
import java.util.Scanner;

public class Atm_Interface {
	String username,password,name,acc_no;
	float balance=0;
	int transactions=0;
	String transactionHistory="";

	public void createAccount() {
		Scanner n = new Scanner(System.in);
		System.out.println("Enter your name: ");
		this.name=n.nextLine();
		System.out.println("Enter Account Number: ");
		this.acc_no=n.nextLine();
		System.out.println("Enter your username");
		this.username=n.nextLine();
		System.out.println("Enter password");
		this.password=n.nextLine();
		System.out.println();
		System.out.println("Your registration is successfully completed");
		}
	
	public void login() {
		boolean flag=true;
		Scanner n = new Scanner(System.in);
		while(flag) {
			System.out.println("Enter your username :");
			String Username=n.nextLine();
			if(Username.equals(username)) {
				System.out.println("Enter password");
				String Password=n.nextLine();
				if(Password.equals(password)) {
					System.out.println("Login successful");
					flag=false;
				}
				else
					System.out.println("Password doesn't match, Please try again ");
				}
			else {
				System.out.println("\n Username Not Found");
			}
		}
	}
	
	public void deposit() {
		System.out.println("Enter amount to deposit,amount should be greater than zero:");
		Scanner n = new Scanner(System.in);
		float amount=n.nextFloat();
		balance=balance+amount;
		System.out.println("Amount "+amount+" has been deposited");
		transactions++;
		String transaction = amount+" has been credited to your account\n";
		transactionHistory = transactionHistory.concat(transaction);
	}
	
	public void withdraw() {
		System.out.println("Enter amount to withdraw ");
		Scanner n = new Scanner(System.in);
		float amount=n.nextFloat();
		if(balance>=amount) {
			balance =balance-amount;
			System.out.println(amount +" Withdrawl succesul");
			transactions++;
			String transaction = amount+" has been successfully withdrawn\n";
			transactionHistory = transactionHistory.concat(transaction);
		}
		else
			System.out.println("Insufficient Balance ");
	}
	
	public void transfer() {
		Scanner n = new Scanner(System.in);
		System.out.println("\nEnter Receiver's Name : ");
		String receiver=n.nextLine();
		System.out.println("\nEnter Amount to transfer : ");
		float amount = n.nextFloat();
		if(amount<=balance) {
			balance = balance-amount;
			System.out.println(amount+" successfully transferred ");
			transactions++;
			String transaction = amount+" transferred to "+receiver+"\n";
			transactionHistory = transactionHistory.concat(transaction);
		}
	}
	
	public void balanceEnquiry() {
		System.out.println("Your account balance is "+balance);
	}
	
	public void transactionHistory() {
		System.out.println("\n"+transactionHistory);
	}
	
	public static void main(String[] args) {
	// TODO Auto-generated method stub
	Scanner n = new Scanner(System.in);
	
	System.out.println("ATM INTERFACE\n\n");
	
	System.out.println(" Enter 1 to Create account\n 0 to exit\n");
	
	System.out.println("Enter your preference");
	
	int input=n.nextInt();
	
	if(input==1) {
		Atm_Interface user = new Atm_Interface();
		user.createAccount();
		System.out.println("\nplease enter atm details to login\n");
		user.login();
		boolean exit=false;
		
		while(!exit) {
			System.out.println("\n1.Deposit \n2.withdraw \n3.Trasfer \n4.check balance \n5.check transactions \n6.Exit\n");
			System.out.println("Enter your choice");
			int choice = n.nextInt();
			if(choice<7 && choice>0) {
				switch(choice) {
					case 1:user.deposit();
					break;
					case 2:user.withdraw();
					break;
					case 3:user.transfer();
					break;
					case 4:user.balanceEnquiry();
					break;
					case 5:user.transactionHistory();
					break;
					case 6:exit=true;
					break;
				}
			}
		}
	}
	}
}
