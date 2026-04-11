import javax.swing.*;
import java.awt.*;

public class Calculator {
    public static void main(String[] args) {

        JFrame frame = new JFrame("Calculator"); // Cria a janela
        JTextField display = new JTextField(); // Cria o visor
        JButton[] buttons = new JButton[10];
        JButton clearButton = new JButton("C");
        JButton equalButton = new JButton("=");
        JButton multButton = new JButton("*");
        JButton divideButton = new JButton("/");
        JButton plusButton = new JButton("+");
        JButton minusButton = new JButton("-");

        double[] firstNumber = {0};
        double[] secondNumber = {0};
        String[] operator = {""};
        boolean[] startNewNumber = {false};

        frame.setSize(300, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Fecha o programa ao fechar a janela
        frame.setLayout(null); // Permite posicionar manualmente

        display.setBounds(30, 30, 220, 40); // Posição e tamanho do visor
        display.setEditable(false); // Impede digitação direta
        frame.add(display);

        for (int i = 0; i <= 9; i++) {
            buttons[i] = new JButton(String.valueOf(i));
        }

        int[][] numbers = {
                {7, 8, 9},
                {4, 5, 6},
                {1, 2, 3}
        };

        int y = 100;

        for (int row = 0; row < 3; row++) {
            // Este for percorre as linhas da calculadora: primeira, segunda e terceira linha de botões

            int x = 30; // Pega o número correspondente à posição atual da matriz

            for (int col = 0; col < 3; col++) {
                // Este for percorre os botões da linha atual, da esquerda para a direita

                int number = numbers[row][col]; // Pega o número correspondente à posição atual da matriz

                buttons[number].setBounds(x, y, 50, 50); // Define a posição e o tamanho do botão
                frame.add(buttons[number]); // Adiciona o botão na janela

                x += 60; // Move a próxima posição para a direita
            }

            y += 60; // Move para a próxima linha de botões
        }

        buttons[0].setBounds(90, 280, 50, 50);
        frame.add(buttons[0]);

        for (int i = 0; i <= 9; i++) {
            int number = i;

            buttons[i].addActionListener(e -> {
                if (startNewNumber[0]){
                    display.setText(String.valueOf(number));
                    startNewNumber[0] = false; // Zera o visor para entrar o novo número
                } else {
                    display.setText(display.getText() + number); // Continua concatenando
                }
            });
        }

        clearButton.setBounds(30, 280, 50, 50);
        clearButton.addActionListener(e -> display.setText(""));
        frame.add(clearButton);

        equalButton.setBounds(150, 280, 50, 50);
        equalButton.addActionListener(e -> {
            secondNumber[0] = Double.parseDouble(display.getText());
            double result = 0;

            if (operator[0].equals("+")) {
                result = firstNumber[0] + secondNumber[0];
            } else if (operator[0].equals("-")) {
                result = firstNumber[0] - secondNumber[0];
            } else if (operator[0].equals("*")) {
                result = firstNumber[0] * secondNumber[0];
            } else if (operator[0].equals("/")) {
                result = firstNumber[0] / secondNumber[0];
            }

            if(result == (int) result) {
                display.setText(String.valueOf((int) result));
            } else {
                display.setText(String.valueOf(result));
            }

            startNewNumber[0] = true;
        });
        frame.add(equalButton);

        divideButton.setBounds(210, 100, 50, 50);
        frame.add(divideButton);

        multButton.setBounds(210, 160, 50, 50);
        frame.add(multButton);

        minusButton.setBounds(210, 220, 50, 50);
        frame.add(minusButton);

        plusButton.setBounds(210, 280, 50, 50);
        plusButton.addActionListener(e -> {
                firstNumber[0] = Double.parseDouble(display.getText());
                operator[0] = "+";
                startNewNumber[0] = true;
        });
        frame.add(plusButton);

        frame.setVisible(true);
    }
}
