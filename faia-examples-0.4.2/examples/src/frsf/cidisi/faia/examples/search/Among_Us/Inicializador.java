package frsf.cidisi.faia.examples.search.Among_Us;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class Inicializador {

    private static Inicializador instance;

    private int agentEnergy;
    private Room agentPosition;
    private Collection<Room> habitacionesConectadas;
    private int cantTripulantes;
    private HashMap<Room, Collection<Room>> ship;
    private ArrayList<Tarea> listaTareas;
     private List<Tripulante> tripulantes_en_habitacion;
     private HashMap<Room, Collection<Tripulante>> Tripulantes_Adyacentes; //hay que hacer la percepcion de atrapar el conjunto (room, tripulantes de las otras habitaciones)

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

    public static Inicializador getInstance() {
        if(instance==null) {instance=new Inicializador();
        return instance;}
        else return instance;
    }
    
    public Inicializador() {

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

        // Params
        ArrayList<Room> keys = new ArrayList<Room>(ship.keySet());
        Random r = new Random();
        this.agentPosition = keys.get(r.nextInt(1, 21));
        this.agentEnergy = r.nextInt(30, 151);
        this.cantTripulantes = 7;

        Tripulante tripulante;
        ArrayList<Room> nodos = new ArrayList<Room>(ship.keySet());
    
        // Put tripulantes que estaba en enviroment state
        for(int i = 0; i < this.cantTripulantes; i++) {
            tripulante = new Tripulante(i);
            nodos.get(r.nextInt(nodos.size())).addTripulante(tripulante);
        }

        //habitaciones conectadas

        this.habitacionesConectadas= ship.get(this.agentPosition);



        //tareas
        ArrayList<Tarea> listaTareas = new ArrayList<Tarea>();
        listaTareas.add(Tarea.DESCONECTAR_SERVICIO_ELECTRICO);
        listaTareas.add(Tarea.DESTRUIR_REACTOR);
        listaTareas.add(Tarea.DESTRUIR_SALA_ARMAS);
        
        //primeros tripulantes en habitacion
        
        tripulantes_en_habitacion= agentPosition.getTripulantesEnHabitacion();

        //tripulantes en habitaciones conectadas
        Tripulantes_Adyacentes= new HashMap<Room, Collection<Tripulante>>();
        for(Room room: habitacionesConectadas){

            if(!room.getTripulantesEnHabitacion().isEmpty()){
                Tripulantes_Adyacentes.put(room, room.getTripulantesEnHabitacion());
            }

        }




    }

    public int getAgentEnergy() {
        return agentEnergy;
    }

    public Room getAgentPosition() {
        return agentPosition;
    }

    public int getCantTripulantes() {
        return cantTripulantes;
    }

    public HashMap<Room, Collection<Room>> getShip() {
        return ship;
    }

    public ArrayList<Tarea> getListaTareas() {
        return listaTareas;
    }

    public List<Tripulante> getTripulantes_en_habitacion() {
        return tripulantes_en_habitacion;
    }

    public Collection<Room> getHabitacionesConectadas() {
        return habitacionesConectadas;
    }

    public HashMap<Room, Collection<Tripulante>> getTripulantes_Adyacentes() {
        return Tripulantes_Adyacentes;
    }

    
}
