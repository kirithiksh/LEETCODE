class Solution {
    
    void f(int i,List<Integer> temp,int []nums,List<List<Integer>> ans){
        if(i==nums.length){
            ans.add(new ArrayList<>(temp));
            return;
        }
        f(i+1,temp,nums,ans);
        temp.add(nums[i]);
        f(i+1,temp,nums,ans);
        temp.remove(temp.size()-1);
    }
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans=new ArrayList<>();
        List<Integer> temp=new ArrayList<>();
        f(0,temp,nums,ans);
        return ans;
    }
}  
    
