
public class Producto {
    private String codigo;
    private String nombre;
    private double precio;
    private int stock;
    private static int contadorProductos = 0;

    public Producto(String codigo, String nombre, double precio, int stock) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
        contadorProductos++;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        if (codigo == null || codigo.trim().isEmpty()) {
            throw new IllegalArgumentException("El código es requerido.");
        }
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del producto
     * 
     * @param nombre El nombre del producto
     * @throws IllegalArgumentException Si el nombre es nulo o vacío
     */
    public void setNombre(String nombre) {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre es requerido.");
        }
        this.nombre = nombre;
    }

    /**
     * Obtiene el precio del producto
     * 
     * @return El precio del producto
     */
    public double getPrecio() {
        return precio;
    }

    /**
     * Establece el precio del producto
     * 
     * @param precio El precio del producto
     * @throws IllegalArgumentException Si el precio es negativo
     */
    public void setPrecio(double precio) {
        if (precio < 0) {
            throw new IllegalArgumentException("El precio no puede ser negativo.");
        }
        this.precio = precio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        if (stock < 0) {
            throw new IllegalArgumentException("No se acepta un numero negativo");
        }
        this.stock = stock;
    }

    /**
     * Obtiene el contador total de productos creados
     * 
     * @return El número total de productos creados
     */
    public static int getContadorProductos() {
        return contadorProductos;
    }

    public void vender(int cantidad) throws StockInsuficienteException, IllegalArgumentException {
        if (cantidad <= 0) {
            throw new IllegalArgumentException("La cantidad a vender debe ser positiva.");
        }

        if (cantidad > this.stock) {
            throw new StockInsuficienteException("Stock insuficiente para " + this.nombre +
                    ". Disponibles: " + this.stock);
        }

        this.stock -= cantidad;
    }

    /**
     * Método protegido para obtener los detalles base del producto
     * 
     * @return String con la información base del producto
     */
    protected String getDetalleBase() {
        return String.format("Codigo: %s, Nombre: %s, Precio: $%.2f, Stock: %d",
                codigo, nombre, precio, stock);
    }

    public void mostrarInfoCompleja() {
        System.out.println("***********************");
        System.out.println("--- DETALLE PRODUCTO ---");
        System.out.println("ID: " + this.codigo);
        System.out.println("Nombre: " + this.nombre);

        // Lógica refactorizada para categorización de precios
        String categoriaPrecio;
        if (this.precio > 100) {
            categoriaPrecio = "Alto";
        } else if (this.precio > 50) {
            categoriaPrecio = "Medio";
        } else {
            categoriaPrecio = "Bajo";
        }

        System.out.println("Precio : (" + categoriaPrecio + "): " + this.precio);
        System.out.println("Stock disponible: " + this.stock);
        System.out.println("***********************");
    }

    /**
     * Representación en String del producto
     * 
     * @return String con todos los detalles del producto
     */
    @Override
    public String toString() {
        return getDetalleBase();
    }
}