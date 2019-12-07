package maps;

import props.NPC;

import java.util.ArrayList;

public class Map1
{
    public ArrayList<NPC> npcs = new ArrayList<NPC>();

    public void addProps()
    {
        //NPCS:
        npcs.add(new NPC("Old Man", 10, 10));
    }
}
