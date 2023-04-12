package Repository;

import Model.NSX;
import Utility.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class NSXRepository {
    public List<NSX> getAll(){
        List<NSX> listNsx = new ArrayList<>();
        try(Session session = HibernateUtil.getFACTORY().openSession()) {
            Query query = session.createQuery("from NSX",NSX.class);
            listNsx = query.getResultList();
        }catch (Exception e){
            e.printStackTrace();
        }
        return listNsx;
    }

    public NSX getById(UUID id){
        NSX nsx = new NSX();
        try(Session session = HibernateUtil.getFACTORY().openSession()) {
            nsx = session.get(NSX.class, id);
        }catch (Exception e){
            e.printStackTrace();
        }
        return nsx;
    }

    public Boolean add(NSX nsx){
        Transaction transaction = null;
        try(Session session = HibernateUtil.getFACTORY().openSession()) {
           transaction = session.beginTransaction();
           session.persist(nsx);
           transaction.commit();
           return true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    public Boolean update(NSX nsx){
        Transaction transaction = null;
        try(Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.merge(nsx);
            transaction.commit();
            return true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }
    public Boolean delete(NSX nsx){
        Transaction transaction = null;
        try(Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.delete(nsx);
            transaction.commit();
            return true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }
}
