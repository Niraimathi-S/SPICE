package com.mdtlabs.coreplatform.common.util;

import java.util.Map;

import com.mdtlabs.coreplatform.common.UnitConstants;


public class UnitConversion {

    public static void convertUnit(Map<String, Float> data, String unit) {

        // for (String field : UnitConstants.FIELDS) {
        //   if (unit == UnitConstants.IMPERIAL) {
        //     float imperialValue = convertMetricToImperial(data[field], field);
        //     data[field] = Number(imperialValue);
        //   } else if (unit === UnitConstants.METRIC) {
        //     const metricValue = AppUtils.convertImperialToMetric(data[field], field);
        //     data[field] = Number(metricValue);
        //   }
          
        // }

    }


    /**
   * Convert Imperial unit height(in) to Metric unit height(cm) and vice versa
   *
   * @param value Imperial height value
   * @param unit Height unit name
   * @returns value metric height or value imperial height
   *  
   */
  public static float convertHeight(float value, String convertUnit) {
    float height = 0.0f;
    if (convertUnit == UnitConstants.IMPERIAL) {
      height = (value * UnitConstants.DEFAULT_HEIGHT_UNIT_VALUE);
    } else {
      height = (value / UnitConstants.DEFAULT_HEIGHT_UNIT_VALUE);
    }
    return Float.parseFloat(String.format("%.2f", height));
  }

  /**
   * Convert Imperial unit temperature(F) to Metric unit temperature(C) and vice versa
   *
   * @param value Imperial temperature value
   * @param unit Temperature unit name
   * @returns value metric temperature or imperiar temperature
   * 
   */
  public static float convertTemperature(float value, String convertUnit) {
    float temperature = 0.0f;
    if (convertUnit == UnitConstants.IMPERIAL) {
      temperature = (((value - 32) * 5) / 9);
    } else {
      temperature = ((value * 9) / 5 + 32);
    }
    return Float.parseFloat(String.format("%.2f", temperature));
  }

  /**
   * Convert Imperial unit weight(pounds) to Metric unit weight(kg) and vice versa
   *
   * @param value Weight value
   * @param unit Weight unit name
   * @returns value metric weight or imperial weight
   * @author Shrikanth
   */
  public static float convertWeight(float value, String convertUnit) {
    float weight = 0.0f;
    if (convertUnit == UnitConstants.IMPERIAL) {
      weight = (value / UnitConstants.DEFAULT_WEIGHT_UNIT_VALUE);
    } else {
      weight = (value * UnitConstants.DEFAULT_WEIGHT_UNIT_VALUE);
    }
    return Float.parseFloat(String.format("%.2f", weight));
  }


  public static float convertMgDlToMmol(float value) {
    return Float.parseFloat(String.format("%.2f", (value / 18)));
  }    
}
