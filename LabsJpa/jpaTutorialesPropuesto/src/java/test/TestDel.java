package test;

import dao.DaoTutoriales;
import dao.impl.DaoTutorialesImpl;

public class TestDel {

    public static void main(String[] args) {

        DaoTutoriales daoTutoriales = new DaoTutorialesImpl();

        String msg = daoTutoriales.tutorialesDel(10);

        if (msg == null) {
            System.out.println(":)");

        } else {
            System.out.println(msg);
        }
    }

}
