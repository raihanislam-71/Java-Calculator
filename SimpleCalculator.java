import javax.swing.*;
import java.awt.Color;
import java.awt.Font;
import java.util.Stack;

public class SimpleCalculator {

    static String expression = "";
    static boolean isResultDisplayed = false;
    
    public static void main(String[] args) {
        JFrame f = new JFrame("Calculator");

        // Frame Setup
        f.setSize(300, 390);
        f.setLayout(null);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.getContentPane().setBackground(new Color(236, 239, 241));
        // f.setVisible(true);
        
        // Display
        JTextField display = new JTextField();
        display.setBounds(0, 10, 290, 80);
        display.setEditable(false);
        display.setHorizontalAlignment(JTextField.RIGHT);
        display.setFont(new Font("Segoe UI", Font.BOLD, 28));
        display.setBackground(new Color(236, 239, 241));
        display.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); //padding
        f.add(display);
                

        //Button creat and Set Bounds and Add
        JButton b1 = new JButton("√");
        b1.setBounds(5, 100, 65, 45); 
        b1.setFont(new Font("Segoe UI", Font.BOLD, 24));
        b1.setBackground(Color.WHITE);
        f.add(b1); 

        JButton b2 = new JButton("C");
        b2.setBounds(75, 100, 65, 45); 
        b2.setFont(new Font("Segoe UI", Font.BOLD, 22));
        b2.setBackground(Color.WHITE);
        f.add(b2);

        JButton b3 = new JButton("\u232B"); //⌫
        b3.setBounds(145, 100, 65, 45);
        b3.setBackground(Color.WHITE); 
        f.add(b3);

        JButton b4 = new JButton("÷");
        b4.setBounds(215, 100, 65, 45); 
        b4.setFont(new Font("Segoe UI", Font.BOLD, 24));
        b4.setBackground(Color.WHITE);
        f.add(b4);

        JButton b5 = new JButton("7");
        b5.setBounds(5, 150, 65, 45); 
        b5.setFont(new Font("Segoe UI", Font.BOLD, 20));
        b5.setBackground(Color.WHITE);
        f.add(b5);

        JButton b6 = new JButton("8");
        b6.setBounds(75, 150, 65, 45); 
        b6.setFont(new Font("Segoe UI", Font.BOLD, 20));
        b6.setBackground(Color.WHITE);
        f.add(b6);

        JButton b7 = new JButton("9");
        b7.setBounds(145, 150, 65, 45); 
        b7.setFont(new Font("Segoe UI", Font.BOLD, 20));
        b7.setBackground(Color.WHITE);
        f.add(b7);

        JButton b8 = new JButton("×");
        b8.setBounds(215, 150, 65, 45); 
        b8.setFont(new Font("Segoe UI", Font.BOLD, 24));
        b8.setBackground(Color.WHITE);
        f.add(b8);

        JButton b9 = new JButton("4");
        b9.setBounds(5, 200, 65, 45); 
        b9.setFont(new Font("Segoe UI", Font.BOLD, 20));
        b9.setBackground(Color.WHITE);
        f.add(b9);

        JButton b10 = new JButton("5");
        b10.setBounds(75, 200, 65, 45); 
        b10.setFont(new Font("Segoe UI", Font.BOLD, 20));
        b10.setBackground(Color.WHITE);
        f.add(b10);

        JButton b11 = new JButton("6");
        b11.setBounds(145, 200, 65, 45); 
        b11.setFont(new Font("Segoe UI", Font.BOLD, 20));
        b11.setBackground(Color.WHITE);
        f.add(b11);

        JButton b12 = new JButton("-");
        b12.setBounds(215, 200, 65, 45); 
        b12.setFont(new Font("Segoe UI", Font.BOLD, 28));
        b12.setBackground(Color.WHITE);
        f.add(b12);

        JButton b13 = new JButton("1");
        b13.setBounds(5, 250, 65, 45); 
        b13.setFont(new Font("Segoe UI", Font.BOLD, 20));
        b13.setBackground(Color.WHITE);
        f.add(b13);

        JButton b14 = new JButton("2");
        b14.setBounds(75, 250, 65, 45); 
        b14.setFont(new Font("Segoe UI", Font.BOLD, 20));
        b14.setBackground(Color.WHITE);
        f.add(b14);

        JButton b15 = new JButton("3");
        b15.setBounds(145, 250, 65, 45); 
        b15.setFont(new Font("Segoe UI", Font.BOLD, 20));
        b15.setBackground(Color.WHITE);
        f.add(b15);

        JButton b16 = new JButton("+");
        b16.setBounds(215, 250, 65, 45); 
        b16.setFont(new Font("Segoe UI", Font.BOLD, 24));
        b16.setBackground(Color.WHITE);
        f.add(b16);

        JButton b17 = new JButton("+/-");
        b17.setBounds(5, 300, 65, 45); 
        b17.setFont(new Font("Segoe UI", Font.BOLD, 20));
        b17.setBackground(Color.WHITE);
        b17.setBackground(Color.WHITE);
        f.add(b17);

        JButton b18 = new JButton("0");
        b18.setBounds(75, 300, 65, 45); 
        b18.setFont(new Font("Segoe UI", Font.BOLD, 20));
        b18.setBackground(Color.WHITE);
        f.add(b18);

        JButton b19 = new JButton(".");
        b19.setBounds(145, 300, 65, 45); 
        b19.setFont(new Font("Segoe UI", Font.BOLD, 28));
        b19.setBackground(Color.WHITE);
        f.add(b19);    

        JButton b20 = new JButton("=");
        b20.setBounds(215, 300, 65, 45); 
        b20.setBackground(new Color(25, 118, 210));
        b20.setFont(new Font("Segoe UI", Font.BOLD, 24));
        f.add(b20);

        f.setVisible(true);
        f.revalidate();
        f.repaint();

        // Action Numbers & Values
        JButton[] numbers = {b5, b6, b7, b9, b10, b11, b13, b14, b15, b18};
        String[] values = {"7", "8", "9", "4", "5", "6", "1", "2", "3", "0"};

        for (int i = 0; i < numbers.length; i++) {
            int finalI = i;
            numbers[i].addActionListener(e -> {
                if (isResultDisplayed) {
                    expression = "";
                    isResultDisplayed = false;
                }
                expression += values[finalI];
                display.setText(expression);
            });
        }

        //Action Operator
        b19.addActionListener(e -> {   //Lambda expression
            if (isResultDisplayed) {
                expression = "";
                isResultDisplayed = false;
            }
            expression += ".";
            display.setText(expression);
        });

        b16.addActionListener(e -> {   
            if (isResultDisplayed) isResultDisplayed = false;
            expression += "+";
            display.setText(expression);
        });

        b12.addActionListener(e -> {
            if (isResultDisplayed) isResultDisplayed = false;
            expression += "-";
            display.setText(expression);
        });

        b8.addActionListener(e -> {
            if (isResultDisplayed) isResultDisplayed = false;
            expression += "×";
            display.setText(expression);
        });

        b4.addActionListener(e -> {
            if (isResultDisplayed) isResultDisplayed = false;
            expression += "÷"; 
            display.setText(expression);
        });
        
        //Delete one by one number
        b3.addActionListener(e -> {
            if (expression.length() > 0) {
                expression = expression.substring(0, expression.length() - 1);
                display.setText(expression);
            }
        });

        //Delete All number
        b2.addActionListener(e -> {
            expression = "";
            display.setText("");
        });

        // +/- button action
        b17.addActionListener(e -> {
            if (!display.getText().isEmpty()) {
                try {
                    double val = Double.parseDouble(display.getText());
                    val = -val;
                    if (val == (int) val) {
                        display.setText(String.valueOf((int) val));
                        expression = String.valueOf((int) val);
                    } else {
                        display.setText(String.valueOf(val));
                        expression = String.valueOf(val);
                    }
                } catch (Exception ex) {
                    display.setText("Error");
                    expression = "";
                }
            }
        });

        //root(√)
        b1.addActionListener(e -> {
            try {
                double val = Double.parseDouble(display.getText());
                if (val < 0) {
                    display.setText("Invalid Input");
                    expression = "";
                }
                else {
                    double sqrtVal = Math.sqrt(val);
                    if (sqrtVal == (int) sqrtVal)
                        display.setText(String.valueOf((int) sqrtVal));
                    else
                        display.setText(String.format("%.2f", sqrtVal));
                    expression = display.getText();
                    isResultDisplayed = true;
                }
            } catch (Exception ex) {
                display.setText("Error");
                expression = "";
            }
        });



        //Equals
        b20.addActionListener(e -> {
            try {
                double result = resultOparetion(expression);
                if (result == (int) result) {
                    display.setText(String.valueOf((int) result)); 
                    expression = String.valueOf((int) result); 
                } else {
                    display.setText(String.format("%.2f",result));
                    expression = String.valueOf(result);
                }
                isResultDisplayed = true;
            } catch (ArithmeticException ex) {
                display.setText(ex.getMessage());  
                expression = "";
                isResultDisplayed = true; 
            } catch (Exception ex) {
                display.setText("Error");
                expression = "";
            }
        });

    }

    public static double resultOparetion(String expr) {
        expr = expr.replaceAll("\\s+", ""); //space remove

        Stack<Double> numbers = new Stack<>();
        Stack<Character> operators = new Stack<>();

        for (int i = 0; i < expr.length(); i++) {
            char c = expr.charAt(i);


            if (c == '-' && (i == 0 || (!Character.isDigit(expr.charAt(i - 1)) && expr.charAt(i - 1) != '.'))) {
                StringBuilder num = new StringBuilder("-");
                i++;
                while (i < expr.length() && (Character.isDigit(expr.charAt(i)) || expr.charAt(i) == '.')) {
                    num.append(expr.charAt(i));
                    i++;
                }
                i--;
                numbers.push(Double.parseDouble(num.toString()));
            }

            else if (Character.isDigit(c) || c == '.') {
                StringBuilder num = new StringBuilder();
                while (i < expr.length() && (Character.isDigit(expr.charAt(i)) || expr.charAt(i) == '.')) {
                    num.append(expr.charAt(i));
                    i++;
                }
                i--;
                numbers.push(Double.parseDouble(num.toString()));
            }

            else if (c == '+' || c == '-' || c == '×' || c == '÷') {
                while (!operators.isEmpty() && hasPrecedence(operators.peek(), c)) {
                    double b = numbers.pop();
                    double a = numbers.pop();
                    char op = operators.pop();
                    numbers.push(applyOp(a, b, op));
                }
                operators.push(c);
            }
        }

        while (!operators.isEmpty()) {
            double b = numbers.pop();
            double a = numbers.pop();
            char op = operators.pop();
            numbers.push(applyOp(a, b, op));
        }

        return numbers.pop();
    }


    // Operator precedence
    public static boolean hasPrecedence(char op1, char op2) {
        if ((op1 == '×' || op1 == '÷') && (op2 == '+' || op2 == '-')) return true;
        if ((op1 == '+' || op1 == '-') && (op2 == '+' || op2 == '-')) return true;
        if ((op1 == '×' || op1 == '÷') && (op2 == '×' || op2 == '÷')) return true;
        return false;
    }

    // Operator apply
    public static double applyOp(double a, double b, char op) {
        switch (op) {
            case '+': return a + b;
            case '-': return a - b;
            case '×': return a * b;
            case '÷': 
            if (b == 0) {
                throw new ArithmeticException("Divide by zero error");
            }
            return a / b;
        }
        return 0;
    }

}
    