package org.example.medium.lc22;

import java.sql.Array;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> initList = new ArrayList<>(List.of("()"));

        if (n == 1) {
            return initList;
        }

        for (int i = 1; i < n; i++) {
            initList = getWrap(initList);
        }
        return initList;
    }

    public List<String> getWrap(List<String> list) {
        Set<String> hs = new HashSet<>();
        for (String s : list) {
            for (int i = 0; i < s.length(); i++) {
                StringBuilder sb = new StringBuilder();
                sb.append("(");
                sb.append(s.substring(0, i));
                sb.append(")");
                sb.append(s.substring(i));
                hs.add(sb.toString());
            }
        }
        return new ArrayList<>(hs);
    }

}
