package Repository;

import Model.ChucVu;
import Model.DongSP;
import Utility.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class DongSPRepository {
    public List<DongSP> getAll(){
        List<DongSP> listDsp = new ArrayList<>();
        try(Session session = HibernateUtil.getFACTORY().openSession()) {
            Query query = session.createQuery(" FROM DongSP ", DongSP.class);
            listDsp = query.getResultList();

        }catch (Exception e){
            e.printStackTrace();
        }
        return listDsp;
    }

    public DongSP getById(UUID id){
        DongSP dongSP = new DongSP();
        try(Session session = HibernateUtil.getFACTORY().openSession()) {
            dongSP = session.get(DongSP.class, id);
        }catch (Exception e){
            e.printStackTrace();
        }
        return dongSP;
    }

    public Boolean add(DongSP dongSP){
        Transaction transaction = null;
        try(Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.persist(dongSP);
            transaction.commit();
            return true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }
    public Boolean update(DongSP dongSP){
        Transaction transaction = null;
        try(Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.merge(dongSP);
            transaction.commit();
            return true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }
    public Boolean delete(DongSP dongSP){
        Transaction transaction = null;
        try(Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.delete(dongSP);
            transaction.commit();
            return true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    public static void main(String[] args) {
        new DongSPRepository().getAll().forEach(x-> System.out.println(x));
    }

}
