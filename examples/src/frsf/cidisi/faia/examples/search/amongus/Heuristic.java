package frsf.cidisi.faia.examples.search.amongus;

import frsf.cidisi.faia.solver.search.IEstimatedCostFunction;
import frsf.cidisi.faia.solver.search.NTree;

public class Heuristic implements IEstimatedCostFunction {

    /**
     * It returns the estimated cost to reach the goal from a NTree node.
     */
    @Override
    public double getEstimatedCost(NTree node) {
        ImpostorState impostorState = (ImpostorState) node.getAgentState();

        return (impostorState.getCrewmatesLeft() +
                impostorState.getTaskList().size());
    }

}