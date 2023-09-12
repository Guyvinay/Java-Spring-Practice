package com.masai;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.CSVWriter;

public class App 
{
	
	public static void readDataLineByLine(String file)
	{
	 

		
		try {
			
			//writing to CSV file
			
			
			FileWriter fileWriter  = new FileWriter(file);
			List<List<String>> list = new ArrayList<>();
			list.add(Arrays.asList("name" , "roll" , "dept" , "res" , "cgpa" ));
			list.add(Arrays.asList("name1" , "roll1" , "dept1" , "res1" , "cgpa1" ));
			list.add(Arrays.asList("name2" , "roll" , "dept2" , "res2" , "cgpa2" ));
			list.add(Arrays.asList("name3" , "roll" , "dept3" , "res3" , "cgpa3" ));
			list.add(Arrays.asList("name4" , "roll" , "dept4" , "res4" , "cgpa4" ));

			
			
			for(List<String> it : list) {
				fileWriter.append(String.join(",", it));
				fileWriter.append("\n");
			}
			fileWriter.flush();
			fileWriter.close();
			
			
			
			//Reading from CSV file
            FileReader fileReader = new FileReader(file);
//			BufferedReader bufferedReader = new BufferedReader(fileReader);
//			
//			String str;
//			
//			while( (str = bufferedReader.readLine())!=null ) {
//				String[] records = str.split(",");
//				for(String s : records ) {
//					System.out.print(s+"\t");
//				}System.out.println();
//			}		
			
			CSVParser csvParser = new CSVParserBuilder().withSeparator(',').build();
			
			
			CSVReader build = new CSVReaderBuilder(fileReader)
					.withSkipLines(1)
					.withCSVParser(csvParser)
					.build();
			
			List<String[]> lis = build.readAll();
			
			for(String[] ele : lis) {
				for(String st : ele) {
					System.out.print(st+"\t");
				}
				System.out.println();
			}
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			List<List<String>> rows = Arrays.asList(
				    Arrays.asList("Jean", "author", "Java"),
				    Arrays.asList("David", "editor", "Python"),
				    Arrays.asList("Scott", "editor", "Node.js")
				);
			
			
			
			
			
//			
			
//			try {
//			FileReader fileReader = new FileReader(file);
//			
//			
//			CSVReader csvReader = new CSVReader(fileReader);
//			
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
			
//			
//			FileWriter csvWriter = new FileWriter(file);
//			csvWriter.append("Name");
//			csvWriter.append(",");
//			csvWriter.append("Role");
//			csvWriter.append(",");
//			csvWriter.append("Topic");
//			csvWriter.append("\n");
////			
//			for (List<String> rowData : rows) {
//			    csvWriter.append(String.join(",", rowData));
//			    csvWriter.append("\n");
//			}
//			
//			csvWriter.flush();
//			csvWriter.close();
//			
////			
//			
//			csvWrit.writeAll(list);
//			
//			
			
			
//			csvWriter.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	
    public static void main( String[] args )
    {
        
    	readDataLineByLine("demo.csv");
    	
    }
}
