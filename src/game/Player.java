package game;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.Color;

public class Player extends Rectangle
{
    int x;
    int y;
    int direction; //0 = Up, 1 = Left, 2 = Down, 3 = Right

    public Player(int x, int y, int direction)
    {
        this.x = x;
        this.y = y;
        this.direction = direction;
    }

    public void drawPlayer(Graphics g, int x, int y)
    {
        g.setColor(Color.WHITE);
        g.fillRect(x, y, 20, 20);
    }
}
