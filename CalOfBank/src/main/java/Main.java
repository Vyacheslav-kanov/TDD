import java.util.Scanner;

public class Main {

    private static LoanCalculator calc = new LoanCalculator();
    private static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Введите сумму кредита: ");
        int loanAmount = scan.nextInt();

        System.out.println("Введите процентную ставку: ");
        double percent = scan.nextDouble();

        System.out.println("Введите срок кредита");
        int termMonth = scan.nextInt();

        System.out.println("Месячный платёж: " + calc.getMonth(loanAmount, percent, termMonth));
        System.out.println("Общая сумма к возврату в банк: " + calc.getAllAmount(loanAmount, percent, termMonth));
        System.out.println("Переплата за весь период: " + calc.getOverpayment(loanAmount, percent, termMonth));
    }
}
