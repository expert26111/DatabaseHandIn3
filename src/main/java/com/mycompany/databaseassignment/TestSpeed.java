package com.mycompany.databaseassignment;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.Writer;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Set;

/**
 *
 * @author yoyo
 */
public class TestSpeed {

    public static void main(String[] args) throws SQLException, FileNotFoundException {
        DAOSQL sql = new DAOSQL();
        Random num = new Random();
        List<Double> listTimes = new ArrayList<Double>();

        List<Double> listTimes1 = new ArrayList<Double>();
        List<Double> listTimes2 = new ArrayList<Double>();
        List<Double> listTimes3 = new ArrayList<Double>();
        List<Double> listTimes4 = new ArrayList<Double>();
        List<Double> listTimes5 = new ArrayList<Double>();

        for (int i = 0; i < 20; i++) {
            int num4e = num.nextInt(500000) + 1;

            double time = timeOne(sql, num4e);
            listTimes.add(time);
            listTimes1.add(time);
            double time2 = timeTwo(sql, num4e);
            listTimes.add(time2);
            listTimes2.add(time2);
            double time3 = timeThree(sql, num4e);
            listTimes.add(time3);
            listTimes3.add(time3);
            double time4 = timeFour(sql, num4e);
            listTimes.add(time4);
            listTimes4.add(time4);
            double time5 = timeFive(sql, num4e);
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

    public static double timeOne(DAOSQL sql, int number) throws SQLException {
        double before = System.currentTimeMillis();
        sql.getOneEndorsment(number);
        double after = System.currentTimeMillis();
        return (after - before);
    }

    public static double timeTwo(DAOSQL sql, int number) throws SQLException {
        double before = System.currentTimeMillis();
        sql.getTwoEndorsments(number);
        double after = System.currentTimeMillis();
        return (after - before);
    }

    public static double timeThree(DAOSQL sql, int number) throws SQLException {
        double before = System.currentTimeMillis();
        sql.getThreeEndorsments(number);
        double after = System.currentTimeMillis();
        return (after - before);
    }

    public static double timeFour(DAOSQL sql, int number) throws SQLException {
        double before = System.currentTimeMillis();
        sql.getFourEndorsments(number);
        double after = System.currentTimeMillis();
        return (after - before);
    }

    public static double timeFive(DAOSQL sql, int number) throws SQLException {
        double before = System.currentTimeMillis();
        sql.getFiveEndorsments(number);
        double after = System.currentTimeMillis();
        return (after - before);
    }

}
