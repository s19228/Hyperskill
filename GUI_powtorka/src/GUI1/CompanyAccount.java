package GUI1;

public class CompanyAccount extends Account {

    public CompanyAccount(double balance) {
        super(balance);
    }

    public void charge(){
        this.balance -= 50;
    }

    @Override
    public String toString() {
        return "Company account balace is: " + balance;
    }
}
