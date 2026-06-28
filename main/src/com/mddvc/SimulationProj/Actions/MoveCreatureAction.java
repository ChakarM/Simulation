package com.mddvc.SimulationProj.Actions;

import com.mddvc.SimulationProj.Coordinates;
import com.mddvc.SimulationProj.Entities.Creature;
import com.mddvc.SimulationProj.Entities.Entity;
import com.mddvc.SimulationProj.WorldMap;


import java.util.List;
import java.util.Map;

public class MoveCreatureAction extends Action {
    @Override
    public void perform(WorldMap worldMap) {
        List<Map.Entry<Coordinates, Entity>> map = worldMap.getMapCopy();
        for (Map.Entry<Coordinates, Entity> entry : map) {
            Coordinates my_pos = entry.getKey();
            Entity entity = entry.getValue();
            if (entity instanceof Creature) {
                ((Creature) entity).makeMove(worldMap, my_pos);
            }
        }
    }
}
