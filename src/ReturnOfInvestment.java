
public class ReturnOfInvestment {

	
	public int maxProfit(int budget, String[][] arrData){
		
		// row : base line + project index
		// column : base line + budget
		
		int row = arrData.length + 1;
		int column = budget + 1;
		
		int[][] array = new int[row][column];
		
		int cost = 0;
		String projectName = "";
		int ROI = 0;
		
		// base line
		for(int i =0; i < column; i++){
			array[0][i] = 0;
		}
		
		for(int i = 0; i<array.length; i++) {
			
			cost = Integer.parseInt(arrData[i][1]);
			ROI = Integer.parseInt(arrData[i][2]);
			
			for(int j = 0; j<array[i].length; j++) {
				
				
			}
		}
		return 1;
	}
}
