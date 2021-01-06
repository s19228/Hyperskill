/**
 * @author Gryka Konrad S19228
 */

package zad1;

import java.math.BigDecimal;

public class Add implements Activity {

    @Override
    public BigDecimal calculate(BigDecimal db1, BigDecimal bd2) {
        return db1.add(bd2);
    }

}
