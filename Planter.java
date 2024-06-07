package planet.plant;

import planet.*;
import planet.plant.*;
import java.io.*;
import java.util.*;

public class Planter{
    private int[] plantCounts ={0,0,100,0,0,0,0,0};
    private Planet planterLocation =(Planet.EARTH);

    public Planter(){      
    }
    public Planter(int[]x){       
        if (x.length != 8) {
        throw new IllegalArgumentException("Invalid array length. It should be 8.");
    }
        System.arraycopy(x,0,plantCounts,0,8);
    }
    public Planter(int[]x, Planet p){
        if (x.length != 8) {
        throw new IllegalArgumentException("Invalid array length. It should be 8.");
    }
        System.arraycopy(x,0,plantCounts,0,8);
        this.planterLocation=p;   
    }

    public int getPlantCount(Planet p){
        int x=p.ordinal();
        return plantCounts[x];
    }

    public void addPlant(Planet p){
        planterLocation=p;
        plantCounts[p.ordinal()]=plantCounts[p.ordinal()]+1;
    }

    public void growPlants(){
        plantCounts[planterLocation.ordinal()]=plantCounts[planterLocation.ordinal()]*2;
    }

    public void movePlants(int x,Planet p,Planet c){
        if(plantCounts[p.ordinal()]<x){
            throw new IllegalArgumentException("The first planet doesnt have enough plants.");
        }
        else{
            planterLocation=c;
            plantCounts[p.ordinal()]=plantCounts[p.ordinal()]-x;
            plantCounts[c.ordinal()]=plantCounts[c.ordinal()]+x;
        }
    }

    public int[] getPlantCounts(){
        return plantCounts;
    }
    
    public int dis(Planet p, int y){
        int x=Math.abs(p.ordinal()-y);
        return x;
    }
    public void growPlantsByDistanceFrom(Planet p){
        for(int i=0;i<8;i++){
            plantCounts[i]=plantCounts[i]+dis(p,i);
        }
    }
}