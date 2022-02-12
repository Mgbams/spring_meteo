package fr.orsys.kingsley.meteo.business;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the intervention database table.
 * 
 */
@Entity
@NamedQuery(name="Intervention.findAll", query="SELECT i FROM Intervention i")
public class Intervention implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idIntervention;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dateHeureDebut;

	private int duree;

	private String remarques;

	//bi-directional many-to-one association to Station
	@ManyToOne
	@JoinColumn(name="idStation")
	private Station station;

	//bi-directional many-to-one association to Technicien
	@ManyToOne
	@JoinColumn(name="idTechnicien")
	private Technicien technicien;

	public Intervention() {
	}

	public int getIdIntervention() {
		return this.idIntervention;
	}

	public void setIdIntervention(int idIntervention) {
		this.idIntervention = idIntervention;
	}

	public Date getDateHeureDebut() {
		return this.dateHeureDebut;
	}

	public void setDateHeureDebut(Date dateHeureDebut) {
		this.dateHeureDebut = dateHeureDebut;
	}

	public int getDuree() {
		return this.duree;
	}

	public void setDuree(int duree) {
		this.duree = duree;
	}

	public String getRemarques() {
		return this.remarques;
	}

	public void setRemarques(String remarques) {
		this.remarques = remarques;
	}

	public Station getStation() {
		return this.station;
	}

	public void setStation(Station station) {
		this.station = station;
	}

	public Technicien getTechnicien() {
		return this.technicien;
	}

	public void setTechnicien(Technicien technicien) {
		this.technicien = technicien;
	}

}