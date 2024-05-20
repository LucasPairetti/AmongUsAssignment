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

    @SuppressWarnings("unchecked")
    @Override
    public Perception getPercept() {

        // Create a new perception to return based on the environment.
        AmongUsPerception newPerception = new AmongUsPerception();

        // Get agent position
        AmongUsEnviromentState state = this.getEnvironmentState();
        
        state.setNroDePercepcion(state.getNroDePercepcion()+1);
        newPerception.setNroDePercepcion(state.getNroDePercepcion());
        newPerception.setProximoPoder(state.getProximoPoder());
 
        // Set agent position
        newPerception.setHabitacionActual(state.getAgentPosition());

        //set energy
        newPerception.setEnergia(state.getAgentEnergy());

        // Set available rooms to go
        newPerception.setHabitacionesSiguientes(state.getHabitacionesConectadas());
        
        //tarea en habitacion
        if(state.getAgentPosition().getTarea()==null){
            newPerception.setTareaEnHabitacion(false);
        } else
        newPerception.setTareaEnHabitacion(true);

        // Tripulantes en habitaciones conectadas!
        if(newPerception.getNroDePercepcion()>1){// Mapa general para updatear
            
            HashMap<Room,Collection<Tripulante>> habitacionesConTripulantes = new HashMap<Room,Collection<Tripulante>>();

            for(Room room : state.getHabitacionesConectadas()) {
                if(!room.getTripulantesEnHabitacion().isEmpty() ) habitacionesConTripulantes.put(room, room.getTripulantesEnHabitacion());
            }

            if(!state.getAgentPosition().getTripulantesEnHabitacion().isEmpty()){
                System.out.println("IM INSIDE HELP ME");
                habitacionesConTripulantes.put(state.getAgentPosition(),state.getAgentPosition().getTripulantesEnHabitacion());
            }

            newPerception.setHabitacionesConTripulantes(habitacionesConTripulantes);

        } else {newPerception.setHabitacionesConTripulantes((HashMap<Room,Collection<Tripulante>>) state.getHabitacionesConTripulantes().clone());};

        /*Habilidad especial, guarda en esta variable todas las habitaciones con al menos 1 tripulante dentro, pero aun no está
                implementada*/

        //habilidad especial
        if(newPerception.getNroDePercepcion()==newPerception.getProximoPoder()){
            
            newPerception.setHabitacionesConTripulantes((HashMap<Room,Collection<Tripulante>>) state.getHabitacionesConTripulantes().clone());

            Random nuevoPoder = new Random();
            newPerception.setProximoPoder(nuevoPoder.nextInt(3,6));
            
        }

        // System.out.println("This is the habitaciones con tripulantes in perc");
        // System.out.println(newPerception.getHabitacionesConTripulantes());
        
        // Return perception to Simulator
        return newPerception;
        
    }

    @Override
    public boolean agentFailed(Action actionReturned) {
        
        AmongUsEnviromentState state = this.getEnvironmentState();
                
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
