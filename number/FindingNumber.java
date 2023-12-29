package number;

import java.util.InputMismatchException;
import java.util.Scanner;

public class FindingNumber {
    public static int[] array;
    public static void findNum() {
        try {
            int num = input();
            int answer = findInArray(num);
            System.out.println(answer);
        } catch (NegativeNumberException | TooSmallNumberException e) {
            System.out.println(e.getMessage());
        } catch (InputMismatchException e){
            System.out.println("Wrong input");
        } catch (Exception e) {
            System.out.println("Unknown error");
        }
    }
    private static int findInArray(int num) throws TooSmallNumberException {
        int answer = -1;
        for (int i : array) {
            if (i < num) answer = i;
        }
        if (answer == -1) throw new TooSmallNumberException("Нет числа меньше");
        return answer;
    }
    public static void setArray(int[] intArray, boolean isSorted) {
        if (isSorted) {
            array = intArray;
        } else {
            array = sort(intArray);
        }
    }
    public static void setArray(String line) {
        String[] stringArray = line.split(" ");
        int[] array = new int[stringArray.length];
        for (int i = 0; i < array.length; i++) {
            array[i] = Integer.parseInt(stringArray[i]);
        }
        FindingNumber.array = sort(array);
    }
    private static int[] sort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int tmp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = tmp;
                }
            }
        }
        return array;
    }
    private static int input() throws NegativeNumberException {
        Scanner in = new Scanner(System.in);
        System.out.print("Введите число: ");
        int num = in.nextInt();
        if (num < 0) throw new NegativeNumberException("Число отрицательное");
        return num;
    }
}
