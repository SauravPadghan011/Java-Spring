package operation;

import entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Scanner;

public class DeleteOperation {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session session = sessionFactory.getCurrentSession();

        try{
            System.out.println("====DELETE by ID====");
            Scanner scan = new Scanner(System.in);
            System.out.print("Enter ID: ");
            int id = scan.nextInt();

            session.beginTransaction();
//            Student student = session.get(Student.class, id);
//            if(student!=null) {
//                session.delete(student);
//                System.out.println("Student with ID %d Deleted");
//            } else {
//                System.out.println("Student NOT Found");
//            }

            session.createQuery("delete from Student s where s.id=1").executeUpdate();
            session.getTransaction().commit();

        } catch (Exception e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            session.close();
            sessionFactory.close();
        }
    }
}

