package com.app;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

public class Main {

    //Path for the csv files
    static final File inputFilePath = new File("input.csv");
    static final File outputFilePath = new File("output.csv");
	
	public static void main(String[] args) {
		
            //declaring method to read  values from CSV file
            Map<String, String> values = readCSV(inputFilePath);

            System.out.println(values);

            //Process inputes from CSV file
            Map<String, Double> ans = processMap(values);

            System.out.println(ans);

            //Writing processed value to CSV file
            writeToCSVFile(ans);


	}

    public static Map<String, String> readCSV(File filePath) {

        //declaring LinkedHashMap to store read entries from CSV file in order
        Map<String, String> values = new LinkedHashMap<>();

        //Try with resources to handle File Reader likely exceptions
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {

            //Reading lines from file
            String line;
            while ((line = reader.readLine()) != null) {

                //split values with ,
                String[] entries = line.split(",");
                for(String str: entries){
                    //getting key-value pair as : divides key-value in csv
                    String[] vals = str.split(":");

                    //storing literals as key and value as value in Map
                    values.put(vals[0].trim(), vals[1].trim());
                }
            }
        } catch (IOException e) {
            System.out.println("Reading CSV file failed!!! "+ e.getMessage());
        }
        return values;
    }

    //Processing Extracted map from CSV file to do airthmatic ops
	public static Map<String, Double> processMap(Map<String, String> values) {

        //Map to store airthematice operated entries in map
        Map<String, Double> ansMap = new LinkedHashMap<>();

        //Iterating throught it
        for(Map.Entry<String, String> ent:values.entrySet()){
            String key = ent.getKey();
            String val = ent.getValue();

            //if value starts with '=' perform airthematic ops on that entry
            if(val.startsWith("=")){
                double sum = evaluateValue(val.substring(1), ansMap);
                ansMap.put(key, sum);
            }else{
                ansMap.put(key, Double.parseDouble(val));
            }
        }
        return ansMap;
    }

    //Calculating sum when encountered '='
    public static double evaluateValue(String str, Map<String, Double> values) {
        //Split expression 'A+B' so Am B values can be get
        String[] vals = str.split("\\+");
        double sum = 0;
        for(String val: vals){
            if(values.containsKey(val)){
                sum+= values.get(val);
            }
            else sum+=Double.parseDouble(val);
        }
        return sum;
    }
    
    //Writing to CSV file after processing retrieved data
    public static void writeToCSVFile(Map<String, Double> ans) {

        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(outputFilePath))) {
            
            for(Map.Entry<String, Double> ent : ans.entrySet()){
                bufferedWriter.append(ent.getKey()).append(":").append(String.valueOf(ent.getValue())).append(",\n");
            }
        } catch (IOException e) {
           System.out.println("Write to CSV file failed: "+e.getMessage());
        }
    }
}