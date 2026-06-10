    
class Solution {
    void f(int open,int close,StringBuilder s,int n,List<String>ans){
        if(open==n && close==n){//base case 
            ans.add(s.toString());//it is in StringBuilder .we are changing StringBuilder to string
            return;//once ans found.backtrack and go
        }
        if(open<n){
            s.append('(');
            f(open+1,close,s,n,ans);
            s.deleteCharAt(s.length()-1);//backtracking delete lastly inserted character
        }
        if(close<n && open >close){
            s.append(')');
            f(open,close+1,s,n,ans);
            s.deleteCharAt(s.length()-1);
        }
    } 
    public List<String> generateParenthesis(int n) {
        StringBuilder s=new StringBuilder("");
        List<String>ans=new ArrayList<>();
        f(0,0,s,n,ans);
        return ans;
    }}