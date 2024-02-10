package com.app;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

public class Main {

    //Path for the csv files
    static final String inputFilePath = "input.csv";
    static final String outputFilePath = "output.csv";
	
	public static void main(String[] args) {
		
        try {
            Map<String, String> values = readCSV(inputFilePath);

            System.out.println(values);

            //Process inputes from CSV file
            Map<String, Double> ans = processMap(values);

            System.out.println(ans);

            //Writing processed value to CSV file
            writeToCSVFile(ans);
        } catch (IOException e) {
            System.err.println("Error processing CSV file: " + e.getMessage());
        }
	}

    public static Map<String, String> readCSV(String filePath) throws IOException {

        Map<String, String> values = new LinkedHashMap<>();
        
        try(BufferedReader reader = new BufferedReader(new FileReader(filePath)))  {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                for(String str: parts){
                    String[] vals = str.split(":");
                    values.put(vals[0].trim(), vals[1].trim());
                }
            }
        }
        return values;
    }

	public static Map<String, Double> processMap(Map<String, String> values) {
        Map<String, Double> ansMap = new LinkedHashMap<>();
        for(Map.Entry<String, String> ent:values.entrySet()){
            String key = ent.getKey();
            String val = ent.getValue();
            if(val.startsWith("=")){
                double sum = evaluateValue(val.substring(1), values);
                ansMap.put(key, sum);
            }else{
                ansMap.put(key, Double.parseDouble(val));
            }
        }
        return ansMap;
    }

    public static double evaluateValue(String str, Map<String, String> values) {
        String[] vals = str.split("\\+");
        double sum = 0;
        for(String val: vals){
            if(values.containsKey(val)){
                // System.out.println(values.get(val));
            }
            else sum+=Double.parseDouble(val);
        }
        // System.out.println(sum);
        return sum;
    }

    
    public static void writeToCSVFile(Map<String, Double> ans) {
        try (FileWriter fileWriter = new FileWriter(outputFilePath)) {
            for(Map.Entry<String, Double> ent : ans.entrySet()){
                fileWriter.append(ent.getKey()).append(":").append(String.valueOf(ent.getValue())).append(",\n");
            }
        } catch (IOException e) {
           System.out.println("Write to CSV file failed: "+e.getMessage());
        }
    }

}

