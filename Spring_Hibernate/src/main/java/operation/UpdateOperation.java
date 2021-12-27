package operation;

import entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Scanner;

public class UpdateOperation {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session session = sessionFactory.getCurrentSession();

        try{
            System.out.println("====Update First Name for any given ID and save to DB====");
            Scanner scan = new Scanner(System.in);
            System.out.print("Enter ID: ");
            int id = scan.nextInt();

            session.beginTransaction();
//            Student student = session.get(Student.class, id);
//            if(student!=null){
//                System.out.print("Enter First Name to Update: ");
//                String firstName = scan.next();
//                student.setFirstName(firstName);
//            } else {
//                System.out.println("Data NOT Found");
//            }

            session.createQuery("UPDATE Student s set s.firstName='Lilly' where s.firstName='Steve'").executeUpdate();

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
