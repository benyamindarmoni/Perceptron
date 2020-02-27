
public class Perceptron {
	static double LEARNRATE=1;
	static double THRESHOLD=0;
	double[] weights;
	static int MAXITERATION=100;

	public double[] my_perceptron_train(double[][] inputs, int[] targets)
	{
		int numOfUpdate=0;
		weights = new double[inputs[0].length+1];

		//initialize weights
		for(int i=0;i<weights.length;i++)
		{
			weights[i] = 0;
		}

		boolean finish=true;
		do {
			finish=true;
			for(int j =0;j<targets.length;j++)
			{
				int output = multAndThreshold(inputs[j]);
				int error = targets[j] - output;
				if(error!=0) {
					numOfUpdate++;
					finish=false;
					for(int k = 0;k<inputs[0].length;k++)
					{
						weights[k] += LEARNRATE * inputs[j][k] * error;
					}
					weights[weights.length-1]+=LEARNRATE * error;
				}
			}
		}while(!finish);
		System.out.println("num of update: "+numOfUpdate);
		return weights;
	}

	public int multAndThreshold(double[] input)
	{
		double sum = 0.0;
		for(int i=0;i<input.length;i++)
		{
			sum += weights[i]*input[i];
		}
		sum +=weights[weights.length-1];
		if(sum>THRESHOLD)
			return 1;
		else
			return 0;
	}
	public int my_perceptron_test( double[] weights, double[][]X_test,  int[]y_test) {
		int errors=0;
		for(int j =0;j<y_test.length;j++){
			int output = multAndThreshold(X_test[j]);
			int error = y_test[j] - output;
			if(error!=0) errors++;
		}
		return errors;
	}

}