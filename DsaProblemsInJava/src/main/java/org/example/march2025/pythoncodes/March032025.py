class Solution:
    def pivotArray(self, nums: List[int], pivot: int) -> List[int]:
        lesser = []
        more = []
        eq = []
        for elem in nums:
            if(pivot>elem):
                lesser.append(elem)
            elif(pivot==elem):
                eq.append(elem)
            else:
                more.append(elem)
        lesser.extend(eq)
        lesser.extend(more)
        return lesser
