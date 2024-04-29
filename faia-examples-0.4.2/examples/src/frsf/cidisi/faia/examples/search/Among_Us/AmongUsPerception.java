package frsf.cidisi.faia.examples.search.Among_Us;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import frsf.cidisi.faia.agent.Agent;
import frsf.cidisi.faia.agent.Perception;
import frsf.cidisi.faia.environment.Environment;


public class AmongUsPerception extends Perception{

    // Evaluar si pasarlo a ingles o no, porque el resto de clases esta en ingles.
    private Room habitacionActual;
    private List<Room> habitacionesSiguientes;
    private int energia;

    public AmongUsPerception() {
        // No inicializar, porque se crea uno nuevo cada vez que se pide una percepcion
        // a la clase xEnvironment. Actualizar posicion, habitaciones, energia, etc
        // en xEnvironmentState.
        super();
    }

    public AmongUsPerception(Agent agent, Environment environment) {
        super(agent, environment);
    }

    // Esto es lo mismo que hace AmongUsEnvironment a mano cuando se le pide
    // percepcion. Esta al pedo. Es otra forma de inicializar una perception.
    @Override
    public void initPerception(Agent agent, Environment environment) {
        
        AmongUsEnviromentState state = (AmongUsEnviromentState) environment.getEnvironmentState();

        // Set agent position
        this.habitacionActual = state.getAgentPosition();

        // Set available rooms to go
        this.habitacionesSiguientes = state.getSuccesors(habitacionActual);

        // Creo que la energía debe setearse en el state y sacarse de ahí.
        this.energia = state.getAgentEnergy();

    }

    public void setHabitacionesSiguientes(List<Room> habitacionesSiguientes) {
        this.habitacionesSiguientes = habitacionesSiguientes;
    }

    public int getEnergia() {
        return energia;
    }

    public Room getHabitacionActual() {
        return habitacionActual;
    }

    public List<Room> getHabitacionesSiguientes() {
        return habitacionesSiguientes;
    }

    public void setEnergia(int energia) {
        this.energia = energia;
    }
    
    public void setHabitacionActual(Room habitacionActual) {
        this.habitacionActual = habitacionActual;
    }

}
