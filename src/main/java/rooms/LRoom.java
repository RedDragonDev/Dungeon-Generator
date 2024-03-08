package main.java.rooms;

import main.java.Enums;
import main.java.rooms.base.Chunk;
import main.java.rooms.base.Room;

public class LRoom extends Room {

    public LRoom() {
        super("L Room (top right missing)",2, 2);
        generateRoom();
    }


    @Override
    public void generateRoom() {
        Chunk c0_0 = new Chunk(Enums.ChunkType.ROOM, Enums.EdgeState.POTENTIAL, Enums.EdgeState.INNER, Enums.EdgeState.POTENTIAL, Enums.EdgeState.POTENTIAL); //Top Left
        super.setRoomOrigin(c0_0);
        Chunk c0_1 = new Chunk(Enums.ChunkType.EMPTY, Enums.EdgeState.NULL, Enums.EdgeState.NULL, Enums.EdgeState.NULL, Enums.EdgeState.NULL); //Top Right
        Chunk c1_0 = new Chunk(Enums.ChunkType.ROOM, Enums.EdgeState.INNER, Enums.EdgeState.POTENTIAL, Enums.EdgeState.INNER, Enums.EdgeState.POTENTIAL); //Bottom Left
        Chunk c1_1 = new Chunk(Enums.ChunkType.ROOM, Enums.EdgeState.POTENTIAL, Enums.EdgeState.POTENTIAL, Enums.EdgeState.POTENTIAL, Enums.EdgeState.INNER); //Bottom Right

        this.chunkList.get(0).set(0,c0_0);
        this.chunkList.get(0).set(1,c0_1);
        this.chunkList.get(1).set(0,c1_0);
        this.chunkList.get(1).set(1,c1_1);
    }

}
