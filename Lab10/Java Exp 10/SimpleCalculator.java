import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SimpleCalculator {
    private static JTextField textField;
    private static String currentInput = "";
    private static double firstNumber = 0;
    private static String operator = "";

    public static void main(String[] args) {
        JFrame frame = new JFrame("Calculator");
        frame.setSize(300, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        // Display
        textField = new JTextField();
        textField.setFont(new Font("Arial", Font.BOLD, 24));
        textField.setHorizontalAlignment(JTextField.RIGHT);
        textField.setEditable(false);
        frame.add(textField, BorderLayout.NORTH);

        // Panel for buttons
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 4, 10, 10));

        // Button labels
        String[] buttons = {
            "7", "8", "9", "/",
            "4", "5", "6", "*",
            "1", "2", "3", "-",
            "0", "=", "C", "+"
        };

        for (String label : buttons) {
            JButton button = new JButton(label);
            button.setFont(new Font("Arial", Font.BOLD, 18));
            panel.add(button);

            button.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    handleButtonClick(label);
                }
            });
        }

        frame.add(panel, BorderLayout.CENTER);
        frame.setVisible(true);
    }

    private static void handleButtonClick(String label) {
        if (label.matches("[0-9]")) {
            currentInput += label;
            textField.setText(currentInput);
        } else if (label.matches("[+\\-*/]")) {
            if (!currentInput.isEmpty()) {
                firstNumber = Double.parseDouble(currentInput);
                operator = label;
                currentInput = "";
            }
        } else if (label.equals("=")) {
            if (!currentInput.isEmpty() && !operator.isEmpty()) {
                double secondNumber = Double.parseDouble(currentInput);
                double result = 0;

                switch (operator) {
                    case "+": result = firstNumber + secondNumber; break;
                    case "-": result = firstNumber - secondNumber; break;
                    case "*": result = firstNumber * secondNumber; break;
                    case "/": 
                        if (secondNumber != 0)
                            result = firstNumber / secondNumber;
                        else {
                            textField.setText("Error: /0");
                            currentInput = "";
                            return;
                        }
                        break;
                }

                textField.setText(String.valueOf(result));
                currentInput = String.valueOf(result);
                operator = "";
            }
        } else if (label.equals("C")) {
            currentInput = "";
            operator = "";
            firstNumber = 0;
            textField.setText("");
        }
    }
}
