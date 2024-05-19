        package frsf.cidisi.faia.examples.search.Among_Us.actions;

import frsf.cidisi.faia.examples.search.Among_Us.*;
import frsf.cidisi.faia.examples.search.pacman.*;
import frsf.cidisi.faia.agent.search.SearchAction;
import frsf.cidisi.faia.agent.search.SearchBasedAgentState;
import frsf.cidisi.faia.state.AgentState;
import frsf.cidisi.faia.state.EnvironmentState;


/*deprecated */
public class Realizar_Tarea extends SearchAction{

    private Tarea tarea;

    
    public Realizar_Tarea(Tarea tarea) {
        this.tarea = tarea;
    }

    @Override
    public SearchBasedAgentState execute(SearchBasedAgentState s) {
        AmongUsImpostorState impostorState = (AmongUsImpostorState) s;
        if(!impostorState.getHabitacionActual().getTarea().equals(tarea))
        return null;
        else{
           
            impostorState.getTareas_Pendientes().remove(tarea);
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
       AmongUsEnviromentState environmentState = (AmongUsEnviromentState) est;
       AmongUsImpostorState impostorState = (AmongUsImpostorState) ast;

       if(!impostorState.getHabitacionActual().getTarea().equals(tarea))
       return null;
       else{
          
            environmentState.setAgentEnergy(impostorState.getEnergia()-1);
          
           return environmentState;
       }

       
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return "realizar tarea";
    }
 //idem con el movimiento, vamos a tener que hacer una accion de sabotaje por cada una porque no se pueden pasar argumentos
}
