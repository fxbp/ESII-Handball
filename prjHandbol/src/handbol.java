/*
 * @file handbol.java
 */

import java.util.Scanner;

/**\brief handbol classe main que carrega les dades i executa les opcions de menu: Entrenador envia missatge a pista, Arbitre amonesta a jugador X (targeta groga) i Jugador X agafa el rol 
 * @author Adrià Alabau
 * @author Francesc Bullich
 */
public class handbol {
    
    private static Scanner scanner = new Scanner(System.in);
    private static Partit partit;
    
    public static void main(String[] args) {
        CarregaDades loader = new CarregaDades();
        try{   
            loader.inicialitzaDades();
            partit = loader.getPartit();
            
            while(accio() == 0){;}
            
        }
        catch(Exception e){
            System.err.println(e.toString());
        }
        
    }
    
    public static void mostrarMenu()
    {
        System.out.println("---------------------------------------------------------");
        System.out.println("Menu:");
        System.out.println("1: Notificar a tots els jugadors d'un equip un missatge");
        System.out.println("2: Amonestar a un jugador X amb tarja groga");
        System.out.println("3: Canviar al rol R a un jugador X");
        System.out.println("0: Finalitzar");
        System.out.println("---------------------------------------------------------");
    }
    
    public static String demanarAccio(String message)
    {
        System.out.println(message);
        String value = scanner.nextLine();
        return value;
    }
    
    public static int accio()
    {
        mostrarMenu();
        int value= Integer.parseInt(demanarAccio("Introdueix l'index que vols realitzar:"));
        if(value == 1){ ;}
        else if(value == 2){ ;}
        else if(value == 3){ ;}
        else if(value == 0){return 1;}
        else{System.out.println("Valor no reconegut");}
        
        return 0;
    }
    
    public static void NotificarATots()
    {
        partit.mostrarEquips();
        int equipEscollit = Integer.parseInt(demanarAccio("Entra l'index de l'equip que vols escollir"));
        Equip equip = partit.obtenirEquip(equipEscollit);
        
        if(equip != null)
        {
            
            String missatge = demanarAccio("Introdueix el missatge que vols enviar");
            
        }
        else
        {
            System.out.println("Index incorrecte");
            System.out.println();
            NotificarATots();
        }
        
    }
     
    
}
