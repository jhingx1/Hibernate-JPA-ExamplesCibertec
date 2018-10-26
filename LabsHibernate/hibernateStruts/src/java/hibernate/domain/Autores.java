package hibernate.domain;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class Autores implements java.io.Serializable {

    private static final long serialVersionUID = 1L;

    private Integer idautor;
    private String autor;
    private Set<Frases> fraseses = new LinkedHashSet<>(); //HashSet : desordenado

    public Autores() {
    }

    public Autores(String autor) {
        this.autor = autor;
    }

    public Autores(String autor, Set<Frases> fraseses) {
        this.autor = autor;
        this.fraseses = fraseses;
    }

    public Integer getIdautor() {
        return this.idautor;
    }

    public void setIdautor(Integer idautor) {
        this.idautor = idautor;
    }

    public String getAutor() {
        return this.autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public Set<Frases> getFraseses() {
        return this.fraseses;
    }

    public void setFraseses(Set<Frases> fraseses) {
        this.fraseses = fraseses;
    }

}
