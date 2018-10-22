package hibernate.domain;

public class Frases implements java.io.Serializable {

    private static final long serialVersionUID = 1L;

    private Integer idfrase;
    private Autores autores;
    private String frase;

    public Frases() {
    }

    public Frases(Autores autores, String frase) {
        this.autores = autores;
        this.frase = frase;
    }

    public Integer getIdfrase() {
        return this.idfrase;
    }

    public void setIdfrase(Integer idfrase) {
        this.idfrase = idfrase;
    }

    public Autores getAutores() {
        return this.autores;
    }

    public void setAutores(Autores autores) {
        this.autores = autores;
    }

    public String getFrase() {
        return this.frase;
    }

    public void setFrase(String frase) {
        this.frase = frase;
    }

}
