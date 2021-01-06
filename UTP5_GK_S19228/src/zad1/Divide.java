/**
 * @author Gryka Konrad S19228
 */

package zad1;

import java.math.BigDecimal;
import java.math.MathContext;

public class Divide implements Activity {

    @Override
    public BigDecimal calculate(BigDecimal db1, BigDecimal bd2) {
        return db1.divide(bd2, new MathContext(7));
    }

}
