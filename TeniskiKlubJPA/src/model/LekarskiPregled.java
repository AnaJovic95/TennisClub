package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the LekarskiPregled database table.
 * 
 */
@Entity
@NamedQuery(name="LekarskiPregled.findAll", query="SELECT l FROM LekarskiPregled l")
public class LekarskiPregled implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idLekarskiPregled;

	@Temporal(TemporalType.DATE)
	private Date datumDoKadaVazi;

	@Temporal(TemporalType.DATE)
	private Date datumPregleda;

	//bi-directional many-to-one association to Igrac
	@ManyToOne
	@JoinColumn(name="fkIdIgrac")
	private Igrac igrac;

	public LekarskiPregled() {
	}

	public int getIdLekarskiPregled() {
		return this.idLekarskiPregled;
	}

	public void setIdLekarskiPregled(int idLekarskiPregled) {
		this.idLekarskiPregled = idLekarskiPregled;
	}

	public Date getDatumDoKadaVazi() {
		return this.datumDoKadaVazi;
	}

	public void setDatumDoKadaVazi(Date datumDoKadaVazi) {
		this.datumDoKadaVazi = datumDoKadaVazi;
	}

	public Date getDatumPregleda() {
		return this.datumPregleda;
	}

	public void setDatumPregleda(Date datumPregleda) {
		this.datumPregleda = datumPregleda;
	}

	public Igrac getIgrac() {
		return this.igrac;
	}

	public void setIgrac(Igrac igrac) {
		this.igrac = igrac;
	}

}