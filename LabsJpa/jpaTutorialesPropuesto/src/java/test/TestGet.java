package test;

import dao.DaoTutoriales;
import dao.impl.DaoTutorialesImpl;
import hibernate.domain.Tutoriales;

public class TestGet {

    public static void main(String[] args) {

        DaoTutoriales daoTutoriales = new DaoTutorialesImpl();

        Tutoriales tutoriales = daoTutoriales.tutorialesGet(9);

        if (tutoriales != null) {
            System.out.println(tutoriales.getTitulo());

        } else {
            System.out.println(daoTutoriales.getMessage());
        }
    }

}
