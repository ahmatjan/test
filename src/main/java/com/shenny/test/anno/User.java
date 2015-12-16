package com.shenny.test.anno;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @ClassName: User
 * @Description:
 * @author <a href="mailto:zhonghuagen@qq.com">Huagen_Zhong</a>
 * @date 2015年9月23日 下午1:17:49
 */

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface User {

	public int type() default 1;

}
