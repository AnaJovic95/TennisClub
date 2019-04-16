package managers;

import javax.persistence.EntityManager;

import model.Admin;

public class AdminManager {

	public Admin login(String username, String password) {
		EntityManager em = JPAUtil.getEntityManager();
		try {
			Admin a = (Admin) em
					.createQuery("SELECT a FROM Admin a where a.username=:username AND a.password=:password")
					.setParameter("username", username).setParameter("password", password).getSingleResult();
			return a;
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}finally{
			em.close();
		}

	}
}
