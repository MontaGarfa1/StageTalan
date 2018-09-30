package com.stageMonta.TalanTunisie.controllers;

import com.stageMonta.TalanTunisie.index.Kpi;
import com.stageMonta.TalanTunisie.services.GenerateKpi;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.lang.reflect.Array;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Map;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("generateKpiController")
public class GenerateKpiController {
    Logger logger = LoggerFactory.getLogger(GenerateKpiController.class);
    @Autowired
    GenerateKpi generateKpi;
    @ResponseBody
    @GetMapping(value = "addKpi/{input1}")///{input2}/{input3}/{input4}/{input5}")
    public String addKpi(@PathVariable(name = "input1") JSONObject input1){/*, @PathVariable(name = "input2") ArrayList input2, @PathVariable(name = "input3") ArrayList input3, @PathVariable(name = "input4") ArrayList input4, @PathVariable(name = "input5") ArrayList input5) {
       */ System.out.println("monta monta");
        System.out.println(input1);
        return "GarfaMontassar";
    }
    @ResponseBody
    @PostMapping("savekpi")
    public Kpi saveKpi(@RequestBody  ArrayList<String> monta) throws IOException, ParseException {
        return generateKpi.saveKpi(monta);
    }

}
