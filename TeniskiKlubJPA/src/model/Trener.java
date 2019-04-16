package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the Trener database table.
 * 
 */
@Entity
@NamedQuery(name="Trener.findAll", query="SELECT t FROM Trener t")
public class Trener implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idTrener;

	private String adresa;

	@Temporal(TemporalType.DATE)
	private Date datumRodjenja;

	private String ime;

	private String licenca;

	private String prezime;

	//bi-directional many-to-one association to Trening
	@OneToMany(mappedBy="trener")
	private List<Trening> trenings;

	public Trener() {
	}

	public int getIdTrener() {
		return this.idTrener;
	}

	public void setIdTrener(int idTrener) {
		this.idTrener = idTrener;
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

	public String getIme() {
		return this.ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public String getLicenca() {
		return this.licenca;
	}

	public void setLicenca(String licenca) {
		this.licenca = licenca;
	}

	public String getPrezime() {
		return this.prezime;
	}

	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}

	public List<Trening> getTrenings() {
		return this.trenings;
	}

	public void setTrenings(List<Trening> trenings) {
		this.trenings = trenings;
	}

	public Trening addTrening(Trening trening) {
		getTrenings().add(trening);
		trening.setTrener(this);

		return trening;
	}

	public Trening removeTrening(Trening trening) {
		getTrenings().remove(trening);
		trening.setTrener(null);

		return trening;
	}

}