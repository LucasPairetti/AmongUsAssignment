package frsf.cidisi.faia.examples.search.amongus.actions;

import frsf.cidisi.faia.agent.search.SearchAction;
import frsf.cidisi.faia.agent.search.SearchBasedAgentState;
import frsf.cidisi.faia.examples.search.amongus.AmongUsEnvironmentState;
import frsf.cidisi.faia.examples.search.amongus.ImpostorState;
import frsf.cidisi.faia.state.AgentState;
import frsf.cidisi.faia.state.EnvironmentState;

public class Moverse_A_11 extends SearchAction{

 
    int idRoom=11;
    String roomName= "Reactor";
    @Override
    public SearchBasedAgentState execute(SearchBasedAgentState s) {
        ImpostorState impostorState = (ImpostorState) s;

        if(impostorState.getAgentEnergy()>0 && impostorState.isConnected(idRoom)){

            impostorState.setAgentEnergy(impostorState.getAgentEnergy()-1);
            impostorState.setAgentPosition(impostorState.getRoomByID(idRoom));


            return impostorState;
        }

        return null;


    }

    @Override
    public Double getCost() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getCost'");
    }

    @Override
    public EnvironmentState execute(AgentState ast, EnvironmentState est) {
        ImpostorState impostorState = (ImpostorState) ast;
    AmongUsEnvironmentState envState = (AmongUsEnvironmentState) est;
        if(envState.getAgentEnergy()>0 && envState.isConnected(idRoom)){
            //act ambiente
            envState.setAgentEnergy(envState.getAgentEnergy()-1);
            envState.setAgentPosition(envState.getRoomByID(idRoom));
            //act agente
            impostorState.setAgentEnergy(impostorState.getAgentEnergy()-1);
            impostorState.setAgentPosition(impostorState.getRoomByID(idRoom));

            return envState;
        }

        return null;

    }

    @Override
    public String toString() {
       return "me moví a "+roomName;
    }

}
