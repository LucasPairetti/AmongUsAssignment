package frsf.cidisi.faia.examples.search.Among_Us;

import java.util.Random;

import frsf.cidisi.faia.examples.search.pacman.PacmanAgent;
import frsf.cidisi.faia.examples.search.pacman.PacmanEnvironment;
import frsf.cidisi.faia.examples.search.robot.RobotAgent;
import frsf.cidisi.faia.examples.search.robot.RobotEnvironment;
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
