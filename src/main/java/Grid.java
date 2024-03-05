package main.java;

import main.java.rooms.Room;

import java.util.ArrayList;

public class Grid {
    private ArrayList<ArrayList<String>> gridMap;

    private ArrayList<Room> rooms;

    public Grid(int x, int y){
        ArrayList<String> tempList = new ArrayList<>();
        gridMap = new ArrayList<>();

        for (int i = 0; i < y; i++) {
            for (int j = 0; j < x; j++) {
                tempList.add("O");
            }
            gridMap.add((ArrayList<String>) tempList.clone());
            tempList.clear();
        }
    }
    public void printGrid(){
        int y = gridMap.size();
        int x = gridMap.size();

        for (int i = 0; i < y; i++) {
            for (int j = 0; j < x; j++) {
                System.out.print(gridMap.get(i).get(j));
            }
            System.out.println();
        }
    }


}
