package Repository;

import Model.MauSac;
import Utility.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class MauSacRepository {

    public List<MauSac> getAll(){
        List<MauSac> listMs = new ArrayList<>();
        try(Session session = HibernateUtil.getFACTORY().openSession()) {
            Query query = session.createQuery("from MauSac", MauSac.class);
            listMs = query.getResultList();
        }catch (Exception e){
            e.printStackTrace();
        }
        return listMs;
    }

    public MauSac getById(UUID id){
        MauSac ms = new MauSac();
        try(Session session = HibernateUtil.getFACTORY().openSession()) {
            ms = session.get(MauSac.class, id);
        }catch (Exception e){
            e.printStackTrace();
        }
        return ms;
    }

    public Boolean add(MauSac mauSac){
        Transaction transaction = null;
        try(Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.persist(mauSac);
            transaction.commit();
            return true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }
    public Boolean update(MauSac mauSac){
        Transaction transaction = null;
        try(Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.merge(mauSac);
            transaction.commit();
            return true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }
    public Boolean delete(MauSac mauSac){
        Transaction transaction = null;
        try(Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.delete(mauSac);
            transaction.commit();
            return true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }


}
