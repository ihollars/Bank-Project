/*
This bank account project allows the user to make transactions to
3 basic kinds of accounts (checking,savings,and credit). The user interacts
with the program through a command line interface. This project
focuses on the concept of inheritance by deriving
specific kinds of accounts from a parent class called Account.
The RunBank class contains the main method that loops through the
instructions for the user.
 */


import java.util.Scanner;

public class RunBank {

    public static void main(String[] args) {

        //create 3 separate accounts with $100 balance
        Checking myChecking = new Checking("My Checking",123456789,100);
        Savings mySavings = new Savings("My Savings",123456789,100);
        CreditCard myCreditCard = new CreditCard("My Credit Card", 123456789,100);

        Scanner scan = new Scanner(System.in);


        //Main Loop
        boolean stayOnPage = true;
        while (stayOnPage){

            System.out.println("*.*.*.*.*.*.*.*.*.*.*.*.*.*.*.*.*.*.*.*.*.*.*.*.*.*.*.*.*.*.*.*.*.*.*.");
            System.out.println("Balances:");
            System.out.print("Checking: $"+myChecking.getBalance());
            System.out.print("    Savings: $"+mySavings.getBalance());
            System.out.print("    Credit Card Balance (debt) : $"+myCreditCard.getBalance()+"\n");
            System.out.println("*.*.*.*.*.*.*.*.*.*.*.*.*.*.*.*.*.*.*.*.*.*.*.*.*.*.*.*.*.*.*.*.*.*.*.\n");

            System.out.println("*.*.*.*.*.*.*.*.*.*.*.*.*.*.*.*.*.*.*.*.*.*.*.*.*.*.*.*.*.*.*.*.*.*.*.");
            System.out.println("Select a MENU option Number (1-10).");
            System.out.println("*.*.*.*.*.*.*.*.*.*.*.*.*.*.*.*.*.*.*.*.*.*.*.*.*.*.*.*.*.*.*.*.*.*.*.");
            System.out.println("1. Savings Deposit");
            System.out.println("2. Savings Withdraw");
            System.out.println("3. Checking Deposit");
            System.out.println("4. Write a Check");
            System.out.println("5. Credit Card Payment");
            System.out.println("6. Make a Credit Charge");
            System.out.println("7. Display Savings (Scroll UP to view)");
            System.out.println("8. Display Checking (Scroll UP to view)");
            System.out.println("9. Display Credit Card (Scroll UP to view)");
            System.out.println("10. Select 10 to EXIT");

            int response = scan.nextInt();
            switch (response){
                case 1:
                    System.out.println("Enter Savings Deposit amount: ");
                    double d = scan.nextDouble();
                    mySavings.makeDeposit(d);
                    break;
                case 2:
                    System.out.println("Enter Savings Withdraw amount: ");
                    d = scan.nextDouble();
                    mySavings.makeWithdraw(d);
                    break;
                case 3:
                    System.out.println("Enter Checking Deposit amount: ");
                    d = scan.nextDouble();
                    myChecking.makeDeposit(d);
                    break;
                case 4:
                    System.out.println("Enter Check amount: ");
                    d = scan.nextDouble();
                    myChecking.writeCheck(d);
                    break;
                case 5:
                    System.out.println("Enter Credit Card payment amount: ");
                    d = scan.nextDouble();
                    myCreditCard.makePayment(d);
                    break;
                case 6:

                    System.out.println("Enter the charge amount: ");
                    d = scan.nextDouble();
                    scan.nextLine(); //this is needed to clear out the extra \n that the scan.nextDouble() left over
                    System.out.println("Enter what the charge was for (brief description): ");
                    String s = scan.nextLine();

                    myCreditCard.creditCharge(s,d);
                    break;
                case 7: mySavings.display();
                    break;
                case 8: myChecking.display();
                    break;
                case 9: myCreditCard.display();
                    break;
                case 10: stayOnPage = false;
                    break;
                default:
                    System.out.println("please enter a number option 1-10\n\n\n");
                    break;
            }
        }

    }

}



