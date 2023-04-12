package Repository;

import Model.NhanVien;
import Utility.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class NhanVienRepository {
    public List<NhanVien> getAll(){
        List<NhanVien> listNv = new ArrayList<>();
        try(Session session = HibernateUtil.getFACTORY().openSession()) {
            Query query = session.createQuery("from NhanVien", NhanVien.class);
            listNv = query.getResultList();
        }catch (Exception e){
            e.printStackTrace();
        }
        return listNv;
    }

    public NhanVien getById(UUID id){
        NhanVien nv = new NhanVien();
        try(Session session = HibernateUtil.getFACTORY().openSession()) {
            nv = session.get(NhanVien.class, id);
        }catch (Exception e){
            e.printStackTrace();
        }
        return nv;
    }

    public Boolean add(NhanVien nhanVien){
        Transaction transaction = null;
        try(Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.persist(nhanVien);
            transaction.commit();
            return true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }
    public Boolean update(NhanVien nhanVien){
        Transaction transaction = null;
        try(Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.merge(nhanVien);
            transaction.commit();
            return true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }
    public Boolean delete(NhanVien nhanVien){
        Transaction transaction = null;
        try(Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.delete(nhanVien);
            transaction.commit();
            return true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

}
