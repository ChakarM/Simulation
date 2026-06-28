package com.mddvc.SimulationProj;

import com.mddvc.SimulationProj.Actions.*;
import com.mddvc.SimulationProj.Entities.Grass;

public class Simulation {

    private WorldMap worldMap;
    private final Renderer renderer;

    SpawnAction[] initActions = {
            new SpawnTreeAction(),
            new SpawnRockAction(),
            new SpawnGrassAction(),
            new SpawnPredatorAction(),
            new SpawnHerbivoreAction()
    };

    Action[] turnActions = {
            new MoveCreatureAction()
    };

    public Simulation(int width, int height) {
        this.worldMap = new WorldMap(width, height);
        this.renderer = new Renderer();
        for (SpawnAction action : initActions) {
            action.perform(this.worldMap);
        }
    }


    private void nextTurn() {
        for (Action action : turnActions) {
            action.perform(this.worldMap);
        }
        renderer.renderMap(this.worldMap);
    }

    public void startSimulation() {
       while (this.worldMap.hasMoreEntitiesOf(new Grass())) {
           nextTurn();
           try {
               Thread.sleep(500);
           } catch (InterruptedException e) {
               throw new RuntimeException(e);
           }
       }
    }



}



