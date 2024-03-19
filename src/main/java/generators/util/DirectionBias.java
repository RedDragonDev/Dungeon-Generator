package main.java.generators.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DirectionBias {
    private int northWeight = 0;
    private int southWeight = 0;
    private int eastWeight = 0;
    private int westWeight = 0;

    List<Integer> weights;

    public DirectionBias(int northWeight, int southWeight, int eastWeight, int westWeight){
        this.northWeight = northWeight;
        this.southWeight = southWeight;
        this.eastWeight = eastWeight;
        this.westWeight = westWeight;

        weights = Arrays.asList(northWeight,southWeight,eastWeight,westWeight);
    }

    public int getNorthWeight() {
        return northWeight;
    }

    public int getSouthWeight() {
        return southWeight;
    }

    public int getEastWeight() {
        return eastWeight;
    }

    public int getWestWeight() {
        return westWeight;
    }

    public void setNorthWeight(int northWeight) {
        this.northWeight = northWeight;
        this.weights.set(0,northWeight);
    }

    public void setSouthWeight(int southWeight) {
        this.southWeight = southWeight;
        this.weights.set(1,northWeight);

    }

    public void setEastWeight(int eastWeight) {
        this.eastWeight = eastWeight;
        this.weights.set(2,northWeight);

    }

    public void setWestWeight(int westWeight) {
        this.westWeight = westWeight;
        this.weights.set(3,northWeight);
    }


}
