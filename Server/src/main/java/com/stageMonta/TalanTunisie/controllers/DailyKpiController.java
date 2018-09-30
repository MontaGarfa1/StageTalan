package com.stageMonta.TalanTunisie.controllers;


import com.stageMonta.TalanTunisie.config.ElasticsearchConfig;
import com.stageMonta.TalanTunisie.index.DailyKpi;
import com.stageMonta.TalanTunisie.services.DailyKpiService;
import org.elasticsearch.action.search.SearchResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600, allowCredentials = "false")
@RestController
@RequestMapping("/dailyKpi")
public class DailyKpiController {
    @Autowired
    private DailyKpiService dailyKpiService;

    @Autowired
    private ElasticsearchConfig elasticsearchConfig;

    @ResponseBody
    @GetMapping(value = "all")
    public ResponseEntity<List<DailyKpi>> getAllAccounts() {
        return new ResponseEntity<List<DailyKpi>>(dailyKpiService.getAll(), HttpStatus.OK);
        /* List<Account> listAccount = new ArrayList<>();
          accountRepository.findAll().forEach(listAccount::add);
        return listAccount;**/
    }

    @ResponseBody
    @GetMapping(value = "{id}")
    public ResponseEntity<DailyKpi> getAccountById(@PathVariable String id) {
        DailyKpi account = new DailyKpi();
        // account = accountService.findOne(id);
        return new ResponseEntity<DailyKpi>(dailyKpiService.findOne(id).get(), HttpStatus.OK);
        /*return accountRepository.findById(id);*/
    }

    @ResponseBody
    @PostMapping(value = "add")
    public ResponseEntity<DailyKpi> setAccount(@Valid @RequestBody DailyKpi dailyKpi) {
        DailyKpi dailyKpi1 = dailyKpiService.create(dailyKpi);
        if (dailyKpi1 == null) {
            return ResponseEntity.noContent().build();
        }
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(dailyKpi1.getKpiname())
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
    public ResponseEntity<DailyKpi> deleteAccountByID(@PathVariable String id) {
        dailyKpiService.delete(id);
        return new ResponseEntity<DailyKpi>(HttpStatus.NO_CONTENT);
        //accountRepository.deleteById(id);
    }

    @ResponseBody
    @GetMapping(value = "req/{param}")
    public List getReqResponse(@PathVariable ArrayList<String> param) throws Exception {
        System.out.println("Montassar Garfa was here");
        for (int i = 0; i < param.size(); i++) {
            System.out.println("param[" + i + "]" + param.get(i));
        }
        try {
            SearchResponse response = elasticsearchConfig.client().prepareSearch("dailykpi").setTypes("_doc").execute().get();
        } catch (Exception e) {
        }
        ;


        return null;
    }


}
