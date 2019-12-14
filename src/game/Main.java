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

import game.Player;
import props.NPC;

public class Main implements KeyListener
{
    //Window Variables:
    JFrame frame;
    DrawingPanel drPanel;

    //Game Flow Variables:
    static int gameState = 0;
    
    //Player Variables:
    Player py = new Player(100, 100, 2);
    public static boolean W, A, S, D, J, K, ENTER = false;

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

        Timer gameTimer = new Timer(100, new TimerListener());
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

            switch (gameState)
            {	
            	//Title Screen:
            	case 0:
            		drawTitleScreen(g);
            		break;
        		
        		//Loading:
            	case 1:
            		drawLoadingScreen(g);
                    break;
                
                //Gameplay:
            	case 2:
            	    py.drawPlayer(g, py.x, py.y);
            	    for (NPC n : Map1.npcs) n.drawNPC(g, Color.RED, 30, 30);
            		break;
            }
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
    	//Only occurs when gameplay is enabled:
    	if (gameState == 2)
    	{
    		//Movement:
    		if (W) { py.y -= 1; }
            if (A) { py.x -= 1; }
            if (S) { py.y += 1; }
            if (D) { py.x += 1; }
            
            //Button Presses:
            if (J) { System.out.println("Who are you talking to?"); }
    	}
        
        /*Special Cases:*/
        
        //ONLY ON THE TITLESCREEN - transitions to gameplay:
        if (gameState == 0 && ENTER) gameState = 2;
    }

    //Add more to this later:
    public void drawTitleScreen(Graphics g)
    {
        g.setColor(Color.WHITE);
        g.drawString("Text Adventure Game", 135, 150);
        g.drawString("Press Enter", 155, 250);
    }
    
    //Blank Screen with text for now, might put something else here later:
    public void drawLoadingScreen(Graphics g)
    {
    	g.setColor(Color.WHITE);
    	g.drawString("Loading...", 135, 150);
    }

    @Override
    public void keyPressed(KeyEvent e)
    {
        if (e.getKeyCode()==KeyEvent.VK_W) W = true;
        if (e.getKeyCode()==KeyEvent.VK_A) A = true;
        if (e.getKeyCode()==KeyEvent.VK_S) S = true;
        if (e.getKeyCode()==KeyEvent.VK_D) D = true;
        if (e.getKeyCode()==KeyEvent.VK_J) J = true;
        if (e.getKeyCode()==KeyEvent.VK_K) K = true;
        if (e.getKeyCode()==KeyEvent.VK_ENTER) ENTER = true;
    }

    @Override
    public void keyReleased(KeyEvent e)
    {
        if (e.getKeyCode()==KeyEvent.VK_W) W = false;
        if (e.getKeyCode()==KeyEvent.VK_A) A = false;
        if (e.getKeyCode()==KeyEvent.VK_S) S = false;
        if (e.getKeyCode()==KeyEvent.VK_D) D = false;
        if (e.getKeyCode()==KeyEvent.VK_J) J = false;
        if (e.getKeyCode()==KeyEvent.VK_K) K = false;
        if (e.getKeyCode()==KeyEvent.VK_ENTER) ENTER = false;
    }

    @Override
    public void keyTyped(KeyEvent e) {}

}