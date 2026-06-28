package com.mddvc.SimulationProj;

import com.mddvc.SimulationProj.Entities.Rock;
import com.mddvc.SimulationProj.Entities.Tree;

import java.util.ArrayList;
import java.util.Objects;

public class Coordinates {
    private final int x;
    private final int y;

    public Coordinates(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }


    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Coordinates that = (Coordinates) o;
        return x == that.x && y == that.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }


    public ArrayList<Coordinates> getNeighbors(WorldMap worldMap) {
        ArrayList<Coordinates> neighbours = new ArrayList<>();
        int[][] xy = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        for (int[] n : xy) {
            int nx = this.getX() + n[0];
            int ny = this.getY() + n[1];
            if (nx >= 0 && nx < worldMap.getWORLD_WIDTH() && ny >= 0 && ny < worldMap.getWORLD_HEIGHT()) {
                if (!(worldMap.getEntity(new Coordinates(nx, ny)) instanceof Rock) &&
                        !(worldMap.getEntity(new Coordinates(nx, ny)) instanceof Tree)) {
                    neighbours.add(new Coordinates(nx, ny));
                }
            }
        }
        return neighbours;
    }

}
