import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculatorController {

    private CalculatorView theView;
    private CalculatorModel theModel;

    public CalculatorController(CalculatorView theView, CalculatorModel theModel) {
        this.theView = theView;
        this.theModel = theModel;

        this.theView.addCalculationListener(new CalculationListener());
    }

    class CalculationListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent event) {

            double firstNumber;
            double secondNumber;

            try{

                firstNumber = theView.getFirstNumber();
                secondNumber = theView.getSecondNumber();

                switch (theView.getAction()){
                    case "+":
                        theModel.addTwoNumbers(firstNumber, secondNumber);
                        break ;
                    case "-":
                        theModel.subtractTwoNumbers(firstNumber, secondNumber);
                        break ;
                    case "*":
                        theModel.multiplyTwoNumbers(firstNumber, secondNumber);
                        break ;
                    case "/":
                        theModel.divideTwoNumbers(firstNumber, secondNumber);
                        break ;
                    case "%":
                        theModel.modTwoNumbers(firstNumber, secondNumber);
                        break ;
                    case "^":
                        theModel.powerTwoNumbers(firstNumber, secondNumber);
                        break ;
                    default:
                        theView.displayErrorMessage("No such action " + theView.getAction());
                        break ;
                }

                theView.setCalcSolution(theModel.getCalculationValue());

            } catch (Exception exception){

                theView.displayErrorMessage(exception.getMessage());

            }
        }
    }
}
