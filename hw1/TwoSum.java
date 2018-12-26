import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class TwoSum{
	
	public static void main(String[] args) throws IOException{
		String sCurrentLine; 
		BufferedReader br = new BufferedReader(new FileReader("test2sum.txt"));
		
		int currentIndex = 0;
		int[] numbers = null;
		int sumValue = 0;
		while ((sCurrentLine = br.readLine()) != null) {
			if(currentIndex % 2 == 0) {
				numbers = getNumbers(sCurrentLine);
			} else {
				sumValue = Integer.parseInt(sCurrentLine);
				boolean hasTwoSum = hasTwoSumInArray(numbers, sumValue);
				System.out.println(hasTwoSum);
			}
			currentIndex ++;
			
		}
	}
	
	private static boolean hasTwoSumInArray(int[] numbers, int sumValue) {
		boolean result = false;
		// Your code goes here and set result
        int n1,n2;                                          //1
        for(int i=0;i<numbers.length;i++){                  //n+1
            n1=numbers[i];                                  //n
            for(int j=i+1;j<numbers.length;j++){            // n   n-1 n-2 ... 1   (1+n)n /2
                n2=numbers[j];                              // n-1 n-2 n-3 ....0   (n-1)n /2
                if(n1+n2==sumValue){                        // (n-1)n/2
                    return true;                            // 1
                }
            }
        }
		
		return result;
	}
	
	private static int[] getNumbers(String currentLine) {
		String[] items = currentLine.split(",");
		int[] numbers = new int[items.length];
		for(int i = 0; i < items.length; i++) {
			try {
				numbers[i] = Integer.parseInt(items[i]);
			} catch(NumberFormatException e) {
				System.out.println("Error Occurred: " + e.getMessage());
			}
		}
		
		return numbers;
	}
}
