package main.java.rooms.base;

import main.java.Enums.*;

public class Chunk{

    private EdgeState north = EdgeState.NULL;
    private EdgeState south = EdgeState.NULL;
    private EdgeState east = EdgeState.NULL;
    private EdgeState west = EdgeState.NULL;

    private ChunkType chunkType = ChunkType.EMPTY;

    public Chunk(){

    }

    public Chunk(ChunkType chunkType,EdgeState north, EdgeState south, EdgeState east, EdgeState west){
        this.north = north;
        this.south = south;
        this.east = east;
        this.west = west;

        this.chunkType = chunkType;
    }

    public EdgeState getNorth() {
        return north;
    }

    public EdgeState getSouth() {
        return south;
    }

    public EdgeState getEast() {
        return east;
    }

    public EdgeState getWest() {
        return west;
    }

    public ChunkType getChunkType() {
        return chunkType;
    }
}
