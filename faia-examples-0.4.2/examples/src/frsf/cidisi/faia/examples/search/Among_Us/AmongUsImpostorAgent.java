package frsf.cidisi.faia.examples.search.Among_Us;

import java.util.Collection;
import java.util.HashMap;

import frsf.cidisi.faia.agent.Perception;
import frsf.cidisi.faia.agent.search.SearchBasedAgent;

public class AmongUsImpostorAgent extends SearchBasedAgent {


    public void amongUsImpostorAgent(){

        // Impostor goal
        AmongUsGoal goal = new AmongUsGoal();

        // Get Inicializador
        Inicializador init = Inicializador.getInstance();

        

        // Impostor agent state
        AmongUsImpostorState state = new AmongUsImpostorState(init.getShip(), init.getAgentEnergy(),
                init.getAgentPosition(), init.getShip().get(init.getAgentPosition()), init.getAgentEnergy(), 
                init.getCantTripulantes(), init.getTripulantes_en_habitacion(), init.getTripulantes_Adyacentes() );

    }

    @Override
    public void see(Perception p) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'see'");
    }

    @Override
    public Action selectAction() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'selectAction'");
    }
    
}
