package Repository;

import Model.SanPham;
import Utility.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class SanPhamRepository {

    public List<SanPham> getAll(){
        List<SanPham> listSp = new ArrayList<>();
        try(Session session = HibernateUtil.getFACTORY().openSession()) {
            Query query = session.createQuery("from SanPham", SanPham.class);
            listSp = query.getResultList();
        }catch (Exception e){
            e.printStackTrace();
        }
        return listSp;
    }

    public SanPham getById(UUID id){
        SanPham sp = new SanPham();
        try(Session session = HibernateUtil.getFACTORY().openSession()) {
            sp = session.get(SanPham.class, id);
        }catch (Exception e){
            e.printStackTrace();
        }
        return sp;
    }

    public Boolean add(SanPham sanPham){
        Transaction transaction = null;
        try(Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.persist(sanPham);
            transaction.commit();
            return true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }
    public Boolean update(SanPham sanPham){
        Transaction transaction = null;
        try(Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.merge(sanPham);
            transaction.commit();
            return true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }
    public Boolean delete(SanPham sanPham){
        Transaction transaction = null;
        try(Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.delete(sanPham);
            transaction.commit();
            return true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

}
