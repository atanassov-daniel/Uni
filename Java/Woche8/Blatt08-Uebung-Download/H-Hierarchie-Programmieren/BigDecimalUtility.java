import java.math.MathContext;
import java.math.RoundingMode;
import java.math.BigDecimal;

public class BigDecimalUtility
{
    public static boolean equalValues(final BigDecimal bigDecimal, final BigDecimal bigDecimal2) {
        final int min = Math.min(bigDecimal.scale(), bigDecimal2.scale());
        return bigDecimal.setScale(min, RoundingMode.HALF_EVEN).equals(bigDecimal2.setScale(min, RoundingMode.HALF_EVEN));
    }
    
    public static BigDecimal sqrt(final BigDecimal bigDecimal) {
        return bigDecimal.sqrt(MathContext.DECIMAL128);
    }
}