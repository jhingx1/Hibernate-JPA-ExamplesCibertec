package hibernate;

public class Notas implements java.io.Serializable {

    private Integer idnota;
    private Alumnos alumnos;
    private short nota;

    public Notas() {
    }

    public Notas(Alumnos alumnos, short nota) {
        this.alumnos = alumnos;
        this.nota = nota;
    }

    public Integer getIdnota() {
        return this.idnota;
    }

    public void setIdnota(Integer idnota) {
        this.idnota = idnota;
    }

    public Alumnos getAlumnos() {
        return this.alumnos;
    }

    public void setAlumnos(Alumnos alumnos) {
        this.alumnos = alumnos;
    }

    public short getNota() {
        return this.nota;
    }

    public void setNota(short nota) {
        this.nota = nota;
    }

}
