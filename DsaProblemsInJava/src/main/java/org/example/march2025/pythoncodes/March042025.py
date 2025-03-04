from typing import List
from typing import Dict
class Solution:
    def isPossible(self,n: int, used: List[int],cache:Dict[int,bool]) -> bool:
        if(cache.get(n)!=None):
            return cache[n]

        if(n==0):
            return True
        if(n<0):
            return False
        for i in range(len(used)):
            if(used[i]!=1):
                used[i] = 1
                pval = 3**i
                result = self.isPossible(n-pval,used,cache)
                if(result):
                    cache[n] = True
                    return True
                used[i] =0
        cache[n] = False
        return False

    def checkPowersOfThree(self, n: int) -> bool:
        lst = [0]*18
        dic = {}
        return self.isPossible(n,lst,dic)
