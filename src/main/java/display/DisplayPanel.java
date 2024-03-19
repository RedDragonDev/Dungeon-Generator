package main.java.display;

import main.java.Enums.*;
import main.java.Grid;
import main.java.rooms.base.Chunk;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class DisplayPanel extends JPanel {
    //Config
    private final int scale;
    private final int lineScale;

    //
    private final int width;
    private final int length;

    private BufferedImage emptyTile;
    private BufferedImage startTile;
    private BufferedImage roomTile;

    private Grid grid;

    //Chunk Colors
    Color emptyColor = new Color(0,0,0);
    Color startColor = new Color(6, 114, 82);
    Color roomColor = new Color(157, 8, 231);
    Color tempHallColor = new Color(0, 166, 255);

    //Edge Colors
    Color nullColor = new Color(0,0,0);
    Color potentialColor = new Color(255, 106,0);
    Color innerColor = new Color(255, 255, 255);
    Color wallColor = new Color(255,0,0);
    Color doorColor = new Color(24,241,12);
    Color entranceColor = new Color(255, 216, 45);


    public DisplayPanel(Grid grid,int scale,int lineScale){
        this.grid = grid;
        this.scale = scale;
        this.lineScale = lineScale;

        this.width = grid.getWidth()*scale;
        this.length = grid.getLength()*scale;
    }


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        ArrayList<ArrayList<Chunk>> gridmap = this.grid.getGridMap();

        for (int y = 0; y < gridmap.size(); y++) {
            for (int x = 0; x < gridmap.get(y).size(); x++) {
                Chunk chunk = gridmap.get(y).get(x);

                //Fill Tile with Apropriate Color
                switch(chunk.getChunkType()){
                    case START:
                        g.setColor(startColor);
                        g.fillRect(x*scale,y*scale,scale,scale);
                        break;
                    case ROOM:
                        g.setColor(roomColor);
                        g.fillRect(x*scale,y*scale,scale,scale);
                        break;
                    case TEMPHALL:
                        g.setColor(tempHallColor);
                        g.fillRect(x*scale,y*scale,scale,scale);
                        break;
                    case EMPTY:
                    default:
                        g.setColor(emptyColor);
                        g.fillRect(x*scale,y*scale,scale,scale);
                        break;

                }

                //Draw Edges
                //North
                g.setColor(setEdgeColor(g,chunk.getNorth()));
                g.fillRect(x*scale+lineScale,y*scale,scale-(lineScale*2),lineScale);
                //South
                g.setColor(setEdgeColor(g,chunk.getSouth()));
                g.fillRect(x*scale+lineScale,(y*scale)+(scale-lineScale),scale-(lineScale*2),lineScale);

                //West
                g.setColor(setEdgeColor(g,chunk.getWest()));
                g.fillRect(x*scale, y*scale+lineScale ,lineScale,scale-(lineScale*2));


                //East
                g.setColor(setEdgeColor(g,chunk.getEast()));
                g.fillRect((x*scale)+(scale-lineScale),y*scale+lineScale,lineScale,scale-(lineScale*2));
            }
        }
    }

    public Color setEdgeColor(Graphics g, EdgeState edgeState){
        Color c;
        switch(edgeState){
            case POTENTIAL:
                c = this.potentialColor;
                break;
            case INNER:
                c = this.roomColor;
                break;
            case WALL:
                c = this.wallColor;
                break;
            case DOOR:
                c = this.doorColor;
                break;
            case ENTRANCE:
                c = this.entranceColor;
                break;
            case NULL:
            default:
                c = this.nullColor;
                break;
        }
        return c;
    }


    public static void main(String[] args) {

    }
}
