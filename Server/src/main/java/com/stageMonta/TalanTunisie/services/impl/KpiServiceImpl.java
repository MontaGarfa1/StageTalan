package com.stageMonta.TalanTunisie.services.impl;

import com.stageMonta.TalanTunisie.config.ElasticsearchConfig;
import com.stageMonta.TalanTunisie.index.Kpi;
import org.elasticsearch.action.search.SearchRequestBuilder;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.rest.RestStatus;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.sort.SortOrder;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Service
public class KpiServiceImpl {
    @Autowired

    private ElasticsearchConfig elasticsearchConfig;

    /*public ArrayList<Kpi> executeQuery(@PathVariable(name = "typeKpi") String typeKpi, @PathVariable(name = "queryList") ArrayList<String> queryList) throws Exception{
        ArrayList<Kpi> arrayList= new ArrayList<Kpi>();
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
                    Kpi dailyKpi = new Kpi();
                    dailyKpi.setIdKpi(searchHit.getId());
                    dailyKpi.setKpiname(searchHit.getSourceAsMap().get("kpiname").toString());
                    dailyKpi.setDate(searchHit.getSourceAsMap().get("date").toString());
                    dailyKpi.setLastUpdateTimestamp(searchHit.getSourceAsMap().get("lastUpdateTimestamp").toString());
                    dailyKpi.setDeviationFromTarget(searchHit.getSourceAsMap().get("deviationFromTarget").toString());
                    dailyKpi.setValue(Long.valueOf(searchHit.getSourceAsMap().get("value").toString()));
                    dailyKpi.setNbOfIncludedMeters(Long.valueOf(searchHit.getSourceAsMap().get("nbOfIncludedMeters").toString()));

                    arrayList.add(dailyKpi);
                }
                 for (int i = 0; i < arrayList.size(); i++) {
                    System.out.println("row[" + i + "]= " + arrayList.get(i).getIdKpi().toString());
                }
                return arrayList;
            }


        }catch (Exception e){}
        return null;
    }

*/
    public Map<String, ArrayList<Kpi>> executeQuery(JSONObject filter) throws Exception {

        ArrayList<Kpi> arrayList = new ArrayList<Kpi>();
        Map<String, ArrayList<Kpi>> mapKpi = new HashMap<String, ArrayList<Kpi>>();

        try {
            SearchRequestBuilder searchRequestBuilder = null;
            /**
                FILTER SELON LE TYPE DE KPI
             */
            if (filter.get("typekpi").toString().equalsIgnoreCase("all")) {
                searchRequestBuilder = elasticsearchConfig.client().prepareSearch("_all").setTypes("_doc");
            } else {
                searchRequestBuilder = elasticsearchConfig.client().prepareSearch(filter.get("typekpi").toString()).setTypes("_doc");
            }
            /**
             FILTER SELOM DATE / LAST UPDATE DATE
             */
            if (filter.get("datetype").toString().equalsIgnoreCase("date")) {
                QueryBuilder query = QueryBuilders.rangeQuery("date").gte(filter.get("dateFrom").toString()).lte(filter.get("dateTo").toString());
                System.out.println(query.toString());
                searchRequestBuilder.setQuery(query);
            } else {
                QueryBuilder query = QueryBuilders.rangeQuery("lastUpdateTimestamp").gte(filter.get("dateFrom").toString()).lte(filter.get("dateTo").toString());
                System.out.println(query.toString());
                searchRequestBuilder.setQuery(query);
            }

            /**
             SIZE RESPONSE 2000 KPI;
             SORT WITH DATE
             */
            SearchResponse searchResponse = searchRequestBuilder.setSize(2000).addSort("date", SortOrder.ASC).execute().actionGet();
            RestStatus status = searchResponse.status();
            if (status == RestStatus.OK) {
                for (SearchHit searchHit : searchResponse.getHits().getHits()) {
                    Kpi dailyKpi = new Kpi();
                    dailyKpi.setIdKpi(searchHit.getId());
                    dailyKpi.setKpiname(searchHit.getSourceAsMap().get("kpiname").toString());
                    dailyKpi.setDate(searchHit.getSourceAsMap().get("date").toString());
                    dailyKpi.setLastUpdateTimestamp(searchHit.getSourceAsMap().get("lastUpdateTimestamp").toString());
                    dailyKpi.setDeviationFromTarget(Float.valueOf(searchHit.getSourceAsMap().get("deviationFromTarget").toString()));
                    dailyKpi.setValue(Float.valueOf(searchHit.getSourceAsMap().get("value").toString()));
                    dailyKpi.setNbOfIncludedMeters(Integer.valueOf(searchHit.getSourceAsMap().get("nbOfIncludedMeters").toString()));

                    arrayList.add(dailyKpi);
                    /**
                     KEY MAP : KPI NAME
                     */
                    if (mapKpi.get(searchHit.getSourceAsMap().get("kpiname")) == null) {
                        ArrayList<Kpi> addmap = new ArrayList<Kpi>();
                        addmap.add(dailyKpi);
                        mapKpi.put(searchHit.getSourceAsMap().get("kpiname").toString(), addmap);
                    } else {
                        ArrayList<Kpi> addmap = mapKpi.get(searchHit.getSourceAsMap().get("kpiname").toString());
                        addmap.add(dailyKpi);
                        mapKpi.put(searchHit.getSourceAsMap().get("kpiname").toString(), addmap);

                    }
                }

                System.out.println("Result: \n");
                for (int i = 0; i < arrayList.size(); i++) {
                    System.out.println("row[" + i + "]= " + arrayList.get(i).getIdKpi().toString());
                }
                return mapKpi;
            }


        } catch (Exception e) {
        }
        return null;
    }
}
