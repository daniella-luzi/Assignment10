import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class BubbleMergeGenerics {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello! Press 1 for BubbleSort or 2 for MergeSort");
        
        Scanner scanner = new Scanner(System.in);
        int nextResponse = scanner.nextInt();

        if (nextResponse == 1) {
            System.out.println("Press 3 for a random array or 4 for a file");
            int response = scanner.nextInt();
            if (response == 3) {
                System.out.println("Enter the length of the array: ");
            int arrayLength = scanner.nextInt();
            Integer[] array = createRandomArray(arrayLength);
            System.out.println("Here is your array before it is sorted:");
            for (int i = 0; i < array.length; i++) {
                System.out.println(array[i] + " ");
            }
            System.out.println("Here is your array after it is sorted:");
            bubbleSort(array);
            writeArrayToFile(array, "sortedArray.txt");
            
        }

        if (response == 4) {
            System.out.println("Enter the name of the file:");
            String filename = scanner.next();
            Integer[] array = readFileToArray(filename);
            System.out.println("Here is your array before it is sorted:");
            for (int i = 0; i < array.length; i++) {
                System.out.println(array[i] + " ");
            }
            System.out.println("Here is your array after it is sorted:");
            bubbleSort(array);
            writeArrayToFile(array, "sortedArray2.txt");

        }
        scanner.close();
        }

        if (nextResponse == 2) {
            System.out.println("Press 3 for a random array or 4 for a file");
            int response = scanner.nextInt();
            if (response == 3) {
                System.out.println("Enter the length of the array: ");
                int arrayLength = scanner.nextInt();
                Integer[] array = createRandomArray(arrayLength);
                System.out.println("Here is your array before it is sorted:");
                for (int i = 0; i < array.length; i++) {
                    System.out.println(array[i] + " ");
                }
                System.out.println("Here is your array after it is sorted:");
                mergeSort(array);
                printArray(array);
                writeArrayToFile(array, "sortedArray.txt");

            }

            if (response == 4) {
                System.out.println("Enter the name of the file:");
            String filename = scanner.next();
            Integer[] array = readFileToArray(filename);
            System.out.println("Here is your array before it is sorted:");
            for (int i = 0; i < array.length; i++) {
                System.out.println(array[i] + " ");
            }
            System.out.println("Here is your array after it is sorted:");
            mergeSort(array);
            printArray(array);
            writeArrayToFile(array, "sortedArray2.txt");

        }
        scanner.close();
    }
            }
    
private static <T extends Comparable<T>> void mergeSort(T[] inputArray) {
    int inputLength =  inputArray.length;
        
    if (inputLength < 2) {
    return;
    }
        
    int mid = inputLength / 2;
    T[] leftArray = (T[]) new Comparable[mid];
    T[] rightArray = (T[]) new Comparable[inputLength - mid];
        
        for(int i = 0; i < mid; i++) {
            leftArray[i] = inputArray[i];
                }
        
        for(int i = mid; i < inputLength; i++) {
            rightArray[i - mid] = inputArray[i];
            }
        
        mergeSort(leftArray);
        mergeSort(rightArray);
        
        merge(inputArray, leftArray, rightArray);
                
            }      
            
private static <T extends Comparable<T>> void merge(T[] inputArray, T[] leftArray, T[] rightArray) {
    int leftHalf = leftArray.length;
    int rightHalf = rightArray.length;
        
    int i = 0;
    int j = 0;
    int k = 0;
        
        while(i < leftHalf  && j < rightHalf) {
            if(leftArray[i].compareTo(rightArray[j]) <= 0) {
                inputArray[k] = leftArray[i];
                    i++;
                }
            else {
                inputArray[k] = rightArray[j];
                    j++;
                }
                    k++;
                }
        
        while(i < leftHalf) {
            inputArray[k] = leftArray[i];
                i++;
                k++;
                }
        
        while(j < rightHalf) {
            inputArray[k] = rightArray[j];
                j++;
                k++;
                }
        
            }


public static Integer[] createRandomArray(int arrayLength){
    Random random = new Random();
    Integer[] array = new Integer[arrayLength];
    for(int i = 0; i < arrayLength; i++){
        array[i] = random.nextInt(100); 
    }
    return array;
}

public static <T extends Comparable<T>> void bubbleSort(T[] array) {
    boolean swapped = true;
    while (swapped) {
        swapped = false;
        for(int i = 0; i < array.length - 1; i++) {
            if(array[i].compareTo(array[i+1]) > 0) {
                swapped = true;
                T temp = array[i];
                array[i] = array[i+1];
                array[i+1] = temp;
            }
        }
        
    }
    for(int i = 0; i < array.length; i++) {
        System.out.println(array[i]);
    }
}

public static <T> void writeArrayToFile(T[] array, String filename) throws IOException {
    BufferedWriter writer = new BufferedWriter(new FileWriter(filename));
    for(int i = 0; i < array.length; i++){
        writer.write(array[i] + " ");
        writer.newLine();
    }
    writer.close();
}

public static Integer[] readFileToArray(String filename) throws Exception {
    BufferedReader reader = new BufferedReader(new FileReader(filename));
    int count = 0;
    String line;
    while((line  = reader.readLine()) != null) {
        count++;
    }
    Integer[] array = null;
    if (count > 0) {
        array = new Integer[count];
        int index = 0;
        reader.close();
        reader = new BufferedReader(new FileReader(filename));
        while((line = reader.readLine()) != null){
            String[] values = line.split(" ");
            for(String value : values){
                array[index++] = Integer.parseInt(value);
            }
        }
    }
    
    reader.close();
    return array;
}

private static <T> void printArray(T[] num) {
    for (int i = 0; i < num.length; i++) {
        System.out.println(num[i]);
    }
}
}




