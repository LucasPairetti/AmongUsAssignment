package frsf.cidisi.faia.examples.search.Among_Us;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import frsf.cidisi.faia.state.EnvironmentState;



public class AmongUsEnviromentState extends EnvironmentState{

    private HashMap<Room, Collection<Room>> ship;
    private Room agentPosition;
    private int agentEnergy;
    private Collection<Room> habitacionesConectadas = new ArrayList<Room>();
    private int tripulantes_Vivos;
    private List<Tarea> tareas_Pendientes;
    private HashMap<Room, Collection<Tripulante>> habitacionesConTripulantes;
    private Boolean tareaEnHabitacion;
    //habilidad especial
    private int nroDePercepcion;
    private int proximoPoder;

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
        this.setHabitacionesConectadas(init.getHabitacionesConectadas());
        this.setHabitacionesConTripulantes(init.getHabitacionesConTripulantes());
        this.setNroDePercepcion(init.getNroDePercepcion());
        this.setProximoPoder(init.getProximoPoder());
        this.setTareaEnHabitacion(init.getTareaEnHabitacion());
        this.setTripulantes_Vivos(init.getCantTripulantes());
        this.setTareas_Pendientes(init.getListaTareas());

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

        str = str + "\nHABITACIONES C TRIPULANTES: " + this.getHabitacionesConTripulantes();

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

    public Collection<Room> getHabitacionesConectadas() {
        return habitacionesConectadas;
    }

    public void setHabitacionesConectadas(Collection<Room> habitacionesConectadas) {
        this.habitacionesConectadas = habitacionesConectadas;
    }

    public int getTripulantes_Vivos() {
        return tripulantes_Vivos;
    }

    public void setTripulantes_Vivos(int tripulantes_Vivos) {
        this.tripulantes_Vivos = tripulantes_Vivos;
    }

    public List<Tarea> getTareas_Pendientes() {
        return tareas_Pendientes;
    }

    public void setTareas_Pendientes(List<Tarea> tareas_Pendientes) {
        this.tareas_Pendientes = tareas_Pendientes;
    }

    public HashMap<Room, Collection<Tripulante>> getHabitacionesConTripulantes() {
        return habitacionesConTripulantes;
    }

    public void setHabitacionesConTripulantes(HashMap<Room, Collection<Tripulante>> habitacionesConTripulantes) {
        this.habitacionesConTripulantes = habitacionesConTripulantes;
    }

    public Boolean getTareaEnHabitacion() {
        return tareaEnHabitacion;
    }

    public void setTareaEnHabitacion(Boolean tareaEnHabitacion) {
        this.tareaEnHabitacion = tareaEnHabitacion;
    }

    public int getNroDePercepcion() {
        return nroDePercepcion;
    }

    public void setNroDePercepcion(int nroDePercepcion) {
        this.nroDePercepcion = nroDePercepcion;
    }

    public int getProximoPoder() {
        return proximoPoder;
    }

    public void setProximoPoder(int proximoPoder) {
        this.proximoPoder = proximoPoder;
    }

    

}