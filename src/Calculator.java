import javax.swing.*;
import java.awt.*;

public class Calculator {
    public static void main(String[] args) {

        // =========================================================
        // 1. CRIAÇÃO DOS COMPONENTES PRINCIPAIS DA INTERFACE
        // =========================================================
        JFrame frame = new JFrame("Calculator"); // Cria a janela principal
        JTextField display = new JTextField(); // Cria o visor da calculadora
        JButton[] buttons = new JButton[10]; // Vetor para os botões numéricos de 0 a 9

        JButton clearButton = new JButton("C");
        JButton equalButton = new JButton("=");
        JButton multButton = new JButton("*");
        JButton divideButton = new JButton("/");
        JButton plusButton = new JButton("+");
        JButton minusButton = new JButton("-");

        // =========================================================
        // 2. CONFIGURAÇÃO DE CORES E AGRUPAMENTO DOS OPERADORES
        // =========================================================
        Color defaultColor = UIManager.getColor("Button.background");
        Color activeColor = new Color(180, 220, 255);
        Color functionButtonColor = new Color(200, 200, 200);
        Color functionTextColor = Color.BLACK;

        JButton[] operatorButtons = {divideButton, multButton, minusButton, plusButton};

        // =========================================================
        // 3. ESTILIZAÇÃO INICIAL DOS BOTÕES DE FUNÇÃO
        // =========================================================
        clearButton.setBackground(functionButtonColor);
        clearButton.setForeground(functionTextColor);
        clearButton.setOpaque(true);
        clearButton.setBorderPainted(false);
        clearButton.setFocusPainted(false);

        equalButton.setBackground(functionButtonColor);
        equalButton.setForeground(functionTextColor);
        equalButton.setOpaque(true);
        equalButton.setBorderPainted(false);
        equalButton.setFocusPainted(false);

        for (JButton button : operatorButtons) {
            button.setOpaque(true);
            button.setBorderPainted(true);
        }

        // =========================================================
        // 4. VARIÁVEIS DE CONTROLE DA LÓGICA DA CALCULADORA
        // =========================================================
        double[] firstNumber = {0};
        double[] secondNumber = {0};
        String[] operator = {""};
        boolean[] startNewNumber = {false};

        // =========================================================
        // 5. CONFIGURAÇÃO DA JANELA PRINCIPAL
        // =========================================================
        frame.setSize(300, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Fecha o programa ao fechar a janela
        frame.setLayout(null); // Permite posicionar manualmente

        // =========================================================
        // 6. CONFIGURAÇÃO DO VISOR
        // =========================================================
        display.setBounds(30, 30, 220, 40); // Posição e tamanho do visor
        display.setEditable(false); // Impede digitação direta
        frame.add(display);

        // =========================================================
        // 7. CRIAÇÃO DOS BOTÕES NUMÉRICOS
        // =========================================================
        for (int i = 0; i <= 9; i++) {
            buttons[i] = new JButton(String.valueOf(i));
        }

        // =========================================================
        // 8. MATRIZ QUE DEFINE A ORDEM VISUAL DOS NÚMEROS
        // =========================================================
        int[][] numbers = {
                {7, 8, 9},
                {4, 5, 6},
                {1, 2, 3}
        };

        // =========================================================
        // 9. POSICIONAMENTO DOS BOTÕES NUMÉRICOS NA TELA
        // =========================================================
        int y = 100;

        for (int row = 0; row < 3; row++) {
            int x = 30; // Reinicia a posição horizontal no começo de cada linha

            for (int col = 0; col < 3; col++) {
                int number = numbers[row][col]; // Pega o número da matriz

                buttons[number].setBounds(x, y, 50, 50); // Define posição e tamanho
                frame.add(buttons[number]); // Adiciona o botão na janela

                x += 60; // Move para a próxima coluna
            }

            y += 60; // Move para a próxima linha
        }

        // Botão 0 fica na última linha, centralizado
        buttons[0].setBounds(90, 280, 50, 50);
        frame.add(buttons[0]);

        // =========================================================
        // 10. EVENTOS DOS BOTÕES NUMÉRICOS
        // =========================================================
        for (int i = 0; i <= 9; i++) {
            int number = i;

            buttons[i].addActionListener(e -> {
                if (startNewNumber[0]) {
                    display.setText(String.valueOf(number));
                    startNewNumber[0] = false; // Começa um novo número no visor
                } else {
                    display.setText(display.getText() + number); // Continua concatenando
                }
            });
        }

        // =========================================================
        // 11. CONFIGURAÇÃO E LÓGICA DO BOTÃO CLEAR
        // =========================================================
        clearButton.setBounds(30, 280, 50, 50);
        clearButton.addActionListener(e -> {
            display.setText("");
            firstNumber[0] = 0;
            secondNumber[0] = 0;
            operator[0] = "";
            startNewNumber[0] = false;

            for (JButton button : operatorButtons) {
                button.setBackground(defaultColor);
            }
        });
        frame.add(clearButton);

        // =========================================================
        // 12. CONFIGURAÇÃO E LÓGICA DO BOTÃO IGUAL
        // =========================================================
        equalButton.setBounds(150, 280, 50, 50);
        equalButton.addActionListener(e -> {
            if (display.getText().isEmpty() || display.getText().equals("Error")) {
                return;
            }

            secondNumber[0] = Double.parseDouble(display.getText());
            double result = 0;

            if (operator[0].equals("+")) {
                result = firstNumber[0] + secondNumber[0];
            } else if (operator[0].equals("-")) {
                result = firstNumber[0] - secondNumber[0];
            } else if (operator[0].equals("*")) {
                result = firstNumber[0] * secondNumber[0];
            } else if (operator[0].equals("/")) {
                if (secondNumber[0] == 0) {
                    display.setText("Error");
                    startNewNumber[0] = true;

                    for (JButton button : operatorButtons) {
                        button.setBackground(defaultColor);
                    }

                    return;
                }

                result = firstNumber[0] / secondNumber[0];
            }

            if (result == (int) result) {
                display.setText(String.valueOf((int) result));
            } else {
                display.setText(String.valueOf(result));
            }

            startNewNumber[0] = true;

            for (JButton button : operatorButtons) {
                button.setBackground(defaultColor);
            }
        });
        frame.add(equalButton);

        // =========================================================
        // 13. CONFIGURAÇÃO E LÓGICA DO BOTÃO DE DIVISÃO
        // =========================================================
        divideButton.setBounds(210, 100, 50, 50);
        divideButton.addActionListener(e -> {
            if (display.getText().isEmpty() || display.getText().equals("Error")) {
                return;
            }

            for (JButton button : operatorButtons) {
                button.setBackground(defaultColor);
            }

            divideButton.setBackground(activeColor);

            firstNumber[0] = Double.parseDouble(display.getText());
            operator[0] = "/";
            startNewNumber[0] = true;
        });
        frame.add(divideButton);

        // =========================================================
        // 14. CONFIGURAÇÃO E LÓGICA DO BOTÃO DE MULTIPLICAÇÃO
        // =========================================================
        multButton.setBounds(210, 160, 50, 50);
        multButton.addActionListener(e -> {
            if (display.getText().isEmpty() || display.getText().equals("Error")) {
                return;
            }

            for (JButton button : operatorButtons) {
                button.setBackground(defaultColor);
            }

            multButton.setBackground(activeColor);

            firstNumber[0] = Double.parseDouble(display.getText());
            operator[0] = "*";
            startNewNumber[0] = true;
        });
        frame.add(multButton);

        // =========================================================
        // 15. CONFIGURAÇÃO E LÓGICA DO BOTÃO DE SUBTRAÇÃO
        // =========================================================
        minusButton.setBounds(210, 220, 50, 50);
        minusButton.addActionListener(e -> {
            if (display.getText().isEmpty() || display.getText().equals("Error")) {
                return;
            }

            for (JButton button : operatorButtons) {
                button.setBackground(defaultColor);
            }

            minusButton.setBackground(activeColor);

            firstNumber[0] = Double.parseDouble(display.getText());
            operator[0] = "-";
            startNewNumber[0] = true;
        });
        frame.add(minusButton);

        // =========================================================
        // 16. CONFIGURAÇÃO E LÓGICA DO BOTÃO DE SOMA
        // =========================================================
        plusButton.setBounds(210, 280, 50, 50);
        plusButton.addActionListener(e -> {
            if (display.getText().isEmpty() || display.getText().equals("Error")) {
                return;
            }

            for (JButton button : operatorButtons) {
                button.setBackground(defaultColor);
            }

            plusButton.setBackground(activeColor);

            firstNumber[0] = Double.parseDouble(display.getText());
            operator[0] = "+";
            startNewNumber[0] = true;
        });
        frame.add(plusButton);

        // =========================================================
        // 17. EXIBIÇÃO FINAL DA JANELA
        // =========================================================
        frame.setVisible(true);
    }
}