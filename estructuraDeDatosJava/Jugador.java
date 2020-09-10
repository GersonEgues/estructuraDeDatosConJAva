import ED.EDL.*;
import ED.EDNL.*;
public class Jugador{
  private boolean crupier;
  private String nombre;
  private int id;
  private int puntos;
  ListaSE<Carta> cartas;
  public Jugador(String nom,int id,boolean crupier){
    nombre = nom;
    this.id=id;
    this.crupier = crupier;
    puntos=0;
    cartas = new ListaSE<>();
  }
  public String getNombre(){
   return nombre;
  }
  public int getId(){
   return id;  
  }
  public boolean crupier(){
   return crupier;
  }
  //-----------------------------------
  public int puntos(){
   return puntos;
  }
  //--------------------------------
  public void addCarta(Carta c){
    puntos+=c.getValor();
    cartas.add(c);
  }
  public ListaSE<Carta> getCartas(){
   return cartas;  
  }
  //--------------
}
