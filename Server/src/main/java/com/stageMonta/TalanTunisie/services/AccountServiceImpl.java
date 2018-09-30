package com.stageMonta.TalanTunisie.services;

import com.stageMonta.TalanTunisie.model.AppRole;
import com.stageMonta.TalanTunisie.model.AppUser;
import com.stageMonta.TalanTunisie.repositories.AppRoleRepository;
import com.stageMonta.TalanTunisie.repositories.AppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AccountServiceImpl implements AccountService {
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired
    private AppUserRepository appUserRepository;
    @Autowired
    private AppRoleRepository appRoleRepository;

    /**
     * add user
     */
    @Override
    public AppUser saveUser(AppUser user) {
        if(appUserRepository.findByUsername(user.getUsername())==null){
        String hashPW = bCryptPasswordEncoder.encode(user.getPassword());
        user.setPassword(hashPW);
        // TODO Auto-generated method stub
         appUserRepository.save(user);
         return user;
        }
        return null;
    }


    /**
     * add role
     */

    @Override
    public AppRole saveRole(AppRole role) {
        // TODO Auto-generated method stub
        return appRoleRepository.save(role);
    }

    /**
     * add role to user
     */
    @Override
    public void addRoleToUser(String username, String roleName) {
        // TODO Auto-generated method stub
        if(this.appRoleRepository.findByRoleName(roleName)==null){
          appRoleRepository.save(new AppRole(roleName));
        }

        AppRole role = appRoleRepository.findByRoleName(roleName);

        AppUser user = appUserRepository.findByUsername(username);
        user.getRoles().add(role);

    }

    /**
     * find user by username
     */
    @Override
    public AppUser findUserByUsername(String username) {
        // TODO Auto-generated method stub
        return appUserRepository.findByUsername(username);
    }
}
