package lab10;

public class question {
    public static void main(String[] args) {
        int[] intArray = {45, 7, 2, 8, 19, 3};

        System.out.println("Before sorting:");

        for (int integer : intArray) {
            System.out.print(integer + " ");
        }

        System.out.println("\n");

        selectionSortSmallest(intArray);

        System.out.println("After sorting smallest:");

        for (int integer : intArray) {
            System.out.print(integer + " ");
        }

        System.out.println("\n");

        System.out.println("After sorting largest:");

        selectionSortLargest(intArray);

        for (int integer : intArray) {
            System.out.print(integer + " ");
        }

        System.out.println("\n\nQuestion 4: ");
        int[] secondArray = {10, 34, 2, 56, 7, 67, 88, 42};

        System.out.println("Before sorting:");

        for (int integer : secondArray) {
            System.out.print(integer + " ");
        }

        selectionSortSmallest(secondArray);

        System.out.println("\n\nAfter sorting:");

        for (int integer : secondArray) {
            System.out.print(integer + " ");
        }
    }

    public static void selectionSortSmallest(int[] arr){
        for (int i = 0; i < arr.length - 1; i++) {

            // Finding the minimum in the array
            int currentMinimum = arr[i];
            int currentMinimumIndex = i;

            for (int j = i + 1; j < arr.length; j++) {
                if (currentMinimum > arr[j]){
                    currentMinimum = arr[j];
                    currentMinimumIndex = j;
                }
            }

            // Swap array[i] with array[currentMinimumIndex] if necessary
            if(currentMinimumIndex != i){
                arr[currentMinimumIndex] = arr[i];
                arr[i] = currentMinimum;
            }

        }
    }

    public static void selectionSortLargest(int[] arr){
        for (int i = 0; i < arr.length - 1; i++) {

            // Finding the minimum in the array
            int currentMaximum = arr[i];
            int currentMaximumIndex = i;

            for (int j = i + 1; j < arr.length; j++) {
                if (currentMaximum < arr[j]){
                    currentMaximum = arr[j];
                    currentMaximumIndex = j;
                }
            }

            // Swap array[i] with array[currentMinimumIndex] if necessary
            if(currentMaximumIndex != i){
                arr[currentMaximumIndex] = arr[i];
                arr[i] = currentMaximum;
            }

        }
    }

}
