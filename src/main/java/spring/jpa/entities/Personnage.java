package spring.jpa.entities;

import java.io.Serializable;

import javax.persistence.*;

import java.util.List;


/**
 * The persistent class for the personnage database table.
 *
 */
@Table (name = "personnages")
@Entity
@NamedQuery(name="Personnage.findAll", query="SELECT p FROM Personnage p")
public class Personnage implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	private String genre;

	private String nom;

	private String prenom;

	private String profession;

	private String sexe;

	//bi-directional many-to-one association to Apparait
	@OneToMany(mappedBy="personnage")
	private List<Apparait> apparaits;

	public Personnage() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getGenre() {
		return this.genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
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

	public String getProfession() {
		return this.profession;
	}

	public void setProfession(String profession) {
		this.profession = profession;
	}

	public String getSexe() {
		return this.sexe;
	}

	public void setSexe(String sexe) {
		this.sexe = sexe;
	}

	public List<Apparait> getApparaits() {
		return this.apparaits;
	}

	public void setApparaits(List<Apparait> apparaits) {
		this.apparaits = apparaits;
	}

	public Apparait addApparait(Apparait apparait) {
		getApparaits().add(apparait);
		apparait.setPersonnage(this);

		return apparait;
	}

	public Apparait removeApparait(Apparait apparait) {
		getApparaits().remove(apparait);
		apparait.setPersonnage(null);

		return apparait;
	}

	@Override
	public String toString() {
		return "Personnage{" +
				"id=" + id +
				", genre='" + genre + '\'' +
				", nom='" + nom + '\'' +
				", prenom='" + prenom + '\'' +
				", profession='" + profession + '\'' +
				", sexe='" + sexe + '\'' +
				'}';
	}
}