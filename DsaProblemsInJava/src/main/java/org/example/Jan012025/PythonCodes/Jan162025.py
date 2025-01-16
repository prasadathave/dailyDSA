def xorAllNums(self, nums1: List[int], nums2: List[int]) -> int:
    result = 0
    if(len(nums1)%2==0 and len(nums2)%2==0):
        return 0
    if(len(nums1)%2==0 and len(nums2)%2!=0):
        for elem in nums1:
            result = result ^ elem
    if(len(nums1)%2!=0 and len(nums2)%2==0):
        for elem in nums2:
            result = result ^ elem
    if(len(nums1)%2!=0 and len(nums2)%2!=0):
        for elem in nums1:
            result = result ^ elem
        for elem in nums2:
            result = result ^ elem

    return result
