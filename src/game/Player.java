package game;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.Color;

public class Player extends Rectangle
{
    int x;
    int y;

    public Player(int x, int y)
    {
        this.x = x;
        this.y = y;
    }

    public void drawPlayer(Graphics g, int x, int y)
    {
        g.setColor(Color.WHITE);
        g.drawRect(x, y, 20, 20);
    }
}
