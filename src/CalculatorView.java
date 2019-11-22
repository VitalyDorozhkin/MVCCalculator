import javax.swing.*;
import java.awt.event.ActionListener;

public class CalculatorView extends JFrame {

    private JTextField firstNumber = new JTextField(10);
    private String[] items = {
            "+",
            "-",
            "*",
            "/",
            "%",
            "^"
    };
    private JComboBox<String> actionComboBox = new JComboBox<>(items);
    private JTextField secondNumber = new JTextField(10);
    private JButton calculateButton = new JButton("Calculate");
    private JTextField calcSolution = new JTextField(10);

    CalculatorView(){

        setTitle("MVCCalculator");

        JPanel calcPanel = new JPanel();

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(600, 200);

        calcPanel.add(firstNumber);
        calcPanel.add(actionComboBox);
        calcPanel.add(secondNumber);
        calcPanel.add(calculateButton);
        calcPanel.add(calcSolution);

        this.add(calcPanel);
    }

    public double getFirstNumber() {
        return Double.parseDouble(firstNumber.getText());
    }

    public String getAction() {
        return (String)actionComboBox.getSelectedItem();
    }

    public double getSecondNumber() {
        return  Double.parseDouble(secondNumber.getText());
    }

    public void setCalcSolution(double solution){

        String output;

        if(Math.floor(solution) == solution){
            output = String.valueOf((int)solution);
        } else{
            output = String.format("%.10f", solution);
        }
        calcSolution.setText(output);
    }

    void addCalculationListener(ActionListener listenerForCalcButton){
        calculateButton.addActionListener(listenerForCalcButton);
    }

    void displayErrorMessage(String errorMessage){
        JOptionPane.showMessageDialog(this, errorMessage);
    }
}
