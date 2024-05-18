package frsf.cidisi.faia.examples.search.Among_Us;
import frsf.cidisi.faia.exceptions.PrologConnectorException;
import frsf.cidisi.faia.simulator.SearchBasedAgentSimulator;

public class AmongUsMain {
    public static void main(String[] args) throws PrologConnectorException {
        
        AmongUsImpostorAgent impostor = new AmongUsImpostorAgent();
        
        System.out.println("this is the agent in main:");
        System.out.println(impostor);
        System.out.println("this is my state in main:");
        System.out.println(impostor.getAgentState());

        AmongUsEnviroment amongUsEnvironment = new AmongUsEnviroment();
    
        SearchBasedAgentSimulator simulator =
                new SearchBasedAgentSimulator(amongUsEnvironment, impostor);
        
        simulator.start();
        
    }
}


//TOMI fijate en la percepcion capaz

// si soyyy