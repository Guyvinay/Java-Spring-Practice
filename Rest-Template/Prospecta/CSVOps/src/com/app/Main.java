package com.app;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class Main {
	
	public static void main(String[] args) {
		String inputFilePath = "input.csv";
        String outputFilePath = "output.csv";
        try {
            Map<String, String> values = readCSV(inputFilePath);
            System.out.println(values);
            processMap(values);
        } catch (IOException e) {
            System.err.println("Error processing CSV file: " + e.getMessage());
        }
	}

    private static Map<String, String> readCSV(String filePath) throws IOException {
        Map<String, String> values = new LinkedHashMap<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                for(String str: parts){
                    String[] vals = str.split(":");
                    vals[1] = vals[1].trim();
                    vals[0] = vals[0].trim();
                    values.put(vals[0], vals[1]);
                    // System.out.println(Arrays.toString(vals));

                }
            }
        }
        return values;
    }

	private static void processMap(Map<String, String> values) {
        Map<String, Double> ansMap = new LinkedHashMap<>();
        for(Map.Entry<String, String> ent:values.entrySet()){
            String key = ent.getKey();
            String val = ent.getValue();
            if(val.startsWith("=")){
                // System.out.println(val);
                double sum = evaluateValue(val, values);
                ansMap.put(key, sum);
            }else{
                ansMap.put(key, Double.parseDouble(val));
            }
        }
        System.out.println(ansMap);
    }

    private static double evaluateValue(String str, Map<String, String> values) {
        str = str.substring(1);
        String[] vals = str.split("\\+");
        // System.out.println(Arrays.toString(vals));
        double sum = 0;
        
        for(String val: vals){
            if(values.containsKey(val)){
                // sum+= values.get(val);
                System.out.println(values.get(val));
            }
            else sum+=Double.parseDouble(val);
        }

        return sum;
    }

    
}