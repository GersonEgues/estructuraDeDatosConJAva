import ED.EDL.*;
import ED.EDNL.*;
public class Mesa{
 private ListaSE<Carta> cartas;
 private Stack<Carta> maso;
 public Mesa(){
  cartas = new ListaSE<>();
  maso = new Stack<>();
  llenarCartas();
  llenarMaso();
 }
 //-------------------------------------------------------------------
 public Carta pop(){
  return maso.pop();   
 }
 public boolean empty(){
  return maso.empty();   
 }
 public Carta top(){
  return maso.top();   
 }
 
 //-------------------------------------------------------------------
 private void llenarMaso(){
  while(!cartas.empty()){
    int aux = (int)(Math.random()*cartas.size());
    maso.push(cartas.remove(aux));
  }   
  //System.out.println(cartas.size());
 }
 private void llenarCartas(){
  for(int i=0;i<2;i++)
   cartas.add(new Carta("Uno",1,false,""));
  for(int i=0;i<2;i++)
   cartas.add(new Carta("Uno",11,false,""));
  for(int i=0;i<4;i++)
   cartas.add(new Carta("Dos",2,false,""));
  for(int i=0;i<4;i++)
   cartas.add(new Carta("Tres",3,false,""));
  for(int i=0;i<4;i++)
   cartas.add(new Carta("Cuatro",4,false,""));
  for(int i=0;i<4;i++)
   cartas.add(new Carta("Cinco",5,false,""));
  for(int i=0;i<4;i++)
   cartas.add(new Carta("Seis",6,false,""));
  for(int i=0;i<4;i++)
   cartas.add(new Carta("Siete",7,false,""));
  for(int i=0;i<4;i++)
   cartas.add(new Carta("Ocho",8,false,""));
  for(int i=0;i<4;i++)
   cartas.add(new Carta("Nueve",9,false,""));
  for(int i=0;i<4;i++)
   cartas.add(new Carta("Diez",10,false,""));
  
  cartas.add(new Carta("J",10,true,"Corazon"));
  cartas.add(new Carta("J",10,true,"Diamante"));
  cartas.add(new Carta("J",10,true,"Trebol"));
  cartas.add(new Carta("J",10,true,"Espada"));
  //--------------------------------------------
  cartas.add(new Carta("Q",10,true,"Corazon"));
  cartas.add(new Carta("Q",10,true,"Diamante"));
  cartas.add(new Carta("Q",10,true,"Trebol"));
  cartas.add(new Carta("Q",10,true,"Espada"));
  //-------------------------------------------
  cartas.add(new Carta("K",10,true,"Corazon"));
  cartas.add(new Carta("K",10,true,"Diamante"));
  cartas.add(new Carta("K",10,true,"Trebol"));
  cartas.add(new Carta("K",10,true,"Espada"));
 }
}
