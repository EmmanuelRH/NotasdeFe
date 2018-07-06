package emmrdz.notasdefe.Objetos;

public class Templo {

    private String nombre;
    private String direccion;
    private String agrupacion;
    private String admin;
    private String admin2;
    private String fechaalta;

    public Templo(String nombre, String direccion, String agrupacion, String admin, String admin2, String fechaalta) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.agrupacion = agrupacion;
        this.admin = admin;
        this.admin2 = admin2;
        this.fechaalta = fechaalta;
    }

    public Templo() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getAgrupacion() {
        return agrupacion;
    }

    public void setAgrupacion(String agrupacion) {
        this.agrupacion = agrupacion;
    }

    public String getAdmin() {
        return admin;
    }

    public void setAdmin(String admin) {
        this.admin = admin;
    }

    public String getAdmin2() {
        return admin2;
    }

    public void setAdmin2(String admin2) {
        this.admin2 = admin2;
    }

    public String getFechaalta() {
        return fechaalta;
    }

    public void setFechaalta(String fechaalta) {
        this.fechaalta = fechaalta;
    }
}
