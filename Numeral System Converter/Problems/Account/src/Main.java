class Main{
    public static void main(String[] args) {

        Account account = new Account();
        //account.setLocked(true);
        System.out.println(account.isLocked());


    }
}

class Account {

    private long balance;
    private String ownerName;
    private boolean locked;

    public Account(){
        this.locked = true;
    }

    public long getBalance() {
        return balance;
    }

    public void setBalance(long balance) {
        this.balance = balance;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public boolean isLocked() {
        return locked;
    }

    public void setLocked(boolean locked) {
        this.locked = locked;
    }
}