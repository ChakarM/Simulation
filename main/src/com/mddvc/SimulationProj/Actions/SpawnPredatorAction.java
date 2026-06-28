package com.mddvc.SimulationProj.Actions;


import com.mddvc.SimulationProj.Entities.Creatures.Predator;
import com.mddvc.SimulationProj.WorldMap;

import java.util.function.Supplier;

public class SpawnPredatorAction extends SpawnAction {

    @Override
    public void perform(WorldMap worldMap) {
        int rate = calculateRate(worldMap, 0.005);
        Supplier<Predator> predatorSupplier = Predator::new;
        spawn(worldMap, rate, predatorSupplier);
    }
}
