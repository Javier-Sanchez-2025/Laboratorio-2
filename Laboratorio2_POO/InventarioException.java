/**
 * Excepción personalizada para manejar errores específicos del inventario
 */
public class InventarioException extends Exception {
    
    /**
     * Constructor que recibe un mensaje de error
     * @param mensaje El mensaje descriptivo del error
     */
    public InventarioException(String mensaje) {
        super(mensaje);
    }
}