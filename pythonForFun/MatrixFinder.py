#MatrixFinder remastered in Python!
import time

##precond for 2D array: every row and column must be increasing,
##and the number of row and number of columns are the same (denoted with n).

## find the number in a given 2D array
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

##make a 2D array with increasing numbers
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

##toString method basically
def printArr(arr):
    retStr = "["
    for i in range(len(arr)):
        for j in range(len(arr)):
            retStr += str(arr[i][j]) + " "
        retStr = retStr + "]\n["
    print retStr[:len(retStr)-2]

##lab00 here we go
def test():
    n=1000
    while True:
        arr = populate(n)
        before = time.time()
        find(arr,n*n-n+1)
        after = time.time()
        print str(n) + ", " + str(after-before)
        n+=100
