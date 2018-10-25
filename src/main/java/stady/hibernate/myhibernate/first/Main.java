package stady.hibernate.myhibernate.first;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class Main {

    public static void main(String[] args) {
        HibernateConnections hibernateConnection = new HibernateConnections();
        Configuration configuration = hibernateConnection.conn();
        SessionFactory sessionFactory = createSessionFactory(configuration);
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        UserMassage userMassage = new UserMassage();
        userMassage.setMessage("1111111");
        session.save(userMassage);
        transaction.commit();
        session.close();
        sessionFactory.close();

    }




    private static SessionFactory createSessionFactory(Configuration configuration) {
        StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder();
        builder.applySettings(configuration.getProperties());
        ServiceRegistry serviceRegistry = builder.build();
        return configuration.buildSessionFactory(serviceRegistry);
    }

}
