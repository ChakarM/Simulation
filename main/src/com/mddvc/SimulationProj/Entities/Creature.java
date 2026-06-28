package com.mddvc.SimulationProj.Entities;


import com.mddvc.SimulationProj.Coordinates;
import com.mddvc.SimulationProj.WorldMap;

public abstract class Creature extends Entity{
    protected int HP = 10;

    public abstract void makeMove(WorldMap worldMap, Coordinates my_pos);


}
