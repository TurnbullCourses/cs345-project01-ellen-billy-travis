package edu.ithaca.dturnbull.bank;
import java.util.Scanner;

import javax.sound.sampled.SourceDataLine;

public class UserInterface{

    static User Tim = new User(new BankAccount[] {new CheckingAccount(500), new SavingAccount(200, .01, 50)}, "tbartlett@gmail.com", "P@55w0rd"); 
    static User Tamar = new User(new BankAccount[] {new CheckingAccount(500), new SavingAccount(200, .01, 50)}, "tabartlett@gmail.com", "P@55w0rd"); 
    static User Rachel = new User(new BankAccount[] {new CheckingAccount(200), new SavingAccount(100, .01, 50)}, "rbartlett@gmail.com", "P@55w0rd"); 
    static User Sophie = new User(new BankAccount[] {new CheckingAccount(200), new SavingAccount(100, .01, 50)}, "sbartlett@gmail.com", "P@55w0rd"); 
    
    public static void main(String[] args){
        Scanner userInput = new Scanner(System.in);
        
        System.out.println("Select an account (Enter the number): \n 1: Tim \n 2: Tamar \n 3: Rachel \n 4: Sophie ");
        int selectedUser = userInput.nextInt();
        while(selectedUser < 1 && selectedUser > 4){
            System.out.println(selectedUser + " not recognized, please enter a vaild customer name.");
            selectedUser = userInput.nextInt();
        }

        User user;
        if(selectedUser == 1){
            user = Tim;
        }
        else if(selectedUser == 2){
            user = Tamar;
        }
        else if(selectedUser == 3){
            user = Rachel;
        }
        else{
            user = Sophie;
        }
        userInput.reset();
        System.out.println("Enter username:");
        String userName = userInput.nextLine();
        
        System.out.println("Enter password:");
        String userPassword = userInput.nextLine();

        while(!user.confirmCredentials(userName, userPassword)){ 
            
            System.out.println("Sorry, we can't recognize that login, please try again.");
            userInput.reset();
            System.out.println("Enter username:");
            userName = userInput.nextLine();
            
            System.out.println("Enter password:");
            userPassword = userInput.nextLine();
        }

        

        System.out.println("Select an account type: \n 1: Checkings \n 2: Savings");
        int selectedType = userInput.nextInt();
        while(selectedType > 3 && selectedType < 1){
            System.out.println("Please enter a vaild type.");
            selectedType = userInput.nextInt();
        }

        selectedType -= 1;

        System.out.println("Select the action you wish to complete: \n 1: Withdraw \n 2: Deposit \n 3: Transfer");
        int selectedAction = userInput.nextInt();

        while(selectedAction > 3 && selectedAction < 1){
            System.out.println("Please enter a vaild action.");
            selectedAction = userInput.nextInt();
        }

        System.out.println("Entered an amount");
        Double selectedAmount = userInput.nextDouble();

        while(BankAccount.isAmountValid(selectedAmount) == false){
            System.out.println("Please enter a vaild amount");
            selectedAmount = userInput.nextDouble();
        }

            //Withdraw
        if(selectedAction == 1){
            try{
            user.getAccount(selectedType).withdraw(selectedAmount);
            }
            catch(InsufficientFundsException exception){
                System.out.println("Insufficient funds: Transaction failed!");
            }
        }
            //Deposit
        else if(selectedAction == 2){
            user.getAccount(selectedType).deposit(selectedAmount);
        }
            //transfer
        else{
            //user.getAccount(account).transfer(selectedAmount);
        }

        //System.out.println(selectedUser + "'s" + selectedType + " account balance is now:" + user.getAccount(account).getBalance());
        System.out.println("Account balance is now: " + user.getAccount(selectedType).balance);
        

    }
    
}
