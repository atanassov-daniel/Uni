import java.math.*;
import java.util.Random;

public class TestUtils {
    public static BigDecimal between(BigDecimal min, BigDecimal MAX) {
        int digitCount = Math.max(min.precision(), MAX.precision());
        int bitCount = (int) (digitCount / Math.log10(2.0));

        // convert Random BigInteger to a BigDecimal between 0 and 1
        BigDecimal alpha = new BigDecimal(new BigInteger(bitCount, new Random())).movePointLeft(digitCount);

        return min.add(MAX.subtract(min).multiply(alpha, new MathContext(digitCount)));
    }

    public static Punkt neuerPunkt() {
        double min = -100;
        double max = 100;

        BigDecimal x1 = between(new BigDecimal(min), new BigDecimal(max));
        BigDecimal y1 = between(new BigDecimal(min), new BigDecimal(max));

        return new Punkt(x1, y1);
    }
}
