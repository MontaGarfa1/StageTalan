package com .stageMonta.TalanTunisie.index;

import org.springframework.data.elasticsearch.annotations.Document;

@Document(indexName = "monthlykpi", type = "_doc")
public class MonthlyKpi extends Kpi {

}
