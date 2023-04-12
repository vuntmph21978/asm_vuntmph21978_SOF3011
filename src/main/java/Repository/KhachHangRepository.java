package Repository;

import Model.KhachHang;
import Utility.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class KhachHangRepository {
    List<KhachHang> listKhachHang = new ArrayList<>();
    public List<KhachHang> getAll(){
        try (Session session = HibernateUtil.getFACTORY().openSession()){
            Query query = session.createQuery("select v from KhachHang v ",KhachHang.class);
            listKhachHang = query.getResultList();
        }
        return listKhachHang;
    }
    public KhachHang getById(UUID id){
        KhachHang khachHang = new KhachHang();
        try (Session session = HibernateUtil.getFACTORY().openSession()){
           khachHang = session.get(KhachHang.class,id);
        }
        return khachHang;
    }
    public Boolean add(KhachHang khachHang){
        Transaction transaction = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()){
            transaction = session.beginTransaction();
            session.persist(khachHang);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }
    public Boolean update(KhachHang khachHang){
        Transaction transaction = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()){
            transaction = session.beginTransaction();
            session.merge(khachHang);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }
    public void delete(KhachHang khachHang){
        Transaction transaction = null;
        try(Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.delete(khachHang);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new KhachHangRepository().getAll().forEach(s-> System.out.println(s));
    }
}
