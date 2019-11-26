package interview.hw;

import java.math.BigDecimal;

public class BigDecimalTest {
    public static void main(String[] args) {
        new BigDecimalTest().testBigdecimal();
    }

    private void testBigdecimal(){
        BigDecimal serviceAmount = new BigDecimal(998.23).setScale(2,BigDecimal.ROUND_HALF_UP);

        BigDecimal refundAmount = new BigDecimal(797.77).setScale(2,BigDecimal.ROUND_HALF_UP);
        BigDecimal billAmount = new BigDecimal(77.77).setScale(2,BigDecimal.ROUND_HALF_UP);

        BigDecimal refundBill = billAmount.multiply (refundAmount.divide(serviceAmount,2,BigDecimal.ROUND_HALF_UP));
        System.out.println(refundBill.setScale(2,BigDecimal.ROUND_HALF_UP));
    }
}
