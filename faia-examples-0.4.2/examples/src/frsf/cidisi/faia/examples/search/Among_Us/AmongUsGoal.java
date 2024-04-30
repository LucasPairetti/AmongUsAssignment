package frsf.cidisi.faia.examples.search.Among_Us;


import frsf.cidisi.faia.agent.search.GoalTest;
import frsf.cidisi.faia.state.AgentState;

public class AmongUsGoal extends GoalTest {

    @Override
    public boolean isGoalState(AgentState agentState) {
        if (((AmongUsImpostorState) agentState).getEnergia()>0 && ((AmongUsImpostorState) agentState).getTripulantes_Vivos() ==0){
            return true;
        }else return false;
    }

}