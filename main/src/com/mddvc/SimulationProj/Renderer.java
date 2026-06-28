package com.mddvc.SimulationProj;


public class Renderer {
    public void renderMap(WorldMap worldMap) {
        int WIDTH = worldMap.getWORLD_WIDTH();
        int HEIGHT = worldMap.getWORLD_HEIGHT();
        IO.println("\n---------------------------");
        for (int i = 0; i < WIDTH; i++) {
            for (int j = 0; j < HEIGHT; j++) {
                if (worldMap.hasEntity(new Coordinates(i, j))) {
                    worldMap.getEntity(new Coordinates(i, j)).render();
                }
                else IO.print(" ");
            }
            System.out.println();
        }

    }


}
