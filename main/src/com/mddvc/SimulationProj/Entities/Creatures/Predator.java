package com.mddvc.SimulationProj.Entities.Creatures;


import com.mddvc.SimulationProj.BreadthFirstSearcher;
import com.mddvc.SimulationProj.Coordinates;
import com.mddvc.SimulationProj.Entities.Creature;
import com.mddvc.SimulationProj.Entities.Entity;
import com.mddvc.SimulationProj.WorldMap;

import java.util.ArrayList;

public class Predator extends Creature {

    private final int ATTACK_POWER = 5;

    @Override
    public void render() {
        IO.print("P");
    }

    @Override
    public void makeMove(WorldMap worldMap, Coordinates my_pos) {
        BreadthFirstSearcher searcher = new BreadthFirstSearcher();
        Coordinates nextStep = searcher.getNextStep(worldMap, my_pos, new Herbivore());
        if (nextStep != null) {
            ArrayList<Coordinates> neighbors = my_pos.getNeighbors(worldMap);
            if(worldMap.getEntity(nextStep) instanceof Herbivore
            && neighbors.contains(nextStep)){
                ((Herbivore) worldMap.getEntity(nextStep)).SetHP(ATTACK_POWER);
            }
            else{
                Entity predator = worldMap.removeEntity(my_pos);
                worldMap.addEntity(nextStep, predator);
            }
        }

    }
}
