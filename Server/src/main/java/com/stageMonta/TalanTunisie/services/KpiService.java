package com.stageMonta.TalanTunisie.services;

import com.stageMonta.TalanTunisie.index.Kpi;

import java.util.List;
import java.util.Optional;

public interface KpiService<T extends Kpi> {
    List<T> getAll();

    Optional<T> findOne(String id);

    T create(T kpi);

    T update(T kpi);

    void delete(String id);

    // Map<String,Long> stateStats();
}
