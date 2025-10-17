import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CalculatorApp extends JFrame implements ActionListener {
    JTextField text;
    double num1 = 0, num2 = 0, result = 0;
    char operator;

    CalculatorApp() {
        setTitle("Calculator");
        setSize(300, 400);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        text = new JTextField();
        text.setBounds(30, 40, 230, 40);
        add(text);

        String[] buttons = {
                "7", "8", "9", "/",
                "4", "5", "6", "*",
                "1", "2", "3", "-",
                "0", ".", "=", "+"
        };

        int x = 30, y = 100;
        for (int i = 0; i < buttons.length; i++) {
            JButton b = new JButton(buttons[i]);
            b.setBounds(x, y, 50, 40);
            add(b);
            b.addActionListener(this);
            x += 60;
            if ((i + 1) % 4 == 0) {
                x = 30;
                y += 50;
            }
        }
    }

    public void actionPerformed(ActionEvent e) {
        String s = e.getActionCommand();

        if ((s.charAt(0) >= '0' && s.charAt(0) <= '9') || s.equals(".")) {
            text.setText(text.getText() + s);
        } else if (s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/")) {
            num1 = Double.parseDouble(text.getText());
            operator = s.charAt(0);
            text.setText("");
        } else if (s.equals("=")) {
            num2 = Double.parseDouble(text.getText());
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
                    result = num1 / num2;
                    break;
            }
            text.setText(String.valueOf(result));
            num1 = result;
        }
    }

    public static void main(String[] args) {
        CalculatorApp calc = new CalculatorApp();
        calc.setVisible(true);
    }
}
