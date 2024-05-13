package frsf.cidisi.faia.examples.search.Among_Us.actions;

import java.util.Collection;
import java.util.List;

import frsf.cidisi.faia.agent.search.SearchAction;
import frsf.cidisi.faia.agent.search.SearchBasedAgentState;
import frsf.cidisi.faia.examples.search.Among_Us.AmongUsEnviromentState;
import frsf.cidisi.faia.examples.search.Among_Us.AmongUsImpostorState;
import frsf.cidisi.faia.examples.search.Among_Us.Room;
import frsf.cidisi.faia.state.AgentState;
import frsf.cidisi.faia.state.EnvironmentState;

public class Moverse_A_17 extends SearchAction{

    @Override
    public SearchBasedAgentState execute(SearchBasedAgentState s) {
        
        AmongUsImpostorState impostorState = (AmongUsImpostorState) s;
        Collection<Room> habitacionesSiguientes = impostorState.getShip().keySet();
        Room habitacionSiguiente = new Room(0, null);
        for(Room habitacion : habitacionesSiguientes){
            if (habitacion.getId()==17) {
                habitacionSiguiente = habitacion;
            }
        }
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
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getCost'");
    }

    @Override
    public EnvironmentState execute(AgentState ast, EnvironmentState est) {
        AmongUsEnviromentState enviromentState = (AmongUsEnviromentState) est;
        AmongUsImpostorState impostorState = (AmongUsImpostorState) ast;

        Collection<Room> habitacionesSiguientes = impostorState.getShip().keySet();
        Room habitacionSiguiente = new Room(0, null);
        for(Room habitacion : habitacionesSiguientes){
            if (habitacion.getId()==17) {
                habitacionSiguiente = habitacion;
            }
        }

        enviromentState.setAgentPosition(habitacionSiguiente);
        enviromentState.setAgentEnergy(impostorState.getEnergia() - 1);

        return enviromentState;
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'toString'");
    }
    
}
