class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer>map=new HashMap<>();
        for(int i:nums)
        {
            if(map.containsKey(i))
            {
                map.put(i,map.get(i)+1);
            }
            else{
                map.put(i,1);
            }
        }
        List<Integer>list=new ArrayList<>(map.keySet());
        list.sort((a, b) -> map.get(b) - map.get(a));
        int res[] = new int[k];
        for (int i = 0; i < k; ++i)
            res[i] = list.get(i);
        return res;

    }
}