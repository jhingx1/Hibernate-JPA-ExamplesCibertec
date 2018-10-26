package test;

import dao.DaoTutoriales;
import dao.impl.DaoTutorialesImpl;
import hibernate.domain.Tutoriales;

public class TestUpd {

    public static void main(String[] args) {

        DaoTutoriales daoTutoriales = new DaoTutorialesImpl();

        Tutoriales tutoriales = daoTutoriales.tutorialesGet(9);

        tutoriales.setTitulo("tutorial 9");

        String msg = daoTutoriales.tutorialesUpd(tutoriales);

        if (msg == null) {
            System.out.println(":)");

        } else {
            System.out.println(daoTutoriales.getMessage());
        }
    }

}
