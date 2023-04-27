package ma.emsi.patientmvc;

import ma.emsi.patientmvc.entities.Patient;
import ma.emsi.patientmvc.repositories.PatientRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.boot.CommandLineRunner;

import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Date;

@SpringBootApplication
public class PatientMvcApplication {
    public static void main(String[] args) {
        SpringApplication.run(PatientMvcApplication.class, args);
    }
 //   @Bean //Pour que ça s'execute au démarrage
    CommandLineRunner commandLineRunner(PatientRepository patientRepository) {
        return args -> {
            patientRepository.save(new Patient(null, "Adham", new Date(), false, 123));
            patientRepository.save(new Patient(null, "Achraf", new Date(), true, 124));
            patientRepository.save(new Patient(null, "Mohammed", new Date(), false, 101));
            patientRepository.save(new Patient(null, "Aziza", new Date(), true, 102));
            patientRepository.findAll().forEach(
                    p -> {
                        System.out.println(p.getNom());
                    }
            );
        };
    }
    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
