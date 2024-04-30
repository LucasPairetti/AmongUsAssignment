package frsf.cidisi.faia.examples.search.Among_Us;

public class Tripulante {

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

}
