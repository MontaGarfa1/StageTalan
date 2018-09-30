package com.stageMonta.TalanTunisie.controllers;

import com.stageMonta.TalanTunisie.index.WeeklyKpi;
import com.stageMonta.TalanTunisie.services.WeeklyKpiService;
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
@RequestMapping("/weeklyKpi")
public class WeeklyKpiController {
    @Autowired
    private WeeklyKpiService weeklyKpiService;

    @ResponseBody
    @GetMapping(value = "all")
    public ResponseEntity<List<WeeklyKpi>> getAllAccounts() {
        return new ResponseEntity<List<WeeklyKpi>>(weeklyKpiService.getAll(), HttpStatus.OK);
        /* List<Account> listAccount = new ArrayList<>();
          accountRepository.findAll().forEach(listAccount::add);
        return listAccount;**/
    }

    @ResponseBody
    @GetMapping(value = "{id}")
    public ResponseEntity<WeeklyKpi> getAccountById(@PathVariable String id) {
        WeeklyKpi account = new WeeklyKpi();
        // account = accountService.findOne(id);
        return new ResponseEntity<WeeklyKpi>(weeklyKpiService.findOne(id).get(), HttpStatus.OK);
        /*return accountRepository.findById(id);*/
    }

    @ResponseBody
    @PostMapping(value = "add")
    public ResponseEntity<WeeklyKpi> setAccount(@Valid @RequestBody WeeklyKpi weeklyKpi) {
        WeeklyKpi weeklyKpi1 = weeklyKpiService.create(weeklyKpi);
        if (weeklyKpi1 == null) {
            return ResponseEntity.noContent().build();
        }
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(weeklyKpi1.getKpiname())
                .toUri();
        return ResponseEntity.created(location).build();
    }

    @ResponseBody
    @DeleteMapping(value = "delete/{id}")
    public ResponseEntity<WeeklyKpi> deleteAccountByID(@PathVariable String id) {
        weeklyKpiService.delete(id);
        return new ResponseEntity<WeeklyKpi>(HttpStatus.NO_CONTENT);
        //accountRepository.deleteById(id);
    }
    /*@GetMapping(value = "get/special")
    public Map<String,Long> stateStatus(){
        Map<String,Long> stats = accountService.stateStats();
      /*  Gson gson = new Gson();
        String json = gson.toJson(stats);
        System.out.println(json);
        return stats;
    }*/


}
