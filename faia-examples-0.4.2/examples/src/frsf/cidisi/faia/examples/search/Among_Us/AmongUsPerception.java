package frsf.cidisi.faia.examples.search.Among_Us;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import frsf.cidisi.faia.agent.Agent;
import frsf.cidisi.faia.agent.Perception;
import frsf.cidisi.faia.environment.Environment;


public class AmongUsPerception extends Perception{

private Room habitacionActual;
private List<Room> habitacionesSiguientes;
private int energia;

public AmongUsPerception(){
    habitacionesSiguientes = new ArrayList<Room>();
    Random rand = new Random();
    energia = rand.nextInt(150 - 30 + 1) + 30;
}

    @Override
    public void initPerception(Agent agent, Environment environment) {
        
        AmongUsEnviroment enviroment = (AmongUsEnviroment) environment;
        AmongUsImpostorAgent impostor = (AmongUsImpostorAgent)agent;

        
    }

}
