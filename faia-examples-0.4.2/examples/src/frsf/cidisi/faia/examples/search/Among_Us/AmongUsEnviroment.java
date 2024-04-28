package frsf.cidisi.faia.examples.search.Among_Us;

import frsf.cidisi.faia.agent.Action;
import frsf.cidisi.faia.agent.Agent;
import frsf.cidisi.faia.agent.Perception;
import frsf.cidisi.faia.environment.Environment;


public class AmongUsEnviroment extends Environment {

    public AmongUsEnviroment(){
        this.environmentState = new AmongUsEnviromentState();
    }


    @Override
    public Perception getPercept() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String toString() {
        return "";
    }

}
