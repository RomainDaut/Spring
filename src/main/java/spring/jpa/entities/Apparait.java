package spring.jpa.entities;

import java.io.Serializable;

import javax.persistence.*;


/**
 * The persistent class for the apparait database table.
 */
@Table(name = "apparaits")
@Entity
@NamedQuery(name = "Apparait.findAll", query = "SELECT a FROM Apparait a")
public class Apparait implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    private Integer id;

    //bi-directional many-to-one association to Album
    @ManyToOne
    private Album album;

    //bi-directional many-to-one association to Personnage
    @ManyToOne
    private Personnage personnage;

    public Apparait() {
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Album getAlbum() {
        return this.album;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }

    public Personnage getPersonnage() {
        return this.personnage;
    }

    public void setPersonnage(Personnage personnage) {
        this.personnage = personnage;
    }

}