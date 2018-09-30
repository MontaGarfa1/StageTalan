package com.stageMonta.TalanTunisie.services.impl;

import com.stageMonta.TalanTunisie.config.ElasticsearchConfig;
import com.stageMonta.TalanTunisie.index.WeeklyKpi;
import com.stageMonta.TalanTunisie.repositoriesElastic.WeeklyKpiRepository;
import com.stageMonta.TalanTunisie.services.WeeklyKpiService;
import org.assertj.core.util.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WeeklyKpiServiceImpl implements WeeklyKpiService {
    @Autowired
    WeeklyKpiRepository weeklyKpiRepository;
    @Autowired
    ElasticsearchConfig elasticsearchConfig;

    @Override
    public List<WeeklyKpi> getAll() {
        return Lists.newArrayList(weeklyKpiRepository.findAll());
    }

    @Override
    public Optional<WeeklyKpi> findOne(String id) {
        return weeklyKpiRepository.findById(id);
    }

    @Override
    public WeeklyKpi create(WeeklyKpi kpi) {
        return weeklyKpiRepository.save(kpi);
    }

    @Override
    public WeeklyKpi update(WeeklyKpi kpi) {
        Optional<WeeklyKpi> persitedWeeklyKpi = weeklyKpiRepository.findById(kpi.getIdKpi());
        if (persitedWeeklyKpi == null) {
            return null;
        }
        return weeklyKpiRepository.save(kpi);
    }

    @Override
    public void delete(String id) {
        weeklyKpiRepository.deleteById(id);
    }

   /* @Override
    public Map<String, Long> stateStats() {
        return null;
    }*/
}
