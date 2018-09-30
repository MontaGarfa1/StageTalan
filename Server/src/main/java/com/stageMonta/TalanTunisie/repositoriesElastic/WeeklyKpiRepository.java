package com.stageMonta.TalanTunisie.repositoriesElastic;

import com.stageMonta.TalanTunisie.index.WeeklyKpi;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WeeklyKpiRepository extends ElasticsearchRepository<WeeklyKpi, String> {
}
