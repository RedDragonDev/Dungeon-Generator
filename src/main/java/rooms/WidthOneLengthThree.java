package main.java.rooms;

import main.java.Enums.ChunkType;
import main.java.Enums.EdgeState;
import main.java.rooms.base.Chunk;
import main.java.rooms.base.Room;

public class WidthOneLengthThree extends Room {

    public WidthOneLengthThree() {
        super("Two By Two",1, 3);
        generateRoom();
    }


    @Override
    public void generateRoom() {
        //naming is cy_x

        Chunk c0_0 = new Chunk(ChunkType.ROOM,EdgeState.POTENTIAL,EdgeState.INNER,EdgeState.POTENTIAL,EdgeState.POTENTIAL); //Top
        super.setRoomOrigin(c0_0);
        Chunk c1_0 = new Chunk(ChunkType.ROOM,EdgeState.INNER,EdgeState.INNER,EdgeState.POTENTIAL,EdgeState.POTENTIAL); //Middle
        Chunk c2_0 = new Chunk(ChunkType.ROOM,EdgeState.INNER,EdgeState.POTENTIAL,EdgeState.POTENTIAL,EdgeState.POTENTIAL); //Bottom

        this.chunkList.get(0).set(0,c0_0);
        this.chunkList.get(1).set(0,c1_0);
        this.chunkList.get(2).set(0,c2_0);
    }

}
