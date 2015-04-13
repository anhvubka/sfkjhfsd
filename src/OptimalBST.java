
public class OptimalBST {
	public OptimalBST(double[] arr) {
		int size = arr.length - 1;
		double[][] solution = new double[size + 1][size + 1];
		for (int s = 0; s < size; s++) 
			for (int i = 1; i <= size - s;i++) {
				double p = 0;
				for (int k = i; k <= i + s;k++)
					p += arr[k];
				double minSolution = Double.MAX_VALUE;
				for(int k = i; k < i + s; k++) {
					double tmpSolution = p + solution[i][k - 1] + solution[k + 1][i + s];
					if (tmpSolution < minSolution) minSolution = tmpSolution;
				}
				double tmpSolution = p + solution[i][i + s - 1];
				if (tmpSolution < minSolution) minSolution = tmpSolution;
				solution[i][i + s] = minSolution;
			}
		System.out.println(solution[1][size]);
	}
	public static void main(String[] args) {
		double[] input = {0, 0.2, 0.05,0.17,0.1,0.2,0.03,0.25};
		OptimalBST op = new OptimalBST(input);
	}
}
