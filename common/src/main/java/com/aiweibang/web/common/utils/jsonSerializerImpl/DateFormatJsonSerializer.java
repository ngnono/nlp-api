package com.aiweibang.web.common.utils.jsonSerializerImpl;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 日期格式序列化
 */
public class DateFormatJsonSerializer extends JsonSerializer<Date> {


    public DateFormatJsonSerializer() {
        this.setDateFormat("yyyy-MM-ddTHH:mm:ss");
    }

    public String getDateFormat() {
        return dateFormat;
    }

    public void setDateFormat(String dateFormat) {
        this.dateFormat = dateFormat;
    }

    private String dateFormat;

    /**
     * Jackson支持日期字符串格式
     * "yyyy-MM-dd'T'HH:mm:ss.SSSZ" "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'"
     * "EEE, dd MMM yyyy HH:mm:ss zzz" "yyyy-MM-dd"
     */
    @Override
    public void serialize(Date value, JsonGenerator jgen, SerializerProvider provider) throws IOException, JsonProcessingException {
        SimpleDateFormat formatter = new SimpleDateFormat(this.getDateFormat());
        String formattedDate = formatter.format(value);
        jgen.writeString(formattedDate);
    }
}
