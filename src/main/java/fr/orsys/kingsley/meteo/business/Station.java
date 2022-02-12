package fr.orsys.kingsley.meteo.business;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the station database table.
 * 
 */
@Entity
@NamedQuery(name="Station.findAll", query="SELECT s FROM Station s")
public class Station implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idStation;

	private int altitude;

	private byte estZoneUrbaine;

	private float latitude;

	private float longitude;

	private String nom;

	//bi-directional many-to-one association to Intervention
	@OneToMany(mappedBy="station")
	private List<Intervention> interventions;

	//bi-directional many-to-one association to Releve
	@OneToMany(mappedBy="station")
	private List<Releve> releves;

	//bi-directional many-to-one association to Societe
	@ManyToOne
	@JoinColumn(name="idSociete")
	private Societe societe;

	public Station() {
	}

	public int getIdStation() {
		return this.idStation;
	}

	public void setIdStation(int idStation) {
		this.idStation = idStation;
	}

	public int getAltitude() {
		return this.altitude;
	}

	public void setAltitude(int altitude) {
		this.altitude = altitude;
	}

	public byte getEstZoneUrbaine() {
		return this.estZoneUrbaine;
	}

	public void setEstZoneUrbaine(byte estZoneUrbaine) {
		this.estZoneUrbaine = estZoneUrbaine;
	}

	public float getLatitude() {
		return this.latitude;
	}

	public void setLatitude(float latitude) {
		this.latitude = latitude;
	}

	public float getLongitude() {
		return this.longitude;
	}

	public void setLongitude(float longitude) {
		this.longitude = longitude;
	}

	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public List<Intervention> getInterventions() {
		return this.interventions;
	}

	public void setInterventions(List<Intervention> interventions) {
		this.interventions = interventions;
	}

	public Intervention addIntervention(Intervention intervention) {
		getInterventions().add(intervention);
		intervention.setStation(this);

		return intervention;
	}

	public Intervention removeIntervention(Intervention intervention) {
		getInterventions().remove(intervention);
		intervention.setStation(null);

		return intervention;
	}

	public List<Releve> getReleves() {
		return this.releves;
	}

	public void setReleves(List<Releve> releves) {
		this.releves = releves;
	}

	public Releve addReleve(Releve releve) {
		getReleves().add(releve);
		releve.setStation(this);

		return releve;
	}

	public Releve removeReleve(Releve releve) {
		getReleves().remove(releve);
		releve.setStation(null);

		return releve;
	}

	public Societe getSociete() {
		return this.societe;
	}

	public void setSociete(Societe societe) {
		this.societe = societe;
	}

}