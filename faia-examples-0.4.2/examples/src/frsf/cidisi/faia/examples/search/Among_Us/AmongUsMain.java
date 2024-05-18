package frsf.cidisi.faia.examples.search.Among_Us;
import frsf.cidisi.faia.exceptions.PrologConnectorException;
import frsf.cidisi.faia.simulator.SearchBasedAgentSimulator;

public class AmongUsMain {
    public static void main(String[] args) throws PrologConnectorException {
        
        AmongUsImpostorAgent impostor = new AmongUsImpostorAgent();
            
        AmongUsEnviroment amongUsEnvironment = new AmongUsEnviroment();
       /* 
        System.out.println("this is the impostor:");
        // No anda get agent state
        System.out.println(impostor.getAgentState());
        System.out.println("llegue");
        System.out.println("this is the environment:");
        System.out.println(amongUsEnvironment);

        SearchBasedAgentSimulator simulator =
            new SearchBasedAgentSimulator(amongUsEnvironment, impostor);
            
        simulator.start();
        */ 

        Inicializador init = Inicializador.getInstance();
        System.out.println(init.getStateTest());
    }
}


//Intento hacer una kill ahi