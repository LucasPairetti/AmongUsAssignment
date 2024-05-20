package frsf.cidisi.faia.examples.search.Among_Us.actions;


import frsf.cidisi.faia.examples.search.Among_Us.AmongUsEnviromentState;
import frsf.cidisi.faia.examples.search.Among_Us.AmongUsImpostorState;
import frsf.cidisi.faia.examples.search.Among_Us.Room;
import frsf.cidisi.faia.examples.search.Among_Us.Tripulante;

import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import frsf.cidisi.faia.agent.search.SearchAction;
import frsf.cidisi.faia.agent.search.SearchBasedAgentState;
import frsf.cidisi.faia.state.AgentState;
import frsf.cidisi.faia.state.EnvironmentState;

public class matar_Tripulante extends SearchAction {
    
    int i=0;
    
    @Override
    public SearchBasedAgentState execute(SearchBasedAgentState s) {
        AmongUsImpostorState impostorState = (AmongUsImpostorState) s;
      i++;
      
      System.out.println("ESTOY EN"+impostorState.getHabitacionActual());

      HashMap<Room, Collection<Tripulante>> habitacionesConTripulantes=filterDuplicateRooms(impostorState.getHabitacionesConTripulantes());
      System.out.println("Tripulante en: "+habitacionesConTripulantes);

      if(!habitacionesConTripulantes.containsKey(impostorState.getHabitacionActual())){
            System.out.println("Return 1 kill");
            return null;
        }
         
        else{
            if(!impostorState.getHabitacionActual().getTripulantesEnHabitacion().isEmpty()){
                
                Tripulante victima= impostorState.getHabitacionActual().getTripulantesEnHabitacion().get(0);
                victima.setVivo(false);
                impostorState.setTripulantes_Vivos(impostorState.getTripulantes_Vivos()-1);
                impostorState.setEnergia(impostorState.getEnergia()-1);
                
                impostorState.getHabitacionActual().getTripulantesEnHabitacion().remove(victima);
                if(impostorState.getHabitacionActual().getTripulantesEnHabitacion().isEmpty()){
                    habitacionesConTripulantes.remove(impostorState.getHabitacionActual());
                    impostorState.setHabitacionesConTripulantes(habitacionesConTripulantes);
                    
                }
                

                System.out.println("Return return de matar!");
                return impostorState; 
            } else{
                System.out.println("Return 3 kill");
                return null;
            } 
        }

    }
    @Override
    public Double getCost() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getCost'");
    }

    @Override
    public EnvironmentState execute(AgentState ast, EnvironmentState est) {
       AmongUsEnviromentState enviromentState = (AmongUsEnviromentState) est;
       AmongUsImpostorState impostorState = (AmongUsImpostorState) ast;
       
        System.out.println("IM EXECUTED");
        System.out.println("execute kill env lista: "+ i  +" "+enviromentState.getHabitacionesConTripulantes());
        System.out.println("execute kill env tripvivos: "+ i +" "+enviromentState.getTripulantes_Vivos());
        System.out.println(enviromentState.getAgentPosition().getNombre());
        if(!enviromentState.getHabitacionesConTripulantes().containsKey(enviromentState.getAgentPosition())){
            return null;
        } 

        else{
            
        Tripulante victima= enviromentState.getAgentPosition().getTripulantesEnHabitacion().get(0);
        victima.setVivo(false);

        //actualizo ambiente
        enviromentState.getHabitacionesConTripulantes().remove(enviromentState.getAgentPosition());
        enviromentState.getAgentPosition().getTripulantesEnHabitacion().remove(victima);
        enviromentState.setAgentEnergy(impostorState.getEnergia()-1);
                impostorState.setTripulantes_Vivos(impostorState.getTripulantes_Vivos()-1);
                impostorState.setEnergia(impostorState.getEnergia()-1);
                impostorState.getHabitacionActual().getTripulantesEnHabitacion().remove(victima);
                if(impostorState.getHabitacionActual().getTripulantesEnHabitacion().isEmpty())
                impostorState.getHabitacionesConTripulantes().remove(impostorState.getHabitacionActual());
       return enviromentState;
    }
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return "matar tripulante";
    }


      public static HashMap<Room, Collection<Tripulante>> filterDuplicateRooms(HashMap<Room, Collection<Tripulante>> habitacionesConTripulantes) {
        return habitacionesConTripulantes.entrySet().stream()
            .collect(Collectors.toMap(
                entry -> entry.getKey().getId(), // Usar el ID como clave
                Map.Entry::getValue, // Usar el valor del mapa original
                (existing, replacement) -> replacement, // En caso de duplicados, usar el valor de reemplazo
                LinkedHashMap::new // Mantener el orden de inserción
            )).entrySet().stream()
            .collect(Collectors.toMap(
                entry -> getRoomById(habitacionesConTripulantes.keySet(), entry.getKey()),
                Map.Entry::getValue,
                (existing, replacement) -> replacement,
                HashMap::new
            ));
    }

    private static Room getRoomById(Set<Room> rooms, int id) {
        return rooms.stream()
            .filter(room -> room.getId() == id)
            .findFirst()
            .orElse(null);
    }

}
