class Account {

    long balance;
    String ownerName;
    boolean locked;

    Account(long b, String on, boolean loc) {
        this.balance = b;
        this.ownerName = on;
        this.locked = loc;
    }
}