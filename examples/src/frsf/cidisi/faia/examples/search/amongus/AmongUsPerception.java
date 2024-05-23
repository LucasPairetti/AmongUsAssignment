package frsf.cidisi.faia.examples.search.amongus;

import java.util.ArrayList;
import java.util.List;

import frsf.cidisi.faia.agent.Agent;
import frsf.cidisi.faia.agent.Perception;
import frsf.cidisi.faia.environment.Environment;

public class AmongUsPerception extends Perception {
    List<Room> roomsWithCrewMates; //El impostor debe buscar y actualizar sus roomsWithCrewMates en base al idRoom (evita referencia cruzada)
  
    private String RoomName; //solo empleado para el to String
    
    @Override
    public void initPerception(Agent agent, Environment environment) {
        AmongUsEnvironmentState envState = ((AmongUsEnvironment) environment).getEnvironmentState();

        this.roomsWithCrewMates=envState.getRoomsWithCrewmate();
         this.RoomName = envState.getAgentPosition().getName();
         
        
    }
    
    public List<Room> getRoomsWithCrewMates() {
        return roomsWithCrewMates;
    }

    public void setRoomsWithCrewMates(List<Room> roomsWithCrewMates) {
        this.roomsWithCrewMates = roomsWithCrewMates;
    }

    public String getRoomName() {
        return RoomName;
    }

    public void setRoomName(String roomName) {
        RoomName = roomName;
    }

    @Override
    public String toString() {
       String str="Habitaciones con tripulantes: "+ roomsWithCrewMates.toString() +"\n";
       return str;
    }

    

}
