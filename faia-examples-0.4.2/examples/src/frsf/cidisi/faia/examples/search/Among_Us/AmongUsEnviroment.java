package frsf.cidisi.faia.examples.search.Among_Us;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Random;

import frsf.cidisi.faia.agent.Action;
import frsf.cidisi.faia.agent.Perception;
import frsf.cidisi.faia.environment.Environment;


public class AmongUsEnviroment extends Environment {

    public AmongUsEnviroment(){
        this.environmentState = new AmongUsEnviromentState();
    }

    @Override
    public AmongUsEnviromentState getEnvironmentState() {
        return (AmongUsEnviromentState) super.getEnvironmentState();
    }

    @Override
    public Perception getPercept() {
        // Create a new perception to return based on the environment.
        AmongUsPerception newPerception = new AmongUsPerception();

        // Get agent position
        AmongUsEnviromentState state = this.getEnvironmentState();
        

        /*
        private Room habitacionActual;
        private List<Room> habitacionesSiguientes;
        private int energia;
        private HashMap<Room, Collection<Tripulante>> habitacionesConTripulantes;
        private Boolean tareaEnHabitacion;
        private int nroDePercepcion;
        private int proximoPoder; */

    

        //actualizar percepcion!!!  creo que hay que copiar el  initPerception pero solo empleando el estado
       
        
        
        
        
        

        newPerception.setNroDePercepcion(state.getNroDePercepcion());
        newPerception.setProximoPoder(state.getProximoPoder());
        
        



        // Set agent position
         
        newPerception.setHabitacionActual(state.getAgentPosition());

        //set energy
        newPerception.setEnergia(state.getAgentEnergy());

        // Set available rooms to go
        newPerception.setHabitacionesSiguientes(state.getShip().get(state.getAgentPosition()));

        
        //tarea en habitacion

        if(state.getAgentPosition().getTarea()==null){
            newPerception.setTareaEnHabitacion(false);
        } else
        newPerception.setTareaEnHabitacion(true);


        // tripulantes en habitaciones adyacentes
        HashMap<Room, Collection<Tripulante>> habitacionesConTripulantes = new HashMap<Room, Collection<Tripulante>>();
        
        if(!state.getAgentPosition().getTripulantesEnHabitacion().isEmpty()){
            habitacionesConTripulantes.put(state.getAgentPosition(), state.getAgentPosition().getTripulantesEnHabitacion());
        }
        

        for(Room room: newPerception.getHabitacionesSiguientes()){
            if(!room.getTripulantesEnHabitacion().isEmpty()){
                habitacionesConTripulantes.put(room, room.getTripulantesEnHabitacion());
            }
            newPerception.setHabitacionesConTripulantes(habitacionesConTripulantes);
        }

         /*Habilidad especial, guarda en esta variable todas las habitaciones con al menos 1 tripulante dentro, pero aun no está
            implementada*/

            //habilidad especial
            newPerception.setNroDePercepcion(state.getNroDePercepcion()+1);
            if(newPerception.getNroDePercepcion()==newPerception.getProximoPoder()){
             
            
            for(Room habitacion :state.getShip().keySet()){
                if(!habitacion.getTripulantesEnHabitacion().isEmpty())
                habitacionesConTripulantes.put(habitacion,habitacion.getTripulantesEnHabitacion());
            }
            Random nuevoPoder = new Random();
            newPerception.setProximoPoder(nuevoPoder.nextInt(3,6)); 
        }
        
    
        
        
        // Return perception to Simulator
        return newPerception;
    }

    @Override
    public boolean agentFailed(Action actionReturned) {

        AmongUsEnviromentState state =
                this.getEnvironmentState();

        int agentEnergy = state.getAgentEnergy();

        // return true or false depending on if the agent run out of energy.
        // GET SURE THE AGENT'S ENERGY IS UPDATED WITH ACTIONS!!!
        return agentEnergy <= 0 ? true : false;

    }

    @Override
    public String toString() {
        return environmentState.toString();
    }

    public ArrayList<Room> getSuccesors(Room nodo) {
        return this.getEnvironmentState().getSuccesors(nodo);
    }

}
