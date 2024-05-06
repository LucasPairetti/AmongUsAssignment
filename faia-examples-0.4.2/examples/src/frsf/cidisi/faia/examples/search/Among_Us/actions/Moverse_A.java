package frsf.cidisi.faia.examples.search.Among_Us.actions;

import frsf.cidisi.faia.examples.search.Among_Us.*;
import frsf.cidisi.faia.examples.search.pacman.*;

import java.util.List;

import frsf.cidisi.faia.agent.search.SearchAction;
import frsf.cidisi.faia.agent.search.SearchBasedAgentState;
import frsf.cidisi.faia.state.AgentState;
import frsf.cidisi.faia.state.EnvironmentState;

public class Moverse_A extends SearchAction {

    private Room habitacionSiguiente;

    // como no puede pasarse argumentos vamos a tener que hacer una accion por cada
    // habitacion al parecer, preguntar esto hoy!

    public Moverse_A(Room habitacionSiguiente) {

        this.habitacionSiguiente = habitacionSiguiente;
    }

    @Override
    public SearchBasedAgentState execute(SearchBasedAgentState s) {

        AmongUsImpostorState impostorState = (AmongUsImpostorState) s;
        Room habitacionActual = impostorState.getHabitacionActual();

        if (!impostorState.getHabitacionesConectadas().contains(habitacionSiguiente))
            return null;
        else {
            impostorState.setEnergia(impostorState.getEnergia() - 1);
            impostorState.setHabitacionActual(habitacionSiguiente);
            impostorState.setHabitacionesConectadas((List<Room>) impostorState.getShip().get(habitacionSiguiente));
            return impostorState;
        }

        
    }

    @Override
    public Double getCost() {
        return (double) 0;
    }

    @Override
    public EnvironmentState execute(AgentState ast, EnvironmentState est) {
        AmongUsEnviromentState enviromentState = (AmongUsEnviromentState) est;
        AmongUsImpostorState impostorState = (AmongUsImpostorState) ast;

        enviromentState.setAgentPosition(habitacionSiguiente);
        enviromentState.setAgentEnergy(impostorState.getEnergia() - 1);

        return enviromentState;
    }

    @Override
    public String toString() {
        String str = "";
        str = str + "agente se mueve hacia " + habitacionSiguiente.getNombre();
        return str;
    }

}
