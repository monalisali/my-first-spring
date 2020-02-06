package xdml;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Aspect //spring-boot-starter-aop提供的注解，声明一个AOP的切面
@Configuration //Spring注释：告诉Spring这部分内容是和配置相关的（spring.aop.proxy-target-class=true），要把配置考虑进去
public class CacheAspect {
    Map<String,Object> cache = new HashMap<>();

    @Around("@annotation(xdml.anno.Cache)")
    public Object cache(ProceedingJoinPoint joinPoint) throws Throwable {
        MethodSignature signature = (MethodSignature)joinPoint.getSignature();
        String methodName = signature.getName();
        Object cachedVal = cache.get(methodName);
        if(cachedVal != null){
            System.out.println("Get Data from cache");
            return cachedVal;
        }else {
            System.out.println("Get Data from database");
            Object val = joinPoint.proceed();
            cache.put(methodName,val);
            return val;
        }
    }
}
