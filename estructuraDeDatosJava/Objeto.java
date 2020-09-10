
public class Objeto implements Comparable<Objeto>{
 private String nom;
 private int cont;
 public Objeto(String n){
    nom = n;
    cont=1;
 }
 public void sumar(){
  cont+=1;   
 }
 public int compareTo(Objeto o){
  return nom.compareTo(o.getNombre());
 }
 public boolean equals(Object otro){
  boolean res = false;
  String a = nom;
  Objeto aa = (Objeto)otro;
  if(a.equals(aa.getNombre())){
   res = true;  
  }
  return res;
 }
 public String getNombre(){
  return nom;   
 }
}
