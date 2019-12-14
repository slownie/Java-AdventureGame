package props;

import java.awt.Rectangle;
import java.awt.Graphics;
import java.awt.Color;

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

    public void drawNPC(Graphics g, Color c, int x, int y)
    {
        g.setColor(c);
        g.fillRect(x, y, 20, 20);
    }

    public void talk(Graphics g, Color c, String sr1, String sr2)
    {
        //Draws the text box:
        g.setColor(Color.WHITE);
        g.drawRect(50, 50, 200, 200);

        //Draws the text:
        g.setColor(c);
        g.drawString(sr1, 100, 100);
        g.drawString(sr1, 100, 200);
    }
}
