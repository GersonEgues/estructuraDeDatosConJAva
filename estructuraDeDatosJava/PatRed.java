public class PatRed{
 private char caracter;
 private int cont;
 public PatRed(char c){
    caracter = c;
    cont=1;
 }
 public char getChar(){
  return  caracter;   
 }
 public int getCont(){
  return cont;
 }
 //-----------------
 public void sumar(){
  cont+=1;   
 }
}
