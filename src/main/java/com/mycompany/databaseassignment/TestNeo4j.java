/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package com.thaonedroid.databaseexercise3;
package com.mycompany.databaseassignment;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import org.neo4j.driver.v1.StatementResult;
import org.neo4j.register.Register;

/**
 *
 * @author thatOneDroid
 */
public class TestNeo4j {

    public static void main(String[] args) {
        Neo4j neo = new Neo4j();
        Random num = new Random();
        List<Double> listTimes = new ArrayList<Double>();

        List<Double> listTimes1 = new ArrayList<Double>();
        List<Double> listTimes2 = new ArrayList<Double>();
        List<Double> listTimes3 = new ArrayList<Double>();
        List<Double> listTimes4 = new ArrayList<Double>();
        List<Double> listTimes5 = new ArrayList<Double>();

        long start1d = System.currentTimeMillis();
        for (int i = 0; i <= 20; i++) {
            int num4e = num.nextInt(500000);
            double time = (double) timeOne(neo, num4e);
            listTimes.add(time);
            listTimes1.add(time);
            double time2 = (double) timeTwo(neo, num4e);
            listTimes.add(time2);
            listTimes2.add(time2);
            double time3 = (double) timeThree(neo, num4e);
            listTimes.add(time3);
            listTimes3.add(time3);
            double time4 = (double) timeFour(neo, num4e);
            listTimes.add(time4);
            listTimes4.add(time4);
            double time5 = (double) timeFive(neo, num4e);
            listTimes.add(time5);
            listTimes5.add(time5);
        }
        
          int count = 0;
        for (int i = 0; i < listTimes.size(); i++) {
            count++;
            System.out.println(listTimes.get(i));
            if (count == 5) {
                System.out.println("-------------------------");
                count = 0;
            }

        }

        System.out.println("THE MEDIAN IS FOR ONE ENDORSMENT " + getMedian(listTimes1));
        System.out.println("THE MEDIAN IS FOR ONE TWOENDORSMENT " + getMedian(listTimes2));
        System.out.println("THE MEDIAN IS FOR ONE THREEENDORSMENT " + getMedian(listTimes3));
        System.out.println("THE MEDIAN IS FOR ONE FOURENDORSMENT " + getMedian(listTimes4));
        System.out.println("THE MEDIAN IS FOR ONE FIVEENDORSMENT " + getMedian(listTimes5));
        
        System.out.println("THE ONE AVERAGE IS " + calculateAverage(listTimes1));
        System.out.println("THE TWO AVERAGE IS " + calculateAverage(listTimes2));
        System.out.println("THE THREE AVERAGE IS " + calculateAverage(listTimes3));
        System.out.println("THE FOUR AVERAGE IS " + calculateAverage(listTimes4));
        System.out.println("THE FIVE AVERAGE IS " + calculateAverage(listTimes5));
    }

    public static double getMedian(List<Double> list) {
        double median = 0;
        Collections.sort(list);
        if (list.size() % 2 == 0) {
            median = ((double) list.get(list.size() / 2) + (double) list.get(list.size() / 2 - 1)) / 2;
        } else {
            median = (double) list.get(list.size() / 2);
        }
        return median;

    }

    public static Double calculateAverage(List<Double> elements) {

        double sum = 0;
        for (int i = 0; i < elements.size(); i++) {
            sum += elements.get(i);
        }
        return sum / elements.size();
    }
        
        
           
    public static double timeOne(Neo4j neo, int number) {
        double before = System.currentTimeMillis();
        neo.depthOne(number);
        double after = System.currentTimeMillis();
        return (after - before);
    }

    public static double timeTwo(Neo4j neo, int number) {
        double before = System.currentTimeMillis();
        neo.depthTwo(number);
        double after = System.currentTimeMillis();
        return (after - before);
    }

    public static double timeThree(Neo4j neo, int number) {
        double before = System.currentTimeMillis();
        neo.depthThree(number);
        double after = System.currentTimeMillis();
        return (after - before);
    }

    public static double timeFour(Neo4j neo, int number){
        double before = System.currentTimeMillis();
        neo.depthFour(number);
        double after = System.currentTimeMillis();
        return (after - before);
    }

    public static double timeFive(Neo4j neo, int number) {
        double before = System.currentTimeMillis();
        neo.depthFive(number);
        double after = System.currentTimeMillis();
        return (after - before);
    }

    //long end1d = System.currentTimeMillis();
/*
    System.out.println (

    "Time taken for one depth : " + (end1d - start1d) + "milliseconds");
    System.out.println (

    "Average time taken for one depth : " + (end1d - start1d) / 20 + "milliseconds");
    System.out.println (
    "Median time for one depth : " + (mdn.getMedian(neo.one)) + "milliseconds");

        long start2d = System.currentTimeMillis();
    for (int i = 0;
    i <= 20; i

    
        ++) {
               int num4e = num.nextInt(500000);
        neo.depthTwo(num4e);
    }
    long end2d = System.currentTimeMillis();

    System.out.println (

    "Time taken for two depth : " + (end2d - start2d) + "milliseconds");
    System.out.println (

    "Average time taken for two depth : " + (end2d - start2d) / 20 + "milliseconds");
    System.out.println (
    "Median time for two depth : " + (mdn.getMedian(neo.two)) + "milliseconds");

        long start3d = System.currentTimeMillis();
    for (int i = 0;
    i <= 20; i

    
        ++) {
               int num4e = num.nextInt(500000);
        neo.depthThree(num4e);
    }
    long end3d = System.currentTimeMillis();

    System.out.println (

    "Time taken for three depth : " + (end3d - start3d) + "milliseconds");
    System.out.println (

    "Average time taken for three depth : " + (end3d - start3d) / 20 + "milliseconds");
    System.out.println (
    "Median time for three depth : " + (mdn.getMedian(neo.two)) + "milliseconds");

        long start4d = System.currentTimeMillis();
    for (int i = 0;
    i <= 20; i

    
        ++) {
               int num4e = num.nextInt(500000);
        neo.depthFour(num4e);
    }
    long end4d = System.currentTimeMillis();

    System.out.println (

    "Time taken for four depth : " + (end4d - start4d) + "milliseconds");
    System.out.println (

    "Average time taken for four depth : " + (end4d - start4d) / 20 + "milliseconds");
    System.out.println (
    "Median time for four depth : " + (mdn.getMedian(neo.one)) + "milliseconds");

        long start5d = System.currentTimeMillis();
    for (int i = 0;
    i <= 20; i

    
        ++) {
               int num4e = num.nextInt(500000);
        neo.depthFive(num4e);
    }
    long end5d = System.currentTimeMillis();

    System.out.println (

    "Time taken for five depth : " + (start5d - end5d) + "milliseconds");
    System.out.println (

    "Average time taken for five depth : " + (start5d - end5d) / 20 + "milliseconds");
    System.out.println (

"Median time for five depth : " + (mdn.getMedian(neo.one)) + "milliseconds");
*/
    //}
}