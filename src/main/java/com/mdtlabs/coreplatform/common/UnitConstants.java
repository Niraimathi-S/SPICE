package com.mdtlabs.coreplatform.common;

import java.util.ArrayList;
import java.util.Map;

import org.springframework.data.geo.Metric;

public final class UnitConstants {

    private UnitConstants() {
    };

    public static final Float DEFAULT_WEIGHT_UNIT_VALUE = 2.205f;
    public static final Float DEFAULT_HEIGHT_UNIT_VALUE = 2.54f;

    public static final String METRIC = "metric";
    public static final String IMPERIAL = "imperial";

    public static final String WEIGHT = "weight";
    public static final String HEIGHT = "height";
    public static final String TEMPERATURE = "temperature";

    public static final String[] FIELDS = {WEIGHT, HEIGHT, TEMPERATURE};

    public static final Map<String, String> METRIC_UNITS = Map.of(WEIGHT, "kg", HEIGHT, "cm", TEMPERATURE, "C"); 
    public static final Map<String, String> IMPERIAL_UNITS = Map.of(WEIGHT, "pounds", HEIGHT, "in", TEMPERATURE, "F"); 

    
    /*
     * DEFAULT_WEIGHT_UNIT_VALUE: 2.205,
  DEFAULT_HEIGHT_UNIT_VALUE: 2.54,
  METRIC: 'metric',
  METRIC_UNITS: {
    WEIGHT: 'kg',
    HEIGHT: 'cm',
    TEMPERATURE: 'C'
  },
  IMPERIAL: 'imperial',
  IMPERIAL_UNITS: {
    WEIGHT: 'pounds',
    HEIGHT: 'in',
    TEMPERATURE: 'F'
  },
  FIELDS: {
    HEIGHT: 'height',
    WEIGHT: 'weight',
    TEMPERATURE: 'temperature'
  }
     */
}
