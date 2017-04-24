package uni.entity;

public class Detalle {
    // campos

    private String idproducto;
    private String nomproducto;
    private double precio;
    private int cantidad;
    private double importe;

    //constructor
    public Detalle() {
    }

    public Detalle(String idproducto, String nomproducto, double precio, int cantidad, double importe) {
        this.idproducto = idproducto;
        this.nomproducto = nomproducto;
        this.precio = precio;
        this.cantidad = cantidad;
        this.importe = importe;
    }

   

    // metodos get y set
   
    public String getIdproducto() {
        return idproducto;
    }

    public void setIdproducto(String idproducto) {
        this.idproducto = idproducto;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getImporte() {
        return importe;
    }

    public void setImporte(double importe) {
        this.importe = importe;
    }

    public String getNomproducto() {
        return nomproducto;
    }

    public void setNomproducto(String nomproducto) {
        this.nomproducto = nomproducto;
    }
    
}
