public class Savings extends Account {

    //2 types of constructors
    public Savings(){
        super();
    }
    public Savings(String name, long taxID, double balance){
        super(name,taxID,balance);
    }

    //overrides the parent display method to include additional savings records
    public void display(){

        super.display();

        System.out.println("\n");
        System.out.println("Savings Account Records:\n");
        System.out.println("Last 10 Withdraws: ");
        for(int i =0 ; i<last10Withdraws.length ; i++){
            System.out.println("Withdraw Number: "+ (i+1) + "   Withdraw amount: " + last10Withdraws[i]);
        }
        System.out.println("\nLast 10 Deposits: ");
        for(int i =0 ; i<last10Deposits.length ; i++){
            System.out.println("Deposit Number: "+ (i+1) + "   deposit amount: " + last10Deposits[i]);
        }
    }
}
