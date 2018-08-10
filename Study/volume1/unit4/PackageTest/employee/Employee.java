package com.volume1.unit4.PackageTest.employee;

import java.time.LocalDate;

public class Employee {
    private String name;
    private double salary;
    private LocalDate Hireday;

    public Employee(String n, double s, int year, int month, int day){
        name = n;
        salary = s;
        Hireday = LocalDate.of(year, month, day);
    }

    public String getName(){
        return name;
    }

    public double getSalary(){
        return salary;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getHireday(){
        return Hireday;
    }

    public void raiseSalary(double byPercent){
        double raise = salary * byPercent / 100;
        salary += raise;
    }
}
