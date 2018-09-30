package com.stageMonta.TalanTunisie.controllers;

import com.stageMonta.TalanTunisie.index.Kpi;
import com.stageMonta.TalanTunisie.services.impl.KpiServiceImpl;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600, allowCredentials = "false")
@RestController
@RequestMapping("/allKpi")
public class KpiController {
    @Autowired
    private KpiServiceImpl kpiService;

    @ResponseBody
    @GetMapping(value = "query/{filter}")
    public Map<String, ArrayList<Kpi>> executeQuery(@PathVariable JSONObject filter) throws Exception {
        return kpiService.executeQuery(filter);

    }
   /* @ResponseBody
    @GetMapping(value = "query/{typeKpi}/{queryList}")
    public ArrayList<Kpi> executeQuery(@PathVariable(name = "typeKpi") String typeKpi,@PathVariable(name = "queryList") ArrayList<String> queryList) throws Exception{
        return kpiService.executeQuery(typeKpi,queryList);
       /* ArrayList<DailyKpi> arrayList= new ArrayList<DailyKpi>();
        try {
            String fieldFilter = "";
            String vauleFilter = "";
            System.out.println(typeKpi);
            SearchRequestBuilder searchRequestBuilder = null;
            if(typeKpi.equalsIgnoreCase("all")){
                 searchRequestBuilder = elasticsearchConfig.client().prepareSearch("_all").setTypes("_doc");
            }else{
                searchRequestBuilder = elasticsearchConfig.client().prepareSearch(typeKpi).setTypes("_doc");
            }
            BoolQueryBuilder query = QueryBuilders.boolQuery();

            System.out.println(queryList);
            for (int i=0;i<queryList.size();i++){
                fieldFilter = queryList.get(i).substring(0,queryList.get(i).indexOf("="));
                vauleFilter =queryList.get(i).substring(queryList.get(i).indexOf("=")+1,queryList.get(i).toString().length());

                System.out.println(fieldFilter+"/////"+vauleFilter);
                System.out.println(queryList.get(i).toString());
                query.must().add(QueryBuilders.termQuery(fieldFilter,vauleFilter));

            }
            searchRequestBuilder.setQuery(query);

            SearchResponse searchResponse = searchRequestBuilder.setSize(100).execute().get();
            RestStatus status = searchResponse.status();
            if (status == RestStatus.OK) {
                for (SearchHit searchHit : searchResponse.getHits().getHits()) {
                    DailyKpi dailyKpi = new DailyKpi();
                    dailyKpi.setIdKpi(searchHit.getId());
                    dailyKpi.setKpiname(searchHit.getSourceAsMap().get("kpiname").toString());
                    dailyKpi.setDate(searchHit.getSourceAsMap().get("date").toString());
                    dailyKpi.setLastUpdateTimestamp(searchHit.getSourceAsMap().get("lastUpdateTimestamp").toString());
                    dailyKpi.setDeviationFromTarget(searchHit.getSourceAsMap().get("deviationFromTarget").toString());
                    dailyKpi.setValue(Long.valueOf(searchHit.getSourceAsMap().get("value").toString()));
                    dailyKpi.setNbOfIncludedMeters(Long.valueOf(searchHit.getSourceAsMap().get("nbOfIncludedMeters").toString()));

                    arrayList.add(dailyKpi);
                }
                System.out.println("Result: \n");
                for (int i = 0; i < arrayList.size(); i++) {
                    System.out.println("row[" + i + "]= " + arrayList.get(i).getIdKpi().toString());
                }
                return arrayList;
            }


        }catch (Exception e){}
        return null;*/
    //}

}
