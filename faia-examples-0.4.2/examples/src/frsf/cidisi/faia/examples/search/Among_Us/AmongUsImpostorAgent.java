package frsf.cidisi.faia.examples.search.Among_Us;

import java.util.Collection;
import java.util.HashMap;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

import frsf.cidisi.faia.agent.Action;
import frsf.cidisi.faia.agent.Perception;
import frsf.cidisi.faia.agent.search.Problem;
import frsf.cidisi.faia.agent.search.SearchAction;
import frsf.cidisi.faia.agent.search.SearchBasedAgent;
import frsf.cidisi.faia.examples.search.Among_Us.AmongUsImpostorAgent;
import frsf.cidisi.faia.examples.search.Among_Us.actions.*;
import frsf.cidisi.faia.solver.search.BreathFirstSearch;
import frsf.cidisi.faia.solver.search.DepthFirstSearch;
import frsf.cidisi.faia.solver.search.Search;

public class AmongUsImpostorAgent extends SearchBasedAgent {

    private AmongUsGoal goal;


    public AmongUsImpostorAgent(){

        // Impostor goal
        this.goal = new AmongUsGoal();

        // Impostor agent state
        AmongUsImpostorState agentState = new AmongUsImpostorState();
        this.setAgentState(agentState);

        // Create the operators
        Vector<SearchAction> operators = new Vector<SearchAction>();
        operators.addElement(new matar_Tripulante());
        operators.addElement(new Moverse_A_1());
        operators.addElement(new Moverse_A_2());
        operators.addElement(new Moverse_A_3());
        operators.addElement(new Moverse_A_4());
        operators.addElement(new Moverse_A_5());
        operators.addElement(new Moverse_A_6());
        operators.addElement(new Moverse_A_7());
        operators.addElement(new Moverse_A_8());
        operators.addElement(new Moverse_A_9());
        operators.addElement(new Moverse_A_10());
        operators.addElement(new Moverse_A_11());
        operators.addElement(new Moverse_A_12());
        operators.addElement(new Moverse_A_13());
        operators.addElement(new Moverse_A_14());
        operators.addElement(new Moverse_A_15());
        operators.addElement(new Moverse_A_16());
        operators.addElement(new Moverse_A_17());
        operators.addElement(new Moverse_A_18());
        operators.addElement(new Moverse_A_19());
        operators.addElement(new Moverse_A_20());
        //operators.addElement(new Moverse_A(null));
        operators.addElement(new Realizar_DesconectarServicioElectrico());
        operators.addElement(new Realizar_DestruirReactor());
        operators.addElement(new Realizar_DestruirSalaDeArmas());
        //operators.addElement(new Realizar_Tarea(null));
        

        // Create the Problem which the Impostor will resolve
        Problem problem = new Problem(goal, (AmongUsImpostorState) this.getAgentState(), operators);
        this.setProblem(problem);

    }


    /**
     * This method is executed by the simulator to ask the agent for an action.
     */
    @Override
    public Action selectAction() {

        // Create the search strategy
        BreathFirstSearch strategy = new BreathFirstSearch();

        // Create a Search object with the strategy
        Search searchSolver = new Search(strategy);

        /* Generate an XML file with the search tree. It can also be generated
         * in other formats like PDF with PDF_TREE */
        searchSolver.setVisibleTree(Search.XML_TREE);

        // Set the Search searchSolver.
        this.setSolver(searchSolver);

        // Ask the solver for the best action
        Action selectedAction = null;
        try {
            System.out.println("Im the solver" + this.getSolver());
            System.out.println("Im the problem" + this.getProblem());
            // Printea ambos. O sea, el error debe estar en el problema
            selectedAction =
                    this.getSolver().solve(new Object[]{this.getProblem()});
        } catch (Exception ex) {
            Logger.getLogger(AmongUsImpostorAgent.class.getName()).log(Level.SEVERE, null, ex);
        }

        // Return the selected action
        return selectedAction;
    }

    /** 
     * This method is executed by the simulator to give the agent a perception.
     * Then it updates its state.
     * @param p
     */
    @Override
    public void see(Perception p) {
        this.getAgentState().updateState(p);
    }

    @Override
    public String toString() {
        return "AmongUsImpostorAgent [goal=" + goal + ", state=" + state + ", solver=" + solver + "]";
    }
    
}
