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

    private final Room nodo1;
    private final Room nodo2;
    private final Room nodo3;
    private final Room nodo4;
    private final Room nodo5;
    private final Room nodo6;
    private final Room nodo7;
    private final Room nodo8;
    private final Room nodo9;
    private final Room nodo10;
    private final Room nodo11;
    private final Room nodo12;
    private final Room nodo13;
    private final Room nodo14;
    private final Room nodo15;
    private final Room nodo16;
    private final Room nodo17;
    private final Room nodo18;
    private final Room nodo19;
    private final Room nodo20;

public AmongUsEnviromentState(){

    // Initialize ship
    ship = new HashMap<Room, Collection<Room>>();

    // Define rooms
    this.nodo1 = new Room(1, "Cafetería");
    this.nodo2 = new Room(2, "Weapons");
    this.nodo3 = new Room(3, "O2");
    this.nodo4 = new Room(4, "Navigation");
    this.nodo5 = new Room(5, "Shields");
    this.nodo6 = new Room(6, "Communication");
    this.nodo7 = new Room(7, "Storage");
    this.nodo8 = new Room(8, "Admin");
    this.nodo9 = new Room(9, "Electrical");
    this.nodo10 = new Room(10, "Lower Engine");
    this.nodo11 = new Room(11, "Reactor");
    this.nodo12 = new Room(12, "Security");
    this.nodo13 = new Room(13, "Upper Engine");
    this.nodo14 = new Room(14, "Medbay");
    this.nodo15 = new Room(15, "Pasillo derecho medio");
    this.nodo16 = new Room(16, "Pasillo derecho inferior");
    this.nodo17 = new Room(17, "Pasillo izquierdo inferior");
    this.nodo18 = new Room(18, "Pasillo izquierdo medio");
    this.nodo19 = new Room(19, "Pasillo izquierdo superior");
    this.nodo20 = new Room(20, "Pasillo centro");

    // Set successors
    ship.put(nodo1,new ArrayList<Room>(Arrays.asList(nodo2,nodo19,nodo20)));
    ship.put(nodo2,new ArrayList<Room>(Arrays.asList(nodo1,nodo15)));
    ship.put(nodo3,new ArrayList<Room>(Arrays.asList(nodo15)));
    ship.put(nodo4,new ArrayList<Room>(Arrays.asList(nodo15)));
    ship.put(nodo5,new ArrayList<Room>(Arrays.asList(nodo15,nodo16)));
    ship.put(nodo6,new ArrayList<Room>(Arrays.asList(nodo16)));
    ship.put(nodo7,new ArrayList<Room>(Arrays.asList(nodo16,nodo17,nodo20)));
    ship.put(nodo8,new ArrayList<Room>(Arrays.asList(nodo20)));
    ship.put(nodo9,new ArrayList<Room>(Arrays.asList(nodo17)));
    ship.put(nodo10,new ArrayList<Room>(Arrays.asList(nodo17,nodo18)));
    ship.put(nodo11,new ArrayList<Room>(Arrays.asList(nodo18)));
    ship.put(nodo12,new ArrayList<Room>(Arrays.asList(nodo18)));
    ship.put(nodo13,new ArrayList<Room>(Arrays.asList(nodo18,nodo19)));
    ship.put(nodo14,new ArrayList<Room>(Arrays.asList(nodo19)));
    ship.put(nodo15,new ArrayList<Room>(Arrays.asList(nodo2,nodo3,nodo4,nodo5)));
    ship.put(nodo16,new ArrayList<Room>(Arrays.asList(nodo5,nodo6,nodo7)));
    ship.put(nodo17,new ArrayList<Room>(Arrays.asList(nodo7,nodo9,nodo10)));
    ship.put(nodo18,new ArrayList<Room>(Arrays.asList(nodo10,nodo11,nodo12,nodo13)));
    ship.put(nodo19,new ArrayList<Room>(Arrays.asList(nodo1,nodo13,nodo14)));
    ship.put(nodo20,new ArrayList<Room>(Arrays.asList(nodo1,nodo7,nodo8)));

    // Define initial parameters
    this.initState();

}

    @Override
    public void initState() {

        // Generate Random obj
        Random r = new Random();
/* 
        // Set agent random parameters
        Room[] keys = (Room[]) ship.keySet().toArray();
        this.setAgentPosition(keys[r.nextInt(keys.length)]);
        this.setAgentEnergy(r.nextInt(30, 151));
*/
        // Set tripulantes
        // Set variables
        int numTripulantes = 7;
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