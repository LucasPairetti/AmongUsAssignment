package frsf.cidisi.faia.examples.search.Among_Us;

import java.util.ArrayList;

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
        Room agentPosition = state.getAgentPosition();
        
        // Set available rooms to go
        newPerception.setHabitacionesSiguientes(state.getSuccesors(agentPosition));

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
