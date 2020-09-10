import ED.EDL.*;
import ED.EDNL.*;
public class blackjack26edl{
  ListaSE<Jugador> jugadores=new ListaSE<>();;
  private Mesa mesa;
  public blackjack26edl(Jugador[] jug){
   mesa = new Mesa();
   for(int i=0;i<jug.length;i++){
    jugadores.add(jug[i]);
   }
  }
  public void repartirCartas(){
   //primara ronda
   for(int i=0;i<jugadores.size();i++){
    Jugador jug = jugadores.get(i);
    jug.addCarta(mesa.pop());
    jug.addCarta(mesa.pop());
   }
   //segunda ronda
   for(int i=0;i<jugadores.size();i++){
    Jugador jug = jugadores.get(i);
    if(jug.crupier()){
     if(jug.puntos()<=16){
      if(!mesa.empty()){
        jug.addCarta(mesa.pop());
      }  
     }
    }else{
     int aux = (int)(Math.random()*2);
     if(aux==1){
      if(!mesa.empty()){
        jug.addCarta(mesa.pop());
      }
     }
    }
   }
  }
  public ListaSE<Jugador> verificarGanador(){
   ListaSE<Jugador> res = new ListaSE<>();
   Jugador jugW = null;
   int tam=jugadores.size();
   boolean b=true;
   int k=0;
   while(k<tam&&b){
    Jugador aux = jugadores.get(k);
    if(aux.puntos()<=21){
     jugW=aux;
     res.add(jugW);
     b=false;
    }
    k+=1;
   }
   
   if(jugW!=null){
    for(int i=1;i<jugadores.size();i++){
     Jugador aux = jugadores.get(i);
     if(aux.puntos()==jugW.puntos()&&(jugW.getId()!=aux.getId())){
      res.add(aux);
     }else if(aux.puntos()>jugW.puntos()&&aux.puntos()<=21){
      jugW = aux;
      res.clear();
      res.add(jugW);
     }
    }  
   }
   return res;
  }
}
