package main.java.rooms;

import main.java.Enums.ChunkType;
import main.java.Enums.EdgeState;
import main.java.rooms.base.Chunk;
import main.java.rooms.base.Room;

public class WidthOneLengthOne extends Room {

    public WidthOneLengthOne() {
        super("1x1",1, 1);
        generateRoom();
    }


    @Override
    public void generateRoom() {
        Chunk c0_0 = new Chunk(ChunkType.ROOM,EdgeState.POTENTIAL,EdgeState.INNER,EdgeState.POTENTIAL,EdgeState.INNER); //Top Left
        super.setRoomOrigin(c0_0);

        this.chunkList.get(0).set(0,c0_0);
    }

}
