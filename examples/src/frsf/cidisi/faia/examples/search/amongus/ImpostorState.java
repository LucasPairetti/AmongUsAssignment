package frsf.cidisi.faia.examples.search.amongus;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

import frsf.cidisi.faia.agent.Perception;
import frsf.cidisi.faia.agent.search.SearchBasedAgentState;

public class ImpostorState extends SearchBasedAgentState {

    private HashMap<Room, ArrayList<Room>> ship;
    private int agentEnergy;
    private Room agentPosition;
    private int crewmatesLeft;
    private ArrayList<Task> taskList;
    private Double cost;
    
    public ImpostorState() {
        initState();
    }

    public ImpostorState(HashMap<Room, ArrayList<Room>> ship, int agentEnergy, Room agentPosition, int crewmatesLeft,
            ArrayList<Task> taskList, Double cost) {
        this.ship = ship;
        this.agentEnergy = agentEnergy;
        this.agentPosition = agentPosition;
        this.crewmatesLeft = crewmatesLeft;
        this.taskList = taskList;
        this.cost = cost;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        ImpostorState that = (ImpostorState) obj;
        return agentEnergy == that.agentEnergy &&
               crewmatesLeft == that.crewmatesLeft &&
               Objects.equals(ship, that.ship) &&
               Objects.equals(agentPosition, that.agentPosition) &&
               Objects.equals(taskList, that.taskList);
    }

    @SuppressWarnings("unchecked")
    @Override
    public SearchBasedAgentState clone() {

        HashMap<Room,ArrayList<Room>> newShip = clonedShip();
        
        Room newAgentPosition = null;

        for(Room r : newShip.keySet()){
            if(r.getId()==this.agentPosition.getId()) 
            {newAgentPosition=r; break;}
        }

        return new ImpostorState(newShip, agentEnergy, newAgentPosition, crewmatesLeft,(ArrayList<Task>) taskList.clone(), this.cost);

    }

    @Override
    public void updateState(Perception p) {
        AmongUsPerception perception = (AmongUsPerception) p;
        List<Room> updateThisRooms= perception.getRoomsWithCrewMates();

        if(perception.isSuperpower()) {
            for(Room room : this.getRoomsWithCrewmate()) {
                room.setCrewmatesInRoom(new ArrayList<Crewmate>());
            }
        }

        for(Room room: updateThisRooms){
            int id= room.getId();
            Room impostorStateRoom= this.getRoomByID(id);
            if(id==impostorStateRoom.getId()) {
                ArrayList<Crewmate> updateCrewmates = new ArrayList<Crewmate>();
                for(Crewmate crew: room.getCrewmatesInRoom()){
                    updateCrewmates.add(new Crewmate(crew.getId())); //creo un tripulante y lo agrego a la lista
                } 
                impostorStateRoom.setCrewmatesInRoom(updateCrewmates);
            }
        }

        if(!perception.isSuperpower()) {
            ArrayList<Integer> idsConnected = (ArrayList<Integer>) this.getConnectedRooms(this.agentPosition).
            stream().map((r)->r.getId()).collect(Collectors.toList());
            idsConnected.add(this.agentPosition.getId());

            ArrayList<Integer> idsPerception = (ArrayList<Integer>) perception.getRoomsWithCrewMates().
            stream().map((r)->r.getId()).collect(Collectors.toList());

            for(int id : idsConnected) {
                if(!idsPerception.contains(id)) this.getRoomByID(id).setCrewmatesInRoom(new ArrayList<Crewmate>());
            }
        }

    }

    @Override
    public String toString() {
        String str = "";
        
        String habitaciones_conectadas= this.getConnectedRooms(this.agentPosition).toString();
        String tareasPorRealizar=this.getTaskList().toString();
        str = str + " position=" + this.agentPosition +"\n";
        str = str + " energy=" + this.agentEnergy + "\n";
        str = str + " habitaciones conectadas=" + habitaciones_conectadas + "\n";
        str = str + " tareasPorRealizar=" + tareasPorRealizar + "\n";
        str = str + "\nHABITACIONES C TRIPULANTES: " + this.getRoomsWithCrewmate()+ " \n";
        str = str + "\n Tripulantes vivos: " + this.getCrewmatesLeft()+ " \n";
        return str;
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

        // Initialize cost
        this.cost=0.;

        Initializer initializer = Initializer.getInstance();

        ArrayList<Room> keys = new ArrayList<Room>(ship.keySet());
        // Let perception set the elements
        this.agentEnergy = initializer.getAgentEnergy();
        this.agentPosition = keys.stream().filter((r)-> r.getId()==initializer.getAgentPosition()).collect(Collectors.toList()).get(0);
        this.crewmatesLeft = 3;
        this.taskList = new ArrayList<Task>();
        this.taskList.add(Task.DESCONECTAR_SERVICIO_ELECTRICO);
        // this.taskList.add(Task.DESTRUIR_REACTOR);
        // this.taskList.add(Task.DESTRUIR_SALA_ARMAS);
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

    public int getCrewmatesLeft() {
        return crewmatesLeft;
    }

    public void setCrewmatesLeft(int tripulantesVivos) {
        this.crewmatesLeft = tripulantesVivos;
    }


    public ArrayList<Task> getTaskList() {
        return taskList;
    }

    public void setTaskList(ArrayList<Task> taskList) {
        this.taskList = taskList;
    }

   //me parece correcto pero
   ArrayList<Room> getConnectedRooms(Room room) {
    return this.ship.get(room);
}

    //este seria util tambien
    ArrayList<Room> getConnectedRoomsForAgent() {
    return this.ship.get(this.agentPosition);
}


    public ArrayList<Room> getRoomsWithCrewmate() {
        ArrayList<Room> list = new ArrayList<Room>();
        for(Room room : this.ship.keySet()) {
            if(room.crewmatesAliveInside()) list.add(room); 
        }
        return list; //esto te devuelve las rooms con crewmates vivos
    }

    public Boolean isInRoomWithCrewmates(){  //checkea por ID de la room si se encuentra en una room con crewMatesVivos
        
        int idRoom = this.getAgentPosition().getId();

        for(Room room: this.getRoomsWithCrewmate()){
            if(room.getId()==idRoom)
                return true;
            
        }

        return false;
    }
   

    public Boolean isConnected(int idRoom){ //Valida si el impostor puede moverse a esa habitacion
        for(Room room: this.getConnectedRoomsForAgent()){
            if(room.getId()==idRoom)
            return true;
        }

        return false;
    }

    public Room getRoomByID(int id){ //obtener una room de la ship en base al ID
        Room room= new Room(0, null);
        for(Room r: this.ship.keySet()){
            if(r.getId()==id)
            room=r;
        }

        return room;
    }

    public ArrayList<Room> cloneRooms(ArrayList<Room> values) {
        ArrayList<Room> newList = new ArrayList<Room>();
        values.forEach((room) -> newList.add(room.clone()));
        return newList;
    }

    public HashMap<Room, ArrayList<Room>> clonedShip() {
        HashMap<Room, ArrayList<Room>> clonedGraph = new HashMap<>();
        HashMap<Room, Room> clonedRoomsMap = new HashMap<>();

        // First pass: clone all rooms and put them in the map
        for (Room room : this.ship.keySet()) {
            Room clonedRoom = room.clone();
            clonedRoomsMap.put(room, clonedRoom);
            clonedGraph.put(clonedRoom, new ArrayList<>());
        }

        // Second pass: clone the connections
        for (Map.Entry<Room, ArrayList<Room>> entry : this.ship.entrySet()) {
            Room originalRoom = entry.getKey();
            Room clonedRoom = clonedRoomsMap.get(originalRoom);
            for (Room connectedRoom : entry.getValue()) {

                clonedGraph.get(clonedRoom).add(clonedRoomsMap.get(connectedRoom));
            }
        }

        return clonedGraph;
    }

    public Double getCost() {
        return cost;
    }

    public void incrementCost(Double cost) {
        this.cost += cost;
    }

}
