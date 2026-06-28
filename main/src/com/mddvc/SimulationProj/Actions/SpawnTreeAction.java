package com.mddvc.SimulationProj.Actions;

import com.mddvc.SimulationProj.Entities.Tree;
import com.mddvc.SimulationProj.WorldMap;

import java.util.function.Supplier;

public class SpawnTreeAction extends SpawnAction {
    @Override
    public void perform(WorldMap worldMap) {
        int rate = calculateRate(worldMap, 0.05);
        Supplier<Tree> treeSupplier = Tree::new;
        spawn(worldMap, rate, treeSupplier);
    }
}
