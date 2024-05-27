package frsf.cidisi.faia.examples.search.amongus;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import frsf.cidisi.faia.agent.Perception;
import frsf.cidisi.faia.environment.Environment;

public class AmongUsEnvironment extends Environment {

    public AmongUsEnvironment() {
        // Create the environment state
        this.environmentState = new AmongUsEnvironmentState();
    }

    public AmongUsEnvironmentState getEnvironmentState() {
        return (AmongUsEnvironmentState) super.getEnvironmentState();
    }

    @SuppressWarnings("unchecked")
    @Override
    public Perception getPercept() {
        AmongUsEnvironmentState state = this.getEnvironmentState();
        AmongUsPerception newPerception = new AmongUsPerception();
        ArrayList<Room>roomsWithCrewMates = new ArrayList<Room>();

        //TODO: Solucionar primera percepcion
        if(state.getNumberPercepcion()==state.getNextPower()){ //Actualizacion de superpoder
            newPerception.setSuperpower(true);
            roomsWithCrewMates= state.getRoomsWithCrewmate();
            state.setNumberPercepcion(1);

            Random r = new Random();
            state.setNextPower(r.nextInt(4,7)); //reseteo superpoder
         
        }else{//actualizacion normal
            newPerception.setSuperpower(false);
            roomsWithCrewMates = (ArrayList<Room>) state.getRoomsWithCrewmateAdyacente().clone();
            if(state.getAgentPosition().crewmatesAliveInside()) roomsWithCrewMates.add(state.getAgentPosition());
        }
        
        if(state.getNumberPercepcion()==0) roomsWithCrewMates = state.getRoomsWithCrewmate();
        
        newPerception.setRoomsWithCrewMates(roomsWithCrewMates);

        state.setNumberPercepcion(state.getNumberPercepcion()+1);

        return newPerception;

    }

}
