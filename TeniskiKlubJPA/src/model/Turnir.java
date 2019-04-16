package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the Turnir database table.
 * 
 */
@Entity
@NamedQuery(name="Turnir.findAll", query="SELECT t FROM Turnir t")
public class Turnir implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idTurnir;

	@Temporal(TemporalType.DATE)
	private Date datum;

	private String kategorija;

	private int konkurencija;

	private String mesto;

	private String naziv;

	private String pol;

	//bi-directional many-to-one association to PrijavaZaTurnir
	@OneToMany(mappedBy="turnir")
	private List<PrijavaZaTurnir> prijavaZaTurnirs;

	public Turnir() {
	}

	public int getIdTurnir() {
		return this.idTurnir;
	}

	public void setIdTurnir(int idTurnir) {
		this.idTurnir = idTurnir;
	}

	public Date getDatum() {
		return this.datum;
	}

	public void setDatum(Date datum) {
		this.datum = datum;
	}

	public String getKategorija() {
		return this.kategorija;
	}

	public void setKategorija(String kategorija) {
		this.kategorija = kategorija;
	}

	public int getKonkurencija() {
		return this.konkurencija;
	}

	public void setKonkurencija(int konkurencija) {
		this.konkurencija = konkurencija;
	}

	public String getMesto() {
		return this.mesto;
	}

	public void setMesto(String mesto) {
		this.mesto = mesto;
	}

	public String getNaziv() {
		return this.naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public String getPol() {
		return this.pol;
	}

	public void setPol(String pol) {
		this.pol = pol;
	}

	public List<PrijavaZaTurnir> getPrijavaZaTurnirs() {
		return this.prijavaZaTurnirs;
	}

	public void setPrijavaZaTurnirs(List<PrijavaZaTurnir> prijavaZaTurnirs) {
		this.prijavaZaTurnirs = prijavaZaTurnirs;
	}

	public PrijavaZaTurnir addPrijavaZaTurnir(PrijavaZaTurnir prijavaZaTurnir) {
		getPrijavaZaTurnirs().add(prijavaZaTurnir);
		prijavaZaTurnir.setTurnir(this);

		return prijavaZaTurnir;
	}

	public PrijavaZaTurnir removePrijavaZaTurnir(PrijavaZaTurnir prijavaZaTurnir) {
		getPrijavaZaTurnirs().remove(prijavaZaTurnir);
		prijavaZaTurnir.setTurnir(null);

		return prijavaZaTurnir;
	}

}