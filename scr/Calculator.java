import javax.swing.*;
import java.awt.*;

public class Calculator {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Calculator"); // Cria a janela
        JTextField display = new JTextField(); // Cria o visor

        frame.setSize(300, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Fecha o programa ao fechar a janela
        frame.setLayout(null); // Permite posicionar manualmente

        display.setBounds(30, 30, 220, 40); // Posição e tamanho do visor
        display.setEditable(false); // Impede digitação direta
        frame.add(display);

        JButton[] buttons = new JButton[10];

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
            buttons[i].addActionListener(e -> display.setText(display.getText() + number));
        }

        frame.setVisible(true);
    }
}