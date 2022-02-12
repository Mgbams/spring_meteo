package fr.orsys.kingsley.meteo.business;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the typemesure database table.
 * 
 */
@Entity
@NamedQuery(name="Typemesure.findAll", query="SELECT t FROM Typemesure t")
public class Typemesure implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idTypeMesure;

	private String nom;

	private String unite;

	private BigDecimal valeurMax;

	private BigDecimal valeurMin;

	//bi-directional many-to-one association to Releve
	@OneToMany(mappedBy="typemesure")
	private List<Releve> releves;

	public Typemesure() {
	}

	public int getIdTypeMesure() {
		return this.idTypeMesure;
	}

	public void setIdTypeMesure(int idTypeMesure) {
		this.idTypeMesure = idTypeMesure;
	}

	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getUnite() {
		return this.unite;
	}

	public void setUnite(String unite) {
		this.unite = unite;
	}

	public BigDecimal getValeurMax() {
		return this.valeurMax;
	}

	public void setValeurMax(BigDecimal valeurMax) {
		this.valeurMax = valeurMax;
	}

	public BigDecimal getValeurMin() {
		return this.valeurMin;
	}

	public void setValeurMin(BigDecimal valeurMin) {
		this.valeurMin = valeurMin;
	}

	public List<Releve> getReleves() {
		return this.releves;
	}

	public void setReleves(List<Releve> releves) {
		this.releves = releves;
	}

	public Releve addReleve(Releve releve) {
		getReleves().add(releve);
		releve.setTypemesure(this);

		return releve;
	}

	public Releve removeReleve(Releve releve) {
		getReleves().remove(releve);
		releve.setTypemesure(null);

		return releve;
	}

}