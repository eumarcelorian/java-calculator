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
            int x = 30;

            for (int col = 0; col < 3; col++) {
                int number = numbers[row][col];

                buttons[number].setBounds(x, y, 50, 50);
                frame.add(buttons[number]);

                x += 60;
            }

            y += 60;
        }

        buttons[0].setBounds(90, 280, 50, 50);
        frame.add(buttons[0]);

        frame.setVisible(true);
    }
}