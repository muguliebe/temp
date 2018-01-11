package com.skcc.start;

import com.skcc.start.entity.common.Code;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

@Slf4j
public class TempTest {

    @Test
    public void test(){
        Code    code           = new Code();

        Field[] declaredFields = code.getClass().getDeclaredFields();

        for(Field field : declaredFields){
            log.info("field = " + field.getName());
            log.info("field.getAnnotation() = " + field.getAnnotatedType().toString());

            try {
                Code tempCode = code.getClass().newInstance();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }

        Annotation[] annotations = code.getClass().getAnnotations();
        for(Annotation a : annotations){
            log.info("a.annotationType() = " + a.annotationType());
        }

    }
}
