package main.java.rooms;

import main.java.Enums.ChunkType;
import main.java.Enums.EdgeState;
import main.java.rooms.base.Chunk;
import main.java.rooms.base.Room;

public class WidthThreeLengthThree extends Room {

    public WidthThreeLengthThree() {
        super("3x3",3, 3);
        generateRoom();
    }


    @Override
    public void generateRoom() {
        Chunk c0_0 = new Chunk(ChunkType.ROOM,EdgeState.POTENTIAL,EdgeState.INNER,EdgeState.INNER,EdgeState.POTENTIAL); //Top Left
        super.setRoomOrigin(c0_0);
        Chunk c0_1 = new Chunk(ChunkType.ROOM,EdgeState.POTENTIAL,EdgeState.INNER,EdgeState.INNER,EdgeState.INNER); //Top Center
        Chunk c0_2 = new Chunk(ChunkType.ROOM,EdgeState.POTENTIAL,EdgeState.INNER,EdgeState.POTENTIAL,EdgeState.INNER); //Top Right

        Chunk c1_0 = new Chunk(ChunkType.ROOM,EdgeState.INNER,EdgeState.INNER,EdgeState.INNER,EdgeState.POTENTIAL); //Middle Left
        Chunk c1_1 = new Chunk(ChunkType.ROOM,EdgeState.INNER,EdgeState.INNER,EdgeState.INNER,EdgeState.INNER); //Middle Center
        Chunk c1_2 = new Chunk(ChunkType.ROOM,EdgeState.INNER,EdgeState.INNER,EdgeState.POTENTIAL,EdgeState.INNER); //Middle Right

        Chunk c2_0 = new Chunk(ChunkType.ROOM,EdgeState.INNER,EdgeState.POTENTIAL,EdgeState.INNER,EdgeState.POTENTIAL); //Bottom Left
        Chunk c2_1 = new Chunk(ChunkType.ROOM,EdgeState.INNER,EdgeState.POTENTIAL,EdgeState.INNER,EdgeState.INNER); //Bottom Center
        Chunk c2_2 = new Chunk(ChunkType.ROOM,EdgeState.INNER,EdgeState.POTENTIAL,EdgeState.POTENTIAL,EdgeState.INNER); //Bottom Right


        this.chunkList.get(0).set(0,c0_0);
        this.chunkList.get(0).set(1,c0_1);
        this.chunkList.get(0).set(2,c0_2);

        this.chunkList.get(1).set(0,c1_0);
        this.chunkList.get(1).set(1,c1_1);
        this.chunkList.get(1).set(2,c1_2);

        this.chunkList.get(2).set(0,c2_0);
        this.chunkList.get(2).set(1,c2_1);
        this.chunkList.get(2).set(2,c2_2);
    }

}
