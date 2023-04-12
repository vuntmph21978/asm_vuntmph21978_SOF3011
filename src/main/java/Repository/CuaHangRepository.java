package Repository;

import Model.ChucVu;
import Model.CuaHang;
import Utility.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;


import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class CuaHangRepository {
    public List<CuaHang> getAll(){
        List<CuaHang> listCh = new ArrayList<>();
        try(Session session = HibernateUtil.getFACTORY().openSession()) {
            Query query = session.createQuery("from CuaHang", CuaHang.class);
            listCh = query.getResultList();
        }catch (Exception e){
            e.printStackTrace();
        }
        return listCh;
    }

    public CuaHang getById(UUID id){
        CuaHang ch = new CuaHang();
        try(Session session = HibernateUtil.getFACTORY().openSession()) {
            ch = session.get(CuaHang.class, id);
        }catch (Exception e){
            e.printStackTrace();
        }
        return ch;
    }

    public Boolean add(CuaHang cuaHang){
        Transaction transaction = null;
        try(Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.persist(cuaHang);
            transaction.commit();
            return true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }
    public Boolean update(CuaHang cuaHang){
        Transaction transaction = null;
        try(Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.merge(cuaHang);
            transaction.commit();
            return true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }
    public Boolean delete(CuaHang cuaHang){
        Transaction transaction = null;
        try(Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.delete(cuaHang);
            transaction.commit();
            return true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }
}
