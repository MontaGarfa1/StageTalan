package com.stageMonta.TalanTunisie.repositoriesElastic;

import com.stageMonta.TalanTunisie.index.MonthlyKpi;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MonthlyKpiRepository extends ElasticsearchRepository<MonthlyKpi, String> {
}
