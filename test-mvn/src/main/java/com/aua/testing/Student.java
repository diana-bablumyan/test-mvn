package com.aua.testing;

public class Student {
    public double gpa(double finPoint, double markPoint, double statPoint, double managePoint){
        return (finPoint + markPoint + statPoint + managePoint) / 4;
    }
    public boolean passCourse(double gpa){
        if (gpa > 12) {
            return true;
        } else {
            return false;
        }
    }

    public boolean less(double firstGPA, double secondGPA){
        return firstGPA < secondGPA;
    }
}