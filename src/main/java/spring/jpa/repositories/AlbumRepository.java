package spring.jpa.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import spring.jpa.entities.Album;
import spring.jpa.entities.Personnage;

import java.util.List;

@Repository
public interface AlbumRepository extends CrudRepository<Album, Integer> {
    List<Album> findByAnnee(Integer annee);

    @Query("select a.personnage from Apparait a where a.album.titre= ?1")
    List<Personnage> findPersonnagesByAlbum(String titre);

    List<Album> findByAlbum(String titre);
}