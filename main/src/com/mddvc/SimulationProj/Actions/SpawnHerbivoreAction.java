package com.mddvc.SimulationProj.Actions;

import com.mddvc.SimulationProj.Entities.Creatures.Herbivore;
import com.mddvc.SimulationProj.WorldMap;

import java.util.function.Supplier;

public class SpawnHerbivoreAction extends SpawnAction {

    @Override
    public void perform(WorldMap worldMap) {
        int rate = calculateRate(worldMap, 0.04);
        Supplier<Herbivore> herbivoreSupplier = Herbivore::new;
        spawn(worldMap, rate, herbivoreSupplier);
    }
}
