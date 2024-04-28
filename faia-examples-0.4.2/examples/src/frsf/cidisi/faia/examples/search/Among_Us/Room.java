package frsf.cidisi.faia.examples.search.Among_Us;
import java.util.ArrayList;
import java.util.List;
public class Room {

    public int id;
    public String nombre;
    public List<Tripulante> tripulantesEnHabitacion;
    
    public Room(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
        this.tripulantesEnHabitacion = new ArrayList<Tripulante> ();
      
    }
    public Room(int id, String nombre, List<Room> sucesores) {
        this.id = id;
        this.nombre = nombre;
        this.tripulantesEnHabitacion = new ArrayList<Tripulante> ();
    
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public List<Tripulante> getTripulantesEnHabitacion() {
        return tripulantesEnHabitacion;
    }
    public void setTripulantesEnHabitacion(List<Tripulante> tripulantesEnHabitacion) {
        this.tripulantesEnHabitacion = tripulantesEnHabitacion;
    }
   
    public void addTripulante(Tripulante tripulante){
        tripulantesEnHabitacion.add(tripulante);
    }

    public void removeTripulante(Tripulante tripulante){
        tripulantesEnHabitacion.remove(tripulante);
    }

    public void removeTripulanteById(Tripulante tripulante){
        tripulantesEnHabitacion.remove(tripulante.getId());
    }
    


    

}
