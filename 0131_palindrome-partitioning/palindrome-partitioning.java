class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> list = new ArrayList<>();
        List<String> path = new ArrayList<>();
        func(0,s,path,list);
        return list;
    }
    static void func(int index,String s,List<String> path,List<List<String>> list){
        if(index == s.length()){
            list.add(new ArrayList<>(path));
            return;
        }
        for(int i = index;i<s.length();i++){
            if(isPalindrom(s,index,i)){
                path.add(s.substring(index,i+1));
                func(i+1,s,path,list);
                path.remove(path.size()-1);
            }
        }
    }
    static boolean isPalindrom(String s,int start,int end){
        while(start<=end){
            if(s.charAt(start++)!=s.charAt(end--)){
                return false;
            }
        }
        return true;
    }
}