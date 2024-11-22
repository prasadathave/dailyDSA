def returnSmallestStrAfterRemovingABandCD(s):
    while s.find("AB")!=-1 or s.find("CD")!=-1:
        while s.find("AB")!=-1:
            s = s.replace("AB","")
        while s.find("CD")!=-1:
            s = s.replace("CD","")
    return len(s)

# This was the accepted solution