class Solution {
    public String countAndSay(int n) {
       if (n<=0) {
            return null;
        }
        String result="1";
        int j=1;
        while(j++<n){
        StringBuilder sb = new StringBuilder();
        int count=1;
        for(int i=1; i<=result.length(); i++){
            if(i == result.length() || result.charAt(i)!=result.charAt(i-1)){
                sb.append(count);
                sb.append(result.charAt(i-1));
                count=1;
                
            }else{
              count++;
            }
        }
            result = sb.toString();
        }
        return result;
    }
}