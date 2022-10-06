package com.mdtlabs.coreplatform.common;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.time.Instant;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * This is an implementation for converting date fields and its format respective to the user's timezone.
 *
 * @author AkashGopinath Created on 25 Aug 2022
 */
public class CustomDateSerializer extends StdSerializer<Date> {

    public static String USER_ZONE_ID;


    public CustomDateSerializer() {
        this(null);
    }

    public CustomDateSerializer(Class t) {
        super(t);
    }

    @Override
    public void serialize(Date date, JsonGenerator gen, SerializerProvider arg2)
            throws IOException {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(Constants.DATE_FORMAT_TIMEZONE);
        Instant timeStamp = date.toInstant();
        String zoneId = String.valueOf(ZoneId.of(Constants.UTC));
        if (StringUtils.isNotEmpty(CustomDateSerializer.USER_ZONE_ID)) {
            zoneId = CustomDateSerializer.USER_ZONE_ID;
        }
        ZonedDateTime zonedDateTime = timeStamp.atZone(ZoneId.of(zoneId));
        OffsetDateTime offsetDateTime = zonedDateTime.toOffsetDateTime();
        gen.writeString(offsetDateTime.format(dateTimeFormatter));
    }
}