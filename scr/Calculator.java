//  Created by Marcelo Bomfim on 30/03/26.

// Como é a primeira vez que uso Swing para programar interface gráfica boa parte do código terá comentários
import java.awt.*;
import javax.swing.*;

public class Calculator {
    public static void main(String[] args) {
        Jframe jframe = new Jframe("Calculator"); // Cria a janela com o título "Calculator"
        JTextField display = new JTextField(); // Cria o campo de texto que será o visor da calculadora

        frame.setSize(300, 400);
        frame.SetDefaultCloseOperation(Jframe.EXIT_ON_CLOSE); // Fecha o programa ao fechar a janela
        frame.setLayout(null);

        display.setBounds(30, 30, 220, 40);
        frame.add(display);

        frame.setVisible(true);
    }
}
