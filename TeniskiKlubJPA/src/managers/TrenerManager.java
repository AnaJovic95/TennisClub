package managers;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import model.Clanarina;
import model.Igrac;
import model.LekarskiPregled;
import model.Trener;
import model.Trening;

public class TrenerManager {

	public List<Trener> vratiSveTrenere() {
		EntityManager em = JPAUtil.getEntityManager();
		List<Trener> treneri = em.createNamedQuery("Trener.findAll").getResultList();
		em.close();
		return treneri;
	}

	public Trener dodajTrenera(String adresa, Date datumRodjenja, String ime, String prezime, String licenca) {
		EntityManager em = JPAUtil.getEntityManager();
		em.getTransaction().begin();

		Trener t = new Trener();
		t.setAdresa(adresa);
		t.setDatumRodjenja(datumRodjenja);
		t.setIme(ime);
		t.setPrezime(prezime);
		t.setLicenca(licenca);

		em.persist(t);
		em.getTransaction().commit();
		em.close();
		return t;
	}

	public void izbrisiTrenera(int id) {
		EntityManager em = JPAUtil.getEntityManager();
		em.getTransaction().begin();
		Trener t = em.find(Trener.class, id);

		List<Trening> treninzi = em.createQuery("SELECT t FROM Trening t where t.trener=:trener")
				.setParameter("trener", t).getResultList();
		for (Trening tr : treninzi) {
			em.remove(tr);
		}

		em.remove(t);
		em.getTransaction().commit();
		em.close();
	}

	public List<Trening> vratiTreningeTreneraZaPeriod(Date datumOd, Date datumDo, int idTrenera) {
		List<Trening> treninzi;
		EntityManager em = JPAUtil.getEntityManager();

		Trener t = em.find(Trener.class, idTrenera);
		
		treninzi = em
				.createQuery(
						"select distinct t from Trening t, Termin tr where t.trener = :trener and t.termin.datum BETWEEN :datumOd AND :datumDo")
				.setParameter("trener", t).setParameter("datumOd", datumOd, TemporalType.DATE)
				.setParameter("datumDo", datumDo, TemporalType.DATE).getResultList();
		
		System.out.println(treninzi.size());
		return treninzi;
	}
}
