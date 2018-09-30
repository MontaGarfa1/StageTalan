package com.stageMonta.TalanTunisie.services;

import com.stageMonta.TalanTunisie.index.Kpi;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;

public interface GenerateKpi {
    public Kpi saveKpi(ArrayList<String> info) throws IOException, ParseException;
}
