package com.yl.util;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/**
 * @author li.yang01@hand-china.com 2020/4/3 4:18 下午
 */
public class ClassOperationUtils {

    /**
     * 将类映射称map
     * @param obj 对象
     * @return map
     * @throws IllegalAccessException 异常信息
     */
    public static Map<String, Object> convertClassToMap(Object obj) throws IllegalAccessException {
        if(obj == null){
            return null;
        }
        Field[] fields = obj.getClass().getDeclaredFields();
        Map<String, Object> map = new HashMap<>(fields.length);
        for(Field field : fields){
            // 设置反射时取消Java的访问检查，暴力访问
            field.setAccessible(true);
            map.put(field.getName(),  field.get(obj));
        }
        return map;

    }

}
