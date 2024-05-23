package frsf.cidisi.faia.examples.search.amongus;

import frsf.cidisi.faia.simulator.SearchBasedAgentSimulator;
import frsf.cidisi.faia.exceptions.PrologConnectorException;

public class AmongUsMain {
    
    public static void main(String[] args) throws PrologConnectorException {
       
        Impostor impostor = new Impostor();
        
        AmongUsEnvironment amongUsEnvironment = new AmongUsEnvironment();
        
        SearchBasedAgentSimulator simulator =
                new SearchBasedAgentSimulator(amongUsEnvironment, impostor);
        
        simulator.start(); 
        
       
       
    }
}
