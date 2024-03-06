package main.java;

public class Enums {

    public enum EdgeState{
        WALL("wall"),
        DOOR("door"),
        INNER("inner"),
        POTENTIAL("potential"),
        ENTRANCE("entrance"),
        NULL("null");

        public final String id;
        private EdgeState(String id){
            this.id = id;
        }
    }

    public enum Direction{
        NORTH("North"),
        SOUTH("South"),
        EAST("East"),
        WEST("West");

        public final String id;
        private Direction(String id){
            this.id = id;
        }
    }


    public enum ChunkType{
        ROOM("Room"),
        TEMPHALL("Temp"),
        HALLWAY("Hallway"),
        EMPTY("Empty"),
        START("Start");

        public final String id;
        private ChunkType(String id){
            this.id = id;
        }
    }
}
