/*
This is the parent class of Checking,Savings,and CreditCard
 */
public class Account {

    protected String name;
    protected long taxID;
    protected double balance;
    protected double[] last10Withdraws;
    protected double[] last10Deposits;
    protected int numWithdraws;
    protected int numDeposits;


    //specific constructor
    public Account(String name_, long taxID_, double balance_) {
        name = name_;
        taxID = taxID_;
        balance = balance_;
        last10Withdraws = new double[10];
        last10Deposits = new double[10];
        numWithdraws = 0;
        numDeposits =0;

    }

    //default constructor
    public Account() {
        name = "N/A";
        taxID = 0;
        balance = 0;
        last10Withdraws = new double[10];
        last10Deposits = new double[10];
        numWithdraws = 0;
        numDeposits =0;


    }

    //These are the Setter methods
  public void setName(String s){
      name = s;
  }
  public void setTaxID(long id){
      if (String.valueOf(id).length() == 9){
          taxID = id;
      }
      else{
          System.out.println("Invalid input: social security number needs to be 9 digits");
      }
    }
  public void setBalance(double bal){
      if(bal>=0){
          balance = bal;
      }
      else{
          System.out.println("Invalid input: negative balance error");
      }
  }


  //These are the Getter methods
    public String getName(){return name;}
    public long getTaxID(){return taxID;}
    public double getBalance(){return balance;}



    //This method adds to the balance and puts the deposit into the deposit array
    public void makeDeposit( double amount ){
      if (amount>=0 && amount <= 1000000){
          balance+= amount;
          Account.addToArray(last10Deposits,amount,numDeposits);
          numDeposits++;
      }
      else{
          System.out.println("Please enter deposit amount between 0 and 1000000.");
      }
    }

    //This method decreases the balance and puts the withdraw into the withdraw array
    public void makeWithdraw( double amount ){
        if ( (amount>=0) && (amount <= 1000000) && (balance>=amount) ){
            balance-= amount;
            Account.addToArray(last10Withdraws,amount,numWithdraws);
            numWithdraws++;
        }
        else{
            System.out.println("Please enter withdraw amount between 0 and 1000000.\nMake sure that your balance is greater than your withdraw request.");
        }
    }


    /*
    This is a helper method to add a value into the deposit/withdraw arrays.
    The method adds a new value to the array if it hasn't been filled yet.
    If the array is filled, the method updates the array to contain the 10 most
    recent entries.
*/
    //Helper method with double array
    public static void addToArray(double[] arr, double value, int howManyInArray){
      if (howManyInArray<arr.length){
          arr[howManyInArray] = value;
      }
      //if full, this will update to 10 most recent entries by shifting the values over
      else{
          for (int i=0; i<arr.length-1; i++){
              arr[i] = arr[i+1];
          }
          arr[arr.length-1] = value;
      }
    }

    //Same Helper method with String array (used to store the titles of credit charges later)
    public static void addToArray(String[] arr, String value, int howManyInArray){
        if (howManyInArray<arr.length){
            arr[howManyInArray] = value;
        }
        //if full, this will update to 10 most recent entries by shifting the values over
        else{
            for (int i=0; i<arr.length-1; i++){
                arr[i] = arr[i+1];
            }
            arr[arr.length-1] = value;
        }
    }

    

    public void display(){
        System.out.println("\n\n\n\n\n\n\n\n\n");
        System.out.println("*.*.*.*.*.*.*.*.*.*.*.*.*.*.*.*.*.*.*.*.*.*.*.*.*.*.*.*.*.*.*.*.*.*.*.");
        System.out.println("Account Name: " + name );
        System.out.println("Account Social Security Number : " + taxID);
        System.out.println("Account Balance: " + balance);
        System.out.println("*.*.*.*.*.*.*.*.*.*.*.*.*.*.*.*.*.*.*.*.*.*.*.*.*.*.*.*.*.*.*.*.*.*.*.");

    }

}
