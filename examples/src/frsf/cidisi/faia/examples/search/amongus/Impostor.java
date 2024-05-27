package frsf.cidisi.faia.examples.search.amongus;

import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

import frsf.cidisi.faia.agent.Action;
import frsf.cidisi.faia.agent.Perception;
import frsf.cidisi.faia.agent.search.Problem;
import frsf.cidisi.faia.agent.search.SearchAction;
import frsf.cidisi.faia.agent.search.SearchBasedAgent;
import frsf.cidisi.faia.examples.search.amongus.actions.matar_Tripulante;
import frsf.cidisi.faia.solver.search.AStarSearch;
import frsf.cidisi.faia.solver.search.BreathFirstSearch;
import frsf.cidisi.faia.solver.search.DepthFirstSearch;
import frsf.cidisi.faia.solver.search.IEstimatedCostFunction;
import frsf.cidisi.faia.solver.search.IStepCostFunction;
import frsf.cidisi.faia.solver.search.Search;
import frsf.cidisi.faia.examples.search.amongus.actions.Moverse_A_1;
import frsf.cidisi.faia.examples.search.amongus.actions.Moverse_A_10;
import frsf.cidisi.faia.examples.search.amongus.actions.Moverse_A_11;
import frsf.cidisi.faia.examples.search.amongus.actions.Moverse_A_12;
import frsf.cidisi.faia.examples.search.amongus.actions.Moverse_A_13;
import frsf.cidisi.faia.examples.search.amongus.actions.Moverse_A_14;
import frsf.cidisi.faia.examples.search.amongus.actions.Moverse_A_15;
import frsf.cidisi.faia.examples.search.amongus.actions.Moverse_A_16;
import frsf.cidisi.faia.examples.search.amongus.actions.Moverse_A_17;
import frsf.cidisi.faia.examples.search.amongus.actions.Moverse_A_18;
import frsf.cidisi.faia.examples.search.amongus.actions.Moverse_A_19;
import frsf.cidisi.faia.examples.search.amongus.actions.Moverse_A_2;
import frsf.cidisi.faia.examples.search.amongus.actions.Moverse_A_20;
import frsf.cidisi.faia.examples.search.amongus.actions.Moverse_A_3;
import frsf.cidisi.faia.examples.search.amongus.actions.Moverse_A_4;
import frsf.cidisi.faia.examples.search.amongus.actions.Moverse_A_5;
import frsf.cidisi.faia.examples.search.amongus.actions.Moverse_A_6;
import frsf.cidisi.faia.examples.search.amongus.actions.Moverse_A_7;
import frsf.cidisi.faia.examples.search.amongus.actions.Moverse_A_8;
import frsf.cidisi.faia.examples.search.amongus.actions.Moverse_A_9;
import frsf.cidisi.faia.examples.search.amongus.actions.Realizar_DesconectarServicioElectrico;
import frsf.cidisi.faia.examples.search.amongus.actions.Realizar_DestruirReactor;
import frsf.cidisi.faia.examples.search.amongus.actions.Realizar_DestruirSalaDeArmas;


public class Impostor extends SearchBasedAgent {

    public Impostor() {
        
        ImpostorGoal goal = new ImpostorGoal();
        
        ImpostorState impostorState = new ImpostorState();
        this.setAgentState(impostorState);

        // Create the operators
        Vector<SearchAction> operators = new Vector<SearchAction>();
        operators.addElement(new matar_Tripulante());
        operators.addElement(new Moverse_A_14());
        operators.addElement(new Moverse_A_1());
        operators.addElement(new Moverse_A_4());
        operators.addElement(new Moverse_A_5());
        operators.addElement(new Moverse_A_9());
        operators.addElement(new Moverse_A_2());
        operators.addElement(new Moverse_A_11());
        operators.addElement(new Moverse_A_13());
        operators.addElement(new Moverse_A_8());
        operators.addElement(new Moverse_A_6());
        operators.addElement(new Moverse_A_10());
        operators.addElement(new Moverse_A_3());
        operators.addElement(new Moverse_A_7());
        operators.addElement(new Moverse_A_12());
        operators.addElement(new Moverse_A_15());
        operators.addElement(new Moverse_A_16());
        operators.addElement(new Moverse_A_17());
        operators.addElement(new Moverse_A_18());
        operators.addElement(new Moverse_A_19());
        operators.addElement(new Moverse_A_20());
        operators.addElement(new Realizar_DesconectarServicioElectrico());
        operators.addElement(new Realizar_DestruirReactor());
        operators.addElement(new Realizar_DestruirSalaDeArmas());

        // Create the Problem which the Pacman will resolve
        Problem problem = new Problem(goal, impostorState, operators);
        this.setProblem(problem);

    }

    @Override
    public void see(Perception p) {
        this.getAgentState().updateState(p);
    }

    // @Override
    // public ImpostorState getAgentState() {
    //     return (ImpostorState) this.state;
    // }

    @Override
    public Action selectAction() { //copypaste
        //   // Create the search strategy
        BreathFirstSearch strategy = new BreathFirstSearch();

        // IStepCostFunction cost = new CostFunction();
        // IEstimatedCostFunction heuristic = new Heuristic();
        // AStarSearch strategy = new AStarSearch(cost, heuristic);

        // Create a Search object with the strategy
        Search searchSolver = new Search(strategy);
        
        /* Generate an XML file with the search tree. It can also be generated
         * in other formats like PDF with PDF_TREE */
        searchSolver.setVisibleTree(Search.PDF_TREE);

        // Set the Search searchSolver.
        this.setSolver(searchSolver);

        // Ask the solver for the best action
        Action selectedAction = null;
        try {
            selectedAction =
                    this.getSolver().solve(new Object[]{this.getProblem()});
        } catch (Exception ex) {
            Logger.getLogger(Impostor.class.getName()).log(Level.SEVERE, null, ex);
        }

        // Return the selected action
        return selectedAction;
    }

}
