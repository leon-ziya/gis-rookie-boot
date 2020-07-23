package cn.edu.cuhk.terra.ccu.web.commponet;

import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@Aspect
@Component
public class WebLogAspect {

    /** 以 controller 包下定义的所有请求为切入点 */
    @Pointcut("execution(public * cn.edu.cuhk.terra.ccu.modules..*.*(..))")
    public void webLog() {}

    /**
     * 在切点之前值入
     * @param joinPoint
     * @throws Throwable
     */
    @Before("webLog()")
    public void doBefore(JoinPoint joinPoint) throws Throwable {
        // 开始打印请求日志
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        // 打印请求相关参数
        log.info("========================================== Start ==========================================");
        // 打印请求 url
        log.info("URL                : {}", request.getRequestURL().toString());
        // 打印请求中的参数
        log.info("Req Params         : {}", new Gson().toJson(request.getParameterMap()));
        // 打印 Http method
        log.info("HTTP Method        : {}", request.getMethod());
        // 打印调用 controller 的全路径以及执行方法
        log.info("Class Method       : {}.{}", joinPoint.getSignature().getDeclaringTypeName(), joinPoint.getSignature().getName());
        // 打印请求的 IP
        log.info("IP                 : {}", request.getRemoteAddr());
        // 打印请求入参
        log.info("Request Args       : {}", joinPoint.getArgs());
    }

    /**
     * 环绕
     * @param proceedingJoinPoint
     * @return
     * @throws Throwable
     */
    @Around("webLog()")
    public Object doAround(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();
        Object result = proceedingJoinPoint.proceed();
        // 打印出参
        log.info("Response Args      : {}", new Gson().toJson(result));
        // 执行耗时
        log.info("Time-Consuming     : {} ms", System.currentTimeMillis() - startTime);
        return result;
    }

    /**
     * 在切点之后值入
     * @throws Throwable
     */
    @After("webLog()")
    public void doAfter(JoinPoint joinPoint) throws Throwable {
        log.info("More Info          : {}", "无");
    }

    /**
     * 切点完成后值入
     *
     * @throws Throwable
     */
    @AfterReturning(value = "webLog()", returning = "result")
    public void deReturn(JoinPoint joinPoint, Object result) throws Throwable {
        log.info("Response Result    : {}", result);
        log.info("=========================================== End ===========================================");
        log.info("");
    }

    /**
     * 在切点失败后
     * 失败时处理
     */
    @AfterThrowing(value = "webLog()", throwing = "exception")
    public void doError(JoinPoint joinPoint, Exception exception) throws Throwable {
        log.error("=================================== ERROR MESSAGE START ==================================");
        log.error("Error Message      : {}", exception);
        log.error("=================================== ERROR MESSAGE END ====================================");
    }

}
