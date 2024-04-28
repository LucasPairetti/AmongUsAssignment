package frsf.cidisi.faia.examples.search.Among_Us;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;

import frsf.cidisi.faia.state.EnvironmentState;



public class AmongUsEnviromentState extends EnvironmentState{

    private HashMap<Room, Collection<Room>> ship;

    Room nodo1 = new Room(1, "Cafetería");
    Room nodo2 = new Room(2, "Weapons");
    Room nodo3 = new Room(3, "O2");
    Room nodo4 = new Room(4, "Navigation");
    Room nodo5 = new Room(5, "Shields");
    Room nodo6 = new Room(6, "Communication");
    Room nodo7 = new Room(7, "Storage");
    Room nodo8 = new Room(8, "Admin");
    Room nodo9 = new Room(9, "Electrical");
    Room nodo10 = new Room(10, "Lower Engine");
    Room nodo11 = new Room(11, "Reactor");
    Room nodo12 = new Room(12, "Security");
    Room nodo13 = new Room(13, "Upper Engine");
    Room nodo14 = new Room(14, "Medbay");
    Room nodo15 = new Room(15, "Pasillo derecho medio");
    Room nodo16 = new Room(16, "Pasillo derecho inferior");
    Room nodo17 = new Room(17, "Pasillo izquierdo inferior");
    Room nodo18 = new Room(18, "Pasillo izquierdo medio");
    Room nodo19 = new Room(19, "Pasillo izquierdo superior");
    Room nodo20 = new Room(20, "Pasillo centro");

AmongUsEnviromentState(){
    ship = new HashMap<Room, Collection<Room>>();
    

}

    @Override
    public void initState() {
       ship = new HashMap<Room, Collection<Room>>();
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

        return str;}
    }