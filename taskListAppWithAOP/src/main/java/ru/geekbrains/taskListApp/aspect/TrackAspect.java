package ru.geekbrains.taskListApp.aspect;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
public class TrackAspect {

    /**
     * Получение название целевого метода
     * @param joinPoint место применения аспекта
     */
    @Before("execution(* ru.geekbrains.taskListApp.service.*.*(..))")
    public void logBeforeMethodCall(JoinPoint joinPoint) {
        System.out.println("Был вызван метод: " + joinPoint.getSignature().getName());
    }

    /**
     * Получение места вызова и параметров целевого метода
     * @param joinPoint место применения аспекта
     */
    @After("execution(* ru.geekbrains.taskListApp.service.*.*(..))")
    public void logAfterTaskCompletion(JoinPoint joinPoint) {
        System.out.println("Метод был вызван из: " + joinPoint.getSignature().getDeclaringTypeName());
        System.out.println("Параметры метода: \n" + Arrays.toString(joinPoint.getArgs()));
    }
}