package Repository;

import Model.ChucVu;
import Utility.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ChucVuRepository {
    public List<ChucVu> getAll() {
        List<ChucVu> listCv = new ArrayList<>();
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            Query query = session.createQuery(" from ChucVu ", ChucVu.class);
            listCv = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listCv;
    }

    public ChucVu getById(UUID id){
        ChucVu cv = new ChucVu();
        try(Session session = HibernateUtil.getFACTORY().openSession()) {
            cv = session.get(ChucVu.class, id);
        }catch (Exception e){
            e.printStackTrace();
        }
        return cv;
    }

    public Boolean add(ChucVu chucVu){
        Transaction transaction = null;
        try(Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.persist(chucVu);
            transaction.commit();
            return true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }
    public Boolean update(ChucVu chucVu){
        Transaction transaction = null;
        try(Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.merge(chucVu);
            transaction.commit();
            return true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }
    public Boolean delete(ChucVu chucVu){
        Transaction transaction = null;
        try(Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.delete(chucVu);
            transaction.commit();
            return true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    public static void main(String[] args) {
        new ChucVuRepository().getAll().forEach(x-> System.out.println(x));
    }

}

