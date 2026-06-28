package com.mddvc.SimulationProj.Actions;

import com.mddvc.SimulationProj.Entities.Rock;
import com.mddvc.SimulationProj.WorldMap;

import java.util.function.Supplier;

public class SpawnRockAction extends SpawnAction {
    @Override
    public void perform(WorldMap worldMap) {
        int rate = calculateRate(worldMap, 0.05);
        Supplier<Rock> rockSupplier = Rock::new;
        spawn(worldMap, rate, rockSupplier);
    }
}
