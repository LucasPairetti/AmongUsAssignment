package frsf.cidisi.faia.examples.search.Among_Us;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;

import frsf.cidisi.faia.exceptions.PrologConnectorException;
import frsf.cidisi.faia.simulator.SearchBasedAgentSimulator;

public class AmongUsMain {
    public static void main(String[] args) throws PrologConnectorException {
       
        AmongUsImpostorAgent impostor = new AmongUsImpostorAgent();

        AmongUsEnviroment amongUsEnvironment = new AmongUsEnviroment();

        
    
        SearchBasedAgentSimulator simulator =
                new SearchBasedAgentSimulator(amongUsEnvironment, impostor);
        
        simulator.start();
        
       
    }
}

