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

public class Main implements KeyListener
{
    //Window Variables:
    JFrame frame;
    DrawingPanel drPanel;

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

        frame.add(drPanel);
        frame.setVisible(true);

        Timer gameTimer = new Timer(120, new TimerListener());
        gameTimer.start();
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

        }
    }

    private class TimerListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {

        }
    }

    /*Methods used in the Program */
    public void drawTitleScreen(Graphics g)
    {
        g.setColor(Color.WHITE);
        g.drawString("Text Adventure Game", 135, 150);
        g.drawString("Press Enter", 155, 250);
    }

    @Override
    public void keyPressed(KeyEvent e)
    {

    }

    @Override
    public void keyReleased(KeyEvent e)
    {

    }

    @Override
    public void keyTyped(KeyEvent e) {}

}