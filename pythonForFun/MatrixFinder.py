#MatrixFinder remastered in Python!

def find(arr,target):
    r = 0
    c = len(arr) - 1
    k = arr[r][c]
    while True:
        if k < target:
            r+=1
            if r >= len(arr):
                break
            k = arr[r][c]
        elif k > target:
            c-=1
            if c < 0:
                break
            k = arr[r][c]
        else:
            return "(" + str(r) + ", " + str(c) + ")"
    return "(-1,-1)"

def populate(n):
    arr = []
    arrTemp = []
    c=1
    for i in range(n):
        for j in range(n):
            arrTemp.append(c)
            c+=1
        arr.append(arrTemp)
        arrTemp=[]
    return arr

def printArr(arr):
    retStr = "["
    for i in range(len(arr)):
        for j in range(len(arr)):
            retStr += str(arr[i][j]) + " "
        retStr = retStr + "]\n["
    print retStr[:len(retStr)-2]

