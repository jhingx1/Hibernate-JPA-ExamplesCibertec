package pruebas;

import hibernate.Employee;
import java.util.Iterator;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.Transaction;

public class ManageEmployee {

    private static SessionFactory factory;

    public static void main(String[] args) {
        //obligatorio
        /*
        Session session
                = HibernateUtil.getSessionFactory().getCurrentSession();        
        session.beginTransaction();
        //--------
        String s = "from Alumnos where idalumno = 1";//sentencia hql, no es la tabla. Siempre com mayuscula la primera
        Query query = session.createQuery(s);
        List<Employee> results = query.list();
         */
 /*
        Iterator<Alumnos> it = query.iterate();
        while (it.hasNext()) {
            Employee a = it.next();
            //
            System.out.println(a.getIdalumno() + "\t" + a.getNombre());
        }
         */
 /*
        for(Employee a:results){
            System.out.println(a.getIdalumno() + a.getNombre());
        }
         */

        //Obligatorio        
        //session.getTransaction().commit();
        try {
            factory = new Configuration().configure().buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("Fallo al crear el objeto sessionFactory." + ex);
            throw new ExceptionInInitializerError(ex);
        }

        ManageEmployee ME = new ManageEmployee();

        //Agregar registros a la BD
        Integer empID1 = ME.addEmployee("Wendy", "Villalobos", 1000);
        //Integer empID2 = ME.addEmployee("Daisy", "Das", 5000);
        //Integer empID3 = ME.addEmployee("John", "Paul", 10000);        
                
        //Lista abajo todos los empleados
        //ME.listEmployees();
        //Actualizar los registros del empleado
        ME.updateEmployee(empID1, 5000);
        //Eliminar un empleado de la base de datos 
        //ME.deleteEmployee(9);
        //Lista nueva lista de los empleados
        //ME.listEmployees();
        /*
        for(int i=1;i<=8;i++){
            ME.deleteEmployee(i);
        }
        */
    }

    //creando el metodo para agregar empleados a la BD.
    public Integer addEmployee(String fname, String lname, int salary) {
        
        Session session = factory.openSession();
        Transaction tx = null;
        Integer employeeID = null;

        try {
            tx = session.beginTransaction();
            Employee employee = new Employee(fname, lname, salary);
            employeeID = (Integer) session.save(employee);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return employeeID;
    }
    
    //Método para LEER a todos los empleados.
    public void listEmployees( ){
      Session session = factory.openSession();
      Transaction tx = null;
      
      try {
         tx = session.beginTransaction();
         List employees = session.createQuery("FROM Employee").list(); 
         for (Iterator iterator = employees.iterator(); iterator.hasNext();){
            Employee employee = (Employee) iterator.next(); 
            System.out.print("First Name: " + employee.getFirstName()); 
            System.out.print("  Last Name: " + employee.getLastName()); 
            System.out.println("  Salary: " + employee.getSalary()); 
         }
         tx.commit();
      } catch (HibernateException e) {
         if (tx!=null) tx.rollback();
         e.printStackTrace(); 
      } finally {
         session.close(); 
      }
   }

    /* Method to UPDATE salary for an employee */
   public void updateEmployee(Integer EmployeeID, int salary ){
      Session session = factory.openSession();
      Transaction tx = null;
      
      try {
         tx = session.beginTransaction();
         Employee employee = (Employee)session.get(Employee.class, EmployeeID); 
         employee.setSalary( salary );
		 session.update(employee); 
         tx.commit();
      } catch (HibernateException e) {
         if (tx!=null) tx.rollback();
         e.printStackTrace(); 
      } finally {
         session.close(); 
      }
   }
   
    /* Method to DELETE an employee from the records */
   public void deleteEmployee(Integer EmployeeID){
      Session session = factory.openSession();
      Transaction tx = null;
      
      try {
         tx = session.beginTransaction();
         Employee employee = (Employee)session.get(Employee.class, EmployeeID); 
         session.delete(employee); 
         tx.commit();
      } catch (HibernateException e) {
         if (tx!=null) tx.rollback();
         e.printStackTrace(); 
      } finally {
         session.close(); 
      }
   }
    
    
}
