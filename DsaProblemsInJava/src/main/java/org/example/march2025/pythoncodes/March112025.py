class Solution:
    def containsAll(self,mp:dict[str,int]):
        if(mp['a']>=1 and mp['b']>=1 and mp['c']>=1):
            return True
        return False
    def numberOfSubstrings(self, s: str) -> int:
        left =0
        mp = {}
        mp['a'] = 0
        mp['b'] = 0
        mp['c'] = 0
        count =0
        for right in range(len(s)):
            mp[s[right]]+=1
            while(self.containsAll(mp)):
                count += len(s) - right
                mp[s[left]]-=1
                left+=1
        return count


        