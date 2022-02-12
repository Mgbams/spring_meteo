package fr.orsys.kingsley.meteo.business;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the technicien database table.
 * 
 */
@Entity
@NamedQuery(name="Technicien.findAll", query="SELECT t FROM Technicien t")
public class Technicien implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idTechnicien;

	private String nom;

	private String prenom;

	//bi-directional many-to-one association to Intervention
	@OneToMany(mappedBy="technicien")
	private List<Intervention> interventions;

	//bi-directional many-to-one association to Societe
	@ManyToOne
	@JoinColumn(name="idSociete")
	private Societe societe;

	public Technicien() {
	}

	public int getIdTechnicien() {
		return this.idTechnicien;
	}

	public void setIdTechnicien(int idTechnicien) {
		this.idTechnicien = idTechnicien;
	}

	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return this.prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public List<Intervention> getInterventions() {
		return this.interventions;
	}

	public void setInterventions(List<Intervention> interventions) {
		this.interventions = interventions;
	}

	public Intervention addIntervention(Intervention intervention) {
		getInterventions().add(intervention);
		intervention.setTechnicien(this);

		return intervention;
	}

	public Intervention removeIntervention(Intervention intervention) {
		getInterventions().remove(intervention);
		intervention.setTechnicien(null);

		return intervention;
	}

	public Societe getSociete() {
		return this.societe;
	}

	public void setSociete(Societe societe) {
		this.societe = societe;
	}

}