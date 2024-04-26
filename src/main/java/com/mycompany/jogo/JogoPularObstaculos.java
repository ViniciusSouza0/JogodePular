package com.mycompany.jogo;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class JogoPularObstaculos extends JPanel implements ActionListener, KeyListener {
    private int personagemX, personagemY; // Posição do personagem
    private int obstaculoX, obstaculoY; // Posição do obstáculo
    private Timer timer; // Timer para atualização do jogo
    private boolean pulando; // Flag para verificar se o personagem está pulando

    public JogoPularObstaculos() {
        personagemX = 50;
        personagemY = 150;
        obstaculoX = 300;
        obstaculoY = 150;
        pulando = false;
        
        timer = new Timer(10, this); // Cria um timer que chama o método actionPerformed a cada 10 milissegundos
        timer.start(); // Inicia o timer

        setPreferredSize(new Dimension(400, 200));
        setBackground(Color.WHITE);
        setFocusable(true);
        addKeyListener(this); // Adiciona o KeyListener para capturar eventos do teclado
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.RED);
        g.fillRect(personagemX, personagemY, 20, 20); // Desenha o personagem
        g.setColor(Color.BLUE);
        g.fillRect(obstaculoX, obstaculoY, 20, 20); // Desenha o obstáculo
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (pulando) {
            personagemY -= 2; // Move o personagem para cima
            if (personagemY <= 100) // Altura máxima do pulo
                pulando = false;
        } else {
            personagemY += 2; // Move o personagem para baixo
            if (personagemY >= 150) // Altura do chão
                personagemY = 150;
        }

        obstaculoX -= 1; // Move o obstáculo para a esquerda
        if (obstaculoX <= 0) // Quando o obstáculo atinge o final da tela
            obstaculoX = 400; // Reposiciona o obstáculo no lado direito

        repaint(); // Redesenha o componente
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_SPACE && personagemY == 150) { // Verifica se a tecla pressionada é a barra de espaço e se o personagem está no chão
            pulando = true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {}

    @Override
    public void keyTyped(KeyEvent e) {} {
    
    
}
}

