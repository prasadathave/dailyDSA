class Solution:
    def minimizeXor(self, num1: int, num2: int) -> int:
        num1Arr = []
        num2Arr = []
        num1c = num1
        num2c = num2
        while num1c!=0:
            num1Arr.insert(0,num1c%2)
            num1c = (num1c-num1c%2)/2

        while num2c!=0:
            num2Arr.insert(0,num2c%2)
            num2c = (num2c-num2c%2)/2


        oneCounter =0
        for elem in num2Arr:
            if elem ==1:
                oneCounter+=1
        if(len(num2Arr)>len(num1Arr)):
            while(len(num2Arr)!=len(num1Arr)):
                num1Arr.insert(0,0)
        elif(len(num1Arr)>len(num2Arr)):
            while(len(num1Arr)!=len(num2Arr)):
                num2Arr.insert(0,0)
                #print(num1Arr)
        #print(num2Arr)
        num3Arr = []
        #print(oneCounter)
        for elem in num1Arr:
            if elem==0:
                num3Arr.append(0)
            elif(oneCounter>0 and elem ==1):
                num3Arr.append(1)
                oneCounter -=1
            else:
                num3Arr.append(0)
        #print(num3Arr)
        #print()
        if(oneCounter >0):
            for i in range(len(num3Arr)-1,-1,-1):
                if(oneCounter>0 and num3Arr[i]==0):
                    num3Arr[i] =1
                    oneCounter -=1
                    #print("updated later")
        #print(num3Arr)

        factor = 1
        number = 0
        for i in range(len(num3Arr)-1,-1,-1):
            number += factor * num3Arr[i]
            factor *=2
        return number


