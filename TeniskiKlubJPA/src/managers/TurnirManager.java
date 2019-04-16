package managers;

import java.util.List;

import javax.persistence.EntityManager;

import model.Turnir;

public class TurnirManager {

	public List<Turnir> vratiSveTurnire(){
		EntityManager em = JPAUtil.getEntityManager();
		List<Turnir> turniri = em.createNamedQuery("Turnir.findAll").getResultList();
		return turniri;
	}
}
