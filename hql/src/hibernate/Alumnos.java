package hibernate;

import java.util.HashSet;
import java.util.Set;

public class Alumnos implements java.io.Serializable {

    private Integer idalumno;
    private String nombre;
    private Set notases = new HashSet(0);

    public Alumnos() {
    }

    public Alumnos(String nombre) {
        this.nombre = nombre;
    }

    public Alumnos(String nombre, Set notases) {
        this.nombre = nombre;
        this.notases = notases;
    }

    public Integer getIdalumno() {
        return this.idalumno;
    }

    public void setIdalumno(Integer idalumno) {
        this.idalumno = idalumno;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Set getNotases() {
        return this.notases;
    }

    public void setNotases(Set notases) {
        this.notases = notases;
    }

}
