package emmrdz.notasdefe.Objetos;

public class Publicacion {

    private String id;
    private String uid;
    private String fecha;
    private String date;
    private String titulo;
    private String contenido;
    private String referencia;

    public Publicacion() {
    }

    public Publicacion(String id, String uid, String fecha, String date, String titulo, String contenido, String referencia) {
        this.id = id;
        this.uid = uid;
        this.fecha = fecha;
        this.date = date;
        this.titulo = titulo;
        this.contenido = contenido;
        this.referencia = referencia;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
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

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }
}


