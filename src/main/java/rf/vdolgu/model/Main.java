package rf.vdolgu.model;

import org.hibernate.Session;
import rf.vdolgu.persistence.HibernateUtil;

/**
 * Created by mil on 17.04.15.
 */
public class Main {

    public static void main( String[] args )
    {
        System.out.println("Maven + Hibernate + MySQL");
        Session session = HibernateUtil.getSessionFactory().openSession();

        session.beginTransaction();

        Token token  = new Token();
        token.setToken("sdfsadf");


        session.save(token);


        session.getTransaction().commit();
    }
}
