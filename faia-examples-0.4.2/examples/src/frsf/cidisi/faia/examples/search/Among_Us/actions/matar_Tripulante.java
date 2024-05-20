package frsf.cidisi.faia.examples.search.Among_Us.actions;


import frsf.cidisi.faia.examples.search.Among_Us.AmongUsEnviromentState;
import frsf.cidisi.faia.examples.search.Among_Us.AmongUsImpostorState;
import frsf.cidisi.faia.examples.search.Among_Us.Tripulante;
import frsf.cidisi.faia.agent.search.SearchAction;
import frsf.cidisi.faia.agent.search.SearchBasedAgentState;
import frsf.cidisi.faia.state.AgentState;
import frsf.cidisi.faia.state.EnvironmentState;

public class matar_Tripulante extends SearchAction {
    
    int i=0;
    
    @Override
    public SearchBasedAgentState execute(SearchBasedAgentState s) {
        AmongUsImpostorState impostorState = (AmongUsImpostorState) s;
      i++;
      System.out.println("execute kill agente lista: "+ i  +" "+impostorState);
      
      

        if(!impostorState.getHabitacionesConTripulantes().containsKey(impostorState.getHabitacionActual())){
            System.out.println("Return 1 kill");
            return null;
        }
         
        else{
            if(!impostorState.getHabitacionActual().getTripulantesEnHabitacion().isEmpty()){
                
                Tripulante victima= impostorState.getHabitacionActual().getTripulantesEnHabitacion().get(0);
                victima.setVivo(false);
                impostorState.setTripulantes_Vivos(impostorState.getTripulantes_Vivos()-1);
                impostorState.setEnergia(impostorState.getEnergia()-1);
                
                impostorState.getHabitacionActual().getTripulantesEnHabitacion().remove(victima);
                if(impostorState.getHabitacionActual().getTripulantesEnHabitacion().isEmpty())
                impostorState.getHabitacionesConTripulantes().remove(impostorState.getHabitacionActual());

                System.out.println("Return 2 kill");
                return impostorState; 
            } else{
                System.out.println("Return 3 kill");
                return null;
            } 
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
       
        System.out.println("IM EXECUTED");
        System.out.println("execute kill env lista: "+ i  +" "+enviromentState.getHabitacionesConTripulantes());
        System.out.println("execute kill env tripvivos: "+ i +" "+enviromentState.getTripulantes_Vivos());
        System.out.println(enviromentState.getAgentPosition().getNombre());
        if(!enviromentState.getHabitacionesConTripulantes().containsKey(enviromentState.getAgentPosition())){
            return null;
        } 

        else{
            
        Tripulante victima= enviromentState.getAgentPosition().getTripulantesEnHabitacion().get(0);
        victima.setVivo(false);

        //actualizo ambiente
        enviromentState.getHabitacionesConTripulantes().remove(enviromentState.getAgentPosition());
        enviromentState.getAgentPosition().getTripulantesEnHabitacion().remove(victima);
        enviromentState.setAgentEnergy(impostorState.getEnergia()-1);
                impostorState.setTripulantes_Vivos(impostorState.getTripulantes_Vivos()-1);
                impostorState.setEnergia(impostorState.getEnergia()-1);
                impostorState.getHabitacionActual().getTripulantesEnHabitacion().remove(victima);
                if(impostorState.getHabitacionActual().getTripulantesEnHabitacion().isEmpty())
                impostorState.getHabitacionesConTripulantes().remove(impostorState.getHabitacionActual());
       return enviromentState;
    }
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return "matar tripulante";
    }

}
