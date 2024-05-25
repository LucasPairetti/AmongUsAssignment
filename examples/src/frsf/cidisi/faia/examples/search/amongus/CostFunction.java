package frsf.cidisi.faia.examples.search.amongus;

import frsf.cidisi.faia.solver.search.IStepCostFunction;
import frsf.cidisi.faia.solver.search.NTree;
import frsf.cidisi.faia.state.AgentState;

/**
 * This class can be used in any search strategy like
 * Uniform Cost.
 */
public class CostFunction implements IStepCostFunction {

    public double calculateCost(AgentState agentState) {
        return ((ImpostorState) agentState).getCost();
    }

    /**
     * This method calculates the cost of the given NTree node.
     */
    @Override
    public double calculateCost(NTree node) {
        ImpostorState state = ((ImpostorState) node.getAgentState());
        return state.getCost();
    }
}
