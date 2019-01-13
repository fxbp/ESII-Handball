
/**
 * \brief Representa el partit del joc de handbol
 * @file Partit.java
 */
public class Partit {
    
    // Atributs ----------------------------------------------------------------
    
    /** \brief identificador del partit*/
    private String _idPartit;
    
    /** \brief data d'inici del partit en format string*/
    private String _dataInici;
    
    /** \brief hora d'inici del partit en format string*/
    private String _horaInici;
    
    /** \brief representa el minut actual del partit*/
    private int _minut;
    
    /** \brief representa la part actual del partit     */
    private int _part;
    
     /** \brief representa el primer arbitre del partit*/
    private Arbitre _primerArbitre;
    
    
     /** \brief representa el segon arbitre del partit*/
    private Arbitre _segonArbitre;
    
     /** \brief Representa l'equip local del partit*/
    private Equip _local;
    
     /** \brief representa l'equip visitant del partit*/    
    private Equip _visitant;
    
    
    // Constructors ----------------------------------------------------------
    
    public Partit(String id, String data, String hora, int part, int minut, Arbitre primerArbitre, Arbitre segonArbitre, Equip local, Equip visitant){
        _idPartit = id;
        _dataInici = data;
        _horaInici = hora;
        _part = part;
        _minut = minut;
        _primerArbitre = primerArbitre;
        _segonArbitre = segonArbitre;
        _local = local;
        _visitant = visitant;
    }
    
    /**
     * @pre Cert
     * @post Ha mostrat per pantalla la informaicio dels equips del partit
     */
    public void mostrarEquips()
    {
        System.out.println("Equips disputant el partit:");
        System.out.println("1: Local "+ _local.toString());
        System.out.println("2: Visitant "+ _visitant.toString());
        System.out.println();
    }
    
    /**
     * @pre Cert
     * @post Ha mostrat per pantalla la informacio dels arbitres del partit
     */
    public void mostrarArbitres()
    {
        System.out.println("Arbitres del partit:");
        System.out.println("1: "+ _primerArbitre.toString());
        System.out.println("2: "+ _segonArbitre.toString());
        System.out.println();
    }
    
    /**
     * @pre value pertany (1,2)
     * @param value equip seleccionat
     * @return equip del partit seleccionat, 1 = local 2 = visitant
     */
    public Equip obtenirEquip(int value)
    {
        if(value == 1)
        {
            return _local;
        }
        else if(value == 2)
        {
            return _visitant;
        }
        else
        {
            return null;
        }
    }
    
    /**
     * @pre value pertany (1,2)
     * @param value determina quin arbitre es selecciona
     * @return arbitre del partit segons value
     */
    public Arbitre obtenirArbitre(int value)
    {
        if(value == 1)
        {
            return _primerArbitre;
        }
        else if(value == 2)
        {
            return _segonArbitre;
        }
        else
        {
            return null;
        }
    }
    
    /**
     * @pre True
     * @return la part actual del partit
     */
    public int getPart(){
        return _part;
    }
    
    /**
     * @pre True
     * @return el minut actual del partit
     */
    public int getMinut(){
        return _minut;
    }
}
