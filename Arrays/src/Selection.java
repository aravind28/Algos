class Selection{
	static int[] arr;
	public static int findIthSmallest(int startIndex, int endIndex, int x){
		if((arr.length == 1) || (startIndex == endIndex)){
			return arr[startIndex];
		}
		int q = randomSelection(startIndex, endIndex);
		int k = q - startIndex + 1;
		if(x == (k)){
			return arr[q];
		}
		else if(x < k){
			return findIthSmallest(startIndex, q - 1, x);
		}
		else{
			return findIthSmallest(q + 1, endIndex, x - k);
		}
	}

	private static int randomSelection(int startIndex, int endIndex){
		int randomIndex = startIndex + (int)(Math.random() * (endIndex - startIndex + 1));
		int temp = arr[endIndex];
		arr[endIndex] = arr[randomIndex];
		arr[randomIndex] = temp;
		return partition(startIndex, endIndex);
	}

	private static int partition(int startIndex, int endIndex){
		int i = startIndex - 1, j = startIndex;
		if(startIndex < endIndex){
			int pivotElement = arr[endIndex];
			for(j = startIndex; j < endIndex; j++){
				if(arr[j] < pivotElement){
					int temp = arr[j];
					arr[j] = arr[++i];
					arr[i] = temp;
				}
			}
		}
		int temp = arr[j];
		arr[j] = arr[++i];
		arr[i] = temp;
		return i;
	}

	public static void main(String[] args){
		arr = new int[]{12, 7, 17, 19, 2, 25};
		int result = findIthSmallest(0, arr.length - 1, 2);
		System.out.println("Result: " + result);
	}
}