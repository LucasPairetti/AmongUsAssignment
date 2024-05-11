package frsf.cidisi.faia.examples.search.Among_Us;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Random;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import frsf.cidisi.faia.state.EnvironmentState;



public class AmongUsEnviromentState extends EnvironmentState{

    private HashMap<Room, Collection<Room>> ship;
    private Room agentPosition;
    private int agentEnergy;


public AmongUsEnviromentState(){

    // Define initial parameters
    this.initState();

}

    @Override
    public void initState() {

        // Get Inicializador
        Inicializador init = Inicializador.getInstance();

        // Get ship
        this.ship = init.getShip();

        // Generate Random obj
        Random r = new Random();

        // Set agent random parameters
        this.setAgentPosition(init.getAgentPosition());
        this.setAgentEnergy(r.nextInt(30, 151));

        // Set tripulantes
        // Set variables
        int numTripulantes = init.getCantTripulantes();
        Tripulante tripulante;
        ArrayList<Room> nodos = new ArrayList<Room>(ship.keySet());
    
        // Put tripulantes
        for(int i = 0; i < numTripulantes; i++) {
            tripulante = new Tripulante(i);
            nodos.get(r.nextInt(nodos.size())).addTripulante(tripulante);
        }

    }

    public Object clone(){
        return ship.clone();
    }

    @Override
    public String toString() {
        String str = "";

        str = str + "[ \n";
        for (Room point : ship.keySet()) {
            str = str + "[ " + point.getNombre() + " --> ";
            Collection<Room> successors = ship.get(point);
            if (successors != null) {
                for (Room successor : successors) {
                    str = str + ", "+ successor.getNombre();
                }
            }
            str = str + " ]\n";
        }
        str = str + " ]";

        return str;
    }

    public void setAgentEnergy(int energy) {
        this.agentEnergy = energy;
    }

    public void setAgentPosition(Room position) {
        this.agentPosition = position;
    }

    public int getAgentEnergy() {
        return this.agentEnergy;
    }

    public Room getAgentPosition() {
        return agentPosition;
    }

    public HashMap<Room, Collection<Room>> getShip() {
        return this.ship;
    }

    public void setShip(HashMap<Room, Collection<Room>> ship) {
        this.ship = ship;
    }

        // Getters
    public Room getNodo1() {
        return nodo1;
    }

    public Room getNodo2() {
        return nodo2;
    }

    public Room getNodo3() {
        return nodo3;
    }

    public Room getNodo4() {
        return nodo4;
    }

    public Room getNodo5() {
        return nodo5;
    }

    public Room getNodo6() {
        return nodo6;
    }

    public Room getNodo7() {
        return nodo7;
    }

    public Room getNodo8() {
        return nodo8;
    }

    public Room getNodo9() {
        return nodo9;
    }

    public Room getNodo10() {
        return nodo10;
    }

    public Room getNodo11() {
        return nodo11;
    }

    public Room getNodo12() {
        return nodo12;
    }

    public Room getNodo13() {
        return nodo13;
    }

    public Room getNodo14() {
        return nodo14;
    }

    public Room getNodo15() {
        return nodo15;
    }

    public Room getNodo16() {
        return nodo16;
    }

    public Room getNodo17() {
        return nodo17;
    }

    public Room getNodo18() {
        return nodo18;
    }

    public Room getNodo19() {
        return nodo19;
    }

    public Room getNodo20() {
        return nodo20;
    }

    public Room getNodo(int id) {
        return ship.keySet().stream().filter(i -> i.getId() == id)
        .collect(Collectors.toList()).get(0);
    }

    public ArrayList<Room> getSuccesors(Room nodo) {
        return new ArrayList<>(ship.get(nodo));
    }

    }