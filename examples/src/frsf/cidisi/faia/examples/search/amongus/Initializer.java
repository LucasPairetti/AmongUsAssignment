package frsf.cidisi.faia.examples.search.amongus;

import java.util.Random;

public class Initializer {

    private static Initializer instance;
    private int agentPosition;
    private int agentEnergy;

    public static Initializer getInstance() {
        if (instance == null) {
            instance = new Initializer();
        }
        return instance;
    }

    public Initializer() {
        
        Random r = new Random();

        this.agentPosition = r.nextInt(0, 14);
        this.agentEnergy = r.nextInt(30,151);

    }

    public int getAgentPosition() {
        return agentPosition;
    }

    public void setAgentPosition(int agentPosition) {
        this.agentPosition = agentPosition;
    }

    public int getAgentEnergy() {
        return agentEnergy;
    }

    public void setAgentEnergy(int agentEnergy) {
        this.agentEnergy = agentEnergy;
    }

}
