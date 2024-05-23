package frsf.cidisi.faia.examples.search.amongus;

import frsf.cidisi.faia.agent.search.GoalTest;
import frsf.cidisi.faia.state.AgentState;

public class ImpostorGoal extends GoalTest {

    @Override
    public boolean isGoalState(AgentState agentState) {
        ImpostorState impostor = (ImpostorState) agentState;
        if(impostor.getAgentEnergy()>=0 &&  //energia mayor o igual a cero (permitimos terminar con 0 de energia)
        impostor.getCrewmatesLeft()==0 &&//todos los tripulantes han sido asesinados
        impostor.getTaskList().isEmpty())  // no hay mas tareas pendientes
        return true;
        else
        return false;
    }

}
