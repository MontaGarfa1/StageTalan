package com.stageMonta.TalanTunisie.controllers;


import com.stageMonta.TalanTunisie.index.MonthlyKpi;
import com.stageMonta.TalanTunisie.services.MonthlyKpiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("/monthlyKpi")
public class MonthlyKpiController {
    @Autowired
    private MonthlyKpiService monthlyKpiService;

    @ResponseBody
    @GetMapping(value = "all")
    public ResponseEntity<List<MonthlyKpi>> getAllAccounts() {
        return new ResponseEntity<List<MonthlyKpi>>(monthlyKpiService.getAll(), HttpStatus.OK);
        /* List<Account> listAccount = new ArrayList<>();
          accountRepository.findAll().forEach(listAccount::add);
        return listAccount;**/
    }

    @ResponseBody
    @GetMapping(value = "{id}")
    public ResponseEntity<MonthlyKpi> getAccountById(@PathVariable String id) {
        MonthlyKpi account = new MonthlyKpi();
        // account = accountService.findOne(id);
        return new ResponseEntity<MonthlyKpi>(monthlyKpiService.findOne(id).get(), HttpStatus.OK);
        /*return accountRepository.findById(id);*/
    }

    @ResponseBody
    @PostMapping(value = "add")
    public ResponseEntity<MonthlyKpi> setAccount(@Valid @RequestBody MonthlyKpi monthlyKpi) {
        MonthlyKpi monthlyKpi1 = monthlyKpiService.create(monthlyKpi);
        if (monthlyKpi1 == null) {
            return ResponseEntity.noContent().build();
        }
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(monthlyKpi1.getKpiname())
                .toUri();
        return ResponseEntity.created(location).build();
        /* Account account1= accountRepository.save(account);
        if(account1 == null){
            return ResponseEntity.noContent().build();
        }
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(account1.getAccount_number())
                .toUri();
        return ResponseEntity.created(location).build();*/
    }

    @ResponseBody
    @DeleteMapping(value = "delete/{id}")
    public ResponseEntity<MonthlyKpi> deleteAccountByID(@PathVariable String id) {
        monthlyKpiService.delete(id);
        return new ResponseEntity<MonthlyKpi>(HttpStatus.NO_CONTENT);
        //accountRepository.deleteById(id);
    }
    /*@GetMapping(value = "get/special")
    public Map<String,Long> stateStatus(){
        Map<String,Long> stats = monthlyKpiService.stateStats();
      /*  Gson gson = new Gson();
        String json = gson.toJson(stats);
        System.out.println(json);
        return stats;
    }*/


}
