package com.stageMonta.TalanTunisie.repositories;

import com.stageMonta.TalanTunisie.model.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;


public interface AppUserRepository extends JpaRepository<AppUser, Long> {
    AppUser findByUsername(String username);
}
