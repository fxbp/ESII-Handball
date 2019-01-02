
import java.util.ArrayList;
import java.util.List;



/**
 * \brief Representa un jugador del joc de handbol
 * @file Jugador.java
 */
public class Jugador extends Personatge{
  
    // Atributs ----------------------------------------------------------------
    
    
    /** \brief Pes en KG del jugador */
    private double _pes;
    
    /** \brief alçada en cm del Jugador*/
    private int _alcada;
    
    /** \brief dorsal del jugador durant el partit*/
    private int _dorsal;
    
    /** \brief numero de gols que ha fet el jugador durant el partit*/
    private int _gols;
        
    /** \brief Representa la llista de sancions que pot tenir un jugador */
    private List<Sancio> _sancions;
    
    /** \brief Represneta els jugadors a pista de l'equip. Els jugadors que siguin a pista son els que estan jugant */
    private Pista _pista;
    
    /** \brief Representa la banqueta de l'equip. El jugador sera a la banqueta si no es a pista o l'exclouen */
    private Banqueta _banqueta;
    
    // Constructors -----------------------------------------------------------
    
    public Jugador(String nom, String cognom, String numLlicencia, double pes, int alcada, int dorsal, Banqueta banqueta, Pista pista) {
        super(nom, cognom, numLlicencia);
        
        _pes=pes;
        _alcada=alcada;
        _dorsal=dorsal;
        _gols=0;
        _sancions=new ArrayList();
        _banqueta=banqueta;
        _pista=pista;
    }
    
    
    
    
    // Metodes Publics --------------------------------------------------------
    
    public int getDorsal(){
        return _dorsal;
    }
    
    
    /**
     * \brief el Jugador s'anota un gol
     * @pre True
     * @post el nombre de gols del jugador ha estat incrementat en 1
     */
    public void anotarGol(){
        _gols++;
    }
    
    
    public void rebreAmonestacio(Sancio.TipusSancio sancio){
        
    }
    
    
    /**
     * @pre True
     * @post el Jugador ha anat a la Banqueta. El jugador ha sortit de pista si hi era
     * @throws Exception Si no es pot afegir el jugador a la banqueta
     */
    public void entrarBanqueta() throws Exception{
        _pista.treureJugador(this);
        if (!_banqueta.plena())
         _banqueta.AfegirJugador(this);
    }
    
    /**
     * @pre True
     * @post el jugador ha anat a Pista. El jugador ha sortit de la banqueta si hi era
     * @throws Exception Si no es pot afegir el jugador a pista
     */
    public void entrarPista() throws Exception{
        _banqueta.treureJugador(this);
        if (!_pista.plena())
            _pista.AfegirJugador(this);
    }
}
