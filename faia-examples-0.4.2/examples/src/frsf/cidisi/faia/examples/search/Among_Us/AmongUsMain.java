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
        //aca ando intentando ejecutar un agenteState y no me lo inicializa entero
        Inicializador init = Inicializador.getInstance();
        System.out.println(init.getAgentPosition().getNombre()); 
        System.out.println(init.getHabitacionesConectadas()); 
        //igual en un ratito salgo a buscar el mic, me lo deje en lo de una amiga anoche
        
    }
}


//corregí la lista de tareas!