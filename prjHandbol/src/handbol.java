/*
 * @file handbol.java
 */

/**\brief handbol classe main que carrega les dades i executa les opcions de menu: Entrenador envia missatge a pista, Arbitre amonesta a jugador X (targeta groga) i Jugador X agafa el rol 
 * @author Adrià Alabau
 * @author Francesc Bullich
 */
public class handbol {
    
    
    public static void main(String[] args) {
        CarregaDades loader = new CarregaDades();
        try{   
            loader.inicialitzaDades();
            Partit partit = loader.getPartit();
        }
        catch(Exception e){
            System.err.println(e.toString());
        }
        
    }
     
    
}
