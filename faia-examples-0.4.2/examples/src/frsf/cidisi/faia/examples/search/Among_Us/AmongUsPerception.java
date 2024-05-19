package frsf.cidisi.faia.examples.search.Among_Us;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Random;

import frsf.cidisi.faia.agent.Agent;
import frsf.cidisi.faia.agent.Perception;
import frsf.cidisi.faia.environment.Environment;


public class AmongUsPerception extends Perception{

    // Evaluar si pasarlo a ingles o no, porque el resto de clases esta en ingles.
    private Room habitacionActual;
    private Collection<Room> habitacionesSiguientes;
    private int energia;
    private HashMap<Room, Collection<Tripulante>> habitacionesConTripulantes;
    private Boolean tareaEnHabitacion;
     //habilidad especial
     private int nroDePercepcion;
     private int proximoPoder;

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
        AmongUsImpostorAgent agente = (AmongUsImpostorAgent) agent;
        AmongUsEnviromentState state = (AmongUsEnviromentState) environment.getEnvironmentState();
        HashMap<Room, Collection<Room>> ship = state.getShip();
        
        // Set agent position
        this.habitacionActual = state.getAgentPosition();

        // Set available rooms to go
        this.habitacionesSiguientes = state.getSuccesors(habitacionActual);

        // Creo que la energía debe setearse en el state y sacarse de ahí.
        this.energia = state.getAgentEnergy();
        
        //tarea en habitacion
        if(state.getAgentPosition().getTarea()==null){
            this.tareaEnHabitacion=false;
        } else
        this.tareaEnHabitacion=true;

        // Mapa general para updatear
        HashMap<Room, Collection<Tripulante>> updatedRooms = state.getHabitacionesConTripulantes();

        // Casteo a ArrayList por comodidad
        ArrayList<Room> listaHabitacionesSiguientes = (ArrayList<Room>) habitacionesSiguientes;

        // Itera sobre el mapa que ya tiene cargado y actualiza los rooms adyacentes con la info
        for(Room room : updatedRooms.keySet()) {
            int indexOf = listaHabitacionesSiguientes.indexOf(room);
            if(indexOf!=-1) {
                updatedRooms.put(room, listaHabitacionesSiguientes.get(indexOf).getTripulantesEnHabitacion());
            }
        }
        
        // Setea el actualizado
        this.habitacionesConTripulantes = updatedRooms;

        // for(Room room: habitacionesSiguientes){
        //     if(!room.getTripulantesEnHabitacion().isEmpty()){
        //         habitacionesConTripulantes.put(room, room.getTripulantesEnHabitacion());
        //     }

        // }
         /*Habilidad especial, guarda en esta variable todas las habitaciones con al menos 1 tripulante dentro, pero aun no está
            implementada*/

        //habilidad especial
        nroDePercepcion++;
        if(nroDePercepcion==proximoPoder){
            
            this.habitacionesConTripulantes = state.getHabitacionesConTripulantes();

            Random nuevoPoder = new Random();
            proximoPoder = nuevoPoder.nextInt(3,6);
            
            // No deberia ser necesario hacer un loop porque el estado conoce todo
            // y el agente tambien en el ciclo de percepcion
            // for(Room habitacion : ship.keySet()){
            //     if(!habitacion.getTripulantesEnHabitacion().isEmpty())
            //     habitacionesConTripulantes.put(habitacion,habitacion.getTripulantesEnHabitacion());
            // }
            
        }

        System.out.println(this.habitacionesConTripulantes);

    }

    public void setHabitacionesSiguientes(Collection<Room> collection) {
        this.habitacionesSiguientes = collection;
    }

    public int getEnergia() {
        return energia;
    }

    public Room getHabitacionActual() {
        return habitacionActual;
    }

    public Collection<Room> getHabitacionesSiguientes() {
        return habitacionesSiguientes;
    }

    public void setEnergia(int energia) {
        this.energia = energia;
    }
    
    public void setHabitacionActual(Room habitacionActual) {
        this.habitacionActual = habitacionActual;
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
    public String toString() {
        return "AmongUsPerception [habitacionActual=" + habitacionActual + ", habitacionesSiguientes="
                + habitacionesSiguientes + ", energia=" + energia + ", habitacionesConTripulantes="
                + habitacionesConTripulantes + ", tareaEnHabitacion=" + tareaEnHabitacion + ", nroDePercepcion="
                + nroDePercepcion + ", proximoPoder=" + proximoPoder + "]";
    }

   



    
}
