package com.stageMonta.TalanTunisie.services.impl;


import com.stageMonta.TalanTunisie.config.ElasticsearchConfig;
import com.stageMonta.TalanTunisie.index.DailyKpi;
import com.stageMonta.TalanTunisie.repositoriesElastic.DailyKpiRepository;
import com.stageMonta.TalanTunisie.services.DailyKpiService;
import org.assertj.core.util.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DailyKpiServiceImpl implements DailyKpiService {
    @Autowired
    DailyKpiRepository dailyKpiRepository;
    @Autowired
    ElasticsearchConfig elasticsearchConfig;

    @Override
    public List<DailyKpi> getAll() {
        return Lists.newArrayList(dailyKpiRepository.findAll());
    }

    @Override
    public Optional<DailyKpi> findOne(String id) {
        return dailyKpiRepository.findById(id);
    }

    @Override
    public DailyKpi create(DailyKpi kpi) {
        return dailyKpiRepository.save(kpi);
    }

    @Override
    public DailyKpi update(DailyKpi kpi) {
        Optional<DailyKpi> persitedDailyKpi = dailyKpiRepository.findById(kpi.getIdKpi());
        if (persitedDailyKpi == null) {
            return null;
        }
        return dailyKpiRepository.save(kpi);
    }

    @Override
    public void delete(String id) {
        dailyKpiRepository.deleteById(id);

    }
}