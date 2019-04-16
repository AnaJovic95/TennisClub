package model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Time;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the Termin database table.
 * 
 */
@Entity
@NamedQuery(name="Termin.findAll", query="SELECT t FROM Termin t")
public class Termin implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idTermin;

	@Temporal(TemporalType.DATE)
	private Date datum;

	private int teren;

	private int trajanje;

	private Time vreme;

	//bi-directional many-to-one association to Sparing
	@OneToMany(mappedBy="termin")
	private List<Sparing> sparings;

	//bi-directional many-to-one association to Trening
	@OneToMany(mappedBy="termin")
	private List<Trening> trenings;

	public Termin() {
	}

	public int getIdTermin() {
		return this.idTermin;
	}

	public void setIdTermin(int idTermin) {
		this.idTermin = idTermin;
	}

	public Date getDatum() {
		return this.datum;
	}

	public void setDatum(Date datum) {
		this.datum = datum;
	}

	public int getTeren() {
		return this.teren;
	}

	public void setTeren(int teren) {
		this.teren = teren;
	}

	public int getTrajanje() {
		return this.trajanje;
	}

	public void setTrajanje(int trajanje) {
		this.trajanje = trajanje;
	}

	public Time getVreme() {
		return this.vreme;
	}

	public void setVreme(Time vreme) {
		this.vreme = vreme;
	}

	public List<Sparing> getSparings() {
		return this.sparings;
	}

	public void setSparings(List<Sparing> sparings) {
		this.sparings = sparings;
	}

	public Sparing addSparing(Sparing sparing) {
		getSparings().add(sparing);
		sparing.setTermin(this);

		return sparing;
	}

	public Sparing removeSparing(Sparing sparing) {
		getSparings().remove(sparing);
		sparing.setTermin(null);

		return sparing;
	}

	public List<Trening> getTrenings() {
		return this.trenings;
	}

	public void setTrenings(List<Trening> trenings) {
		this.trenings = trenings;
	}

	public Trening addTrening(Trening trening) {
		getTrenings().add(trening);
		trening.setTermin(this);

		return trening;
	}

	public Trening removeTrening(Trening trening) {
		getTrenings().remove(trening);
		trening.setTermin(null);

		return trening;
	}

}