package managers;

import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.persistence.EntityManager;
import javax.persistence.TemporalType;

import model.Admin;
import model.Clanarina;
import model.Igrac;
import model.LekarskiPregled;
import model.PrijavaZaTurnir;
import model.Sparing;
import model.Termin;
import model.Trener;
import model.Trening;
import model.Turnir;

public class IgracManager {

	public Igrac dodajIgraca(String ime, String prezime, Date datumRodjenja, Date datumUpisa, String pol, String adresa,
			boolean uradjenPregled) {
		EntityManager em = JPAUtil.getEntityManager();
		em.getTransaction().begin();

		Igrac i = new Igrac();
		i.setIme(ime);
		i.setPrezime(prezime);
		i.setPol(pol);
		i.setDatumUpisa(datumUpisa);
		i.setDatumRodjenja(datumRodjenja);
		i.setAdresa(adresa);
		Random r = new Random();
		int br = r.nextInt(100000);
		i.setUsername(ime + prezime + br);
		i.setPassword(ime + prezime);
		Clanarina c = new Clanarina();
		c.setIznos(2000);
		c.setIgrac(i);
		c.setDatumUplate(datumUpisa);
		em.persist(i);
		em.persist(c);
		if (uradjenPregled) {
			LekarskiPregled lp = new LekarskiPregled();
			lp.setDatumPregleda(new Date());
			Date doKadaVazi = new Date();
			doKadaVazi.setYear(new Date().getYear() + 1);
			lp.setDatumDoKadaVazi(doKadaVazi);
			lp.setIgrac(i);
			em.persist(lp);
		}

		em.getTransaction().commit();
		em.close();
		return i;
	}

	public void izbrisiIgraca(int id) {
		EntityManager em = JPAUtil.getEntityManager();
		em.getTransaction().begin();
		Igrac i = em.find(Igrac.class, id);

		List<LekarskiPregled> pregledi = em.createQuery("SELECT p FROM LekarskiPregled p where p.igrac=:igrac")
				.setParameter("igrac", i).getResultList();
		for (LekarskiPregled p : pregledi) {
			em.remove(p);
		}

		List<Clanarina> clanarine = em.createQuery("SELECT c FROM Clanarina c where c.igrac=:igrac")
				.setParameter("igrac", i).getResultList();
		for (Clanarina c : clanarine) {
			em.remove(c);
		}

		List<Sparing> sparinzi = vratiSparingeIgraca(i);
		for (Sparing s : sparinzi) {
			em.remove(s);
		}

		List<Trening> treninzi = vratiTreningeIgraca(i);
		for (Trening t : treninzi) {
			em.remove(t);
		}

		em.remove(i);
		em.getTransaction().commit();
		em.close();
	}

	public boolean izmeniIgraca(int id, String ime, String prezime, Date datumRodjenja, Date datumUpisa, String pol,
			String adresa, boolean uradjenPregled, boolean placenaClanarina) {
		EntityManager em = JPAUtil.getEntityManager();
		em.getTransaction().begin();

		Igrac i = em.find(Igrac.class, id);
		i.setIme(ime);
		i.setPrezime(prezime);
		i.setPol(pol);
//		i.setDatumUpisa(datumUpisa);
//		i.setDatumRodjenja(datumRodjenja);
		i.setAdresa(adresa);

		if (uradjenPregled) {
			LekarskiPregled lp = new LekarskiPregled();
			lp.setDatumPregleda(new Date());
			Date doKadaVazi = new Date();
			doKadaVazi.setYear(new Date().getYear() + 1);
			lp.setDatumDoKadaVazi(doKadaVazi);
			lp.setIgrac(i);
			em.persist(lp);
		}

		if (placenaClanarina) {
			Clanarina c = new Clanarina();
			c.setDatumUplate(new Date());
			c.setIgrac(i);
			c.setIznos(2000);
			em.persist(c);
		}

		em.merge(i);
		em.getTransaction().commit();
		em.close();
		return true;
	}

	// igracu dodati username i password
	public Igrac login(String username, String password) {
		EntityManager em = JPAUtil.getEntityManager();
		try {
			Igrac i = (Igrac) em
					.createQuery("SELECT i FROM Igrac i where i.username=:username AND i.password=:password")
					.setParameter("username", username).setParameter("password", password).getSingleResult();
			em.close();
			return i;
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
	}

	public boolean izmeniLozinku(String newPassword, Igrac i) {
		EntityManager em = JPAUtil.getEntityManager();
		em.getTransaction().begin();
		i.setPassword(newPassword);
		em.merge(i);
		em.getTransaction().commit();
		em.close();
		return true;
	}

	public boolean prijaviSeZaTurnir(Igrac i, int idTurnira) {
		int godine = new Date().getYear() - i.getDatumRodjenja().getYear();
		EntityManager em = JPAUtil.getEntityManager();

		Turnir t = em.find(Turnir.class, idTurnira);

		// if (t.getPol().equals(i.getPol()) && t.getKonkurencija() - godine >=
		// 0 && t.getKonkurencija() - godine <= 4) {
		PrijavaZaTurnir pzt = new PrijavaZaTurnir();
		pzt.setDatumPrijave(new Date());
		pzt.setIgrac(i);
		pzt.setTurnir(t);
		em.getTransaction().begin();
		em.persist(pzt);
		em.getTransaction().commit();
		em.close();
		return true;
		// }

		// return false;
	}

	public boolean zakaziSparing(Igrac i1, int i2id, Date datum, int teren, int trajanje, Time vreme) {
		EntityManager em = JPAUtil.getEntityManager();
		em.getTransaction().begin();
		Termin t = new Termin();
		t.setDatum(datum);
		t.setTeren(teren);
		t.setTrajanje(trajanje);
		t.setVreme(vreme);
		em.persist(t);

		Igrac i2 = em.find(Igrac.class, i2id);

		Sparing s = new Sparing();
		s.setIgrac1(i1);
		s.setIgrac2(i2);
		s.setTermin(t);
		em.persist(s);

		em.getTransaction().commit();
		em.close();

		return true;
	}

	public boolean zakaziTrening(Igrac i1, int trener, Date datum, int teren, int trajanje, Time vreme, String tip) {

		EntityManager em = JPAUtil.getEntityManager();
		Trener tren = em.find(Trener.class, trener);
		em.getTransaction().begin();
		Termin t = new Termin();
		t.setDatum(datum);
		t.setTeren(teren);
		t.setTrajanje(trajanje);
		t.setVreme(vreme);
		em.persist(t);

		Trening trening = new Trening();
		trening.setIgrac(i1);
		trening.setTermin(t);
		trening.setTrener(tren);
		trening.setTipTreninga(tip);

		em.persist(trening);

		em.getTransaction().commit();
		em.close();

		return true;

	}

	public List<Igrac> vratiSveIgrace() {
		EntityManager em = JPAUtil.getEntityManager();
		List<Igrac> igraci = em.createNamedQuery("Igrac.findAll").getResultList();
		em.close();
		return igraci;
	}

	public List<Igrac> vratiIgraceBezTekuceg(Igrac i) {
		EntityManager em = JPAUtil.getEntityManager();
		List<Igrac> igraci = (List<Igrac>) em
				.createQuery("SELECT i FROM Igrac i WHERE i NOT IN (SELECT i FROM Igrac i where i=:igrac)")
				.setParameter("igrac", i).getResultList();
		em.close();
		return igraci;
	}

	public Igrac vratiIgraca(int idIgraca) {
		EntityManager em = JPAUtil.getEntityManager();
		Igrac i = em.find(Igrac.class, idIgraca);
		return i;
	}

	public List<Sparing> vratiSparingeIgraca(Igrac i) {
		EntityManager em = JPAUtil.getEntityManager();
		List<Sparing> sparinzi = em.createQuery("SELECT s FROM Sparing s where s.igrac1=:igrac OR s.igrac2=:igrac")
				.setParameter("igrac", i).getResultList();
		return sparinzi;
	}

	public List<Sparing> vratiSparingeIgracaZaPeriod(Igrac i, Date datumOd, Date datumDo) {
		EntityManager em = JPAUtil.getEntityManager();
		List<Sparing> sparinzi = null;

		if (datumDo == null && datumOd == null) {
			System.out.println("aaaaaaaaaaaaaa");
			sparinzi = vratiSparingeIgraca(i);
		} else if (datumDo != null && datumOd == null) {
			System.out.println("6666");
			sparinzi = em
					.createQuery(
							"SELECT s FROM Sparing s where s.igrac1=:igrac OR s.igrac2=:igrac AND s.termin.datum <:datumDo")
					.setParameter("datumDo", datumDo, TemporalType.DATE).setParameter("igrac", i).getResultList();
		} else if (datumOd != null && datumDo == null) {
			System.out.println("55555");
			sparinzi = em
					.createQuery(
							"SELECT s FROM Sparing s where s.igrac1=:igrac OR s.igrac2=:igrac AND s.termin.datum >:datumOd")
					.setParameter("datumOd", datumOd, TemporalType.DATE).setParameter("igrac", i).getResultList();
		} else {
			System.out.println("33333");
			sparinzi = em
					.createQuery(
							"SELECT s FROM Sparing s where s.igrac1=:igrac OR s.igrac2=:igrac AND s.termin.datum BETWEEN :datumOd AND :datumDo")
					.setParameter("datumOd", datumOd, TemporalType.DATE)
					.setParameter("datumDo", datumDo, TemporalType.DATE).setParameter("igrac", i).getResultList();
		}

		System.out.println(sparinzi.size());
		return sparinzi;
	}

	public List<Trening> vratiTreningeIgraca(Igrac i) {
		EntityManager em = JPAUtil.getEntityManager();
		List<Trening> treninzi = em.createQuery("SELECT t FROM Trening t where t.igrac=:igrac").setParameter("igrac", i)
				.getResultList();
		return treninzi;
	}

	public List<Trening> vratiTreningeIgracaZaPeriod(Igrac i, Date datumOd, Date datumDo) {
		EntityManager em = JPAUtil.getEntityManager();
		List<Trening> treninzi = null;

		if (datumDo == null && datumOd == null) {
			System.out.println("aaaaaaaaaaaaaa");
			treninzi = vratiTreningeIgraca(i);
		} else if (datumDo != null && datumOd == null) {
			System.out.println("6666");
			treninzi = em.createQuery("SELECT t FROM Trening t where t.igrac=:igrac AND t.termin.datum <:datumDo")
					.setParameter("datumDo", datumDo, TemporalType.DATE).setParameter("igrac", i).getResultList();
		} else if (datumOd != null && datumDo == null) {
			System.out.println("55555");
			treninzi = em.createQuery("SELECT t FROM Trening t where t.igrac=:igrac AND t.termin.datum >:datumOd")
					.setParameter("datumOd", datumOd, TemporalType.DATE).setParameter("igrac", i).getResultList();
		} else {
			System.out.println("33333");
			treninzi = em
					.createQuery(
							"SELECT t FROM Trening t where t.igrac=:igrac AND t.termin.datum BETWEEN :datumOd AND :datumDo")
					.setParameter("datumOd", datumOd, TemporalType.DATE)
					.setParameter("datumDo", datumDo, TemporalType.DATE).setParameter("igrac", i).getResultList();
		}

		return treninzi;
	}

	public Clanarina vratiPoslednjuClanarinuClana(Igrac i) {
		EntityManager em = JPAUtil.getEntityManager();
		Clanarina c = (Clanarina) em.createQuery("SELECT MAX(c) FROM Clanarina c where c.igrac=:igrac")
				.setParameter("igrac", i).getSingleResult();
		return c;
	}

	public LekarskiPregled vratiPoslednjiLekarskiClana(Igrac i) {
		EntityManager em = JPAUtil.getEntityManager();
		LekarskiPregled lp = (LekarskiPregled) em
				.createQuery("SELECT MAX(l) FROM LekarskiPregled l where l.igrac=:igrac").setParameter("igrac", i)
				.getSingleResult();
		return lp;
	}
}
