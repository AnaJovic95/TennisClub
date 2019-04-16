package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the PrijavaZaTurnir database table.
 * 
 */
@Entity
@NamedQuery(name="PrijavaZaTurnir.findAll", query="SELECT p FROM PrijavaZaTurnir p")
public class PrijavaZaTurnir implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idPrijavaZaTurnir;

	@Temporal(TemporalType.DATE)
	private Date datumPrijave;

	//bi-directional many-to-one association to Igrac
	@ManyToOne
	@JoinColumn(name="fkIdIgraca")
	private Igrac igrac;

	//bi-directional many-to-one association to Turnir
	@ManyToOne
	@JoinColumn(name="fkIdTurnira")
	private Turnir turnir;

	public PrijavaZaTurnir() {
	}

	public int getIdPrijavaZaTurnir() {
		return this.idPrijavaZaTurnir;
	}

	public void setIdPrijavaZaTurnir(int idPrijavaZaTurnir) {
		this.idPrijavaZaTurnir = idPrijavaZaTurnir;
	}

	public Date getDatumPrijave() {
		return this.datumPrijave;
	}

	public void setDatumPrijave(Date datumPrijave) {
		this.datumPrijave = datumPrijave;
	}

	public Igrac getIgrac() {
		return this.igrac;
	}

	public void setIgrac(Igrac igrac) {
		this.igrac = igrac;
	}

	public Turnir getTurnir() {
		return this.turnir;
	}

	public void setTurnir(Turnir turnir) {
		this.turnir = turnir;
	}

}