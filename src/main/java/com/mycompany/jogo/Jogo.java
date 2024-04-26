package com.mycompany.jogo;

import javax.swing.JFrame;

public class Jogo {

    public static void main(String[] args) {
JFrame frame = new JFrame("Jogo de Pular Obstáculos");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(new JogoPularObstaculos());
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
} 
