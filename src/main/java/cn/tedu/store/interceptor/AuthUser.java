package cn.tedu.store.interceptor;

import java.lang.annotation.*;

@Documented
@Target({ ElementType.METHOD, ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
public @interface AuthUser {
}
