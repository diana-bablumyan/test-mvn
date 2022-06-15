package com.aua.testing;

import org.testng.annotations.*;

import static org.testng.Assert.*;

public class StudentTest {

    @BeforeClass
    public void beforeClass() {
        System.out.println("Before Class is working");
    }

    @AfterClass
    public void afterClass(){
        System.out.println("After Class is working");
    }

    //Data provider for TEST 1
    @DataProvider(name = "testData")
    public Object [][] getData() {
        Object[][] data = new Object[3][5];
        data[0][0] = 18;  data[0][1] = 20;     data[0][2] = 17.75;   data[0][3] = 19;   data[0][4] = 18.6875;
        data[1][0] = 15;  data[1][1] = 12.25;  data[1][2] = 16;      data[1][3] = 14;   data[1][4] = 14.3125;
        data[2][0] = 8;   data[2][1] = 9.25;   data[2][2] = 7.5;     data[2][3] = 9.5;  data[2][4] = 8.5625;
        return data;
    }

    //TEST 1
    @Test(dataProvider = "testData", priority=1)
    public void testCalculateGPA(double finPoint, double markPoint, double statPoint, double managePoint, double expected) {
        Student student = new Student();
        assertEquals(student.gpa(finPoint,markPoint, statPoint, managePoint), expected);
    }

    //Data provider for TEST 2
    @DataProvider(name = "gpaData")
    public Object[][] gpaData() {
        Object[][] data = new Object[3][2];
        data[0][0] = 18.6875;   data[0][1] = true;
        data[1][0] = 14.3125;   data[1][1] = true;
        data[2][0] = 8.5625;    data[2][1] = false;
        return data;
    }

    //TEST 2
    @Test(dataProvider = "gpaData", priority=3)
    public void testPassCourse(double gpa, boolean answer) {
        Student student = new Student();
        assertEquals(student.passCourse(gpa), answer);
    }

    //TEST 3
    @Test(priority=2)
    public void testLess() {
        Student student = new Student();
        int firstGPA = 18;
        int secondGPA = 14;

        assertFalse(student.less(firstGPA,secondGPA));
    }


}