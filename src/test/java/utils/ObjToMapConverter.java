package utils;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;


/**
 * Convert obj to Key-Value map util class
 */

public class ObjToMapConverter {

    /**
     * Get obj as K-V map
     *
     * @param obj - object to convert
     * @return {Map} - map of object fields and values
     * @throws IllegalAccessException
     */

    public static Map getKeyValueMap(Object obj) throws IllegalAccessException {
        Field[] fields = obj.getClass().getDeclaredFields();
        Map fieldsMap = new HashMap<String, String>();



        for (Field field : fields) {
            field.setAccessible(true);
            fieldsMap.put(field.getName(), field.get(obj));
        }


        return fieldsMap;
    }
}
