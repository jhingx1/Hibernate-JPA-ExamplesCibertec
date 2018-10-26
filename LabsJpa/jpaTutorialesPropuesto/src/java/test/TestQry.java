package test;

import dao.DaoTutoriales;
import dao.impl.DaoTutorialesImpl;
import hibernate.domain.Tutoriales;
import java.util.List;

public class TestQry {

    public static void main(String[] args) {

        DaoTutoriales daoTutoriales = new DaoTutorialesImpl();
        List<Tutoriales> list = daoTutoriales.tutorialesQry();

        if (list != null) {
            list.forEach((tutoriales) -> {
                System.out.println(tutoriales.getIdtutorial() + " - " + tutoriales.getTitulo());
            });
            
        } else {
            System.out.println(daoTutoriales.getMessage());
        }
    }

}
