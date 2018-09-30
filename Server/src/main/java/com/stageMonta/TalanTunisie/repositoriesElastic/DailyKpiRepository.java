package com.stageMonta.TalanTunisie.repositoriesElastic;

import com.stageMonta.TalanTunisie.index.DailyKpi;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DailyKpiRepository extends ElasticsearchRepository<DailyKpi, String> {
}
