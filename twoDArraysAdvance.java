import java.util.*;
import java.util.Scanner;

public class twoDArraysAdvance {
    public static void main(String[] args) {
        int[][] a;
        a = new int[][] { { 10, 30, 50, 200 }, { 60, 40, 70, 55 }, { 80, 5, 35, 100 } };
        System.out.println("Number 1: Sum and Average");
        Number1_SumAverage(a);
        System.out.println();

        System.out.println("Number 2: Largest and Smallest values");
        Number2_LargeSmall(a);
        System.out.println();

        System.out.println("Number 4: Rows and Columns average values");
        Number4_averageRowColumn(a);
        System.out.println();

        a = new int[][] { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 } };
        System.out.println("Number 3: Odd and Even values");
        Number3_OddEven(a);
        System.out.println();

        System.out.println("Number 5: Edges Sum");
        Number5_Edges(a);
        System.out.println();

        System.out.println("Number 6: Both Diagonals Sum for Even Square Dimension");
        a = new int[][] { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 } };
        Number6_DiagonalSum(a);
        System.out.println();

        System.out.println("Number 6: Both Diagonals Sum for Odd Square Dimension");
        a = new int[][] { { 1, 2, 3, 4, 5 }, { 6, 7, 8, 9, 10 }, { 11, 12, 13, 14, 15 }, { 16, 17, 18, 19, 20 },
                { 21, 22, 23, 24, 25 } };
        Number6_DiagonalSum(a);
        System.out.println();

        System.out.println("Number 7: Word with most vowel count");
        String[][] word = { { "dog", "kitty", "moose", "ant", "elephant" },
                { "frog", "bird", "bat", "porcupine", "mice" },
                { "lion", "zebra", "snake", "toad", "turtle" } };
        Number7_vowel(word);
        System.out.println();

        System.out.println("Number 7 Challenge: Word with most vowel count");
        String[][] word2 = { { "dog", "kitty", "moose", "ant", "elephant" },
                { "frog", "bird", "bat", "porcupine", "mice" },
                { "lion", "zebra", "snake", "toad", "companies" } };
        Number7_vowel(word2);
        System.out.println();

        System.out.println("Number 8: Bulls Eye game board");
        int[][] board = { { 10, 10, 10, 10, 10 }, { 10, 50, 50, 50, 10 }, { 10, 50, 100, 50, 10 },
                { 10, 50, 50, 50, 10 }, { 10, 10, 10, 10, 10 } };
        Number8_random(board);
        System.out.println();

        System.out.println("Number 9: Switching rows and columns");
        a = new int[][] { { 1, 2, 3, 4, 5 },
                { 6, 7, 8, 9, 10 },
                { 11, 12, 13, 14, 15 },
                { 16, 17, 18, 19, 20 },
                { 21, 22, 23, 24, 25 } };
        Number9_changing(a);
        System.out.println();

        System.out.println("Number 10: Smoking and Non-smoking");
        int[][] b = new int[2][6];
        Number10_smoking(b);
    }

    public static void Number1_SumAverage(int[][] a) {
        int sum = 0;
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                sum += a[i][j];
            }
        }
        double average = (double) sum / (a.length * a[0].length);
        System.out.println("Sum = " + sum + "    Average = " + average);
    }

    public static void Number2_LargeSmall(int[][] a) {
        int small = a[0][0];
        int large = a[0][0];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                if (a[i][j] < small)
                    small = a[i][j];
                else if (a[i][j] > large)
                    large = a[i][j];
            }
        }
        System.out.println("Largest = " + large + "    Smallest = " + small);
    }

    public static void Number3_OddEven(int[][] a) {
        int odd = 0;
        int even = 0;
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                if (a[i][j] % 2 != 0)
                    odd++;
                else if (a[i][j] % 2 == 0)
                    even++;
            }
        }
        System.out.println("OddCount = " + odd + "    EvenCount = " + even);
    }

    public static void Number4_averageRowColumn(int[][] a) {
        double maxAvgRow = 0.0;
        int maxRow = -1;
        double maxAvgCol = 0.0;
        int maxCol = -1;
        int sum = 0;
        double average = 0.0;

        for (int i = 0; i < a.length; i++) {
            sum = 0;
            for (int j = 0; j < a[i].length; j++) {
                sum += a[i][j];
            }
            average = (double) sum / a[i].length;
            if (average > maxAvgRow) {
                maxAvgRow = average;
                maxRow = i;
            }
            System.out.println("Average of row " + i + " = " + average);
        }
        System.out.println("Row with MaxAvg is row " + maxRow + " with MaxAvg = " + maxAvgRow);

        for (int j = 0; j < a[0].length; j++) {
            sum = 0;
            for (int i = 0; i < a.length; i++) {
                sum += a[i][j];
            }
            average = (double) sum / a.length;
            if (average > maxAvgCol) {
                maxAvgCol = average;
                maxCol = j;
            }
            System.out.println("Average of column " + j + " = " + average);
        }
        System.out.println("Column with MaxAvg is column " + maxCol + " with MaxAvg = " + maxAvgCol);
    }

    public static void Number5_Edges(int[][] a) {
        int sum = 0;
        for (int j = 0; j < a[0].length; j++) {
            sum += a[0][j] + a[a.length - 1][j];
        }

        for (int i = 1; i < a.length - 1; i++) {
            sum += a[i][0] + a[i][a[i].length - 1];
        }
        System.out.println("Sum of the edges = " + sum);
    }

    public static void Number6_DiagonalSum(int[][] a) {
        int sum = 0;
        if (a.length * a[0].length % 2 == 0) {
            for (int i = 0; i < a.length; i++) {
                sum += a[i][i];
            }

            int count = a[0].length - 1;
            for (int i = 0; i < a.length; i++) {
                sum += a[i][count];
                count--;
            }
        }

        else if (a.length * a[0].length % 2 != 0) {
            for (int i = 0; i < a.length; i++) {
                sum += a[i][i];
            }

            int middle = a[0].length / 2;
            int count = a[0].length - 1;
            for (int i = 0; i < a.length; i++) {
                if (count != middle) {
                    sum += a[i][count];
                    count--;
                } else if (count == middle) {
                    count--;
                    i++;
                    sum += a[i][count];
                    count--;
                }
            }
        }
        System.out.println("BOTH diagonals sum = " + sum);
    }

    public static void Number7_vowel(String[][] a) {
        String word = a[0][0];
        int row = -1;
        int col = -1;
        int vowelCount = 0;
        int vowel = 0;
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                vowel = 0;
                for (int k = 0; k < a[i][j].length(); k++) {
                    if (a[i][j].charAt(k) == 'a' || a[i][j].charAt(k) == 'e' || a[i][j].charAt(k) == 'i'
                            || a[i][j].charAt(k) == 'o' || a[i][j].charAt(k) == 'u')
                        vowel++;
                    if (vowel >= vowelCount) {
                        vowelCount = vowel;
                        row = i;
                        col = j;
                        word = a[i][j];
                    }
                }
            }
        }
        System.out.println(
                "Word: " + word + "    Position: row = " + row + ", col = " + col + "   Vowel Count = " + vowelCount);
    }

    public static void Number8_random(int[][] a) {
        int hit = -1;
        int row = -1;
        int col = -1;
        Random r = new Random();
        for (int i = 1; i <= 3; i++) {
            row = r.nextInt(a.length - 1);
            col = r.nextInt(a[0].length - 1);
            hit = a[row][col];
            System.out.println("Hit row: " + row + "   col: " + col + "   Point: " + hit);
        }
    }

    public static void Number9_changing(int[][] a) {
        int count = a[0].length - 1;
        int temp = -1;
        for (int i = a.length - 1; i > 0; i--) {
            for (int j = 0; j <= i; j++) {
                temp = a[j][i];
                a[j][i] = a[i][j];
                a[i][j] = temp;
            }
        }

        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                System.out.print(a[i][j] + ", ");
            }
            System.out.println();
        }
    }

    public static void Number10_smoking(int[][] a) {
        int Row1Smoke = 0;
        int Row2Smoke = 0;
        int Row1Non = 2;
        int Row2Non = 2;
        char answer;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("Do you want smoking or non-smoking? (S/N)");
            answer = sc.next().charAt(0);
            if (answer == 'S' || answer == 's') {
                a[0][Row1Smoke] = 1;
                Row1Smoke++;
            } else if (answer == 'N' || answer == 'n') {
                a[0][Row1Non] = 1;
                Row1Non++;
            }
            printArray(a);
        } while (Row1Smoke < 2 && Row1Non < 6);

        if (Row1Smoke == 2 && Row1Non < 6) {
            do {
                System.out.println("Do you want smoking or non-smoking? (S/N)");
                answer = sc.next().charAt(0);
                if (answer == 'S' || answer == 's') {
                    a[1][Row2Smoke] = 1;
                    Row2Smoke++;
                } else if (answer == 'N' || answer == 'n') {
                    a[0][Row1Non] = 1;
                    Row1Non++;
                }
                printArray(a);
            } while (Row2Smoke < 2 && Row1Non < 6);
        }

        else if (Row1Smoke < 2 && Row1Non == 6) {
            do {
                System.out.println("Do you want smoking or non-smoking? (S/N)");
                answer = sc.next().charAt(0);
                if (answer == 'S' || answer == 's') {
                    a[0][Row1Smoke] = 1;
                    Row1Smoke++;
                } else if (answer == 'N' || answer == 'n') {
                    a[1][Row2Non] = 1;
                    Row2Non++;
                }
                printArray(a);
            } while (Row1Smoke < 2 && Row2Non < 6);
        }

        if (Row2Smoke == 2 || Row2Non == 6 || Row2Non < 6 || Row2Smoke < 2) {
            do {
                if (Row2Smoke == 2 && Row2Non < 6) {
                    do {
                        System.out.println("Smoking section is full, do you want nonsmoking instead? (Y/N)");
                        answer = sc.next().charAt(0);
                        if ((answer == 'Y' || answer == 'y') && Row1Non < 6) {
                            a[0][Row1Non] = 1;
                            Row1Non++;
                        } else if ((answer == 'Y' || answer == 'y') && Row1Non == 6 && Row2Non < 6) {
                            a[1][Row2Non] = 1;
                            Row2Non++;
                        } else if ((answer == 'N' || answer == 'n') && Row1Non < 6) {
                            a[0][Row1Non] = 0;
                            Row1Non++;
                        } else if ((answer == 'N' || answer == 'n') && Row1Non == 6 && Row2Non < 6) {
                            a[1][Row2Non] = 0;
                            Row2Non++;
                        }
                        printArray(a);
                    } while (Row2Non < 6);
                } else if (Row2Non == 6 && Row2Smoke < 2) {
                    do {
                        System.out.println("Non-smoking section is full, do you want smoking instead? (Y/N)");
                        answer = sc.next().charAt(0);
                        if ((answer == 'Y' || answer == 'y') && Row1Smoke < 2) {
                            a[0][Row1Smoke] = 1;
                            Row1Smoke++;
                        } else if ((answer == 'Y' || answer == 'y') && Row1Smoke == 2 && Row2Smoke < 2) {
                            a[1][Row2Smoke] = 1;
                            Row2Smoke++;
                        } else if ((answer == 'N' || answer == 'n') && Row1Smoke < 2) {
                            a[0][Row1Smoke] = 0;
                            Row1Smoke++;
                        } else if ((answer == 'N' || answer == 'n') && Row1Smoke == 2 && Row2Smoke < 2) {
                            a[1][Row2Smoke] = 0;
                            Row2Smoke++;
                        }
                        printArray(a);
                    } while (Row2Smoke < 2);
                }

                else if (Row2Smoke < 2 && Row2Non < 6 && Row1Smoke == 2) {
                    do {
                        System.out.println("Do you want smoking or non-smoking? (S/N)");
                        answer = sc.next().charAt(0);
                        if (answer == 'S' || answer == 's') {
                            a[1][Row2Smoke] = 1;
                            Row2Smoke++;
                        } else if ((answer == 'N' || answer == 'n') && Row1Non < 6) {
                            a[0][Row1Non] = 1;
                            Row1Non++;
                        } else if ((answer == 'N' || answer == 'n') && Row1Non == 6 && Row2Non < 6) {
                            a[1][Row2Non] = 1;
                            Row2Non++;
                        }
                        printArray(a);
                    } while (Row2Smoke < 2 && Row2Non < 6);
                }
            } while (Row2Non < 6 || Row2Smoke < 2);
        }
    }

    public static void printArray(int[][] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.print("[" + a[i][0]);
            for (int j = 1; j < a[i].length; j++) {
                System.out.print(", " + a[i][j]);
            }
            System.out.print("]");
            System.out.println();
        }
    }
}
