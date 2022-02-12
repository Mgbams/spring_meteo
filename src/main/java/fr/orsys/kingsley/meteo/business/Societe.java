package fr.orsys.kingsley.meteo.business;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the societe database table.
 * 
 */
@Entity
@NamedQuery(name="Societe.findAll", query="SELECT s FROM Societe s")
public class Societe implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idSociete;

	private String numTelSupport;

	private String raisonSociale;

	private BigDecimal tauxHoraire;

	//bi-directional many-to-one association to Station
	@OneToMany(mappedBy="societe")
	private List<Station> stations;

	//bi-directional many-to-one association to Technicien
	@OneToMany(mappedBy="societe")
	private List<Technicien> techniciens;

	public Societe() {
	}

	public int getIdSociete() {
		return this.idSociete;
	}

	public void setIdSociete(int idSociete) {
		this.idSociete = idSociete;
	}

	public String getNumTelSupport() {
		return this.numTelSupport;
	}

	public void setNumTelSupport(String numTelSupport) {
		this.numTelSupport = numTelSupport;
	}

	public String getRaisonSociale() {
		return this.raisonSociale;
	}

	public void setRaisonSociale(String raisonSociale) {
		this.raisonSociale = raisonSociale;
	}

	public BigDecimal getTauxHoraire() {
		return this.tauxHoraire;
	}

	public void setTauxHoraire(BigDecimal tauxHoraire) {
		this.tauxHoraire = tauxHoraire;
	}

	public List<Station> getStations() {
		return this.stations;
	}

	public void setStations(List<Station> stations) {
		this.stations = stations;
	}

	public Station addStation(Station station) {
		getStations().add(station);
		station.setSociete(this);

		return station;
	}

	public Station removeStation(Station station) {
		getStations().remove(station);
		station.setSociete(null);

		return station;
	}

	public List<Technicien> getTechniciens() {
		return this.techniciens;
	}

	public void setTechniciens(List<Technicien> techniciens) {
		this.techniciens = techniciens;
	}

	public Technicien addTechnicien(Technicien technicien) {
		getTechniciens().add(technicien);
		technicien.setSociete(this);

		return technicien;
	}

	public Technicien removeTechnicien(Technicien technicien) {
		getTechniciens().remove(technicien);
		technicien.setSociete(null);

		return technicien;
	}

}