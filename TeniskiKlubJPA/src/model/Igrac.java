package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the Igrac database table.
 * 
 */
@Entity
@NamedQuery(name="Igrac.findAll", query="SELECT i FROM Igrac i")
public class Igrac implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idIgrac;

	private String adresa;

	@Temporal(TemporalType.DATE)
	private Date datumRodjenja;

	@Temporal(TemporalType.DATE)
	private Date datumUpisa;

	private String ime;

	private String password;

	private String pol;

	private String prezime;

	private String username;

	//bi-directional many-to-one association to Clanarina
	@OneToMany(mappedBy="igrac")
	private List<Clanarina> clanarinas;

	//bi-directional many-to-one association to LekarskiPregled
	@OneToMany(mappedBy="igrac")
	private List<LekarskiPregled> lekarskiPregleds;

	//bi-directional many-to-one association to PrijavaZaTurnir
	@OneToMany(mappedBy="igrac")
	private List<PrijavaZaTurnir> prijavaZaTurnirs;

	//bi-directional many-to-one association to Sparing
	@OneToMany(mappedBy="igrac1")
	private List<Sparing> sparings1;

	//bi-directional many-to-one association to Sparing
	@OneToMany(mappedBy="igrac2")
	private List<Sparing> sparings2;

	//bi-directional many-to-one association to Trening
	@OneToMany(mappedBy="igrac")
	private List<Trening> trenings;

	public Igrac() {
	}

	public int getIdIgrac() {
		return this.idIgrac;
	}

	public void setIdIgrac(int idIgrac) {
		this.idIgrac = idIgrac;
	}

	public String getAdresa() {
		return this.adresa;
	}

	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}

	public Date getDatumRodjenja() {
		return this.datumRodjenja;
	}

	public void setDatumRodjenja(Date datumRodjenja) {
		this.datumRodjenja = datumRodjenja;
	}

	public Date getDatumUpisa() {
		return this.datumUpisa;
	}

	public void setDatumUpisa(Date datumUpisa) {
		this.datumUpisa = datumUpisa;
	}

	public String getIme() {
		return this.ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPol() {
		return this.pol;
	}

	public void setPol(String pol) {
		this.pol = pol;
	}

	public String getPrezime() {
		return this.prezime;
	}

	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public List<Clanarina> getClanarinas() {
		return this.clanarinas;
	}

	public void setClanarinas(List<Clanarina> clanarinas) {
		this.clanarinas = clanarinas;
	}

	public Clanarina addClanarina(Clanarina clanarina) {
		getClanarinas().add(clanarina);
		clanarina.setIgrac(this);

		return clanarina;
	}

	public Clanarina removeClanarina(Clanarina clanarina) {
		getClanarinas().remove(clanarina);
		clanarina.setIgrac(null);

		return clanarina;
	}

	public List<LekarskiPregled> getLekarskiPregleds() {
		return this.lekarskiPregleds;
	}

	public void setLekarskiPregleds(List<LekarskiPregled> lekarskiPregleds) {
		this.lekarskiPregleds = lekarskiPregleds;
	}

	public LekarskiPregled addLekarskiPregled(LekarskiPregled lekarskiPregled) {
		getLekarskiPregleds().add(lekarskiPregled);
		lekarskiPregled.setIgrac(this);

		return lekarskiPregled;
	}

	public LekarskiPregled removeLekarskiPregled(LekarskiPregled lekarskiPregled) {
		getLekarskiPregleds().remove(lekarskiPregled);
		lekarskiPregled.setIgrac(null);

		return lekarskiPregled;
	}

	public List<PrijavaZaTurnir> getPrijavaZaTurnirs() {
		return this.prijavaZaTurnirs;
	}

	public void setPrijavaZaTurnirs(List<PrijavaZaTurnir> prijavaZaTurnirs) {
		this.prijavaZaTurnirs = prijavaZaTurnirs;
	}

	public PrijavaZaTurnir addPrijavaZaTurnir(PrijavaZaTurnir prijavaZaTurnir) {
		getPrijavaZaTurnirs().add(prijavaZaTurnir);
		prijavaZaTurnir.setIgrac(this);

		return prijavaZaTurnir;
	}

	public PrijavaZaTurnir removePrijavaZaTurnir(PrijavaZaTurnir prijavaZaTurnir) {
		getPrijavaZaTurnirs().remove(prijavaZaTurnir);
		prijavaZaTurnir.setIgrac(null);

		return prijavaZaTurnir;
	}

	public List<Sparing> getSparings1() {
		return this.sparings1;
	}

	public void setSparings1(List<Sparing> sparings1) {
		this.sparings1 = sparings1;
	}

	public Sparing addSparings1(Sparing sparings1) {
		getSparings1().add(sparings1);
		sparings1.setIgrac1(this);

		return sparings1;
	}

	public Sparing removeSparings1(Sparing sparings1) {
		getSparings1().remove(sparings1);
		sparings1.setIgrac1(null);

		return sparings1;
	}

	public List<Sparing> getSparings2() {
		return this.sparings2;
	}

	public void setSparings2(List<Sparing> sparings2) {
		this.sparings2 = sparings2;
	}

	public Sparing addSparings2(Sparing sparings2) {
		getSparings2().add(sparings2);
		sparings2.setIgrac2(this);

		return sparings2;
	}

	public Sparing removeSparings2(Sparing sparings2) {
		getSparings2().remove(sparings2);
		sparings2.setIgrac2(null);

		return sparings2;
	}

	public List<Trening> getTrenings() {
		return this.trenings;
	}

	public void setTrenings(List<Trening> trenings) {
		this.trenings = trenings;
	}

	public Trening addTrening(Trening trening) {
		getTrenings().add(trening);
		trening.setIgrac(this);

		return trening;
	}

	public Trening removeTrening(Trening trening) {
		getTrenings().remove(trening);
		trening.setIgrac(null);

		return trening;
	}

}