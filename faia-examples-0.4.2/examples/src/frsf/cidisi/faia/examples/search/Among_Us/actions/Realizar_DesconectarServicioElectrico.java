package frsf.cidisi.faia.examples.search.Among_Us.actions;

import frsf.cidisi.faia.agent.search.SearchAction;
import frsf.cidisi.faia.agent.search.SearchBasedAgentState;
import frsf.cidisi.faia.examples.search.Among_Us.AmongUsEnviromentState;
import frsf.cidisi.faia.examples.search.Among_Us.AmongUsImpostorState;
import frsf.cidisi.faia.examples.search.Among_Us.Tarea;
import frsf.cidisi.faia.state.AgentState;
import frsf.cidisi.faia.state.EnvironmentState;

public class Realizar_DesconectarServicioElectrico extends SearchAction {
    private Tarea tarea = Tarea.DESCONECTAR_SERVICIO_ELECTRICO;

    @Override
    public SearchBasedAgentState execute(SearchBasedAgentState s) {
        AmongUsImpostorState impostorState = (AmongUsImpostorState) s;

        // System.out.println(impostorState.getTareas_Pendientes());

        if (impostorState.getHabitacionActual().getTarea()==null)
        return null;
        else if (!impostorState.getHabitacionActual().getTarea().equals(tarea))
            return null;
        else if(!impostorState.getTareas_Pendientes().contains(tarea))
        return null;
        else {

            impostorState.getTareas_Pendientes().remove(Tarea.DESCONECTAR_SERVICIO_ELECTRICO);
            impostorState.setEnergia(impostorState.getEnergia() - 1);
            System.out.println("termine de tarea Servicio electrico");
            System.out.println(impostorState.getTareas_Pendientes());
            return impostorState;
        }

    }

    @Override
    public EnvironmentState execute(AgentState ast, EnvironmentState est) {
        AmongUsEnviromentState environmentState = (AmongUsEnviromentState) est;
        AmongUsImpostorState impostorState = (AmongUsImpostorState) ast;
        if (impostorState.getHabitacionActual().getTarea()==null)
        return null;
        if (!impostorState.getHabitacionActual().getTarea().equals(tarea))
            return null;
            else if(!impostorState.getTareas_Pendientes().contains(tarea))
        return null;
        else {

            environmentState.setAgentEnergy(impostorState.getEnergia() - 1);
            environmentState.getTareas_Pendientes().remove(Tarea.DESCONECTAR_SERVICIO_ELECTRICO);
            return environmentState;
        }

    }

    @Override
    public Double getCost() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getCost'");
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return "desconectar servidor";
    }
}
