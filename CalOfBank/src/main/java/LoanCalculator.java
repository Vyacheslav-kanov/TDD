import java.math.BigDecimal;
import java.math.RoundingMode;

public class LoanCalculator {

    public double getMonth(int loan, double percent, int term){
        percent = percent * 0.01 / 12;
        double result = (loan * (percent * Math.pow(1 + percent, term)) / (Math.pow(1 + percent, term) - 1));
        BigDecimal dec = new BigDecimal(result);
        dec = dec.setScale(2, RoundingMode.HALF_UP);
        result = dec.doubleValue();
        return result;
    }

    public double getAllAmount(int loan, double percent, int term){
        percent = percent * 0.01 / 12;
        double result = loan * (percent * Math.pow(1 + percent, term)) / (Math.pow(1 + percent, term) - 1) * term;
        BigDecimal dec = new BigDecimal(result);
        dec = dec.setScale(2, RoundingMode.HALF_UP);
        result = dec.doubleValue();

        return result;
}

    public double getOverpayment(int loan, double percent, int term){
        percent = percent * 0.01 / 12;
        double result = ((loan * (percent * Math.pow(1 + percent, term)) / (Math.pow(1 + percent, term) - 1)) * term - loan);
        BigDecimal dec = new BigDecimal(result);
        dec = dec.setScale(2, RoundingMode.HALF_UP);
        result = dec.doubleValue();

        return result;
    }
}
