package myPacket.dto;

import myPacket.request.Request;
import myPacket.util.HibernateSessionFactoryUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

@Repository
public class RequestDTO {
    CalculationRequestDTO smth;

    public Request findById(int id) {
        return HibernateSessionFactoryUtil.getSessionFactory()
                .openSession().get(Request.class, id);
    }

    public void save(Request request) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Query query = session.createQuery("SELECT 1 FROM Request r WHERE r.symbol = :sym");
        query.setParameter("sym", smth.getSymbol());
    try {
        session.beginTransaction();
            if (query.list().isEmpty()) {
            session.save(request);
            } else {
                Query updateQuery = session.createQuery("UPDATE Request r SET r.result = :newResult WHERE r.symbol = :sym");
                updateQuery.setParameter("newResult", request.getResult());
                updateQuery.setParameter("sym", smth.getSymbol());

                updateQuery.executeUpdate();
            }
            session.getTransaction().commit();

    } catch (Exception e) {
        System.out.println(e);
    } finally {
        session.close();
    }
    }



    public void update(Request request) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(request);
        tx1.commit();
        session.close();
    }

    public void delete(Request request) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(request);
        tx1.commit();
        session.close();
    }

    public void setSmth(CalculationRequestDTO smth) {
        this.smth = smth;
    }
}
