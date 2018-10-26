package hibernate.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "tutoriales", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"titulo", "tipo"})})  //segun el scrpt de tutoriales, titulo, tipo son unicos, esto lo pide antes de ir a la base de datos

//@Table(name = "tutoriales"){

public class Tutoriales implements java.io.Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idtutorial", nullable = false, unique = true, length = 11)//envalua a la base de datos
    private Integer idtutorial;
    
    @Column(name = "titulo", length = 200, nullable = false)
    private String titulo;
    
    @Column(name = "tipo", length = 20, nullable = false)
    private String tipo;
    
    @Column(name = "precio", precision=10, scale=2, nullable = false)
    private Double precio;

    public Tutoriales() {
    }

    public Tutoriales(String titulo, String tipo, double precio) {
        this.titulo = titulo;
        this.tipo = tipo;
        this.precio = precio;
    }

    public Integer getIdtutorial() {
        return this.idtutorial;
    }

    public void setIdtutorial(Integer idtutorial) {
        this.idtutorial = idtutorial;
    }

    public String getTitulo() {
        return this.titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getTipo() {
        return this.tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

}
