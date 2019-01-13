/*
 * @file handbol.java
 */

import java.util.List;
import java.util.Scanner;

/**\brief handbol classe main que carrega les dades i executa les opcions de menu: Entrenador envia missatge a pista, Arbitre amonesta a jugador X (targeta groga) i Jugador X agafa el rol 
 * @author Adrià Alabau
 * @author Francesc Bullich
 */
public class handbol {
    
    private static Scanner scanner = new Scanner(System.in);
    private static Partit partit;
    private static RolFactory fact = new RolFactory();
    
    public static void main(String[] args) {
        CarregaDades loader = new CarregaDades();
        try{   
            loader.inicialitzaDades();
            partit = loader.getPartit();
            
            while(accio() == 0)
            {
              //Iteration
            }
            
        }
        catch(Exception e){
            System.err.println(e.toString());
        }
        
    }
    
    /**
     * @pre Cert
     * @post Mostra per pantalla les opcions amb index disponibles
     */
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
    
    /**
     * @pre Cert
     * @return S'obte l'entrada de teclat de l'usuari
     * @param message String no null amb els caracters del missatge a mostrar per pantalla
     */
    public static String demanarAccio(String message)
    {
        System.out.println(message);
        String value = scanner.nextLine();
        System.out.println();
        return value;
    }
    
    /**
     * @pre Cert
     * @return s'obte un valor enter x >= minim i <= maxim que indica la opcio de les mostrades previament que ha escollit 
     * @param minim indica el minim valor a entrar
     * @param maxim indica el maxim valor que es pot entrar 
     * @param accio missatge a mostrar per pantalla
     */
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
    
    /**
     * @pre Cert
     * @return s'obte un valor enter x >= minim i <= maxim que indica la opcio de les mostrades previament que ha escollit 
     * @param valors llistat de valors enters disponibles a entrar. Si l'usuari no en selecciona cap es tornara a preguntar
     * @param accio indica si l'observer ha d'estar pendent del subject o no
     */
    public static int obtenirOpcio(List<Integer> valors, String accio){
     int value= -1;
        do {
            try{
            value = Integer.parseInt(demanarAccio(accio));
            }
            catch (Exception e){
                value=-1;
            }
            finally{
                if (!valors.contains(value)){
                    System.err.println("Opció no valida!!");
                    System.err.println();
                }
            }
        } while (!valors.contains(value));
        
        return value;
    }
    
     /**
     * @pre Cert
     * @return segons el valor entrat per l'usuari s'executara una de les opcions disponibles del menu
     */
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
                canviarRolJugador();
                break;
            case 0:
                return 1;
            default:
                System.out.println("Valor no reconegut");
                break;
        }  
        return 0;
    }
    
    /**
     * @pre dades de partit inicialitzades
     * @post s'ha demanat un equip i un missatge a l'usuari per ser enviat a tots els jugadors de pista de l'equip
     */
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
    
    /**
     * @pre Dades de partit inicialitzades
     * @post S'ha escollit un arbitre, un jugador d'un equip i s'he l'ha sancionat amb una amonestacio tipus targeta groga
     */
    public static void sancionarJugador()
    {
        int part = partit.getPart();
        int minut = partit.getMinut();
        
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
                List<Integer> dorsals = equip.getDorsalsPista();
                int jugador = obtenirOpcio(dorsals,"Entra el dorsal del jugador a sancionar");
                
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
    
    /**
     * @pre Dades de partit inicialitzades
     * @post S'ha demanat un jugador d'un equip, s'ha escollit un rol desitjat i finalment s'ha afegit el rol al jugador.
     */
    public static void canviarRolJugador()
    {
        partit.mostrarEquips();
        int equipEscollit= obtenirOpcio(1,2,"Entra l'index de l'equip que vols escollir");
        Equip equip = partit.obtenirEquip(equipEscollit);

        if(equip != null)
        {
            equip.mostrarPista();
            List<Integer> dorsals = equip.getDorsalsPista();
            int jugador = obtenirOpcio(dorsals,"Entra el dorsal del jugador a sancionar");

            fact.mostrarRols();
            int rolnou = obtenirOpcio(1,10,"Entra l'index del rol desitjat");

            equip.canviarRolA(jugador,fact.getRol(rolnou));
        }
        else
        {
            showError("Equip");
        }
    }
    
    /**
     * @pre Cert
     * @post Metode auxiliar per no repetir linies de codi, mostra un error amb missatge X per pantalla
     * @param x missatge o valor a mostrar
     */
    private static void showError(String x)
    {
        System.err.println(x + " no existeix");
        System.err.println();
    }
     
    
}
