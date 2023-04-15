package Repository;

import Model.User;
import Utility.HibernateUtil;
import org.hibernate.Session;

import javax.persistence.Query;

public class LoginRepository {
    public Boolean validate(String username, String password){
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            String hql = "from User u where u.username = :username and u.password = :password";
            Query query = session.createQuery(hql, User.class);
            query.setParameter("username", username);
            query.setParameter("password", password);
            User user = (User) ((org.hibernate.query.Query<?>) query).uniqueResult();
            return user != null;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

}
