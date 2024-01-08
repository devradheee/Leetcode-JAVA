class Solution {
    public String simplifyPath(String path) {
      Deque<String> stack = new ArrayDeque<>();
        
        for(String str:path.split("/")){
            if(str.equals("") || str.equals(".")) continue;
            else if (str.equals("..")) stack.pollLast();
            else stack.add(str);
        }
        return "/"+String.join("/",stack);  
    }
}