package frsf.cidisi.faia.examples.search.amongus.actions;

import frsf.cidisi.faia.agent.search.SearchAction;
import frsf.cidisi.faia.agent.search.SearchBasedAgentState;
import frsf.cidisi.faia.examples.search.amongus.AmongUsEnvironmentState;
import frsf.cidisi.faia.examples.search.amongus.ImpostorState;
import frsf.cidisi.faia.examples.search.amongus.Task;
import frsf.cidisi.faia.state.AgentState;
import frsf.cidisi.faia.state.EnvironmentState;

public class Realizar_DesconectarServicioElectrico extends SearchAction{

    Task task = Task.DESCONECTAR_SERVICIO_ELECTRICO;
    @Override
    public SearchBasedAgentState execute(SearchBasedAgentState s) {
          ImpostorState impostorState = (ImpostorState) s;

          if(impostorState.getAgentEnergy()>0&& 
          impostorState.getAgentPosition().getTarea()!=null&& //si no tiene tarea la habitacion corta aca y no evalua lo siguiente
          impostorState.getTaskList().contains(task)&& //checkea si esta en la lista
          impostorState.getAgentPosition().getTarea().equals(task)){   //checkea si la habitacion tiene esta misma tarea
            impostorState.setAgentEnergy(impostorState.getAgentEnergy()-1); //reducir enegia
            impostorState.getTaskList().remove(task); //remover task
            impostorState.incrementCost(this.getCost());

            return impostorState;
          }



          return null;



    }

    @Override
    public Double getCost() {
        return 3.;
    }

    @Override
    public EnvironmentState execute(AgentState ast, EnvironmentState est) {
        ImpostorState impostorState = (ImpostorState) ast;
        AmongUsEnvironmentState envState = (AmongUsEnvironmentState) est;

        if(envState.getAgentEnergy()>0&& 
        envState.getAgentPosition().getTarea()!=null&& //si no tiene tarea la habitacion corta aca y no evalua lo siguiente
        envState.getTaskList().contains(task)&& //checkea si esta en la lista
        envState.getAgentPosition().getTarea().equals(task)){   //checkea si la habitacion tiene esta misma tarea

            //actualizo ambiente
            envState.setAgentEnergy(envState.getAgentEnergy()-1); //reducir enegia
            envState.getTaskList().remove(task); //remover task
            envState.moveCrewmates();
            //actualizo agente
          impostorState.setAgentEnergy(impostorState.getAgentEnergy()-1); //reducir enegia
          impostorState.getTaskList().remove(task); //remover task


          return envState;
        }



        return null;
    }

    @Override
    public String toString() {
        return "Desconecté el serivicio electrico!";
    }

}
