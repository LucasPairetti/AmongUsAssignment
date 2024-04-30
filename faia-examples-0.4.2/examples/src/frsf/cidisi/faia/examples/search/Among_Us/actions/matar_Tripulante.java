package frsf.cidisi.faia.examples.search.Among_Us.actions;


import frsf.cidisi.faia.examples.search.Among_Us.AmongUsEnviromentState;
import frsf.cidisi.faia.examples.search.Among_Us.AmongUsImpostorState;
import frsf.cidisi.faia.examples.search.Among_Us.Tripulante;
import frsf.cidisi.faia.examples.search.pacman.*;
import frsf.cidisi.faia.agent.search.SearchAction;
import frsf.cidisi.faia.agent.search.SearchBasedAgentState;
import frsf.cidisi.faia.state.AgentState;
import frsf.cidisi.faia.state.EnvironmentState;

public class matar_Tripulante extends SearchAction {

    @Override
    public SearchBasedAgentState execute(SearchBasedAgentState s) {
       AmongUsImpostorState impostorState = (AmongUsImpostorState) s;

       if(impostorState.getTripulantes_en_habitacion().isEmpty())
    return null; //hay que agregar que pasa
    else{
      Tripulante victima= impostorState.getTripulantes_en_habitacion().get(0);
      impostorState.getTripulantes_en_habitacion().remove(victima);
      victima.setVivo(false);
    impostorState.setTripulantes_Vivos(impostorState.getTripulantes_Vivos()-1);
    impostorState.setEnergia(impostorState.getEnergia()-1);
        return impostorState;
      
    }

    }
    @Override
    public Double getCost() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getCost'");
    }

    @Override
    public EnvironmentState execute(AgentState ast, EnvironmentState est) {
       AmongUsEnviromentState enviromentState = (AmongUsEnviromentState) est;
       AmongUsImpostorState impostorState = (AmongUsImpostorState) ast;
       enviromentState.setAgentEnergy(impostorState.getEnergia()-1);
       return enviromentState;
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'toString'");
    }

}
