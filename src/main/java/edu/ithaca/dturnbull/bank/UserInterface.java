package edu.ithaca.dturnbull.bank;
import java.util.Scanner;

public class UserInterface{

    User Tim = new User(new BankAccount[] {new CheckingAccount(500), new SavingAccount(200, .01, 50)}, "tbartlett@gmail.com", "P@55w0rd"); 
    User Tamar = new User(new BankAccount[] {new CheckingAccount(500), new SavingAccount(200, .01, 50)}, "tabartlett@gmail.com", "P@55w0rd"); 
    User Rachel = new User(new BankAccount[] {new CheckingAccount(200), new SavingAccount(100, .01, 50)}, "rbartlett@gmail.com", "P@55w0rd"); 
    User Sophie = new User(new BankAccount[] {new CheckingAccount(200), new SavingAccount(100, .01, 50)}, "sbartlett@gmail.com", "P@55w0rd"); 
    
    public static void main(String[] args){
        Scanner userInput = new Scanner(System.in);
        
        System.out.println("Enter username:");
        String userName = userInput.nextLine();
        
        System.out.println("Enter password:");
        String userPassword = userInput.nextLine();

        while(!userName.isEmailValid == true && !userPassword.isPasswordValid == true){ 
            
            System.out.println("Sorry, we can't recognize that login, please try again.")
            System.out.println("Enter username:");
            userName = userInput.nextLine();
            
            System.out.println("Enter password:");
            userPassword = userInput.nextLine();
        }

        System.out.println("Select an account: \n 1: Tim \n 2: Tamar \n 3: Rachel \n 4: Sophie ");
        String selectedUser = userInput.nextLine();
        while(selectedUser != "Tim" || selectedUser != "Tamar" || selectedUser != "Rachel" || selectedUser != "Sophie"){
            System.out.println("Please enter a vaild customer name.");
        }

        System.out.println("Select an account type: \n 1: Checkings \n 2: Savings");
        String selectedType = userInput.nextLine();
        while(selectedType != "Checkings" || selectedType != "Savings"){
            System.out.println("Please enter a vaild account type name.");
        }

        System.out.println("Select the action you wish to complete: \n 1: Withdraw \n 2: Deposit \n 3: Transfer");
        String selectedAction = userInput.nextLine();
        while(selectedAction != "Withdraw" || selectedAction != "Deposit" || selectedAction != "Transfer"){
            System.out.println("Please enter a vaild action.");
        }

        System.out.println("Select the amount you wish to " + selectedAction + ": \n 1: Withdraw \n 2: Deposit \n 3: Transfer");
        String selectedAmount = userInput.nextLine();
        while(!selectedAmount.isAmountValid == true){
            System.out.println("Please enter a vaild amount.");
        }

        int account = -1;
            if (selectedType == "Checkings"){
                account = 0;
            }
            else{
                account = 1;
            }

        if(selectedAction == "Withdraw"){
            account.withdraw(selectedAmount.toInt());
        }
        else if(selectedAction == "Deposit"){
            account.deposit(selectedAmount.toInt());
        }
        else{
            account.transfer(selectedAmount.toInt());
        }

        System.out.println(selectedUser + "'s" + selectedType + " account balance is now:" + account.getBalance());

        

    }
    
}
