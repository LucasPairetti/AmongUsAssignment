package frsf.cidisi.faia.examples.search.amongus;

public class Crewmate implements Cloneable {
    private int id;
   

    public Crewmate(int id) {
        this.id = id;
       
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public Crewmate clone() {
        try {
            return (Crewmate) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(); // No debería ocurrir porque estamos clonando un objeto Cloneable
        }
    }

   
}
