public class ProductoElectronico extends Producto {
    private int mesesGarantia;

    /**
     * Constructor para crear un producto electrónico
     * 
     * @param codigo        El código del producto
     * @param nombre        El nombre del producto
     * @param precio        El precio del producto
     * @param mesesGarantia Los meses de garantía del producto
     * @param stock         El stock inicial del producto
     * @throws IllegalArgumentException Si los parámetros son inválidos
     */
    public ProductoElectronico(String codigo, String nombre, double precio, int mesesGarantia, int stock) {
        super(codigo, nombre, precio, stock);
        this.mesesGarantia = mesesGarantia;
    }

    public int getMesesGarantia() {
        return mesesGarantia;
    }

    /**
     * Establece los meses de garantía del producto
     * 
     * @param mesesGarantia Los meses de garantía
     * @throws IllegalArgumentException Si los meses de garantía son negativos
     */
    public void setMesesGarantia(int mesesGarantia) {
        if (mesesGarantia < 0) {
            throw new IllegalArgumentException("Los meses de garantía no pueden ser menores a 0.");
        }
        this.mesesGarantia = mesesGarantia;
    }

    /**
     * Representación en String del producto electrónico
     * 
     * @return String con todos los detalles del producto
     */
    @Override
    public String toString() {
        return getDetalleBase() + String.format(", Garantía: %d meses", mesesGarantia);
    }
}