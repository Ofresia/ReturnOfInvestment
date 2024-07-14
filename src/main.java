import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class main {
	public static void main(String[] args) {
		
		
		// Budget -> user input
		// ProjectCost
		// 
		List<List<String>> csvData = null;
		
		Scanner sc = new Scanner(System.in);
		
		String[][] arrData;
		
		while(true) {
			
			System.out.println("Enter File Name");
			String fileName = sc.next();
		
			CSVReader csvReader = new CSVReader();
			csvData = csvReader.readCSV("C:\\Users\\gmltj\\Desktop\\github\\ReturnOfInvestment\\ROI_CSV\\" + fileName);
			
			
			
			arrData = convertToArray(csvData);
			previewData(arrData);
			
			System.out.println("Is Data Correct? [y/n]");
			String answer = sc.next();
			
			if(answer.equals("y") ) {
				break;
			}
		}
			
			System.out.println("Enter Your Budget");
			int budget = sc.nextInt();
			System.out.println("Budget : " + "$"+ budget);
			
			ReturnOfInvestment returnOfInvestment = new ReturnOfInvestment();
			
			returnOfInvestment.maxProfit(budget, arrData);
			
			
		
		
	}
	
	public static String[][] convertToArray(List<List<String>> csvData) {
		
		String[][] testData = new String[csvData.size()][3];
		
		for(int i = 0; i<csvData.size(); i++) {
			for(int j = 0; j<csvData.get(i).size(); j++) {
				testData[i][j] = csvData.get(i).get(j);
			}
		}
		
		return testData;
		
	}
	
	public static void previewData(String[][] arrData) {
		
		for(int i = 0; i<5; i++) {
			
			System.out.println(Arrays.toString(arrData[i]));
		}
		
		System.out.println("Total Data Size : " + arrData.length);
	}
	
	
	
}
