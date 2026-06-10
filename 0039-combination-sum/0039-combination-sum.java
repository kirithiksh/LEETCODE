class Solution {
    void f(int i,int target,List<Integer>temp,int[]c,List<List<Integer>>ans){
        if(i==c.length){//index out of bound ->2 case target=0 or target=something
            if(target==0){
                ans.add(new ArrayList<>(temp));//copy of temp will be created and added to the list
                //ans.add(temp)references when  you remove an ele it reflect in all you dont want like that
            }
            return;
        }
        //not pick
        f(i+1,target,temp,c,ans);
        //pick
        if(c[i]<=target){
            temp.add(c[i]);
            f(i,target-c[i],temp,c,ans);
            temp.remove(temp.size()-1);
        }
    }
    public List<List<Integer>> combinationSum(int[] c, int target) {
        List<List<Integer>>ans =new ArrayList<>();
        List<Integer>temp=new ArrayList<>();//we are using list data structure
        f(0,target,temp,c,ans);
        return ans;
    }
}









