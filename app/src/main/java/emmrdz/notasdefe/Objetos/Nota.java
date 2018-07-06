package emmrdz.notasdefe.Objetos;

public class Nota {

    private String id;
    private String idOrigen;
    private String uid;
    private String uidOrigen;
    private String fecha;
    private String dateOrigen;
    private String date;
    private String titulo;
    private String contenido;
    private int color;
    private int prioridad;

    public Nota() {
    }

    public Nota(String id, String idOrigen, String uid, String uidOrigen, String fecha, String dateOrigen, String date, String titulo, String contenido, int color, int prioridad) {
        this.id = id;
        this.idOrigen = idOrigen;
        this.uid = uid;
        this.uidOrigen = uidOrigen;
        this.fecha = fecha;
        this.dateOrigen = dateOrigen;
        this.date = date;
        this.titulo = titulo;
        this.contenido = contenido;
        this.color = color;
        this.prioridad = prioridad;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIdOrigen() {
        return idOrigen;
    }

    public void setIdOrigen(String idOrigen) {
        this.idOrigen = idOrigen;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getUidOrigen() {
        return uidOrigen;
    }

    public void setUidOrigen(String uidOrigen) {
        this.uidOrigen = uidOrigen;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getDateOrigen() {
        return dateOrigen;
    }

    public void setDateOrigen(String dateOrigen) {
        this.dateOrigen = dateOrigen;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public int getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(int prioridad) {
        this.prioridad = prioridad;
    }
}
