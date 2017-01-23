/**
 * 
 */
package myframework.framework.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface Component{

	/**
	 * The value may indicate a suggestion for a logical component name,
	 * to be turned into a bean in case of an autodetected component.
	 * @return the suggested component name, if any
	 */
	String value() default "";

}
