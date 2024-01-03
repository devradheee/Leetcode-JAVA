class Solution {
    public String addBinary(String a, String b) {
       StringBuffer sb = new StringBuffer();
        int i = a.length() - 1;
        int j = b.length() - 1;
        int sum = 0;
        while (i >= 0 || j >= 0) {
            if (j >= 0) sum += b.charAt(j--) - '0';
            if (i >= 0) sum += a.charAt(i--) - '0';
            sb.append(sum % 2);
            sum /= 2;
        }
        if (sum != 0) sb.append(sum);
        return sb.reverse().toString(); 
    }
}