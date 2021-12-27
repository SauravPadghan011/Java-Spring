package operation;

import entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;
import java.util.Scanner;

public class WriteOperation {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session session = sessionFactory.getCurrentSession();
        try{
            Scanner scanner = new Scanner(System.in);
            System.out.print("Please enter ID to read from DB: ");
            int id = scanner.nextInt();

            session.beginTransaction();
            /**
             * Fetching the data from DB based on Primary Key (ID)
             * If ID is not found then student is null
             */
            Student student = session.get(Student.class, id);
            if(student!=null){
                System.out.println("Details of Fetched Student\n"+student);
            } else {
                System.out.println("Student NOT Found");
            }

            System.out.println("\n--------Fetch All Data----------");
            List<Student> studentList = session.createQuery("FROM Student").getResultList();
            for(Student s: studentList)
                System.out.println(s);

            System.out.println("\n--------Search By First Name----------");
            System.out.print("Enter First Name: ");
            String firstName = scanner.next();
            List<Student> fNameList =
                    session.createQuery(String.format("from Student s where s.firstName='%s'", firstName)).getResultList();
            for(Student s: fNameList)
                System.out.println(s);

            session.getTransaction().commit();

        } catch(Exception e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        }
    }
}
