package frsf.cidisi.faia.examples.search.amongus;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

import frsf.cidisi.faia.state.EnvironmentState;

public class AmongUsEnvironmentState extends EnvironmentState {

    private HashMap<Room, ArrayList<Room>> ship;
    private int agentEnergy;
    private Room agentPosition;
    private int crewmatesLeft; //lo pase a ingles para que los metodos coincidan en el impostorState
    private int numberPercepcion;
    private int nextPower;
    private ArrayList<Task> taskList;
    private int initialEnergy;

    public AmongUsEnvironmentState() {
        initState();
    }

    @Override
    public void initState() {

        this.ship = new HashMap<Room, ArrayList<Room>>();

        Room nodo1 = new Room(1, "Cafetería");
        Room nodo2 = new Room(2, "Weapons", Task.DESTRUIR_SALA_ARMAS);
        Room nodo3 = new Room(3, "O2");
        Room nodo4 = new Room(4, "Navigation");
        Room nodo5 = new Room(5, "Shields");
        Room nodo6 = new Room(6, "Communication");
        Room nodo7 = new Room(7, "Storage");
        Room nodo8 = new Room(8, "Admin");
        Room nodo9 = new Room(9, "Electrical", Task.DESCONECTAR_SERVICIO_ELECTRICO);
        Room nodo10 = new Room(10, "Lower Engine");
        Room nodo11 = new Room(11, "Reactor", Task.DESTRUIR_REACTOR);
        Room nodo12 = new Room(12, "Security");
        Room nodo13 = new Room(13, "Upper Engine");
        Room nodo14 = new Room(14, "Medbay");

        // Set successors
        ship.put(nodo1, new ArrayList<Room>(Arrays.asList(nodo2, nodo7, nodo8, nodo13, nodo14)));
        ship.put(nodo2, new ArrayList<Room>(Arrays.asList(nodo1, nodo3, nodo4, nodo5)));
        ship.put(nodo3, new ArrayList<Room>(Arrays.asList(nodo2, nodo4, nodo5)));
        ship.put(nodo4, new ArrayList<Room>(Arrays.asList(nodo2, nodo3, nodo5)));
        ship.put(nodo5, new ArrayList<Room>(Arrays.asList(nodo2, nodo3, nodo4, nodo6, nodo7)));
        ship.put(nodo6, new ArrayList<Room>(Arrays.asList(nodo5, nodo7)));
        ship.put(nodo7, new ArrayList<Room>(Arrays.asList(nodo1, nodo5, nodo6, nodo8, nodo9, nodo10)));
        ship.put(nodo8, new ArrayList<Room>(Arrays.asList(nodo1, nodo7)));
        ship.put(nodo9, new ArrayList<Room>(Arrays.asList(nodo7, nodo10)));
        ship.put(nodo10, new ArrayList<Room>(Arrays.asList(nodo7, nodo9, nodo11, nodo12, nodo13 )));
        ship.put(nodo11, new ArrayList<Room>(Arrays.asList(nodo10, nodo12, nodo13)));
        ship.put(nodo12, new ArrayList<Room>(Arrays.asList(nodo10, nodo11, nodo13)));
        ship.put(nodo13, new ArrayList<Room>(Arrays.asList(nodo1, nodo10, nodo11, nodo12, nodo14)));
        ship.put(nodo14, new ArrayList<Room>(Arrays.asList(nodo1, nodo13)));
        

        // Params
        ArrayList<Room> keys = new ArrayList<Room>(ship.keySet());
        Random r = new Random();
        this.agentPosition = nodo12;
        // this.agentEnergy = r.nextInt(30, 151);
        this.agentEnergy = 50;
        this.initialEnergy = this.agentEnergy;
        this.crewmatesLeft = 3;

        // Set crewmates //podriamos poner un for(int i=0; i<this.crewmatesLeft;i++)
        // para la creacion de tripulantes
        ArrayList<Room> nodos = new ArrayList<Room>(ship.keySet());
        for(int i = 0; i<crewmatesLeft; i++) {
            // Add crewmate
            nodos.get(r.nextInt(0,14)).addCrewmate(new Crewmate(i));
        }
        // Tareas -> estas son las pendientes
        ArrayList<Task> listaTareas = new ArrayList<Task>();
        listaTareas.add(Task.DESCONECTAR_SERVICIO_ELECTRICO);
        // listaTareas.add(Task.DESTRUIR_REACTOR);
        // listaTareas.add(Task.DESTRUIR_SALA_ARMAS);
        this.taskList = listaTareas;

        Random nro = new Random();
        this.numberPercepcion = 0;
        this.nextPower = nro.nextInt(3, 6);

    }

    public HashMap<Room, ArrayList<Room>> getShip() {
        return ship;
    }

    public void setShip(HashMap<Room, ArrayList<Room>> ship) {
        this.ship = ship;
    }

    public int getAgentEnergy() {
        return agentEnergy;
    }

    public void setAgentEnergy(int agentEnergy) {
        this.agentEnergy = agentEnergy;
    }

    public Room getAgentPosition() {
        return agentPosition;
    }

    public void setAgentPosition(Room agentPosition) {
        this.agentPosition = agentPosition;
    }

    

    public int getNumberPercepcion() {
        return numberPercepcion;
    }

    public void setNumberPercepcion(int numberPercepcion) {
        this.numberPercepcion = numberPercepcion;
    }

    public int getNextPower() {
        return nextPower;
    }

    public void setNextPower(int nextPower) {
        this.nextPower = nextPower;
    }

    public int getCrewmatesLeft() {
        return crewmatesLeft;
    }

    public void setCrewmatesLeft(int crewmatesLeft) {
        this.crewmatesLeft = crewmatesLeft;
    }

    public ArrayList<Task> getTaskList() {
        return taskList;
    }

    public void setTaskList(ArrayList<Task> taskList) {
        this.taskList = taskList;
    }
    

    // CORE!
    public ArrayList<Room> getRoomsWithCrewmate() { //superpoder, te pasa todas las habitaciones con tripulantes
        ArrayList<Room> list = new ArrayList<Room>();
        for (Room room : this.ship.keySet()) {
            if (room.crewmatesAliveInside())
                list.add(room); // debemos decidir si usamos el alive o no, o si al matarlos los sacamos
        }
        return list; // esto te devuelve los que se encuentran en la room y estan marcados como vivos
    }


    public ArrayList<Room> getRoomsWithCrewmateAdyacente() { //adyacentes
        ArrayList<Room> list = new ArrayList<Room>();
        for (Room room : this.ship.get(this.agentPosition)) {
            if (room.crewmatesAliveInside())
                list.add(room); // debemos decidir si usamos el alive o no, o si al matarlos los sacamos
        }
        return list; 
    }

    // me parece correcto pero
    ArrayList<Room> getConnectedRooms(Room room) {
        return this.ship.get(room);
    }

    // este seria util tambien
    ArrayList<Room> getConnectedRoomsForAgent() {
        return this.ship.get(this.agentPosition);
    }

    @Override
    public String toString() {

        String str = "";

        str = str + "[ \n";
        for (Room point : ship.keySet()) {
            str = str + "[ " + point.getName() + " --> ";
            Collection<Room> successors = ship.get(point);
            if (successors != null) {
                for (Room successor : successors) {
                    str = str + ", " + successor.getName();
                }
            }
            str = str + " ]\n";
        }
        str = str + " ]";

        str = str + "\nHABITACIONES C TRIPULANTES: " + this.getRoomsWithCrewmate() + " \n";

        return str;
    }

    public Boolean isInRoomWithCrewmates() { // checkea por ID de la room si se encuentra en una room con crewMatesVivos
        boolean flag = false;
        int idRoom = this.getAgentPosition().getId();

        for (Room room : this.getRoomsWithCrewmate()) {
            if (room.getId() == idRoom)
                return true;

        }

        return flag;
    }

    public Boolean isConnected(int idRoom){ //Valida si el impostor puede moverse a esa habitacion
        for(Room room: this.getConnectedRoomsForAgent()){
            if(room.getId()==idRoom)
            return true;
        }

        return false;
    }

    public Room getRoomByID(int id){//obtener una room de la ship en base al ID
        Room room= new Room(0, null);
        for(Room r: this.ship.keySet()){
            if(r.getId()==id)
            room=r;
        }

        return room;
    }

    public int getInitialEnergy() {
        return initialEnergy;
    }

    public void moveCrewmates() {
        Random random = new Random();
        for(Room r : this.getRoomsWithCrewmate()) {
            for(Crewmate c : r.getCrewmatesInRoom()) {
                r.getCrewmatesInRoom().remove(c);
                ship.get(r).get(random.nextInt(0, ship.get(r).size()+1)).addCrewmate(c);
            }
        }
    }

}
