class Solution:
    def minZeroArray(self, nums: List[int], queries: List[List[int]]) -> int:
        if(max(nums)==0):
            return 0
        left =0
        right = len(queries)+1

        def isValid(index):
            diff = [0]*(len(nums)+1)
            # print(index)
            # print(queries[:index])
            for l,r,v in queries[:index]:
                diff[l]+=v
                diff[r+1] -=v

            value =0
            for i in range(len(nums)):
                value+=diff[i]
                if(value<nums[i]):
                    return False

            return True

        while left<right:
            mid = left + (right-left)//2
            if(isValid(mid)):
                right = mid
            else:
                left = mid+1

        if(left>len(queries)):
            return -1
        return left



