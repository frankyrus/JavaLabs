public class MinMaxNumbers {

	public static void main(String[] args) {
		MinMaxNumbers app = new MinMaxNumbers();
		app.start();
	}

	public void start() {
		final int NUMBERS = 19;
		int[] arr = new int[NUMBERS];

		random(arr);
		output(arr);

		int iMin;
		int iMax;
		iMin = searchMin(arr);
		iMax = searchMax(arr);

		swap(arr, iMin, iMax);

		System.out.println("The maximum negative number: " + arr[iMin]);
		System.out.println("The minimum positive number: " + arr[iMax]);

		output(arr);
	}

	private int[] swap(int[] arr, int iMin, int iMax) {
		int temp = arr[iMax];
		arr[iMax] = arr[iMin];
		arr[iMin] = temp;

		return arr;
	}

	public void output(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + "\t");
		}
		System.out.println();
	}

	public int[] random(int[] arr) {
		final int MINIMUM_RANGE = -10;
		final int RANGE = 21;

		for (int i = 0; i < arr.length; i++) {
			arr[i] = (int) (Math.random() * RANGE) + MINIMUM_RANGE;
		}

		return arr;
	}

	public int searchMin(int arr[]) {
		int iMin = 0;

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] > 0) {
				iMin = i;
				break;
			}
		}
		for (int i = 0; i < arr.length; i++) {
			if ((arr[i] > 0) && (arr[i] < arr[iMin]))
				iMin = i;
		}

		return iMin;
	}

	public int searchMax(int arr[]) {
		int iMax = 0;

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] < 0) {
				iMax = i;
				break;
			}
		}
		for (int i = 0; i < arr.length; i++) {
			if ((arr[i] < 0) && (arr[i] > arr[iMax])) {
				iMax = i;
			}
		}

		return iMax;
	}
}