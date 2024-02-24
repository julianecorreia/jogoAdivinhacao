package br.unipar.dinamica;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class JogoAdivinhacao extends JFrame {
    public JPanel panel;
    private JTextArea textArea;
    private JTextField inputField;
    private JButton guessButton;

    private int numeroSecreto;
    private int tentativas;


    public JogoAdivinhacao() {
        setTitle("Jogo de Adivinhação");
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        guessButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                verificarAdivinhacao();
            }
        });

        iniciarJogo();
    }

    private void iniciarJogo() {
        Random random = new Random();
        numeroSecreto = random.nextInt(100); // número aleatório entre 1 e 100
        tentativas = 0;
        atualizarTextArea("Tente adivinhar o número secreto (entre 1 e 100)!\n");
    }

    private void verificarAdivinhacao() {
        try {
            int tentativa = Integer.parseInt(inputField.getText());
            tentativas++;

            if (tentativa == numeroSecreto) {
                JOptionPane.showMessageDialog(this, "Parabéns! Você acertou o número secreto em " + tentativas + " tentativas.");
                iniciarJogo();
            } else if (tentativa < numeroSecreto) {
                atualizarTextArea("Tentativa " + tentativas + ": O número secreto é maior que " + tentativa + "\n");
            } else {
                atualizarTextArea("Tentativa " + tentativas + ": O número secreto é menor que " + tentativa + "\n");
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Por favor, insira um número válido.");
        }
        inputField.setText("");
        inputField.requestFocus();
    }

    private void atualizarTextArea(String texto) {
        textArea.append(texto);
    }
}
