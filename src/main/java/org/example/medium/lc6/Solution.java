package org.example.medium.lc6;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public String convert(String s, int numRows) {
        boolean d = true; int r = 0;
        if (numRows == 1) {
            return s;
        }

        List<List<Character>> rows = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            rows.add(new ArrayList<>());
        }

        for (int i = 0; i < s.length(); i++) {
            List<Character> list = rows.get(r);
            list.add(s.charAt(i));

            if (r == (numRows - 1)) {
                d = false;
            } else if (r == 0 ) {
                d = true;
            }

            if (d == true) {
                r++;
            } else {
                r--;
            }
        }

        StringBuilder builder = new StringBuilder();
        for (List<Character> row : rows) {
            for (Character character : row) {
                builder.append(character);
            }
        }

        return builder.toString();
    }
}