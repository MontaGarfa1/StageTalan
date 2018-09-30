package com.stageMonta.TalanTunisie.index;

import org.springframework.data.elasticsearch.annotations.Document;

@Document(indexName = "weeklykpi", type = "_doc")
public class WeeklyKpi extends Kpi {

}


