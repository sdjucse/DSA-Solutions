class FindSpecialSubstringOfLengthK {
    public boolean hasSpecialSubstring(String s, int k) {
        int n = s.length();
        for (int i = 0; i <= n - k; i++) {
            char c = s.charAt(i);
            boolean allSame = true;
            for (int j = i; j < i + k; j++) {
                if (s.charAt(j) != c) {
                    allSame = false;
                    break;
                }
            }
            if (!allSame) {
                continue;
            }
            if (i > 0 && s.charAt(i - 1) == c) {
                continue;
            }
            if (i + k < n && s.charAt(i + k) == c) {
                continue;
            }
            return true;
        }
        return false;
    }
}
