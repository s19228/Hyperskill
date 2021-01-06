package GUI1;

abstract class Account {

    protected double balance;
    public Account array [];

    public abstract void charge();

    public Account(Account[] array) {
        this.array = array;
    }

    public Account(double balance) {
        this.balance = balance;
    }

    public void deposit (double amount){
        this.balance += amount;
    }

    public void withdraw (double ammount){
        this.balance -= ammount;
    }

    @Override
    public String toString() {
        return "Stan konta" +" "+ getClass().getName() + " " +  Math.round(this.balance);
    }

    public static void showAccountList(Account [] array){
        for (int i = 0; i < array.length; i++)
            System.out.println(array[i] + "\n");
    }
}
