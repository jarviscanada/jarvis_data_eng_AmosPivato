package ca.jrvs.apps.trading.model.Utils;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.IOException;

public class Parse {

    /**
     * parses class object and serelizes object to json string
     * @param object
     * @param prettyJson
     * @param inlcudeNullValues
     * @return Jsons String of class object object
     * @throws JsonProcessingException
     */
    public static String toJson(Object object, boolean prettyJson, boolean inlcudeNullValues) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        if (!inlcudeNullValues){
            mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        }
        if (prettyJson){
            mapper.enable(SerializationFeature.INDENT_OUTPUT);
        }
        return mapper.writeValueAsString(object);
    }

    /**
     * deserializes json string to class object
     * @param json
     * @param clazz
     * @return object of class T
     * @param <T>
     * @throws IOException
     */
    public static <T> T toObject(String json, Class clazz) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return (T) mapper.readValue(json, clazz);
    }
}
