package com.mdtlabs.coreplatform.common.util;

import java.beans.*;
import java.lang.reflect.*;
import java.util.*;
import java.util.stream.*;

public class RequestDataValidation {
    public static List validateRequest(Object requestObject, List<String> mandatoryFields) {
        List missingFields = new ArrayList<>();
        try {
            List classFields =
                    Arrays.stream(requestObject.getClass().getDeclaredFields()).map(a -> a.getName()).collect(
                            Collectors.toList());

            for (String field : mandatoryFields) {
                System.out.println("inside loop " + field);
                if (classFields.contains(field)) {
                    Object value =
                            new PropertyDescriptor(field, requestObject.getClass()).getReadMethod()
                                    .invoke(requestObject);
                    if (Objects.isNull(value)) {
                        missingFields.add(field);
                    }
                }
            }
        } catch (IntrospectionException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
        return missingFields;
    }
}
