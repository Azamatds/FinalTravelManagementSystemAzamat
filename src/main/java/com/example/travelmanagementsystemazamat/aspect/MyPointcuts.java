package com.example.travelmanagementsystemazamat.aspect;

import org.aspectj.lang.annotation.Pointcut;

public class MyPointcuts {
    @Pointcut("execution(public * com.example.travelmanagementsystemazamat.Service.impl.JDBCUserServiceImpl.getAllUsers(..))")
    public void getAllData(){}

    @Pointcut("execution(public * com.example.travelmanagementsystemazamat.Service.impl.JDBCUserServiceImpl.save(..))")
    public void addUser(){}

    @Pointcut("execution(public * com.example.travelmanagementsystemazamat.Service.impl.JDBCUserServiceImpl.getUser(..))")
    public void getUser(){}

    @Pointcut("execution(public * com.example.travelmanagementsystemazamat.Service.impl.JDBCUserServiceImpl.get*(..))")
    public void allGetMethods(){}
}
