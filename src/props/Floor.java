package props;

import java.awt.Graphics;
import java.awt.Color;

public class Floor
{
    int x, y, length, width;
    Color c;

    public Floor(int x, int y, int length, int width, Color c)
    {
        this.x = x;
        this.y = y;
        this.length = length;
        this.width = width;
        this.c = c;
    }

    public void drawFloor(Graphics g, int x, int y, int length, int width, Color c)
    {
        g.setColor(c);
        g.fillRect(x, y, length, width);
    }
}
