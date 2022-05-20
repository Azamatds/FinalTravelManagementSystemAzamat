package com.example.travelmanagementsystemazamat.aspect;

import com.example.travelmanagementsystemazamat.Entities.User;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Aspect
public class UserAspect {

    @Before("com.example.travelmanagementsystemazamat.aspect.MyPointcuts.getAllData()")
    public void beforeAdvice2() {
        System.out.println("Before advice");
    }

    @AfterReturning(pointcut = "com.example.travelmanagementsystemazamat.aspect.MyPointcuts.addUser()",returning = "userList")
    public void afterAdvice(List<User> userList) {
        for (int i = 0; i < userList.size(); i++) {
            if (userList.get(i).getName() != null) {
                System.out.println(i + " " + userList.get(i).getName());
            } else {
                System.out.println("OOPPSS");
            }
        }
        System.out.println("Advice AfterReturning was completed.");
    }


    @AfterThrowing(pointcut = "com.example.travelmanagementsystemazamat.aspect.MyPointcuts.allGetMethods()",throwing = "exception")
    public void afterAdviceTrowing(Throwable exception){
        System.out.println("afterAdviceTrowing " + " исключение " + exception);
    }

    @After("com.example.travelmanagementsystemazamat.aspect.MyPointcuts.getUser()")
    public void afterMethod(){
        System.out.println("After advice");
    }

    @Around("com.example.travelmanagementsystemazamat.aspect.MyPointcuts.allGetMethods()")
    public Object aroundMethod(ProceedingJoinPoint proceedingJoinPoint){
        Object target = null;
        try {
            target = proceedingJoinPoint.proceed();
        } catch (Throwable e) {
            e.printStackTrace();
        }
        System.out.println("success around method");
        return  target;
    }

}
