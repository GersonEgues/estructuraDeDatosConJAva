
public class Carta{
   private String nombre;
   private int valor;
   private boolean jqk;
   private String caracter;
   public Carta(String nom,int val,boolean jqk,String c){
    nombre = nom;
    valor= val;
    caracter=c;
    this.jqk=jqk;
   }
   public String getNobre(){
    return nombre; 
   }
   public int getValor(){
    return valor; 
   }
   public String getCarcater(){
    return caracter; 
   }
   public boolean jqk(){
    return jqk; 
   }
}
