import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class calculator implements ActionListener {
    JFrame frame;
    JTextField textfield;
    JButton[] numberButtons = new JButton[10];
    JButton[] functiButtons = new JButton[9];
    JButton addButton, subButton, mulButton, divButton;
    JButton decButton, equButton, delButton, clrButton;
    JButton negButton;
    JPanel panel;

    Font Myfont = new Font("Times New Roman", Font.BOLD, 30);

    double num1 = 0, num2 = 0, total = 0;
    char operator;

    calculator() {
        frame = new JFrame("Calculator by DV");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(450, 520);
        frame.setLayout(null);
        frame.setResizable(false);

        textfield = new JTextField();
        textfield.setBounds(45, 25, 350, 50);
        textfield.setFont(Myfont);
        textfield.setEditable(false);

        addButton = new JButton("+");
        subButton = new JButton("-");
        mulButton = new JButton("x");
        divButton = new JButton("/");
        decButton = new JButton(".");
        equButton = new JButton("=");
        delButton = new JButton("Delete");
        clrButton = new JButton("Clear");
        negButton = new JButton("(-)");

        functiButtons[0] = addButton;
        functiButtons[1] = subButton;
        functiButtons[2] = mulButton;
        functiButtons[3] = divButton;
        functiButtons[4] = decButton;
        functiButtons[5] = equButton;
        functiButtons[6] = delButton;
        functiButtons[7] = clrButton;
        functiButtons[8] = negButton;

        for (int i = 0; i < 9; i++) {
            functiButtons[i].addActionListener(this);
            functiButtons[i].setFont(Myfont);
            functiButtons[i].setFocusable(false);
        }

        for (int i = 0; i < 10; i++) {
            numberButtons[i] = new JButton(String.valueOf(i));
            numberButtons[i].addActionListener(this);
            numberButtons[i].setFont(Myfont);
            numberButtons[i].setFocusable(false);
        }
        negButton.setBounds(45,430,120,50);
        delButton.setBounds(45, 430, 120, 50);
        clrButton.setBounds(205, 430, 120, 50);

        panel = new JPanel();
        panel.setBounds(45, 100, 350, 300);
        panel.setLayout(new GridLayout(4, 4, 9, 9));
        panel.setBackground(new Color(0x123456));

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
        panel.add(divButton);
        panel.add(equButton);

        frame.add(panel);
        frame.add(negButton);
        frame.add(delButton);
        frame.add(clrButton);
        frame.add(textfield);
        frame.setVisible(true);

        ImageIcon image = new ImageIcon("logo.jpg");
        frame.setIconImage(image.getImage());
        frame.getContentPane().setBackground(new Color(0x123456));
    }

    public static void main(String[] args) {
        calculator calc = new calculator();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < 10; i++) {
            if (e.getSource() == numberButtons[i]) {
                textfield.setText(textfield.getText().concat(String.valueOf(i)));
            }
        }
        if (e.getSource() == decButton) {
            textfield.setText(textfield.getText().concat("."));
        }
        if (e.getSource() == addButton) {
            num1 = Double.parseDouble(textfield.getText());
            operator = '+';
            textfield.setText("");
        }
        if (e.getSource() == subButton) {
            num1 = Double.parseDouble(textfield.getText());
            operator = '-';
            textfield.setText("");
        }
        if (e.getSource() == mulButton) {
            num1 = Double.parseDouble(textfield.getText());
            operator = 'x';
            textfield.setText("");
        }
        if (e.getSource() == divButton) {
            num1 = Double.parseDouble(textfield.getText());
            operator = '/';
            textfield.setText("");
        }
        if (e.getSource() == equButton) {
            num2 = Double.parseDouble(textfield.getText());

            switch (operator) {
                case '+':
                    total = num1 + num2;
                    break;
                case '-':
                    total = num1 - num2;
                    break;
                case 'x':
                    total = num1 * num2;
                    break;
                case '/':
                    total = num1 / num2;
                    break;
            }
            textfield.setText(String.valueOf(total));
            num1 = total;
        }

        if (e.getSource() == clrButton) {
            textfield.setText("");
        }

        if (e.getSource() == delButton) {

            String string= textfield.getText();
            textfield.setText("");
            for(int i=0; i < string.length()-1; i++ ){
                textfield.setText(textfield.getText()+string.charAt(i));

            }
        }
         if (e.getSource() == negButton) {
            double temp = Double.parseDouble(textfield.getText().toString());
            temp *= -1;
            textfield.setText(String.valueOf(temp));
    }
       
            
    }
}
