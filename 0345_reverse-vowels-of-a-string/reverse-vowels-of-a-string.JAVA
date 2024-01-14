class Solution {
    public String reverseVowels(String s) {
        HashSet<Character> set=new HashSet<>(Arrays.asList('a','e','i','o','u','A','E','I','O','U'));
        char str[]=s.toCharArray();
        String temp="";
        for(char ch:str){
            if(set.contains(ch)) temp+=ch;
        }
        
        int idx=temp.length()-1;
        
        for(int i=0; i<str.length; i++){
            if(set.contains(str[i])) str[i]=temp.charAt(idx--);
        }
        return new String(str);
    }
}