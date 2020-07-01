package spring.jpa.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import spring.jpa.entities.Personnage;

import java.util.List;

@Repository
public interface PersonnageRepository extends CrudRepository<Personnage, Integer> {

    @Query("select p from Personnage p where p.genre=?1")
    List<Personnage> findPersonnageByGenreBis(String genre);

    @Query("select p from Personnage p where p.genre=: genre")
    List<Personnage> findPersByGenre(@Param("genre") String genre);
    //utilisation
    //List<Personnage> ens = findPersByGenre("gentil");

    List<Personnage> findByGenre(String genre);
    //               findBy + Attribut
    //utilisation
    //List<Personnage> ens = findByGenre("gentil");

    @Query("select p from Personnage p where p.nom=?1")
    List<Personnage> findPersonnageByNom(String nom);

    @Query("select p from Personnage p where p.nom=:nom")
    List<Personnage> findPerByNom(@Param("nom") String nom);

    List<Personnage> findByNom(String nom);

    @Query("select p from Personnage p where upper(p.prenom)=?1 order by p.nom")
    List<Personnage> findPersByPrenNoCass(String prenom);


    @Query("select p from Personnage p where upper(p.prenom) =upper(:prenom)")
    List<Personnage> findPersonnageByPreNoCass(@Param("prenom") String prenom);

    List<Personnage> findByPrenomIgnoreCase(String prenom);

    @Query("select p from Personnage p where not (p.genre=:genre)")
    List<Personnage> findPersonnageNotInGenre(@Param("genre") String genre);

    List<Personnage> findByGenreNot(String genre);


}
