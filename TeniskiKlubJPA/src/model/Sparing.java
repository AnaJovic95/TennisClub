package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the Sparing database table.
 * 
 */
@Entity
@NamedQuery(name="Sparing.findAll", query="SELECT s FROM Sparing s")
public class Sparing implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idSparing;

	//bi-directional many-to-one association to Igrac
	@ManyToOne
	@JoinColumn(name="fkIgracProtiv")
	private Igrac igrac1;

	//bi-directional many-to-one association to Igrac
	@ManyToOne
	@JoinColumn(name="fkIgrac")
	private Igrac igrac2;

	//bi-directional many-to-one association to Termin
	@ManyToOne
	@JoinColumn(name="fkTermin")
	private Termin termin;

	public Sparing() {
	}

	public int getIdSparing() {
		return this.idSparing;
	}

	public void setIdSparing(int idSparing) {
		this.idSparing = idSparing;
	}

	public Igrac getIgrac1() {
		return this.igrac1;
	}

	public void setIgrac1(Igrac igrac1) {
		this.igrac1 = igrac1;
	}

	public Igrac getIgrac2() {
		return this.igrac2;
	}

	public void setIgrac2(Igrac igrac2) {
		this.igrac2 = igrac2;
	}

	public Termin getTermin() {
		return this.termin;
	}

	public void setTermin(Termin termin) {
		this.termin = termin;
	}

}