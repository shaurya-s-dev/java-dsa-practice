# Practice Log

A running log of my approach, mistakes, and corrections for each problem I solve —
not just the final accepted code, but how I got there.

---

## 1. Two Sum
**Folder:** `05-Arrays/TwoSum.java`

**First approach:** Fix a running `sum` variable and add up all the elements in the array while looping through it once.

This was wrong — the problem doesn't ask for the total sum of the array at all. It asks to find **two specific elements** that add up to `target`, and return their **indices**, not their values or any total.

**Correction:** Use two nested loops — the outer loop picks index `i`, the inner loop picks index `j` (starting from `i+1`, so the same index is never used twice and pairs aren't repeated). Check if `nums[i] + nums[j] == target`. If true, return `new int[]{i, j}` immediately. If no pair is found after both loops finish, return a fallback array like `{-1,-1}` (required so the method always returns something, since Java needs every path to have a return statement).

```java
class Solution {
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{-1, -1};
    }
}
```

---

## 27. Remove Element
**Folder:** `05-Arrays/RemoveElement.java`

**First approach:** Use a `for` loop from index `0` to `n-1`, and inside an `if` condition (`nums[i] != val`), store the matching values into a new array, then print the new array's length along with the array itself.

This was partially right. The correction was: declare `k = 0` before the loop, then inside the `if` condition (`nums[i] != val`), do `nums[k] = nums[i]` — this overwrites the original array **in place** instead of creating a new one — then increment `k`. After the loop, return `k`, which represents both the count of valid elements and how many were written to the front of the array.

```java
class Solution {
    public int removeElement(int[] nums, int val) {
        int k = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[k] = nums[i];
                k++;
            }
        }
        return k;
    }
}
```

---

## 66. Plus One
**Folder:** `05-Arrays/PlusOne.java`

**First approach:** Add 1 only at the last index of the array (`if(i==n-1)`), and separately check if that digit became `9` in order to carry into the digit before it.

This broke down in two ways: (1) the method always returned `new int[]{}`, an empty array, instead of returning the actual modified `nums`; and (2) the carry logic only worked one digit deep — it failed on numbers with multiple trailing 9s, and crashed with an `ArrayIndexOutOfBoundsException` when the very first digit itself was a 9, since there was no `i-1` index left to carry into.

**Correction:** Loop backward, from the last index to the first (`for(i=n-1; i>=0; i--)`). At each digit: if it's less than 9, add 1 to it and `return nums` immediately — no further carrying is needed. If it's exactly 9, set it to 0 and let the loop continue to the next digit on the left. If the loop finishes entirely without returning (meaning every digit was a 9), that means the number needs one extra digit — create a new array of size `n+1`, set index `0` to `1` (the rest default to `0` automatically), and return that.

```java
class Solution {
    public int[] plusOne(int[] nums) {
        int n = nums.length;

        for (int i = n - 1; i >= 0; i--) {
            if (nums[i] < 9) {
                nums[i] = nums[i] + 1;
                return nums;
            } else {
                nums[i] = 0;
            }
        }

        int[] result = new int[n + 1];
        result[0] = 1;
        return result;
    }
}
```

---

## 136. Single Number
**Folder:** `20-Bitwise/SingleNumber.java`

**First approach:** Fix a value at index `0` and compare every other element against it to see if a match exists elsewhere in the array.

This only worked by coincidence when the single number happened to sit at index `0`. In general, this approach would require repeating the "fix and scan" process for every starting index — which is really just a nested-loop comparison in disguise, checking every pair against every other pair.

**Correction:** Since this is an array-only, constant-space problem, the intended trick uses the **XOR bitwise operator (`^`)**. Two key facts make it work: `x ^ x = 0` (a number cancels itself out) and `x ^ 0 = x` (XOR-ing with 0 changes nothing), and XOR doesn't care about the order elements are combined in. XOR every element in the array together in a single pass — every number that appears twice cancels itself out to `0`, and whatever number has no pair is the only thing left standing at the end.

```java
class Solution {
    public int singleNumber(int[] nums) {
        int result = 0;

        for (int i = 0; i < nums.length; i++) {
            result = result ^ nums[i];
        }

        return result;
    }
}
```

---

## 169. Majority Element
**Folder:** `05-Arrays/MajorityElement.java`

**First approach:** Fixed a single candidate at `nums[0]` and counted how many times it appeared in the array.

This only worked by coincidence when the majority element happened to sit at index `0`. It never checked whether any *other* value might be the true majority.

**Second approach:** Used nested loops — outer loop `j` picks a candidate, inner loop `i` counts how many times that candidate appears. This was closer, but `count` was declared **outside** the outer loop, so it never reset between different candidates — leftover counts bled from one candidate into the next, giving wrong totals.

**Correction of that bug:** Move `int count = 0;` inside the outer loop, right before the inner loop starts, so it resets fresh for every new candidate. Also changed the check to `count > nums.length / 2`, the actual definition of majority, instead of just `count > 1`.

This nested-loop version passed correctness (52/54) but **timed out** on very large arrays — it's `O(n²)`, since every candidate re-scans the entire array.

**Final correction — Boyer-Moore Voting Algorithm (`O(n)`, `O(1)` space):** Track a single `candidate` and a `count`. Walk through the array once:
- If `count == 0`, adopt the current element as the new `candidate`.
- If the current element matches `candidate`, increment `count`.
- If it doesn't match, decrement `count`.

This works because the majority element appears more than half the time — every time `count` hits `0`, an equal number of "supporting" and "opposing" elements have cancelled each other out and can be discarded from consideration. Since there are never enough non-majority elements in the whole array to cancel out someone who has more than half the votes, the true majority always survives as the final `candidate`, even if it gets temporarily replaced mid-array.

```java
class Solution {
    public int majorityElement(int[] nums) {
        int count = 0;
        int candidate = 0;

        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }

            if (num == candidate) {
                count++;
            } else {
                count--;
            }
        }

        return candidate;
    }
}
```
