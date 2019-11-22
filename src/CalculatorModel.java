public class CalculatorModel {

    private double calculationValue;

    public void addTwoNumbers(double firstNumber, double secondNumber){
        calculationValue = firstNumber + secondNumber;
    }

    public void subtractTwoNumbers(double firstNumber, double secondNumber){
        calculationValue = firstNumber - secondNumber;
    }

    public void multiplyTwoNumbers(double firstNumber, double secondNumber){
        calculationValue = firstNumber * secondNumber;
    }

    public void divideTwoNumbers(double firstNumber, double secondNumber){
        calculationValue = firstNumber / secondNumber;
    }

    public void modTwoNumbers(double firstNumber, double secondNumber){
        calculationValue = firstNumber % secondNumber;
    }

    public void powerTwoNumbers(double firstNumber, double secondNumber){
        if(Math.floor(secondNumber) == secondNumber){
            calculationValue = fastPow(firstNumber, (int)secondNumber);
        } else {
            calculationValue = Math.pow(firstNumber, secondNumber);
        }
    }


    private double fastPow(double x, int n) {
        double res = 1;
        boolean negativeN = n < 0;

        while (n != 0) {
            if (n % 2 != 0) {
                res *= negativeN ? 1 / x : x;
            }
            x *= x;
            n /= 2;
        }
        return  res;
    }

    public double getCalculationValue() {
        return calculationValue;
    }
}
