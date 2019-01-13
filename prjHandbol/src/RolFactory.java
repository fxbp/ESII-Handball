/**
 * \brief FactoryMethod de rols existents per a jugadors
 * @file RolFactory.java
 */
public class RolFactory {
     
    // Atributs ----------------------------------------------------------------
    /** \brief llistat de Rols disponibles per als jugadors en format String */
    private final String[] arrayRols = {
        "CentralAvancat",
        "CentralCentre",
        "CentralDret",
        "CentralEsquerra",
        "ExtremDret",
        "ExtremEsquerra",
        "LateralDret",
        "LateralEsquerra",
        "Pivot",
        "Porter"
    };
    
     // Constructors -----------------------------------------------------------
    
    public RolFactory()
    {
        //
    }
    
    // Metodes Publics --------------------------------------------------------
    
    /**
     * @pre array rols inicialitzat
     * @post S'han mostrat per pantalla els diferents rols disponibles
     */
    public void mostrarRols()
    {
        System.out.println("Rols a escollir:");
        for(int i= 1; i<=arrayRols.length; i++)
        {
            System.out.println(i+ ": "+arrayRols[i-1]);
        }
        System.out.println();
    }
    
    /**
     * @pre valors inicialitzats
     * @return S'obte mitjançant Utils l'objecte Heredat de rol inicialitzat desitjat
     * @param rolIndex Enter positiu <= arrayRols.length. Indica la posicio del rol desitjada
     */
    public Rol getRol(int rolIndex)
    {
        return Utils.obtenirRol(arrayRols[rolIndex-1]);
    }
}
