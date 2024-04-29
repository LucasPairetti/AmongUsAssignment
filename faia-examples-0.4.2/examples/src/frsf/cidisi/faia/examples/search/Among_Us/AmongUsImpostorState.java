package frsf.cidisi.faia.examples.search.Among_Us;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import frsf.cidisi.faia.agent.Perception;
import frsf.cidisi.faia.agent.search.SearchBasedAgentState;

public class AmongUsImpostorState extends SearchBasedAgentState {

    private int energia;
    private Room habitacionActual;
    //aca tambien irian las habitaciones conectadas?
    private List<Room> habitacionesConectadas = new ArrayList<Room>();
    private int energia_Inicial;
    private int tripulantes_Vivos;
    private List<Tripulante> tripulantes_en_habitacion;
    private int tareas_Pendientes;

    



    public AmongUsImpostorState(int energia, Room habitacionActual, List<Room> habitacionesConectadas) {
        this.energia = energia;
        this.habitacionActual = habitacionActual;
        this.habitacionesConectadas = habitacionesConectadas;
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

}
