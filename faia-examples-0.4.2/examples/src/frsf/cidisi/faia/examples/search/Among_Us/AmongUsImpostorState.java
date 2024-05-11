package frsf.cidisi.faia.examples.search.Among_Us;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

import frsf.cidisi.faia.agent.Perception;
import frsf.cidisi.faia.agent.search.SearchBasedAgentState;

public class AmongUsImpostorState extends SearchBasedAgentState {

    private HashMap<Room, Collection<Room>> ship;
    private int energia;
    private Room habitacionActual;
    private Collection<Room> habitacionesConectadas = new ArrayList<Room>();
    private int energia_Inicial;
    private int tripulantes_Vivos;
    private List<Tripulante> tripulantes_en_habitacion;
    private List<Tarea> tareas_Pendientes;
    private HashMap<Room, Collection<Tripulante>> Tripulantes_Adyacentes;

    



    

    public AmongUsImpostorState(HashMap<Room, Collection<Room>> ship, int energia, Room habitacionActual,
            Collection<Room> habitacionesConectadas, int energia_Inicial, int tripulantes_Vivos,
            List<Tripulante> tripulantes_en_habitacion,
            HashMap<Room, Collection<Tripulante>> tripulantes_Adyacentes) {
        this.ship = ship;
        this.energia = energia;
        this.habitacionActual = habitacionActual;
        this.habitacionesConectadas = habitacionesConectadas;
        this.energia_Inicial = energia_Inicial;
        this.tripulantes_Vivos = tripulantes_Vivos;
        this.tripulantes_en_habitacion = tripulantes_en_habitacion;
        ArrayList<Tarea> listaTareas = new ArrayList<Tarea>();
        listaTareas.add(Tarea.DESCONECTAR_SERVICIO_ELECTRICO);
        listaTareas.add(Tarea.DESTRUIR_REACTOR);
        listaTareas.add(Tarea.DESTRUIR_SALA_ARMAS);
        this.tareas_Pendientes = listaTareas;
        Tripulantes_Adyacentes = tripulantes_Adyacentes;
    }

    public AmongUsImpostorState(){
        Inicializador init= Inicializador.getInstance();
        this.energia= init.getAgentEnergy();
        this.energia_Inicial= init.getAgentEnergy();
        this.habitacionActual = init.getAgentPosition();
        this.ship = init.getShip();
        this.tripulantes_Vivos=init.getCantTripulantes();
        this.habitacionesConectadas = init.getHabitacionesConectadas();
        this.tareas_Pendientes = init.getListaTareas();
        this.tripulantes_en_habitacion=init.getTripulantes_en_habitacion();
        this.Tripulantes_Adyacentes = init.getTripulantes_Adyacentes();


    }

    public int getEnergia() {
        return energia;
    }

    public void setEnergia(int energia) {
        this.energia = energia;
    }

    public Room getHabitacionActual() {
        return habitacionActual;
    }

    public void setHabitacionActual(Room habitacionActual) {
        this.habitacionActual = habitacionActual;
    }

    public Collection<Room> getHabitacionesConectadas() {
        return habitacionesConectadas;
    }

    public void setHabitacionesConectadas(List<Room> habitacionesConectadas) {
        this.habitacionesConectadas = habitacionesConectadas;
    }

    public int getEnergia_Inicial() {
        return energia_Inicial;
    }

    public void setEnergia_Inicial(int energia_Inicial) {
        this.energia_Inicial = energia_Inicial;
    }

    public int getTripulantes_Vivos() {
        return tripulantes_Vivos;
    }

    public void setTripulantes_Vivos(int tripulantes_Vivos) {
        this.tripulantes_Vivos = tripulantes_Vivos;
    }

    public List<Tripulante> getTripulantes_en_habitacion() {
        return tripulantes_en_habitacion;
    }

    public void setTripulantes_en_habitacion(List<Tripulante> tripulantes_en_habitacion) {
        this.tripulantes_en_habitacion = tripulantes_en_habitacion;
    }

    
    @Override
    public boolean equals(Object obj) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'equals'");
    }

    @Override
    public SearchBasedAgentState clone() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'clone'");
    }

    @Override
    public void updateState(Perception p) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateState'");
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'toString'");
    }

    @Override
    public void initState() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'initState'");
    }



    public HashMap<Room, Collection<Room>> getShip() {
        return ship;
    }



    public void setShip(HashMap<Room, Collection<Room>> ship) {
        this.ship = ship;
    }

    public void setTareas_Pendientes(List<Tarea> tareas_Pendientes) {
        this.tareas_Pendientes = tareas_Pendientes;
    }

    public List<Tarea> getTareas_Pendientes() {
        return tareas_Pendientes;
    }

    public void setHabitacionesConectadas(Collection<Room> habitacionesConectadas) {
        this.habitacionesConectadas = habitacionesConectadas;
    }

    public HashMap<Room, Collection<Tripulante>> getTripulantes_Adyacentes() {
        return Tripulantes_Adyacentes;
    }

    public void setTripulantes_Adyacentes(HashMap<Room, Collection<Tripulante>> tripulantes_Adyacentes) {
        Tripulantes_Adyacentes = tripulantes_Adyacentes;
    }

    
    
}
