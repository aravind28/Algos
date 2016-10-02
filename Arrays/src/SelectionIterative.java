class SelectionIterative{
	static int[] arr;

	public static int selectionIterative(int startIndex, int endIndex, int i){
		if(startIndex == endIndex){
			return arr[startIndex];
		}

		while(true){
			int pivotIndex = randomSelection(startIndex, endIndex);
			int k = pivotIndex - startIndex + 1;
			if(i == k){
				return arr[pivotIndex];
			}
			else if(i < k){
				endIndex = pivotIndex - 1;
			}
			else{
				startIndex = pivotIndex + 1;
				i = i - k;
			}
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
        // denotes the ith smallest element in the array
        int i = 2;
		int result = selectionIterative(0, arr.length - 1, i);
		System.out.println("Result: " + result);
	}
}