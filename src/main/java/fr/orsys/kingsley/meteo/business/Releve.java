package fr.orsys.kingsley.meteo.business;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Time;
import java.util.Date;


/**
 * The persistent class for the releve database table.
 * 
 */
@Entity
@NamedQuery(name="Releve.findAll", query="SELECT r FROM Releve r")
public class Releve implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idReleve;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dateHeure;

	private Time heure;

	private BigDecimal valeur;

	//bi-directional many-to-one association to Station
	@ManyToOne
	@JoinColumn(name="idStation")
	private Station station;

	//bi-directional many-to-one association to Typemesure
	@ManyToOne
	@JoinColumn(name="idTypeMesure")
	private Typemesure typemesure;

	public Releve() {
	}

	public int getIdReleve() {
		return this.idReleve;
	}

	public void setIdReleve(int idReleve) {
		this.idReleve = idReleve;
	}

	public Date getDateHeure() {
		return this.dateHeure;
	}

	public void setDateHeure(Date dateHeure) {
		this.dateHeure = dateHeure;
	}

	public Time getHeure() {
		return this.heure;
	}

	public void setHeure(Time heure) {
		this.heure = heure;
	}

	public BigDecimal getValeur() {
		return this.valeur;
	}

	public void setValeur(BigDecimal valeur) {
		this.valeur = valeur;
	}

	public Station getStation() {
		return this.station;
	}

	public void setStation(Station station) {
		this.station = station;
	}

	public Typemesure getTypemesure() {
		return this.typemesure;
	}

	public void setTypemesure(Typemesure typemesure) {
		this.typemesure = typemesure;
	}

}