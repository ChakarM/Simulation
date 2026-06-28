package com.mddvc.SimulationProj;

import com.mddvc.SimulationProj.Entities.Entity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

public class BreadthFirstSearcher {

    public Coordinates getNextStep(WorldMap worldMap, Coordinates my_pos, Entity target) {
        LinkedList<Coordinates> queue = new LinkedList<>();
        ArrayList<Coordinates> visited = new ArrayList<>();
        HashMap<Coordinates, Coordinates> path = new HashMap<>();
        queue.add(my_pos);
        visited.add(my_pos);

        while (!queue.isEmpty()) {
            Coordinates current_pos = queue.poll();
            Coordinates target_pos;
            if (worldMap.getEntity(current_pos) != null && worldMap.getEntity(current_pos).getClass() == target.getClass()) {
                target_pos = current_pos;
                while (!path.get(target_pos).equals(my_pos)) {
                    target_pos = path.get(target_pos);
                }
                return target_pos;
            }


            ArrayList<Coordinates> neighbors = current_pos.getNeighbors(worldMap);
            for (Coordinates neighbor : neighbors) {
                if (!visited.contains(neighbor)) {
                    if (worldMap.getEntity(neighbor) == null
                            || (worldMap.getEntity(neighbor).getClass() == target.getClass())) {
                        queue.add(neighbor);
                        visited.add(neighbor);
                        path.put(neighbor, current_pos);
                    }
                }
            }

        }
        return null;

    }

}


