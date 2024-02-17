/**
 * This class implements the natural merge sort algorithm for sorting an array of integers.
 */
public class NaturalMergeSorter 
{
	/**
	 * This method returns the length of the sorted run starting at the given index.
	 * @param array The array to search for a sorted run.
	 * @param arrayLength The number of elements in the array.
	 * @param startIndex The index at which to start searching for a sorted run.
	 * @return The length of the sorted run starting at the given index.
	 */
	public int getSortedRunLength(int[] array, int arrayLength, int startIndex) 
	{
		// Check for out-of-bounds start index
		if (startIndex < 0 || startIndex >= arrayLength) {
			return 0;
		}

		// Check for ascending run
        int runLength = 1;
        while (runLength < arrayLength && startIndex + runLength < arrayLength &&
                array[startIndex + runLength - 1] <= array[startIndex + runLength]) 
		{
           	runLength++;
        }

        return runLength;
	}

	public void naturalMergeSort(int[] array, int arrayLength) 
	{
		int i = 0;
    	while (i < arrayLength) 
		{
			// Get the length of the first sorted run
			int runLength1 = getSortedRunLength(array, arrayLength, i);

			// If the first run spans the entire array, we're done
			if (runLength1 == arrayLength) 
			{
				return;
			}

			// If the first run ends at the array's end, restart from the beginning
			if (i + runLength1 == arrayLength) 
			{
				i = 0;
				continue; // Skip to the next iteration to find a new first run
			}

			// Get the length of the second sorted run
			int runLength2 = getSortedRunLength(array, arrayLength, i + runLength1);

			// Merge the two runs
			merge(array, i, i + runLength1 - 1, i + runLength1 + runLength2 - 1);

			// Update i for the next iteration
			i += runLength1 + runLength2;

			// If the second run ends at the array's end, restart from the beginning
			if (i == arrayLength) 
			{
				i = 0;
			}
		}
	}
	
	public void merge(int[] numbers, int leftFirst, int leftLast, int rightLast) 
	{
		int mergedSize = rightLast - leftFirst + 1;
		int[] mergedNumbers = new int[mergedSize];
		int mergePos = 0;
		int leftPos = leftFirst;
		int rightPos = leftLast + 1;
      
      // Add smallest element from left or right partition to merged numbers
		while (leftPos <= leftLast && rightPos <= rightLast) 
		{
			if (numbers[leftPos] <= numbers[rightPos]) 
			{
				mergedNumbers[mergePos] = numbers[leftPos];
				leftPos++;
			}
			else 
			{
				mergedNumbers[mergePos] = numbers[rightPos];
				rightPos++;
			}
			mergePos++;
		}
      
      // If left partition isn't empty, add remaining elements to mergedNumbers
		while (leftPos <= leftLast) 
		{
			mergedNumbers[mergePos] = numbers[leftPos];
			leftPos++;
			mergePos++;
		}
      
      // If right partition isn't empty, add remaining elements to mergedNumbers
		while (rightPos <= rightLast) 
		{
			mergedNumbers[mergePos] = numbers[rightPos];
			rightPos++;
			mergePos++;
		}
      
      // Copy merged numbers back to numbers
		for (mergePos = 0; mergePos < mergedSize; mergePos++) 
		{
			numbers[leftFirst + mergePos] = mergedNumbers[mergePos];
		}
      
      // Free temporary array
		mergedNumbers = null;
	}
}