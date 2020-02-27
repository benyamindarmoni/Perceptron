import java.util.Arrays;
import java.util.LinkedList;
public class PerceptronTest {

	public static void main(String[] args) {
	
		Perceptron p = new Perceptron();
		double [][]input= {
				{5.0,3.5},
				{4.5,2.3},
				{4.4,3.2},
				{5.0,3.5},
				{5.1,3.8},
				{4.8,3.0},
				{5.1,3.8},
				{4.6,3.2},
				{5.3,3.7},
				{5.0,3.3},
				{5.0,3.2},
				{5.5,3.5},
				{4.9,3.1},
				{4.4,3.0},
				{5.1,3.4},
				{4.8,3.1},
				{5.4,3.4},
				{5.2,4.1},
				{5.5,4.2},
				{4.9,3.1},
				{5.0,3.0},
				{5.0,3.4},
				{5.2,3.5},
				{5.2,3.4},
				{4.7,3.2},
				{5.4,3.4},
				{5.1,3.7},
				{4.6,3.6},
				{5.1,3.3},
				{4.8,3.4},
				{5.7,4.4},
				{5.4,3.9},
				{5.1,3.5},
				{5.7,3.8},
				{5.1,3.8},
				{5.4,3.7},
				{4.8,3.4},
				{4.8,3.0},
				{4.3,3.0},
				{5.8,4.0},
				{5.1,3.5},
				{4.9,3.0},
				{4.7,3.2},
				{4.6,3.1},
				{5.0,3.6},
				{5.4,3.9},
				{4.6,3.4},
				{5.0,3.4},
				{4.4,2.9},
				{4.9,3.1},










				{5.0,2.0},
				{5.9,3.0},
				{6.0,2.2},
				{6.1,2.9},
				{5.6,2.9},
				{5.5,2.6},
				{6.1,3.0},
				{5.8,2.6},
				{5.0,2.3},
				{5.6,2.7},
				{5.7,3.0},
				{5.7,2.9},
				{6.2,2.9},
				{5.1,2.5},
				{5.7,2.8},
				{6.0,3.4},
				{6.7,3.1},
				{6.3,2.3},
				{5.6,3.0},
				{5.5,2.5},	
				{7.0,3.2},
				{6.4,3.2},
				{6.9,3.1},
				{5.5,2.3},
				{6.5,2.8},
				{5.5,2.4},
				{5.5,2.4},
				{5.8,2.7},
				{6.0,2.7},
				{5.4,3.0},
				{6.6,3.0},
				{6.8,2.8},
				{6.7,3.0},
				{6.0,2.9},
				{5.7,2.6},
				{5.9,3.2},
				{6.1,2.8},
				{6.3,2.5},
				{6.1,2.8},
				{6.4,2.9},
				{6.7,3.1},
				{5.6,3.0},
				{5.8,2.7},
				{6.2,2.2},
				{5.6,2.5},
				{5.7,2.8},
				{6.3,3.3},
				{4.9,2.4},
				{6.6,2.9},
				{5.2,2.7},




		};

		int []tar= {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0
				,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1};

		int ran= 10*((int) ((Math.random()*(10))+1));
		//ran=100;
		LinkedList<Integer> alreadyTake=new LinkedList<Integer>();
		double[][] inputTrain= new double [ran][2];
		int []tarTrain=new int[ran];
		int line;
		for (int i = 0; i < ran; i++) {
			line=(int) ((Math.random()*(100)));
			while(alreadyTake.contains(line))
				line=(int) ((Math.random()*(100)));
			alreadyTake.add(line);
			inputTrain[i][0]=input[line][0];
			inputTrain[i][1]=	input[line][1];
			tarTrain[i]=tar[line];
		}


		double[][] inputTest= new double [100-ran][2];
		int []tarTest=new int[100-ran];

		for (int i = 0; i < inputTest.length; i++) {
			line=(int) ((Math.random()*(100)));
			while(alreadyTake.contains(line))
				line=(int) ((Math.random()*(100)));
			alreadyTake.add(line);
			inputTest[i][0]=input[line][0];
			inputTest[i][1]=	input[line][1];
			tarTest[i]=tar[line];
		}

		
		

		System.out.println("for "+ran+" % of training:");
		System.out.println(Arrays.toString( p.my_perceptron_train(inputTrain, tarTrain)));  
		System.out.println("for "+(100-ran)+" % of testing:");
		System.out.println("num of errors is: "+ p.my_perceptron_test(p.weights,inputTest,tarTest));     
	}
}