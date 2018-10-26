package test;

import dao.DaoTutoriales;
import dao.impl.DaoTutorialesImpl;
import hibernate.domain.Tutoriales;

public class TestIns {

    public static void main(String[] args) {

        DaoTutoriales daoTutoriales = new DaoTutorialesImpl();
        Tutoriales tutoriales = new Tutoriales();

        tutoriales.setTitulo("cccc2 dddd3");
        tutoriales.setTipo("Video");
        tutoriales.setPrecio(20d);

        String msg = daoTutoriales.tutorialesIns(tutoriales);

        if (msg == null) {
            System.out.println(":)");

        } else {
            System.out.println(msg);
        }
    }

}
