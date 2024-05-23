package frsf.cidisi.faia.examples.search.amongus;

import java.util.ArrayList;

public class Room implements Cloneable {

    private int id;
    private String name;
    private ArrayList<Crewmate> crewmatesInRoom;
    private Task task;

    public Room(int id, String name, Task task) {
        this.id = id;
        this.name = name;
        this.crewmatesInRoom = new ArrayList<Crewmate>();
        this.task = task;
    }

    public Room(int id, String name) {
        this.id = id;
        this.name = name;
        this.crewmatesInRoom = new ArrayList<Crewmate>();
        this.task = null;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ArrayList<Crewmate> getCrewmatesInRoom() {
        return crewmatesInRoom;
    }

    public void setCrewmatesInRoom(ArrayList<Crewmate> crewmatesInRoom) {
        this.crewmatesInRoom = crewmatesInRoom;
    }

    public Task getTarea() {
        return task;
    }

    public void setTarea(Task task) {
        this.task = task;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addCrewmate(Crewmate c) {
        this.crewmatesInRoom.add(c);
    }

    public void RemoveCrewmate(Crewmate c) {
        this.crewmatesInRoom.remove(c);
    }
    public void RemoveCrewmate() {  //para ahorrar codigo el agente mata al primero
        this.crewmatesInRoom.remove(this.crewmatesInRoom.getFirst());
    }

    public String toString() {
        return this.name;
    }

    public boolean crewmatesAliveInside(){
        
    if(!this.crewmatesInRoom.isEmpty())
    return true;
    else
    return false;
    }

    public Room clone() {
        try {
            Room cloned = (Room) super.clone();
            cloned.crewmatesInRoom = new ArrayList<>(this.crewmatesInRoom.size());
            for (Crewmate crewmate : this.crewmatesInRoom) {
                cloned.crewmatesInRoom.add(crewmate.clone());
            }
            // No necesitamos clonar task porque es un enum
            return cloned;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(); // No debería ocurrir porque estamos clonando un objeto Cloneable
        }
    }

}
