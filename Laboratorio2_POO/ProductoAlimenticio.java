public class ProductoAlimenticio extends Producto {
    private String fechaCaducidad;

    public ProductoAlimenticio(String codigo, String nombre, double precio, String fechaCaducidad, int stock) {
        super(codigo, nombre, precio, stock);
        this.fechaCaducidad = fechaCaducidad;
    }

    public String getFechaCaducidad() {
        return fechaCaducidad;
    }

    public void setFechaCaducidad(String fechaCaducidad) throws InventarioException {
        if (fechaCaducidad == null || fechaCaducidad.trim().isEmpty()) {
            throw new IllegalArgumentException("La fecha de caducidad es requerida.");
        }

        // Simulación: consideramos que cualquier fecha anterior a "2024-12-31" está
        // caducada
        if (fechaCaducidad.compareTo("2024-12-31") < 0) {
            throw new InventarioException("El producto está caducado.");
        }

        this.fechaCaducidad = fechaCaducidad;
    }

    /**
     * Representación en String del producto alimenticio
     * 
     * @return String con todos los detalles del producto
     */
    @Override
    public String toString() {
        return getDetalleBase() + String.format(", Caducidad: %s", fechaCaducidad);
    }
}