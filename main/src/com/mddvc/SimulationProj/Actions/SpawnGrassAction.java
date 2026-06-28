package com.mddvc.SimulationProj.Actions;

import com.mddvc.SimulationProj.Entities.Grass;
import com.mddvc.SimulationProj.WorldMap;

import java.util.function.Supplier;

public class SpawnGrassAction extends SpawnAction {

    @Override
    public void perform(WorldMap worldMap) {
        int rate = calculateRate(worldMap, 0.18);
        Supplier<Grass> grassSupplier = Grass::new;
        spawn(worldMap, rate, grassSupplier);
    }
}
