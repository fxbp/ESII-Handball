
/**
 *
 * @author Francesc
 */
public interface CSVParser {
    
    
    public <T> T create(String linia, String separador) throws Exception;
}
