package main.java.generators;

import main.java.Enums.*;
import main.java.rooms.base.Chunk;

public class StoredEdge {
    Chunk chunk;
    Direction direction;

    public StoredEdge(Chunk chunk, Direction direction){
        this.chunk = chunk;
        this.direction = direction;
    }

    public Chunk getChunk() {
        return chunk;
    }

    public Direction getDirection() {
        return direction;
    }
}
