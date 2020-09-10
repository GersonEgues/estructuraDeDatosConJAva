public class Pueblo{
    private String nombre;
    private int distancia;
    public Pueblo(String nom,int dis){
     nombre=nom;
     distancia=dis;
    }
    public int getDistancia(){
     return distancia;
    }
    public String getNombre(){
     return nombre;
    }
    public boolean equals(Pueblo otro){
     return nombre.equals(otro.getNombre());
    }
}
