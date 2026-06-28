package com.mddvc.SimulationProj;

import com.mddvc.SimulationProj.Entities.Entity;

import java.util.*;

public class WorldMap {
    private final int WORLD_WIDTH;
    private final int WORLD_HEIGHT;

    public WorldMap(int width, int height) {
        WORLD_WIDTH = width;
        WORLD_HEIGHT = height;
    }

    public int getMapArea() {
        return WORLD_HEIGHT * WORLD_WIDTH;
    }

    private List<Entity> getRemainingEntities() {
        return new ArrayList<>(world_Map.values());
    }

    public boolean hasMoreEntitiesOf(Entity entity) {
        int count = 0;
        for (Entity e : getRemainingEntities()) {
            if (e.getClass() == entity.getClass()) count++;
        }
        return count > 0;
    }

    public List<Map.Entry<Coordinates, Entity>> getMapCopy() {
        return new ArrayList<>(world_Map.entrySet());
    }

    private Map<Coordinates, Entity> world_Map = new HashMap<>();

    public int getWORLD_WIDTH() {
        return WORLD_WIDTH;
    }

    public int getWORLD_HEIGHT() {
        return WORLD_HEIGHT;
    }

    public void addEntity(Coordinates position, Entity entity) {
        this.world_Map.put(position, entity);
    }

    public Entity removeEntity(Coordinates position) {
        return this.world_Map.remove(position);
    }

    public Entity getEntity(Coordinates position) {
        return this.world_Map.get(position);
    }

    public boolean hasEntity(Coordinates position) {
        return this.world_Map.containsKey(position);
    }

    public Coordinates getRandomEmptyCell() {
        Random random = new Random();
        Coordinates coordinates = null;
        do {
            int x = random.nextInt(this.WORLD_WIDTH);
            int y = random.nextInt(this.WORLD_HEIGHT);
            coordinates = new Coordinates(x, y);

        }
        while (this.hasEntity(coordinates));
        return coordinates;
    }
}
