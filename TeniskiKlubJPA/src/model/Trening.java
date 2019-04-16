package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the Trening database table.
 * 
 */
@Entity
@NamedQuery(name="Trening.findAll", query="SELECT t FROM Trening t")
public class Trening implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idTrening;

	private String tipTreninga;

	//bi-directional many-to-one association to Igrac
	@ManyToOne
	@JoinColumn(name="fkIdIgraca")
	private Igrac igrac;

	//bi-directional many-to-one association to Termin
	@ManyToOne
	@JoinColumn(name="fkIdTermina")
	private Termin termin;

	//bi-directional many-to-one association to Trener
	@ManyToOne
	@JoinColumn(name="fkIdTrenera")
	private Trener trener;

	public Trening() {
	}

	public int getIdTrening() {
		return this.idTrening;
	}

	public void setIdTrening(int idTrening) {
		this.idTrening = idTrening;
	}

	public String getTipTreninga() {
		return this.tipTreninga;
	}

	public void setTipTreninga(String tipTreninga) {
		this.tipTreninga = tipTreninga;
	}

	public Igrac getIgrac() {
		return this.igrac;
	}

	public void setIgrac(Igrac igrac) {
		this.igrac = igrac;
	}

	public Termin getTermin() {
		return this.termin;
	}

	public void setTermin(Termin termin) {
		this.termin = termin;
	}

	public Trener getTrener() {
		return this.trener;
	}

	public void setTrener(Trener trener) {
		this.trener = trener;
	}

}