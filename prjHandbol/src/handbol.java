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
            
            while(accio() == 0);
            
        }
        catch(Exception e){
            System.err.println(e.toString());
        }
        
    }
    
    public static void mostrarMenu()
    {
        System.out.println("---------------------------------------------------------");
        System.out.println("Menu:");
        System.out.println("1: Notificar un missatge a tots els jugadors de pista d'un equip");
        System.out.println("2: Amonestar a un jugador X amb tarja groga");
        System.out.println("3: Canviar al rol R a un jugador X");
        System.out.println("0: Finalitzar");
        System.out.println("---------------------------------------------------------");
        System.out.println();
    }
    
    public static String demanarAccio(String message)
    {
        System.out.println(message);
        String value = scanner.nextLine();
        return value;
    }
    
    public static int obtenirOpcio(int minim, int maxim, String accio){
     int value= -1;
        do {
            try{
            value = Integer.parseInt(demanarAccio(accio));
            }
            catch (Exception e){
                value=-1;
            }
            finally{
                if (value < minim || value > maxim){
                    System.err.println("Opció no valida!!");
                    System.err.println();
                }
            }
        } while (value < minim || value > maxim);
        
        return value;
    }
    

    public static int accio()
    {
        mostrarMenu();
        int value = obtenirOpcio(0,3, "Introdueix l'index que vols realitzar:");
       
        
        switch (value) {
            case 1:
                notificarATots();
                break;
            case 2:
                sancionarJugador();
                break;
            case 3:
                ;
                break;
            case 0:
                return 1;
            default:
                System.out.println("Valor no reconegut");
                break;
        }
        
        return 0;
    }
    
    public static void notificarATots()
    {
        partit.mostrarEquips();
        int equipEscollit= obtenirOpcio(1,2,"Entra l'index de l'equip que vols escollir");
        //int equipEscollit = Integer.parseInt(demanarAccio("Entra l'index de l'equip que vols escollir"));
        Equip equip = partit.obtenirEquip(equipEscollit);
        
        if(equip != null)
        {
            
            String missatge = demanarAccio("Introdueix el missatge que vols enviar");
            equip.enviarMissatgePista(missatge);
        }
        else
        {
            System.err.println("L'equip no existeix");
            System.err.println();
        }
        
    }
    
    public static void sancionarJugador()
    {
        int part = obtenirOpcio(1,4,"Entrar el numero de la part actual");
        int minut = obtenirOpcio(1,10,"Entrar minut de la sancio");
        
        partit.mostrarArbitres();
        int arbitre = obtenirOpcio(1,2,"Entra l'index de l'arbitre que sancionarà a un jugador");
        Arbitre arbit = partit.obtenirArbitre(arbitre);
        
        if(arbit != null)
        {
            partit.mostrarEquips();
            int equipEscollit= obtenirOpcio(1,2,"Entra l'index de l'equip que vols escollir");
            Equip equip = partit.obtenirEquip(equipEscollit);

            if(equip != null)
            {
                equip.mostrarPista();
                int jugador = obtenirOpcio(1,5,"Entra el dorsal del jugador a sancionar");
                
                try{
                    arbit.AmonestarJugador(jugador, equip.getId(), Utils.TipusSancio.Groga, part, minut);
                }
                catch(Exception e)
                {
                    System.err.println("Something went wrong");
                }
                
            }
            else
            {
                showError("Equip");
            }
        }       
        else
        {
            showError("Arbitre");
        }
    }
    
    private static void showError(String x)
    {
        System.err.println(x + " no existeix");
        System.err.println();
    }
     
    
}
