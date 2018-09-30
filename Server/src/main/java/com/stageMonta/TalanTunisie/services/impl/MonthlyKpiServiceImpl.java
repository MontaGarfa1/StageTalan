package com.stageMonta.TalanTunisie.services.impl;


import com.stageMonta.TalanTunisie.config.ElasticsearchConfig;
import com.stageMonta.TalanTunisie.index.MonthlyKpi;
import com.stageMonta.TalanTunisie.repositoriesElastic.MonthlyKpiRepository;
import com.stageMonta.TalanTunisie.services.MonthlyKpiService;
import org.assertj.core.util.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MonthlyKpiServiceImpl implements MonthlyKpiService {
    @Autowired
    MonthlyKpiRepository monthlyKpiRepository;
    @Autowired
    ElasticsearchConfig elasticsearchConfig;

    @Override
    public List<MonthlyKpi> getAll() {
        return Lists.newArrayList(monthlyKpiRepository.findAll());
    }

    @Override
    public Optional<MonthlyKpi> findOne(String id) {
        return monthlyKpiRepository.findById(id);
    }

    @Override
    public MonthlyKpi create(MonthlyKpi kpi) {
        return monthlyKpiRepository.save(kpi);
    }

    @Override
    public MonthlyKpi update(MonthlyKpi kpi) {
        Optional<MonthlyKpi> persitedMonthlyKpi = monthlyKpiRepository.findById(kpi.getIdKpi());
        if (persitedMonthlyKpi == null) {
            return null;
        }
        return monthlyKpiRepository.save(kpi);
    }

    @Override
    public void delete(String id) {
        monthlyKpiRepository.deleteById(id);
    }
}