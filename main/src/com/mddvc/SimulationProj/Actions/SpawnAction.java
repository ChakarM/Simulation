package com.mddvc.SimulationProj.Actions;

import com.mddvc.SimulationProj.Entities.Entity;
import com.mddvc.SimulationProj.WorldMap;

import java.util.function.Supplier;

public abstract class SpawnAction extends Action {
    protected <T extends Entity> void spawn(WorldMap worldMap, int rate, Supplier<T> entitySupplier) {
        for (int i = 0; i < rate; i++) {
            worldMap.addEntity(worldMap.getRandomEmptyCell(), entitySupplier.get());
        }
    }

    protected int calculateRate(WorldMap worldMap, double ratio) {
        return (int) (worldMap.getMapArea() * ratio);
    }
}
