import java.util.Arrays;

public class ReturnOfInvestment {

	
	public int maxProfit(int budget, String[][] arrData){
		
		// row : base line + project index
		// column : base line + budget
		
		int row = arrData.length + 1;
		int column = budget + 1;
		int finalProfit = 0; 
		
		// arrData.length = 0~9
		int[][] array = new int[row][column];
		// array.length = 11
		
		int cost = 0;
		int ROI = 0;
		
		// base line
		for(int i =0; i < column; i++){
			array[0][i] = 0;
		}
		
		// project index
		for(int i = 1; i<array.length; i++) {
			
			cost = Integer.parseInt(arrData[i-1][1]);
			ROI = Integer.parseInt(arrData[i-1][2]);
			
			//budget roof
			for(int j = 0; j<array[i].length; j++) {
				// cost�� budget ���� �۰ų� ������
				if(cost <= j) {
					// cost�� ���� ���� ������ �� �ִ�.
					array[i][j] = Math.max(array[i-1][j], array[i-1][j-cost] + ROI);
					
				}else {
					array[i][j] = array[i-1][j];
				}
			}
		}
		
		System.out.println("ROI : $" + array[row-1][column-1]);
		finalProfit = array[row-1][column-1];
		
		selectedProj(array, arrData);
		return finalProfit;
	}
	
	//back tracking
	public String[] selectedProj(int[][] maxProfit, String[][] arrData) {
	
		String[] projName = new String[arrData.length + 1];
		
		// project
		int row = maxProfit.length -1;
		// budget
		int column = maxProfit[0].length -1;
		
		
		for(int i = row; i >= 1; i--) {
			if(maxProfit[i][column] != maxProfit[i - 1][column]) {
				// �ش� row�� �ش��ϴ� proj�� �������� �ʴ´�.
				projName[i] = arrData[i-1][0];	
				column = column - Integer.parseInt(arrData[i-1][1]);
				
			}
		}
		
		int nonNullCount = 0;
		int index = 0;
		
		// null�� �ƴ� projectName count
        for (String element : projName) {
            if (element != null) {
                nonNullCount++;
            }
        }
        String[] finalProjName = new String[nonNullCount];
        
        // projName �ִ� �ֵ� ����
        for (String element : projName) {
            if (element != null) {
            	finalProjName[index++] = element;
            }
        }
		System.out.println("Selected Project Name : " + Arrays.toString(finalProjName));
		return finalProjName; 
	}
}
