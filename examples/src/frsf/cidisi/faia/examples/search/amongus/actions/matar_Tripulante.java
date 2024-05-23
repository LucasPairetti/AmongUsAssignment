package frsf.cidisi.faia.examples.search.amongus.actions;

import frsf.cidisi.faia.agent.search.SearchAction;
import frsf.cidisi.faia.agent.search.SearchBasedAgentState;
import frsf.cidisi.faia.examples.search.amongus.AmongUsEnvironmentState;
import frsf.cidisi.faia.examples.search.amongus.ImpostorState;
import frsf.cidisi.faia.state.AgentState;
import frsf.cidisi.faia.state.EnvironmentState;

public class matar_Tripulante extends SearchAction{

    @Override
    public SearchBasedAgentState execute(SearchBasedAgentState s) {
       ImpostorState impostorState = (ImpostorState) s;
        
       /* el metodo viejo es asi, pero no se ahora con el tema para evitar el tema de los ids hasheados 
        *if(impostorState.getAgentEnergy()>0 && impostorState.getRoomsWithCrewmate().contains(impostorState.getAgentPosition())) 

        */
       if(impostorState.getAgentEnergy()>0 && impostorState.isInRoomWithCrewmates()){
        impostorState.getAgentPosition().RemoveCrewmate(); //mato al primero de la lista 
        impostorState.setCrewmatesLeft(impostorState.getCrewmatesLeft()-1); //reduzco uno de la lista  
        impostorState.setAgentEnergy(impostorState.getAgentEnergy()-1); //reduzco energia


        return impostorState;

       }else

       return null;
    }

    @Override
    public Double getCost() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getCost'");
    }

    @Override
    public EnvironmentState execute(AgentState ast, EnvironmentState est) {
        AmongUsEnvironmentState envState= (AmongUsEnvironmentState) est;
        ImpostorState impostorState = (ImpostorState) ast;

        // System.out.println("inside of matar_tripulante");
        // System.out.println(impostorState);
        // returns 0 on habitaciones con tripulantes

        if(envState.getAgentEnergy()>0&&envState.isInRoomWithCrewmates()){
        
        System.out.println("test");
        
        //actualizo el ambiente
        envState.getAgentPosition().RemoveCrewmate(); //mato al primero de la lista 
        envState.setCrewmatesLeft(envState.getCrewmatesLeft()-1); //reduzco uno de la lista  
        envState.setAgentEnergy(envState.getAgentEnergy()-1); //reduzco energia

        // actualizo al agente
        impostorState.getAgentPosition().RemoveCrewmate(); //mato al primero de la lista 
        impostorState.setCrewmatesLeft(impostorState.getCrewmatesLeft()-1); //reduzco uno de la lista  
        impostorState.setAgentEnergy(impostorState.getAgentEnergy()-1); //reduzco energia

            return envState;
        }else
        return null;

    
    }

    @Override
    public String toString() {
       
       return "He matado a un tripulante!!";
    }

}
