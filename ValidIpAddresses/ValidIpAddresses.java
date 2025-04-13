package ValidIpAddresses;

import java.util.ArrayList;
import java.util.List;

public class ValidIpAddresses {
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        if (s == null || s.length() < 4 || s.length() > 12) {
            return result;
        }
        backtrack(s, 0, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(String s, int start, List<String> current, List<String> result) {
        if (current.size() == 4) {
            if (start == s.length()) {
                result.add(String.join(".", current));
            }
            return;
        }
        for (int i = 1; i <= 3; i++) {
            if (start + i > s.length()) {
                break;
            }
            String segment = s.substring(start, start + i);
            if (isValidSegment(segment)) {
                current.add(segment);
                backtrack(s, start + i, current, result);
                current.remove(current.size() - 1);
            }
        }
    }

    private boolean isValidSegment(String segment) {
        if (segment.length() > 1 && segment.startsWith("0")) {
            return false;
        }
        int num = Integer.parseInt(segment);
        return num >= 0 && num <= 255;
    }

    public static void main(String[] args) {
        ValidIpAddresses solution = new ValidIpAddresses();
        String s = "25525511135";
        List<String> addresses = solution.restoreIpAddresses(s);
        for (String address : addresses) {
            System.out.println(address);
        }
    }
}    