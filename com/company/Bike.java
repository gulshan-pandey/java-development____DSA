package com.company;

public class Bike {
    public String color;
    public int tyres;
    int model;
    private int fuelLevel;
    int costOfPurchase;

    public int getModel(){
    return model;
    }
    public Bike(){

    }
    public Bike(String color, int tyres, int model, int fuelLevel, int costOfPurchase) {
        this.color = color;
        this.tyres = tyres;
        this.model = model;
        this.fuelLevel = fuelLevel;
        this.costOfPurchase = costOfPurchase;
    }


    @Override
    public String toString() {
        return "Bike [color=" + color + ", tyres=" + tyres + ", model=" + model + ", fuelLevel=" + fuelLevel
                + ", costOfPurchase=" + costOfPurchase + "]";
    }

  public static void main(String[] args) {
    
    com.company.Default def = new com.company.Default(); //default class are accesible within its own package but its not accissable in different packages


  }
    
}


