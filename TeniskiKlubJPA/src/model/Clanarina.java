package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the Clanarina database table.
 * 
 */
@Entity
@NamedQuery(name="Clanarina.findAll", query="SELECT c FROM Clanarina c")
public class Clanarina implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idClanarina;

	@Temporal(TemporalType.DATE)
	private Date datumUplate;

	private int iznos;

	//bi-directional many-to-one association to Igrac
	@ManyToOne
	@JoinColumn(name="fkIdIgraca")
	private Igrac igrac;

	public Clanarina() {
	}

	public int getIdClanarina() {
		return this.idClanarina;
	}

	public void setIdClanarina(int idClanarina) {
		this.idClanarina = idClanarina;
	}

	public Date getDatumUplate() {
		return this.datumUplate;
	}

	public void setDatumUplate(Date datumUplate) {
		this.datumUplate = datumUplate;
	}

	public int getIznos() {
		return this.iznos;
	}

	public void setIznos(int iznos) {
		this.iznos = iznos;
	}

	public Igrac getIgrac() {
		return this.igrac;
	}

	public void setIgrac(Igrac igrac) {
		this.igrac = igrac;
	}

}