package com.stageMonta.TalanTunisie;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
@EnableJpaRepositories("com.stageMonta.TalanTunisie.repositories")
@EnableElasticsearchRepositories("com.stageMonta.TalanTunisie.repositoriesElastic")
public class TalanTunisieApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(TalanTunisieApplication.class, args);
	}
	@Bean
	public BCryptPasswordEncoder getBCPE() {
		return new BCryptPasswordEncoder();
	}

	@Override
	public void run(String... args) throws Exception {
        /*System.out.println("saved in DB");
        accountService.saveUser(new AppUser("mariem", "mariouma", null));
        accountService.saveUser(new AppUser("admin", "admin", null));
        accountService.saveUser(new AppUser("agent", "agent", null));
       accountService.saveRole(new AppRole("ADMIN"));
        accountService.saveRole(new AppRole("AGENT"));
        accountService.addRoleToUser("admin", "ADMIN");
        accountService.addRoleToUser("admin", "AGENT");
        accountService.addRoleToUser("agent", "AGENT");
        accountService.saveUser(new AppUser("admin", "admin", null));
        accountService.saveRole(new AppRole("ADMIN"));
        accountService.addRoleToUser("admin", "ADMIN");

*/
	}
}
