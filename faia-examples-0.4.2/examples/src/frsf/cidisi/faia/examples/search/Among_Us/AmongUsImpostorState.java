package frsf.cidisi.faia.examples.search.Among_Us;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;
import frsf.cidisi.faia.agent.Perception;
import frsf.cidisi.faia.agent.search.SearchBasedAgentState;

public class AmongUsImpostorState extends SearchBasedAgentState {

    private HashMap<Room, Collection<Room>> ship;
    private Room habitacionActual;
    private int energia;
    private Collection<Room> habitacionesConectadas = new ArrayList<Room>();
    private int energia_Inicial;
    private int tripulantes_Vivos;
    private List<Tarea> tareas_Pendientes;
    private HashMap<Room, Collection<Tripulante>> habitacionesConTripulantes;
    private Boolean tareaEnHabitacion;
    //habilidad especial
    private int nroDePercepcion;
    private int proximoPoder;

    @Override
    public void initState() {
        // TODO Auto-generated method stub
       
        Inicializador init= Inicializador.getInstance();

        this.nroDePercepcion= init.getNroDePercepcion();
        this.proximoPoder=init.getProximoPoder();
        this.energia= init.getAgentEnergy();
        this.energia_Inicial= init.getAgentEnergy();
        this.habitacionActual = init.getAgentPosition();
        this.ship = init.getShip();
        this.tripulantes_Vivos=init.getCantTripulantes();
        this.habitacionesConectadas = init.getHabitacionesConectadas();
        this.tareas_Pendientes = init.getListaTareas();
        this.tareaEnHabitacion=init.getTareaEnHabitacion();
        this.habitacionesConTripulantes= init.getHabitacionesConTripulantes();
        
    }



    
    public AmongUsImpostorState(HashMap<Room, Collection<Room>> ship, int energia, Room habitacionActual,
            Collection<Room> habitacionesConectadas, int energia_Inicial, int tripulantes_Vivos,
            HashMap<Room, Collection<Tripulante>> habitacionesConTripulantes, List<Tarea> tareas_Pendientes2,
            int nroDePercepcion, int proximoPoder, Boolean tareaEnHabitacion) {
        this.ship = ship;
        this.energia = energia;
        this.habitacionActual = habitacionActual;
        this.habitacionesConectadas = habitacionesConectadas;
        this.energia_Inicial = energia_Inicial;
        this.tripulantes_Vivos = tripulantes_Vivos;
        this.tareas_Pendientes = tareas_Pendientes2;
        this.habitacionesConTripulantes = habitacionesConTripulantes;
        this.nroDePercepcion = nroDePercepcion;
        this.proximoPoder = proximoPoder;
        this.tareaEnHabitacion = tareaEnHabitacion;
        
    }

    public AmongUsImpostorState(){
        initState();
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

    public HashMap<Room, Collection<Tripulante>> getHabitacionesConTripulantes() {
        return habitacionesConTripulantes;
    }

    public void setHabitacionesConTripulantes(HashMap<Room, Collection<Tripulante>> habitacionesConTripulantes) {
        this.habitacionesConTripulantes = habitacionesConTripulantes;
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

    public Boolean getTareaEnHabitacion() {
        return tareaEnHabitacion;
    }

    public void setTareaEnHabitacion(Boolean tareaEnHabitacion) {
        this.tareaEnHabitacion = tareaEnHabitacion;
    }

    
    @Override
    public void updateState(Perception p) {

       AmongUsPerception amongUsPerception = (AmongUsPerception) p;

        this.habitacionesConTripulantes=amongUsPerception.getHabitacionesConTripulantes();
        this.energia=amongUsPerception.getEnergia();
        this.habitacionActual=amongUsPerception.getHabitacionActual();
        this.habitacionesConectadas=amongUsPerception.getHabitacionesSiguientes();
        this.nroDePercepcion = amongUsPerception.getNroDePercepcion();
        this.proximoPoder = amongUsPerception.getProximoPoder();
        this.tareaEnHabitacion=amongUsPerception.getTareaEnHabitacion();


    }

    @Override
    public boolean equals(Object o) {
        
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        
        AmongUsImpostorState that = (AmongUsImpostorState) o;
        
        if (energia != that.energia) return false;
        if (energia_Inicial != that.energia_Inicial) return false;
        if (tripulantes_Vivos != that.tripulantes_Vivos) return false;
        if (nroDePercepcion != that.nroDePercepcion) return false;
        if (proximoPoder != that.proximoPoder) return false;
        if (!ship.equals(that.ship)) return false;
        if (!habitacionActual.equals(that.habitacionActual)) return false;
        if (!habitacionesConectadas.equals(that.habitacionesConectadas)) return false;
        if (!Objects.equals(tareas_Pendientes, that.tareas_Pendientes)) return false;
        if (!Objects.equals(habitacionesConTripulantes, that.habitacionesConTripulantes)) return false;
        return Objects.equals(tareaEnHabitacion, that.tareaEnHabitacion);

    }

    @Override
    public SearchBasedAgentState clone() {
        
        AmongUsImpostorState newState = new AmongUsImpostorState( this.ship, this.energia, this.habitacionActual,
        this.habitacionesConectadas, this.energia_Inicial, this.tripulantes_Vivos,
        this.habitacionesConTripulantes, this.tareas_Pendientes,
        this.nroDePercepcion, this.proximoPoder, this.tareaEnHabitacion);

        return newState;
        
    }
   
    @Override
    public String toString() {
        
       
        String str = "";

        /*
         *   private HashMap<Room, Collection<Room>> ship;
    private Room habitacionActual;
    private int energia;
    private Collection<Room> habitacionesConectadas = new ArrayList<Room>();
    private int energia_Inicial;
    private int tripulantes_Vivos;
    private List<Tarea> tareas_Pendientes;
    private HashMap<Room, Collection<Tripulante>> habitacionesConTripulantes;
    private Boolean tareaEnHabitacion;
    //habilidad especial
    private int nroDePercepcion;
    private int proximoPoder;

         */
        
        String habitaciones_conectadas= this.getHabitacionesConectadas().toString();
        String TareasPorRealizar=this.getTareas_Pendientes().toString();
        str = str + " position=" + this.habitacionActual.getNombre() +"\n";
        str = str + " energy=" + this.energia + "\"\n";
        str = str + " habitaciones conectadas=" + habitaciones_conectadas + "\n";
        str = str + " tareasPorRealizar=" + TareasPorRealizar + "\n";
        // for(Room habitacionConectada: habitacionesConectadas){
        //     habitaciones_conectadas.concat(" "+ habitacionConectada.getNombre()+ "\"\n");
        // }
       
        // for(Tarea tareasRealizables: tareas_Pendientes){
        //     TareasPorRealizar.concat(" "+  tareasRealizables.name()+ "\"\n");
        // }
        
        
        // str = str + "habitaciones conectadas: "+ "\"\n" + habitaciones_conectadas+ "\"\n";
        // str = str + "tripulantes vivos= " + tripulantes_Vivos + "\"\n";
        // str = str + "tareas pendientes= " + TareasPorRealizar + "\"\n";
        
        return str;
        
    }
    //directameente no se inicializó, tiene todo en null al aprecer

    
}
