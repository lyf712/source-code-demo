package org.example.demo.base;

import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author liyunfei
 **/
@Target(value = {ElementType.TYPE})
@Retention(value = RetentionPolicy.CLASS)
@Inherited
public @interface LyfAnnotation {

}
