package frsf.cidisi.faia.examples.search.Among_Us;

public class Tripulante implements Cloneable {

    public int id;
    public boolean vivo;

    public Tripulante(int id) {
        this.id = id;
        vivo= true;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isVivo() {
        return vivo;
    }

    public void setVivo(boolean vivo) {
        this.vivo = vivo;
    }
    @Override
    public Tripulante clone() {
        try {
            return (Tripulante) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(); // No debería ocurrir porque implementamos Cloneable
        }
    }

}
