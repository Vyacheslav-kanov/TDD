import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class TestCalculator {

    @Test
    public void calcMonth() {
        LoanCalculator calculator = new LoanCalculator();
        int loanAmount = (int) random(500000, 1000000);
        double percent = random(10, 50);
        int termMonth = (int) random(3, 600);

        double result = calculator.getMonth(loanAmount, percent, termMonth);
        //Получаю результат реализованного калькулятора
        percent = percent * 0.01 / 12;
        //Перевожу проценты в проценты в месяц
        double argument = (loanAmount * (percent * Math.pow(1 + percent, termMonth)) / (Math.pow(1 + percent, termMonth) - 1));
        BigDecimal dec = new BigDecimal(argument);
        dec = dec.setScale(2, RoundingMode.HALF_UP);
        argument = dec.doubleValue();
        //Создаю аргумент сравнения для проверки
        Assert.assertTrue(argument == result);
    }

    @Test
    public void calcAllAmount() { //Аналогично
        LoanCalculator calculator = new LoanCalculator();
        int loanAmount = (int) random(500000, 1000000);
        double percent = random(10, 50);
        int termMonth = (int) random(3, 600);

        double result = calculator.getAllAmount(loanAmount, percent, termMonth);

        percent = percent * 0.01 / 12;
        double argument = loanAmount * (percent * Math.pow(1 + percent, termMonth)) / (Math.pow(1 + percent, termMonth) - 1) * termMonth;
        BigDecimal dec = new BigDecimal(argument);
        dec = dec.setScale(2, RoundingMode.HALF_UP);
        argument = dec.doubleValue();

        Assert.assertTrue(argument == result);
    }

    @Test
    public void calcOverpayment() {//Аналогично
        LoanCalculator calculator = new LoanCalculator();
        int loanAmount = (int) random(500000, 1000000);
        double percent = random(10, 50);
        int termMonth = (int) random(3, 600);

        double result = calculator.getOverpayment(loanAmount, percent, termMonth);

        percent = percent * 0.01 / 12;
        double argument = loanAmount * (percent * Math.pow(1 + percent, termMonth)) / (Math.pow(1 + percent, termMonth) - 1) * termMonth - loanAmount;
        BigDecimal dec = new BigDecimal(argument);
        dec = dec.setScale(2, RoundingMode.HALF_UP);
        argument = dec.doubleValue();

        Assert.assertTrue(argument == result);
    }

    //Сделал этот метод для удобства
    private static double random (double min, double max){
        max -= min;
        double result = (Math.random() * ++max) + min;

        BigDecimal dec = new BigDecimal(Double.toString(result));
        dec = dec.setScale(2, RoundingMode.HALF_UP);
        result = dec.doubleValue();
        return result;
    }
}
