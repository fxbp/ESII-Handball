
/**
 * \brief Es posiciona en un punt de l'espai 3d, en cm
 * @author fbullich
 */
public class Posicio3D {
    
    // Atributs ----------------------------------------------------------------
    
    /* \brief posicio de l'eix X en cm */
    private int _x;
    
    /* \brief posicio de l'eix y en cm */
    private int _y;
    
    /* \brief posicio de l'eix Z en cm */
    private int _z;
    
    
    // Constructors ------------------------------------------------------------
    
    public Posicio3D(){
        this(0,0,0);
    }
    
    public Posicio3D(int x, int y, int z){
        _x=x;
        _y=y;
        _z=z;
    }
    
}
