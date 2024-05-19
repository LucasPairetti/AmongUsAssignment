package frsf.cidisi.faia.examples.search.Among_Us.actions;


import frsf.cidisi.faia.examples.search.Among_Us.AmongUsEnviromentState;
import frsf.cidisi.faia.examples.search.Among_Us.AmongUsImpostorState;
import frsf.cidisi.faia.examples.search.Among_Us.Tripulante;
import frsf.cidisi.faia.agent.search.SearchAction;
import frsf.cidisi.faia.agent.search.SearchBasedAgentState;
import frsf.cidisi.faia.state.AgentState;
import frsf.cidisi.faia.state.EnvironmentState;

public class matar_Tripulante extends SearchAction {
    
    @Override
    public SearchBasedAgentState execute(SearchBasedAgentState s) {
        AmongUsImpostorState impostorState = (AmongUsImpostorState) s;

        // Siempre es 0
        // System.out.println("This are the tripulantes:");
        // System.out.println(impostorState.getHabitacionActual().getTripulantesEnHabitacion().size());
        // System.out.println((impostorState.getHabitacionActual()).getNombre());

        if(!impostorState.getHabitacionesConTripulantes()
        .containsKey(impostorState.getHabitacionActual())) return null; //hay que agregar que pasa
        else{   
            System.out.println("I AM ABOUT TO MURDER! MUAHAHA");
            Tripulante victima= impostorState.getHabitacionActual().getTripulantesEnHabitacion().get(0);
            victima.setVivo(false);
            impostorState.setTripulantes_Vivos(impostorState.getTripulantes_Vivos()-1);
            impostorState.setEnergia(impostorState.getEnergia()-1);
            impostorState.getHabitacionesConTripulantes().remove(impostorState.getHabitacionActual());
            impostorState.getHabitacionActual().getTripulantesEnHabitacion().remove(victima);

            
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
       
        if(!impostorState.getHabitacionesConTripulantes()
        .containsKey(impostorState.getHabitacionActual())) return null;
        else{

        Tripulante victima= enviromentState.getAgentPosition().getTripulantesEnHabitacion().get(0);
        victima.setVivo(false);
        enviromentState.getHabitacionesConTripulantes().remove(enviromentState.getAgentPosition());
        enviromentState.getAgentPosition().getTripulantesEnHabitacion().remove(victima);
        enviromentState.setAgentEnergy(impostorState.getEnergia()-1);
        enviromentState.setTripulantes_Vivos(impostorState.getTripulantes_Vivos()-1);
        
       return enviromentState;
    }
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return "matar tripulante";
    }

}
