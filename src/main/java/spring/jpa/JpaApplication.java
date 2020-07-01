package spring.jpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import spring.jpa.entities.Album;
import spring.jpa.entities.Personnage;
import spring.jpa.repositories.AlbumRepository;
import spring.jpa.repositories.PersonnageRepository;

import javax.security.auth.login.Configuration;

@SpringBootApplication
public class JpaApplication {

    public static void main(String[] args) {

        ConfigurableApplicationContext context = SpringApplication.run(JpaApplication.class, args);


        AlbumRepository repositoryA = context.getBean(AlbumRepository.class);
        PersonnageRepository repositoryP = context.getBean(PersonnageRepository.class);
        //Recherche des albums
        Iterable<Album> albums = repositoryA.findAll();
        System.out.println("Albums found with findAll():");
        System.out.println("----------------------------");
        for (Album album : albums) {
            System.out.println(album);
        }
        System.out.println();
        Iterable<Personnage> personnages = repositoryA.findPersonnagesByAlbum("Objectif Lune");
        System.out.println("Personnages de l'album Objectif Lune: ");
        System.out.println("--------------------------------------");
        for (Personnage p : personnages) {
            System.out.println(p.getNom() + " " + p.getPrenom());
        }
        System.out.println();

        Iterable<Personnage> persByNom = repositoryP.findByNom("WAGNER");
        System.out.println("Personnage by name");
        System.out.println("------------------------------");
        for (Personnage p : persByNom) {
            System.out.println(p);
        }
        System.out.println();

        Iterable<Personnage> persByPrenom = repositoryP.findPersByPrenNoCass("nestor");
        System.out.println("Personnage by Prenom");
        System.out.println("------------------------------");
        for (Personnage p : persByPrenom) {
            System.out.println(p);
        }
        System.out.println();

        Iterable<Personnage> persNotInGenre = repositoryP.findByGenreNot("MECHANT");
        System.out.println("Personnage not in Genre");
        System.out.println("------------------------------");
        for (Personnage p : persNotInGenre) {
            System.out.println(p);
        }
        System.out.println();

    }


}
