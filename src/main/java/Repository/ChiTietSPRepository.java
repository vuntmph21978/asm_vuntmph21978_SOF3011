package Repository;

import Model.ChiTietSP;
import Utility.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;


import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ChiTietSPRepository {
    public List<ChiTietSP> getAll(){
        List<ChiTietSP> listCtsp = new ArrayList<>();
        try(Session session = HibernateUtil.getFACTORY().openSession()) {
            Query query = session.createQuery("from ChiTietSP", ChiTietSP.class);
            listCtsp = query.getResultList();
        }catch (Exception e){
            e.printStackTrace();
        }
        return listCtsp;
    }

    public ChiTietSP getByID(UUID id){
        ChiTietSP ctsp = new ChiTietSP();
        try(Session session = HibernateUtil.getFACTORY().openSession()) {
            ctsp = session.get(ChiTietSP.class, id);
        }catch (Exception e){
            e.printStackTrace();
        }
        return ctsp;
    }

    public Boolean Add(ChiTietSP chiTietSP){
        Transaction transaction = null;
        try(Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.save(chiTietSP);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    public Boolean Update(ChiTietSP chiTietSP){
        Transaction transaction = null;
        try(Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.merge(chiTietSP);
            transaction.commit();
            return true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    public Boolean Delete(ChiTietSP chiTietSP){
        Transaction transaction = null;
        try(Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.delete(chiTietSP);
            transaction.commit();
            return true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    public static void main(String[] args) {
        new ChiTietSPRepository().Add(new ChiTietSP(2003,"không",100,20000,40000));

    }

}
