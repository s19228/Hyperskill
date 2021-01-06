/**
 * @author Gryka Konrad S19228
 */

package zad2;

import java.beans.PropertyChangeSupport;
import java.beans.PropertyVetoException;
import java.beans.VetoableChangeListener;
import java.beans.VetoableChangeSupport;

public class Account {

    private int accNo;
    private double balance;
    private static int index = 0;

    private final PropertyChangeSupport pcs = new PropertyChangeSupport(this);
    private final VetoableChangeSupport vcs = new VetoableChangeSupport(this);

    public synchronized void addVetoableChangeListener(VetoableChangeListener vetoableChangeListener) {
        vcs.addVetoableChangeListener(vetoableChangeListener);
    }

    public Account(int i) {
        this.balance = i;
        this.accNo = ++index;
    }

    public Account() {
        this.balance = 0;
        this.accNo += ++index;
    }

    public void deposit(double i) throws PropertyVetoException {
        this.balance += i;
    }

    public void withdraw(double i) throws PropertyVetoException {
        this.balance -= i;
    }

    public void transfer(Account account, double money) throws PropertyVetoException {
        setTransfer(account, money);
    }

    private synchronized void setTransfer(Account account, double i) throws PropertyVetoException {
        setBalance(this.balance - i);
        account.setBalance(account.balance + i);
    }

    private synchronized void setBalance(double balance) throws PropertyVetoException {
        int previousValue = (int) this.balance;
        vcs.fireVetoableChange(accNo + ": ", (double) previousValue, (double) (int) balance);
        this.balance = balance;
        pcs.firePropertyChange(accNo + ": ", (double) previousValue, (double) (int) balance);
    }

    @Override
    public String toString() {
        return "Acc " + accNo + ": " + balance;
    }
}
