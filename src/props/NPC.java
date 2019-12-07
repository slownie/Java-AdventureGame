package props;

import java.awt.Rectangle;
import java.awt.Graphics;

@SuppressWarnings("serial")
public class NPC extends Rectangle
{
    String name;
    int x, y;

    public NPC(String name, int x, int y)
    {
        this.name = name;
        this.x = x;
        this.y = y;
    }

    public void paint(Graphics g)
    {

    }
}
