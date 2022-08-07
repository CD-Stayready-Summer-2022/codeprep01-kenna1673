package com.codedifferently.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Problem03 {
    /**
     * You will be given an integer called number and an array called possibleFamilyMembers
     * your jobs is to find the number's family members. A family member is any value that's with in
     * 1 of any other number in the family.
     *
     * So for example if the number = 4, and the possibleFamilyMembers is [1,4,3,5]
     * The actualFamilyMembers would be [3,4,5]
     * 3 is 1 away from 4
     * 4 is equal to 4
     * 4 is 1 away from 5
     * while
     * 1 is not included because the closest releation to 1 is 3 and that's 2 away.
     * @param number
     * @param possibleFamilyMembers
     * @return
     */
    public Integer[] numberFamily(Integer number, Integer[] possibleFamilyMembers){

        ArrayList<Integer> family = (ArrayList<Integer>) Arrays.stream(possibleFamilyMembers).collect(Collectors.toList());
        Collections.sort(family);
        int length = family.size();
        List<Integer> output = new ArrayList<>(List.of(number));

        int startIndex = family.indexOf(number);
        int leftDifference;
        int rightDifference;
        int leftCompareIndex = startIndex;
        int rightCompareIndex = startIndex;
        int leftIndex = startIndex > 0 ? startIndex - 1 : 0;
        int rightIndex = startIndex < (length - 1) ? startIndex + 1 : length - 1;

        while (leftIndex >= 0 && rightIndex < length) {
            int valueLeft = family.get(leftIndex);
            int valueLeftCompare = family.get(leftCompareIndex);
            int valueRight = family.get(rightIndex);
            int valueRightCompare = family.get(rightCompareIndex);
            leftDifference = Math.abs(valueLeft - valueLeftCompare);
            rightDifference = Math.abs(valueRight - valueRightCompare);
            if (leftDifference == 1) {
                output.add(valueLeft);
                leftCompareIndex = leftIndex;
                leftIndex--;
            }
            if (rightDifference == 1) {
                output.add(valueRight);
                rightCompareIndex = rightIndex;
                rightIndex++;
            }
        }

        Integer[] outputArray = output.toArray(new Integer[0]);
        Arrays.sort(outputArray);
        return outputArray;
    }
}
