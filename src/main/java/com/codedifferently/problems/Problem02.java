package com.codedifferently.problems;

import java.util.ArrayList;

public class Problem02 {
    public static Integer cousinTag(ArrayList<String> cousins, Integer startIndex, String targetName){
        int indexOfTarget = cousins.indexOf(targetName);
        int rightDistance = Math.abs(indexOfTarget - startIndex);
        int circularStartIndex = startIndex - cousins.size();
        int leftDistance = Math.abs(circularStartIndex - indexOfTarget);
        return Math.min(rightDistance, leftDistance);
    }
}
