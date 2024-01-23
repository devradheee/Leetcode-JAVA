class Solution {
    public List<Integer> majorityElement(int[] nums) {
        
        Map<Integer, Integer> elementCountMap = new HashMap<>();
       
        for (int i = 0; i < nums.length; i++) {
            elementCountMap.put(nums[i], elementCountMap.getOrDefault(nums[i], 0) + 1);
        }
        
        List<Integer> majorityElements = new ArrayList<>();
        int threshold = nums.length / 3;
        
        for (Map.Entry<Integer, Integer> entry : elementCountMap.entrySet()) {
            int element = entry.getKey();
            int count = entry.getValue();
            
            if (count > threshold) {
                majorityElements.add(element);
            }
        }
        
        return majorityElements; 
    }
}