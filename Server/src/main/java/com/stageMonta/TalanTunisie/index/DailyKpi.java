package com.stageMonta.TalanTunisie.index;

import org.springframework.data.elasticsearch.annotations.Document;

@Document(indexName = "dailykpi", type = "_doc")
public class DailyKpi extends Kpi {

}
