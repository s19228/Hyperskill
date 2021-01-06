package GUI1;

public class IndividualAccount extends Account {

    public IndividualAccount(double balance) {
        super(balance);
    }

    public void charge(){
        balance -= 5;
    }

    @Override
    public String toString() {
        return "Individual account balace is: " + balance;
    }

}
