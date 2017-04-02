/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.databaseassignment;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.neo4j.driver.v1.AuthTokens;
import org.neo4j.driver.v1.Driver;
import org.neo4j.driver.v1.GraphDatabase;
import org.neo4j.driver.v1.Record;
import org.neo4j.driver.v1.Session;
import org.neo4j.driver.v1.StatementResult;
import static org.neo4j.driver.v1.Values.parameters;
import org.neo4j.register.Register.Int;

/**
 *
 * @author thatOneDroid
 */
public class Neo4j {

    private Driver driver;
    Session session;
    

    public List<Long> getOne() {
        return one;
    }

    public List<Long> getTwo() {
        return two;
    }

    public List<Long> getThree() {
        return three;
    }

    public List<Long> getFour() {
        return four;
    }

    public List<Long> getFive() {
        return five;
    }
    public List<Long> one = new ArrayList();
    public List<Long> two = new ArrayList();
    public List<Long> three = new ArrayList();
    public List<Long> four = new ArrayList();
    public List<Long> five = new ArrayList();

    public Neo4j() {

    }
    public Session getSession()
    {
        
        Driver driver = GraphDatabase.driver("bolt://localhost:7687", AuthTokens.basic("neo4j", "Hotmai12"));
        Session ses = driver.session();
        
        
        return ses;
    }

    public List<Int> depthOne(int id) {
        Session ses = getSession();
        StatementResult result = ses.run("MATCH (a:Person)-[:ENDORSES]->(b:Person) WHERE a.id = {id} "
                + "RETURN  b.id as id",
                parameters("id", id));

        List endorsed = new ArrayList();

        long before = System.currentTimeMillis();
        while (result.hasNext()) {
            Record record = result.next();
            record.get("id").asString();
            endorsed.add(record.get("id").asString());
        }
        long after = System.currentTimeMillis();
        one.add((after - before));
        ses.close();
        return endorsed;
    }

    public List<Int> depthTwo(int id) {
                Session ses = getSession();

        StatementResult result = ses.run("MATCH (a:Person)-[:ENDORSES*..2]->(b:id) WHERE a.id = {id} "
                + "RETURN DISTINCT b.id as id",
                parameters("id", id));
        List endorsed = new ArrayList();

        long before = System.currentTimeMillis();
        while (result.hasNext()) {
            Record record = result.next();
            record.get("id").asString();
            endorsed.add(record.get("id").asString());
        }
        long after = System.currentTimeMillis();
        two.add((after - before));
        ses.close();
        return endorsed;
    }

    public List<Int> depthThree(int id) {
                Session ses = getSession();

        long before = System.currentTimeMillis();
        StatementResult result = ses.run("MATCH (a:Person)-[:ENDORSES*..3]->(b:Person) WHERE a.id = {id} "
                + "RETURN DISTINCT b.id as id",
                parameters("id", id));
        List endorsed = new ArrayList();

        while (result.hasNext()) {
            Record record = result.next();
            record.get("id").asString();
            endorsed.add(record.get("id").asString());
        }
        long after = System.currentTimeMillis();
        three.add((after - before));
        ses.close();
        return endorsed;
    }

    public List<Int> depthFour(int id) {
                Session ses = getSession();

        long before = System.currentTimeMillis();
        StatementResult result = ses.run("MATCH (a:Person)-[:ENDORSES*..4]->(b:Person) WHERE a.id = {id} "
                + "RETURN DISTINCT b.id as id",
                parameters("id", id));
        List endorsed = new ArrayList();

        while (result.hasNext()) {
            Record record = result.next();
            record.get("id").asString();
            endorsed.add(record.get("id").asString());
        }
        long after = System.currentTimeMillis();
        four.add((after - before));
        ses.close();
        return endorsed;
    }

    public List<Int> depthFive(int id) {
                Session ses = getSession();

        long before = System.currentTimeMillis();
        StatementResult result = ses.run("MATCH (a:Person)-[:ENDORSES*..5]->(b:Person) WHERE a.id = {id} "
                + "RETURN DISTINCT b.id as id",
                parameters("id", id));
        List endorsed = new ArrayList();

        while (result.hasNext()) {
            Record record = result.next();
            record.get("id").asString();
            endorsed.add(record.get("id").asString());
        }
        long after = System.currentTimeMillis();
        five.add((after - before));
        ses.close();
        return endorsed;
    }

    

    
}
        
     
   
    

  
    

   

