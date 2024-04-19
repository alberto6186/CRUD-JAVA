
package Modelo;

public class Persona {
    private int id_persona;
    private String tipo_identificacion;
    private String numero_identificacion;
    private String nombre;
    private String primer_apellido;
    private String segundo_apellido;

    public Persona() {
    }

    public Persona(int id_persona, String tipo_identificacion, String numero_identificacion, String nombre, String primer_apellido, String segundo_apellido) {
        this.id_persona = id_persona;
        this.tipo_identificacion = tipo_identificacion;
        this.numero_identificacion = numero_identificacion;
        this.nombre = nombre;
        this.primer_apellido = primer_apellido;
        this.segundo_apellido = segundo_apellido;
    }

    public int getId_persona() {
        return id_persona;
    }

    public void setId_persona(int id_persona) {
        this.id_persona = id_persona;
    }

    public String getTipo_identificacion() {
        return tipo_identificacion;
    }

    public void setTipo_identificacion(String tipo_identificacion) {
        this.tipo_identificacion = tipo_identificacion;
    }

    public String getNumero_identificacion() {
        return numero_identificacion;
    }

    public void setNumero_identificacion(String numero_identificacion) {
        this.numero_identificacion = numero_identificacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPrimer_apellido() {
        return primer_apellido;
    }

    public void setPrimer_apellido(String primer_apellido) {
        this.primer_apellido = primer_apellido;
    }

    public String getSegundo_apellido() {
        return segundo_apellido;
    }

    public void setSegundo_apellido(String segundo_apellido) {
        this.segundo_apellido = segundo_apellido;
    }
    
    
    
}
