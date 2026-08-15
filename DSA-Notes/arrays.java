import java.util.*;
public class arrays {
// ============================================================
// BASIC ARRAY CODING QUESTIONS - JAVA (with comments)
// Most commonly asked in labs, interviews, DSA practice
// ============================================================





        // ------------------------------------------------------
        // 1. FIND MAXIMUM ELEMENT IN ARRAY
        // ------------------------------------------------------
        static int findMax(int[] arr) {
            int max = arr[0]; // assume first element is max initially
            for (int i = 1; i < arr.length; i++) {
                if (arr[i] > max) {
                    max = arr[i]; // update whenever a bigger element is found
                }
            }
            return max;
        }

        // ------------------------------------------------------
        // 2. FIND MINIMUM ELEMENT IN ARRAY
        // ------------------------------------------------------
        static int findMin(int[] arr) {
            int min = arr[0];
            for (int i = 1; i < arr.length; i++) {
                if (arr[i] < min) {
                    min = arr[i];
                }
            }
            return min;
        }

        // ------------------------------------------------------
        // 3. SUM AND AVERAGE OF ARRAY ELEMENTS
        // ------------------------------------------------------
        static void sumAndAverage(int[] arr) {
            int sum = 0;
            for (int i = 0; i < arr.length; i++) {
                sum += arr[i];
            }
            double avg = (double) sum / arr.length; // cast to double, else integer division
            System.out.println("Sum=" + sum + " Average=" + avg);
        }

        // ------------------------------------------------------
        // 4. REVERSE AN ARRAY (in place, two-pointer technique)
        // Swap first and last, move pointers toward center
        // ------------------------------------------------------
        static void reverseArray(int[] arr) {
            int left = 0, right = arr.length - 1;
            while (left < right) {
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
                left++;
                right--;
            }
        }

        // ------------------------------------------------------
        // 5. LINEAR SEARCH
        // Check every element one by one - works on unsorted arrays too
        // Returns index if found, -1 if not found
        // ------------------------------------------------------
        static int linearSearch(int[] arr, int target) {
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] == target) return i;
            }
            return -1;
        }

        // ------------------------------------------------------
        // 6. BINARY SEARCH (array MUST be sorted first)
        // Repeatedly cut the search range in half - much faster than linear
        // ------------------------------------------------------
        static int binarySearch(int[] arr, int target) {
            int low = 0, high = arr.length - 1;
            while (low <= high) {
                int mid = low + (high - low) / 2; // avoids overflow vs (low+high)/2
                if (arr[mid] == target) {
                    return mid;
                } else if (arr[mid] < target) {
                    low = mid + 1;  // target is in right half
                } else {
                    high = mid - 1; // target is in left half
                }
            }
            return -1;
        }

        // ------------------------------------------------------
        // 7. CHECK IF ARRAY IS SORTED
        // ------------------------------------------------------
        static boolean isSorted(int[] arr) {
            for (int i = 0; i < arr.length - 1; i++) {
                if (arr[i] > arr[i + 1]) return false; // found a descending pair
            }
            return true;
        }

        // ------------------------------------------------------
        // 8. BUBBLE SORT
        // Repeatedly swap adjacent elements if out of order
        // Largest element "bubbles up" to the end each pass
        // ------------------------------------------------------
        static void bubbleSort(int[] arr) {
            int n = arr.length;
            for (int i = 0; i < n - 1; i++) {
                for (int j = 0; j < n - 1 - i; j++) { // shrink range, end is already sorted
                    if (arr[j] > arr[j + 1]) {
                        int temp = arr[j];
                        arr[j] = arr[j + 1];
                        arr[j + 1] = temp;
                    }
                }
            }
        }

        // ------------------------------------------------------
        // 9. SELECTION SORT
        // Find the minimum in remaining array, put it at current position
        // ------------------------------------------------------
        static void selectionSort(int[] arr) {
            int n = arr.length;
            for (int i = 0; i < n - 1; i++) {
                int minIndex = i;
                for (int j = i + 1; j < n; j++) {
                    if (arr[j] < arr[minIndex]) {
                        minIndex = j; // track index of smallest found so far
                    }
                }
                // swap smallest into position i
                int temp = arr[minIndex];
                arr[minIndex] = arr[i];
                arr[i] = temp;
            }
        }

        // ------------------------------------------------------
        // 10. REMOVE DUPLICATES FROM ARRAY (using a Set)
        // Set automatically ignores repeated values
        // ------------------------------------------------------
        static int[] removeDuplicates(int[] arr) {
            LinkedHashSet<Integer> set = new LinkedHashSet<>(); // keeps insertion order
            for (int val : arr) {
                set.add(val);
            }
            int[] result = new int[set.size()];
            int i = 0;
            for (int val : set) {
                result[i++] = val;
            }
            return result;
        }

        // ------------------------------------------------------
        // 11. FIND SECOND LARGEST ELEMENT
        // Track largest and second largest in a single pass
        // ------------------------------------------------------
        static int secondLargest(int[] arr) {
            int largest = Integer.MIN_VALUE, secondLargest = Integer.MIN_VALUE;
            for (int val : arr) {
                if (val > largest) {
                    secondLargest = largest; // old largest becomes second largest
                    largest = val;
                } else if (val > secondLargest && val != largest) {
                    secondLargest = val; // update second only if not equal to largest
                }
            }
            return secondLargest;
        }

        // ------------------------------------------------------
        // 12. COUNT FREQUENCY OF EACH ELEMENT (using HashMap)
        // ------------------------------------------------------
        static void countFrequency(int[] arr) {
            HashMap<Integer, Integer> freq = new HashMap<>();
            for (int val : arr) {
                // getOrDefault: if val not in map yet, treat count as 0
                freq.put(val, freq.getOrDefault(val, 0) + 1);
            }
            for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
                System.out.println(entry.getKey() + " -> " + entry.getValue() + " times");
            }
        }

        // ------------------------------------------------------
        // 13. CHECK IF ARRAY IS PALINDROME
        // Same two-pointer idea as string/number palindrome
        // ------------------------------------------------------
        static boolean isArrayPalindrome(int[] arr) {
            int left = 0, right = arr.length - 1;
            while (left < right) {
                if (arr[left] != arr[right]) return false;
                left++;
                right--;
            }
            return true;
        }

        // ------------------------------------------------------
        // 14. LEFT ROTATE ARRAY BY 1
        // Save first element, shift everything left, put saved element at end
        // ------------------------------------------------------
        static void rotateLeftByOne(int[] arr) {
            int first = arr[0]; // save first element, it'll be overwritten
            for (int i = 0; i < arr.length - 1; i++) {
                arr[i] = arr[i + 1]; // shift each element one step left
            }
            arr[arr.length - 1] = first; // place saved element at the end
        }

        // ------------------------------------------------------
        // 15. LEFT ROTATE ARRAY BY D POSITIONS (using extra array)
        // ------------------------------------------------------
        static int[] rotateLeftByD(int[] arr, int d) {
            int n = arr.length;
            d = d % n; // handle d larger than array length
            int[] result = new int[n];
            for (int i = 0; i < n; i++) {
                // element at i moves to position (i-d), wrap around using modulo
                result[(i - d + n) % n] = arr[i];
            }
            return result;
        }

        // ------------------------------------------------------
        // 16. FIND MISSING NUMBER FROM 1 TO N
        // Trick: expected sum (formula) - actual sum = missing number
        // ------------------------------------------------------
        static int findMissingNumber(int[] arr, int n) {
            int expectedSum = n * (n + 1) / 2; // sum of 1..n formula
            int actualSum = 0;
            for (int val : arr) {
                actualSum += val;
            }
            return expectedSum - actualSum;
        }

        // ------------------------------------------------------
        // 17. FIND DUPLICATE ELEMENT (using HashSet)
        // First time a value is seen, add() returns true; second time, false
        // ------------------------------------------------------
        static int findDuplicate(int[] arr) {
            HashSet<Integer> seen = new HashSet<>();
            for (int val : arr) {
                if (!seen.add(val)) { // add() returns false if already present
                    return val;
                }
            }
            return -1; // no duplicate found
        }

        // ------------------------------------------------------
        // 18. MOVE ALL ZEROS TO THE END (keep order of non-zero elements)
        // Two-pointer: 'insertPos' tracks where next non-zero should go
        // ------------------------------------------------------
        static void moveZerosToEnd(int[] arr) {
            int insertPos = 0;
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] != 0) {
                    arr[insertPos] = arr[i]; // pack non-zero elements to the front
                    insertPos++;
                }
            }
            while (insertPos < arr.length) {
                arr[insertPos] = 0; // fill remaining spots with zero
                insertPos++;
            }
        }

        // ------------------------------------------------------
        // 19. FIND ALL PAIRS WITH GIVEN SUM (brute force, easy to understand)
        // ------------------------------------------------------
        static void findPairsWithSum(int[] arr, int target) {
            for (int i = 0; i < arr.length; i++) {
                for (int j = i + 1; j < arr.length; j++) { // j starts after i, avoids repeats
                    if (arr[i] + arr[j] == target) {
                        System.out.println("(" + arr[i] + ", " + arr[j] + ")");
                    }
                }
            }
        }

        // ------------------------------------------------------
        // 20. KADANE'S ALGORITHM - MAXIMUM SUBARRAY SUM
        // At each step: either extend previous subarray, or start fresh from here
        // ------------------------------------------------------
        static int maxSubArraySum(int[] arr) {
            int maxSoFar = arr[0];
            int currentSum = arr[0];
            for (int i = 1; i < arr.length; i++) {
                // either add current element to running sum, or start new subarray here
                currentSum = Math.max(arr[i], currentSum + arr[i]);
                maxSoFar = Math.max(maxSoFar, currentSum); // track best overall
            }
            return maxSoFar;
        }

        // ============================================================
        // MAIN - quick test of everything above with example arrays
        // ============================================================
        public static void main(String[] args) {
            int[] a = {4, 2, 9, 7, 5, 2};

            System.out.println("Array: " + Arrays.toString(a));
            System.out.println("Max: " + findMax(a));
            System.out.println("Min: " + findMin(a));
            sumAndAverage(a);

            int[] b = a.clone();
            reverseArray(b);
            System.out.println("Reversed: " + Arrays.toString(b));

            System.out.println("linearSearch(a, 7): " + linearSearch(a, 7));

            int[] sortedArr = {2, 4, 5, 7, 9};
            System.out.println("binarySearch(sortedArr, 7): " + binarySearch(sortedArr, 7));
            System.out.println("isSorted(sortedArr): " + isSorted(sortedArr));

            int[] c = a.clone();
            bubbleSort(c);
            System.out.println("Bubble sorted: " + Arrays.toString(c));

            int[] d = a.clone();
            selectionSort(d);
            System.out.println("Selection sorted: " + Arrays.toString(d));

            System.out.println("Without duplicates: " + Arrays.toString(removeDuplicates(a)));
            System.out.println("Second largest: " + secondLargest(a));

            System.out.println("Frequency:");
            countFrequency(a);

            int[] pal = {1, 2, 3, 2, 1};
            System.out.println("isArrayPalindrome: " + isArrayPalindrome(pal));

            int[] e = a.clone();
            rotateLeftByOne(e);
            System.out.println("Rotated left by 1: " + Arrays.toString(e));

            System.out.println("Rotated left by 2: " + Arrays.toString(rotateLeftByD(a, 2)));

            int[] missingArr = {1, 2, 4, 5}; // missing 3, n=5
            System.out.println("Missing number: " + findMissingNumber(missingArr, 5));

            System.out.println("Duplicate: " + findDuplicate(a));

            int[] zerosArr = {0, 4, 0, 5, 8, 0, 9};
            moveZerosToEnd(zerosArr);
            System.out.println("Zeros moved: " + Arrays.toString(zerosArr));

            System.out.println("Pairs with sum 11:");
            findPairsWithSum(a, 11);

            int[] subArr = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
            System.out.println("Max subarray sum: " + maxSubArraySum(subArr));
        }
    }

