package frsf.cidisi.faia.examples.search.Among_Us;

import frsf.cidisi.faia.examples.search.robot.RobotAgent;
import frsf.cidisi.faia.examples.search.robot.RobotEnvironment;
import frsf.cidisi.faia.exceptions.PrologConnectorException;
import frsf.cidisi.faia.simulator.SearchBasedAgentSimulator;

public class AmongUsMain {
public static void main(String[] args) throws PrologConnectorException {
    AmongUsEnviromentState enviromentState =new AmongUsEnviromentState();
    enviromentState.initState();
    System.out.println(enviromentState.toString());
    }
}
