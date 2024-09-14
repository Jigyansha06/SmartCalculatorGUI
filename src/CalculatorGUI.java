import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculatorGUI extends JFrame implements ActionListener {
    private JTextField display;
    private JButton[] numberButtons = new JButton[10];
    private JButton[] functionButtons = new JButton[12];
    private JButton addButton, subButton, mulButton, divButton;
    private JButton decButton, equButton, delButton, clrButton, negButton, sqrtButton, percentButton;

    private JPanel panel;

    private double num1 = 0, num2 = 0, result = 0;
    private char operator;

    public CalculatorGUI() {
        // Frame setup
        this.setTitle("Smart Calculator");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(420, 550);
        this.setLayout(null);

        // Display (TextField)
        display = new JTextField();
        display.setBounds(50, 25, 300, 50);
        display.setEditable(false);
        display.setBackground(Color.DARK_GRAY);
        display.setForeground(Color.BLACK);
        display.setFont(new Font("Arial", Font.ITALIC, 30));
        this.add(display);

        // Initialize all buttons
        addButton = new JButton("+");
        subButton = new JButton("-");
        mulButton = new JButton("*");
        divButton = new JButton("/");
        decButton = new JButton(".");
        equButton = new JButton("=");
        delButton = new JButton("Del");
        clrButton = new JButton("Clr");
        negButton = new JButton("(-)");
        sqrtButton = new JButton("√");
        percentButton = new JButton("%");

        // Add function buttons to the array
        functionButtons[0] = addButton;
        functionButtons[1] = subButton;
        functionButtons[2] = mulButton;
        functionButtons[3] = divButton;
        functionButtons[4] = decButton;
        functionButtons[5] = equButton;
        functionButtons[6] = delButton;
        functionButtons[7] = clrButton;
        functionButtons[8] = negButton;
        functionButtons[9] = sqrtButton;
        functionButtons[10] = percentButton;

        // Apply font to each function button
        for (JButton btn : functionButtons) {
            if (btn != null) {
                btn.setFont(new Font("Arial", Font.PLAIN, 30));
                btn.addActionListener(this);
            }
        }

        // Initialize number buttons and set their properties
        for (int i = 0; i < 10; i++) {
            numberButtons[i] = new JButton(String.valueOf(i));
            numberButtons[i].setFont(new Font("Arial", Font.PLAIN, 30));
            numberButtons[i].addActionListener(this);
        }

        // Panel for buttons
        panel = new JPanel();
        panel.setLayout(new GridLayout(5, 4, 10, 10));

        // Adding number and function buttons to the panel
        panel.add(numberButtons[1]);
        panel.add(numberButtons[2]);
        panel.add(numberButtons[3]);
        panel.add(addButton);
        panel.add(numberButtons[4]);
        panel.add(numberButtons[5]);
        panel.add(numberButtons[6]);
        panel.add(subButton);
        panel.add(numberButtons[7]);
        panel.add(numberButtons[8]);
        panel.add(numberButtons[9]);
        panel.add(mulButton);
        panel.add(decButton);
        panel.add(numberButtons[0]);
        panel.add(equButton);
        panel.add(divButton);
        panel.add(sqrtButton);
        panel.add(percentButton);
        panel.add(delButton);
        panel.add(clrButton);

        panel.setBounds(50, 100, 300, 300);
        this.add(panel);

        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < 10; i++) {
            if (e.getSource() == numberButtons[i]) {
                display.setText(display.getText().concat(String.valueOf(i)));
            }
        }

        if (e.getSource() == decButton) {
            display.setText(display.getText().concat("."));
        }

        if (e.getSource() == addButton) {
            num1 = Double.parseDouble(display.getText());
            operator = '+';
            display.setText("");
        }

        if (e.getSource() == subButton) {
            num1 = Double.parseDouble(display.getText());
            operator = '-';
            display.setText("");
        }

        if (e.getSource() == mulButton) {
            num1 = Double.parseDouble(display.getText());
            operator = '*';
            display.setText("");
        }

        if (e.getSource() == divButton) {
            num1 = Double.parseDouble(display.getText());
            operator = '/';
            display.setText("");
        }

        if (e.getSource() == sqrtButton) {
            num1 = Double.parseDouble(display.getText());
            result = Math.sqrt(num1);
            display.setText(String.valueOf(result));
        }

        if (e.getSource() == percentButton) {
            num1 = Double.parseDouble(display.getText());
            result = num1 / 100;
            display.setText(String.valueOf(result));
        }

        if (e.getSource() == equButton) {
            num2 = Double.parseDouble(display.getText());

            switch (operator) {
                case '+':
                    result = num1 + num2;
                    break;
                case '-':
                    result = num1 - num2;
                    break;
                case '*':
                    result = num1 * num2;
                    break;
                case '/':
                    if (num2 != 0) {
                        result = num1 / num2;
                    } else {
                        display.setText("Error: Divide by 0");
                        return;
                    }
                    break;
            }

            display.setText(String.valueOf(result));
            num1 = result;
        }

        if (e.getSource() == clrButton) {
            display.setText("");
        }

        if (e.getSource() == delButton) {
            String temp = display.getText();
            display.setText("");
            for (int i = 0; i < temp.length() - 1; i++) {
                display.setText(display.getText() + temp.charAt(i));
            }
        }

        if (e.getSource() == negButton) {
            double temp = Double.parseDouble(display.getText());
            temp *= -1;
            display.setText(String.valueOf(temp));
        }
    }

    public static void main(String[] args) {
        new CalculatorGUI();
    }
}