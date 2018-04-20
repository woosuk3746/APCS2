import math

#checks for primality
def isprime(n):
    if n==1:
        return False
    if n==2 or n==3:
        return True
    if n%2==0:
        return False
    for i in range(2,int(math.sqrt(n))+1):
        if n%i==0:
            return False
    return True

#checks if a and b are relatively prime
def relprime(a,b):
    if (isprime(a) and b%a!=0) or (isprime(b) and a%b!=0):
        return True
    if a==1 or b==1:
        return True
    smaller=a
    larger=b
    if a>b:
        smaller=b
        larger=a
    stuff=[]
    for i in range(1,larger+1):
        if isprime(i):
            stuff.append(i)
    for prime in stuff:
        if a%prime==0 and b%prime==0:
            return False    
    return True

#totient function
#returns the number of natural numbers less than n that is relatively prime to n
def totient(n):
    if isprime(n):
        return n-1
    ct=0
    for i in range(1,n):
        if relprime(n,i):
            ct+=1
    return ct+1

#prime factorization
#returns the prime factorization in a string form
def primef(n):
    if isprime(n):
        return str(n)
    hi = ''
    ct=0
    xd = primelist(n)
    for i in xd:
        while(n%i == 0):
            ct+=1
            n/=i
        if(ct != 0):
            if(ct == 1):
                hi += str(i) + "*"
            else:
                hi+=str(i) + "^" + str(ct) + "*"
            ct=0
    return hi[:len(hi)-1]

#returns the sum of the exponents of each factor in the prime factorization
# e.g.) sumExp(45) ---> 3 because primef(45) --> 3^2*5^1, 2+1=3
def sumExp(n):
    ret = 0
    ct = 0
    xd = primelist(n)
    for i in xd:
        while(n%i == 0):
            ct+=1
            ret+=1
            n/=i
        ct=0
    return ret
        
#factor list
#takes in a number and creates a list of all the primes less than that number
def primelist(n):
    L = [];
    for i in range(n):
        if(isprime(i)):
            L.append(i)
    return L

#AIME I 2016 NUMBER 12
def letsgo():
    a=12
    while( a-11 != int(math.sqrt(a-11)) * (int(math.sqrt(a-11)) + 1) or sumExp(a) != 4):
            a+=1
    return int(math.sqrt(a-11))+1
