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


    public EdgeState getEdge(Direction direction){
        switch(direction){
            case NORTH:
                return north;
            case SOUTH:
                return south;
            case EAST:
                return east;
            case WEST:
                return west;
            default:
                return null;
        }
    }

    public void setEdgeState(Direction direction, EdgeState edgeState){
        switch(direction){
            case NORTH:
                this.north = edgeState;
                break;
            case SOUTH:
                this.south = edgeState;
                break;
            case EAST:
                this.east = edgeState;
                break;
            case WEST:
                this.west = edgeState;
                break;

        }
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

    public void setNorth(EdgeState north) {
        this.north = north;
    }

    public void setSouth(EdgeState south) {
        this.south = south;
    }

    public void setEast(EdgeState east) {
        this.east = east;
    }

    public void setWest(EdgeState west) {
        this.west = west;
    }
}
