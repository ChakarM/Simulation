package com.mddvc.SimulationProj.Entities.Creatures;


import com.mddvc.SimulationProj.BreadthFirstSearcher;
import com.mddvc.SimulationProj.Coordinates;
import com.mddvc.SimulationProj.Entities.Creature;
import com.mddvc.SimulationProj.Entities.Entity;
import com.mddvc.SimulationProj.Entities.Grass;
import com.mddvc.SimulationProj.WorldMap;

import java.util.ArrayList;

public class Herbivore extends Creature {

    @Override
    public void render() {
        IO.print("H");
    }

    public void SetHP(int n) {
        this.HP -= n;
    }

    @Override
    public void makeMove(WorldMap worldMap, Coordinates my_pos) {
        if (this.HP <= 0) {
            worldMap.removeEntity(my_pos);
            return;
        }
        BreadthFirstSearcher searcher = new BreadthFirstSearcher();
        Coordinates nextStep = searcher.getNextStep(worldMap, my_pos, new Grass());
        if (nextStep != null) {
            ArrayList<Coordinates> neighbors = my_pos.getNeighbors(worldMap);
            if(worldMap.getEntity(nextStep) instanceof Grass
                    && neighbors.contains(nextStep)){
               worldMap.removeEntity(nextStep);
                this.SetHP(-1);
            }
            else {
                Entity herbivore = worldMap.removeEntity(my_pos);
                worldMap.addEntity(nextStep, herbivore);
            }
        }

    }

}
