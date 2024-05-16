package frsf.cidisi.faia.examples.search.Among_Us;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
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
        // Set agent random parameters
        this.setAgentPosition(init.getAgentPosition());
        this.setAgentEnergy(init.getAgentEnergy());

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

     

    public Room getNodo(int id) {
        return ship.keySet().stream().filter(i -> i.getId() == id)
        .collect(Collectors.toList()).get(0);
    }

    public ArrayList<Room> getSuccesors(Room nodo) {
        return new ArrayList<>(ship.get(nodo));
    }

}