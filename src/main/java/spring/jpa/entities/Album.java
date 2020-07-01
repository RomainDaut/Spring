package spring.jpa.entities;

import java.io.Serializable;

import javax.persistence.*;

import java.util.List;


/**
 * The persistent class for the album database table.
 */
@Table(name = "albums")
@Entity
@NamedQuery(name = "Album.findAll", query = "SELECT a FROM Album a")
public class Album implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    private Integer id;

    private Integer annee;

    private String titre;

    //bi-directional many-to-one association to Album
    @ManyToOne
    @JoinColumn(name = "suivant")
    private Album album;

    //bi-directional many-to-one association to Album
    @OneToMany(mappedBy = "album")
    private List<Album> albums;

    //bi-directional many-to-one association to Apparait
    @OneToMany(mappedBy = "album")
    private List<Apparait> apparaits;

    public Album() {
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAnnee() {
        return this.annee;
    }

    public void setAnnee(Integer annee) {
        this.annee = annee;
    }

    public String getTitre() {
        return this.titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public Album getAlbum() {
        return this.album;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }

    public List<Album> getAlbums() {
        return this.albums;
    }

    public void setAlbums(List<Album> albums) {
        this.albums = albums;
    }

    public Album addAlbum(Album album) {
        getAlbums().add(album);
        album.setAlbum(this);

        return album;
    }

    public Album removeAlbum(Album album) {
        getAlbums().remove(album);
        album.setAlbum(null);

        return album;
    }

    public List<Apparait> getApparaits() {
        return this.apparaits;
    }

    public void setApparaits(List<Apparait> apparaits) {
        this.apparaits = apparaits;
    }

    public Apparait addApparait(Apparait apparait) {
        getApparaits().add(apparait);
        apparait.setAlbum(this);

        return apparait;
    }

    public Apparait removeApparait(Apparait apparait) {
        getApparaits().remove(apparait);
        apparait.setAlbum(null);

        return apparait;
    }

    @Override
    public String toString() {
        return "Album [id=" + id + ", annee=" + annee + ", titre=" + titre
                + "]";
    }


}