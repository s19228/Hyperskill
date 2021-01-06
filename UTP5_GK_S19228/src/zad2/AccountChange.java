/**
 * @author Gryka Konrad S19228
 */

package zad2;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyVetoException;
import java.beans.VetoableChangeListener;

public class AccountChange implements VetoableChangeListener {

    @Override
    public void vetoableChange(PropertyChangeEvent evt) throws PropertyVetoException {
        double newValue = (double) evt.getNewValue();
        double oldValue = (double) evt.getOldValue();
        if (newValue > 0) {
            System.out.println(evt.getPropertyName() + "Value changed from " + oldValue + " to " + newValue);
        } else
            System.out.println(evt.getPropertyName() + "Value changed from " + oldValue + " to " + newValue + ", balance < 0!");
    }
}
