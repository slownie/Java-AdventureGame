package game;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import maps.Map1;

import props.NPC;

import game.Player;

public class Main implements KeyListener
{
    //Window Variables:
    JFrame frame;
    DrawingPanel drPanel;

    //Player Variables:
    Player py = new Player(100, 100);
    public static boolean W, A, S, D = false;

    public static void main (String args[])
    {
        new Main();
    }

    Main()
    {
        //Window Setup:
        frame = new JFrame("Adventure Game");
        frame.setSize(400, 400);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //DrawingPanel Setup:
        drPanel = new DrawingPanel();
        drPanel.addKeyListener(this);

        //Map Setup:
        Map1 map1 = new Map1();
        map1.addProps();

        Timer gameTimer = new Timer(60, new TimerListener());
        gameTimer.start();

        frame.add(drPanel);
        frame.setVisible(true);
    }

    /*Classes used in the Program */
    @SuppressWarnings("serial")
    private class DrawingPanel extends JPanel
    {
        public DrawingPanel()
        {
            setBackground(Color.BLACK);
        }

        public void paintComponent(Graphics g)
        {
            super.paintComponent(g);
            this.requestFocus();

            py.drawPlayer(g, py.x, py.y);
        }
    }

    private class TimerListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            readInputs();
            frame.repaint();
        }
    }

    /*Methods used in the Program */
    public void readInputs()
    {
        if (W) { py.y -= 3; }
        if (A) { py.x -= 3; }
        if (S) { py.y += 3; }
        if (D) { py.x += 3; }
    }
    public void drawTitleScreen(Graphics g)
    {
        g.setColor(Color.WHITE);
        g.drawString("Text Adventure Game", 135, 150);
        g.drawString("Press Enter", 155, 250);
    }

    @Override
    public void keyPressed(KeyEvent e)
    {
        if (e.getKeyCode()==KeyEvent.VK_W) W = true;
        if (e.getKeyCode()==KeyEvent.VK_A) A = true;
        if (e.getKeyCode()==KeyEvent.VK_S) S = true;
        if (e.getKeyCode()==KeyEvent.VK_D) D = true;
    }

    @Override
    public void keyReleased(KeyEvent e)
    {
        if (e.getKeyCode()==KeyEvent.VK_W) W = false;
        if (e.getKeyCode()==KeyEvent.VK_A) A = false;
        if (e.getKeyCode()==KeyEvent.VK_S) S = false;
        if (e.getKeyCode()==KeyEvent.VK_D) D = false;
    }

    @Override
    public void keyTyped(KeyEvent e) {}

}