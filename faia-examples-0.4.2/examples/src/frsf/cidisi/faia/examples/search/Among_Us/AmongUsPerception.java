package frsf.cidisi.faia.examples.search.Among_Us;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

import frsf.cidisi.faia.agent.Agent;
import frsf.cidisi.faia.agent.Perception;
import frsf.cidisi.faia.environment.Environment;


public class AmongUsPerception extends Perception{

    // Evaluar si pasarlo a ingles o no, porque el resto de clases esta en ingles.
    private Room habitacionActual;
    private List<Room> habitacionesSiguientes;
    private int energia;

    //esta las agregué hoy 16/5 porque necesitamos saber si la habitacion tiene o no una tarea y saber si las habitaciones de alrededor tienen tripulantes
    private List<Tripulante> tripulantes_en_habitacion;
    private Tarea Tarea;
    private HashMap<Room, Collection<Tripulante>> Tripulantes_Adyacentes;

    public AmongUsPerception() {
        // No inicializar, porque se crea uno nuevo cada vez que se pide una percepcion
        // a la clase xEnvironment. Actualizar posicion, habitaciones, energia, etc
        // en xEnvironmentState.
        super();
    }

    public AmongUsPerception(Agent agent, Environment environment) {
        super(agent, environment);
    }

    // Esto es lo mismo que hace AmongUsEnvironment a mano cuando se le pide
    // percepcion. Esta al pedo. Es otra forma de inicializar una perception.
    @Override
    public void initPerception(Agent agent, Environment environment) {
        AmongUsImpostorAgent agente= (AmongUsImpostorAgent) agent;
        AmongUsEnviromentState state = (AmongUsEnviromentState) environment.getEnvironmentState();
        HashMap<Room, Collection<Room>> ship = state.getShip();
        
        // Set agent position
        this.habitacionActual = state.getAgentPosition();

        // Set available rooms to go
        this.habitacionesSiguientes = state.getSuccesors(habitacionActual);

        // Creo que la energía debe setearse en el state y sacarse de ahí.
        this.energia = state.getAgentEnergy();
        
       //tripulantes en habitacion
       this.tripulantes_en_habitacion =  new ArrayList<Tripulante>();
        this.tripulantes_en_habitacion = state.getAgentPosition().getTripulantesEnHabitacion();
        // tripulantes en habitaciones adyacentes
        this.Tripulantes_Adyacentes = new HashMap<Room, Collection<Tripulante>>();
        for(Room room: habitacionesSiguientes){
            if(!room.getTripulantesEnHabitacion().isEmpty()){
                Tripulantes_Adyacentes.put(room, room.getTripulantesEnHabitacion());
            }

            /*Habilidad especial, guarda en esta variable todas las habitaciones con al menos 1 tripulante dentro, pero aun no está
            implementada
            
            List<Room> habitacionesConTripulantes = new ArrayList<Room>();
            for(Room habitacion :ship.keySet()){
                if(!habitacion.getTripulantesEnHabitacion().isEmpty())
                    habitacionesConTripulantes.add(habitacion);
            }
             */

        }



        

    }

    public void setHabitacionesSiguientes(List<Room> habitacionesSiguientes) {
        this.habitacionesSiguientes = habitacionesSiguientes;
    }

    public int getEnergia() {
        return energia;
    }

    public Room getHabitacionActual() {
        return habitacionActual;
    }

    public List<Room> getHabitacionesSiguientes() {
        return habitacionesSiguientes;
    }

    public void setEnergia(int energia) {
        this.energia = energia;
    }
    
    public void setHabitacionActual(Room habitacionActual) {
        this.habitacionActual = habitacionActual;
    }

    public List<Tripulante> getTripulantes_en_habitacion() {
        return tripulantes_en_habitacion;
    }

    public void setTripulantes_en_habitacion(List<Tripulante> tripulantes_en_habitacion) {
        this.tripulantes_en_habitacion = tripulantes_en_habitacion;
    }

    public Tarea getTarea() {
        return Tarea;
    }

    public void setTarea(Tarea tarea) {
        Tarea = tarea;
    }

    public HashMap<Room, Collection<Tripulante>> getTripulantes_Adyacentes() {
        return Tripulantes_Adyacentes;
    }

    public void setTripulantes_Adyacentes(HashMap<Room, Collection<Tripulante>> tripulantes_Adyacentes) {
        Tripulantes_Adyacentes = tripulantes_Adyacentes;
    }



    
}
