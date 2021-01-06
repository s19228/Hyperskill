/**
 *
 *  @author Gryka Konrad S19228
 *
 */

package zad2;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyVetoException;
import java.beans.VetoableChangeListener;

public class AccountLimitator implements VetoableChangeListener {

    private final double limit;

    public AccountLimitator(double i) {
        this.limit = i;
    }

    @Override
    public void vetoableChange(PropertyChangeEvent evt) throws PropertyVetoException {
        double balance = (double) evt.getNewValue();
        if (balance < getLimit()) {
            throw new PropertyVetoException(evt.getPropertyName() +  "Unacceptable value change: " + evt.getNewValue(), evt);
        }
    }

    private double getLimit() {
        return limit;
    }
}
