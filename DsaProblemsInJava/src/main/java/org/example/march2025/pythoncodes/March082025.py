class Solution:
    def minimumRecolors(self, blocks: str, k: int) -> int:
        left =0
        right = k-1
        cnt = blocks[left:right+1].count('B')
        maxcnt = cnt
        while(right<len(blocks)):
            if(blocks[left]=='B'):
                cnt-=1
            if(right<len(blocks)-1 and blocks[right+1]=='B'):
                cnt+=1
            left+=1
            right+=1
            maxcnt = max(cnt,maxcnt)

        if(maxcnt>=k):
            return 0
        return k-maxcnt







