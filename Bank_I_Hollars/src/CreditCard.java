public class CreditCard extends Account {

    //new fields
    long cardNumber;
    String[] last10Charges;
    int numCharges;

    //2 types of constructors
    public CreditCard(){
        super();
        last10Charges = new String[10];
        numCharges=0;
    }
    public CreditCard(String name, long taxID, double balance){
        super(name,taxID,balance);
        last10Charges = new String[10];
        numCharges=0;
    }

    //This method records the name of the charge in the last10Charges array.
    //It also increases/deposits into the credit balance (because the credit balance is like debt)
    public void creditCharge(String name, double amount) {
        if (amount >= 0 && amount <= 1000000) {
            Account.addToArray(last10Charges, name, numCharges);
            super.makeDeposit(amount);
            numCharges++;
        }
        else{
            System.out.println("Please enter a charge amount between 0 and 1000000.");
        }
    }


    //with method will withdraw/decrease the credit balance
    //by making a payment, you are decreasing your debt
    public void makePayment(double amount) {
        if (amount >= 0 && amount <= 1000000 && amount<=balance) {
            super.makeWithdraw(amount);
        }
        else{
            System.out.println("Please enter a payment amount between 0 and 1000000.\nAlso, you can only make a payment up to your credit balance amount. ");
        }
    }

    //override the parent display method to include credit history
    public void display(){
        super.display();

        System.out.println("\n");
        System.out.println("Credit Card Account Records:\n");
        System.out.println("Last 10 Charges: ");
        for(int i =0 ; i<last10Charges.length ; i++){
            System.out.println("Charge title: "+ last10Charges[i] + "   Charge amount: " + last10Deposits[i]);
        }
        System.out.println("\nLast 10 Payments: ");
        for(int i =0 ; i<last10Deposits.length ; i++){
            System.out.println("Deposit Number: "+ (i+1) + "   deposit amount: " + last10Withdraws[i]);
        }
    }


}
