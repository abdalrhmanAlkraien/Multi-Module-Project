package com.project.multimodule.aop;

import lombok.extern.log4j.Log4j2;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

/**
 * @author: Abd-alrhman Alkraien.
 * @Date: 2/13/2024
 * @Time: 5:50 PM
 */
@Component
@Aspect
@Log4j2
public class AopLogs {

    private static Integer LAST_TRACE_ID = 1;

    private final String apiPointCut=
            "execution(* com.project.multimodule.controller.module.*.*.*(..))";

    private final String errorPointCut =
            "execution(* com.project.multimodule.error.advice.GlobalExceptionHandler.*(..))";

    @Pointcut(apiPointCut)
    public void logController(){}

    @Pointcut(errorPointCut)
    public void errorLogRequest(){}

    /**
     *
     * @param joinPoint we can find inside it all the details of the method called inside the join point
     *
     * the AOP will execute this method before execute controller method
     */
    @Around("logController()")
    public Object logRequest(ProceedingJoinPoint joinPoint) throws Throwable {

        final long start = System.currentTimeMillis();

        log.info(createJoinPointForLogs(joinPoint,DataType.REQUEST));

        final Object proceed = joinPoint.proceed();

        log.info(createJoinPointForLogs(joinPoint,DataType.RESPONSE));

        final long executionTime = System.currentTimeMillis() - start;

        // for log the request attributes form client side

        log.info("\n---- Performance aspect ----\n" +
                        "method: {}\n" +
                        "execution time: {} [ms]\n" +
                        "------------------------\n",
                joinPoint.getSignature().getName(), executionTime);

        return proceed;
    }


    //@After("logController()")
    public void logResponse(JoinPoint joinPoint) {
        // for log the controller name
        log.info("API Name is : {}", joinPoint.getSignature().getName());
        // for log the request attributes form client side
        log.info(createJoinPointForLogs(joinPoint,DataType.RESPONSE));
    }


    /**
     * AOP for fetch the errors from ControllerAdvice.
     * @param joinPoint has a point cut information.
     */
    @Before("errorLogRequest()")
    public void LogError(JoinPoint joinPoint){
        // for log the controller name
        log.info("API Name is : {}", joinPoint.getSignature().getName());
        // for log the request attributes form client side
        log.info(createJoinPointForLogs(joinPoint,DataType.ERROR));
    }

    /**
     *
     * @param joinPoint we need to use it to see attributes in the original method
     * @return will return String after building all the attributes
     */
    private String createJoinPointForLogs(JoinPoint joinPoint, DataType dataType) {

        /**
         * the joinPoint has arguments from the controller,
         * but we can see the args will receive here as an Array we need to check the length of it before making any Operations.
         */
        if (joinPoint.getArgs().length < 1) {
            return joinPoint.getSignature().getName()
                    .concat(" method don`t have parameters");
        }

        Object[] obj = joinPoint.getArgs();
        StringBuilder requestValue = new StringBuilder();

        // for log the controller name
        log.info("API Name is : {}", joinPoint.getSignature().getName());

        switch (dataType) {

            case REQUEST -> {
                requestValue.append("========== The REQUEST values ==========");
            }
            case ERROR -> {
                requestValue.append("\r\n========== The ERROR values ==========");
            }
            case RESPONSE -> {
                requestValue.append("\r\n========== The RESPONSE values ==========");
            }

        }

        Arrays.stream(obj).forEach(x -> {
            requestValue.append("\r\n");
            requestValue.append(x.toString());
        });

        requestValue
                .append("\r\n============= ======="
                        + "====== =============");
        return requestValue.toString();
    }
}
