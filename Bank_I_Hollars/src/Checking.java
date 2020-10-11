public class Checking extends Account {

    //unique fields
    public double[] last10Checks;
    public int numChecks;
    public int checkNum;

    //2 types of constructors
    public Checking(){
        super();
        last10Checks = new double[10];
        numChecks=0;
        checkNum=1000;
    }
    public Checking(String name, long taxID, double balance){
        super(name,taxID,balance);
        last10Checks = new double[10];
        numChecks=0;
        checkNum=1000;

    }

    //This method stores the check number in the last10Checks array
    //Additionally, it makes a withdraw using the parent makeWithdraw method
    public void writeCheck(double amount){
        Account.addToArray(last10Checks,checkNum,numChecks);
        checkNum++;
        super.makeWithdraw(amount);
        numChecks++;
    }


    //override the parent display method to include checking history also
    public void display(){
        super.display();

        System.out.println("\n");
        System.out.println("Checking Account Records:\n");
        System.out.println("Last 10 Withdraws: ");
        for(int i =0 ; i<last10Checks.length ; i++){
            System.out.println("Check Number:"+last10Checks[i] + "   withdraw amount: " + last10Withdraws[i]);
        }
        System.out.println("\nLast 10 Deposits: ");
        for(int i =0 ; i<last10Deposits.length ; i++){
            System.out.println("Deposit Number: "+ (i+1) + "   deposit amount: " + last10Deposits[i]);
        }


    }


}
