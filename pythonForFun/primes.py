import math

#checks for primality
def isPrime(n):
    if n==2:
        return True
    if n==1 or n%2==0:
        return False
    for i in range(3,int(math.sqrt(n))+1):
        if n%i==0:
            return False
    return True

#checks if a and b are relatively prime
#Helper function for totient function
def relPrime(a,b):
    if (isPrime(a) and b%a!=0) or (isPrime(b) and a%b!=0):
        return True
    if a==1 or b==1:
        return True
    smaller=a
    larger=b
    if a>b:
        smaller=b
        larger=a
    stuff=[]
    for i in range(1,smaller+1):
        if isPrime(i):
            stuff.append(i)
    ##the list "stuff" will hold all the prime numbers less than max(a,b)
    for prime in stuff:
        if a%prime==0 and b%prime==0:
            return False    
    return True

#totient function
#returns the number of natural numbers less than n that is relatively prime to n
def totient(n):
    if isPrime(n):
        return n-1
    ct=0
    for i in range(1,n):
        if relprime(n,i):
            ct+=1
    return ct+1

#prime factorization
#returns the prime factorization in a string form
def primeF(n):
    if isPrime(n):
        return str(n) #if the input is prime, return itself
    hi = ''
    ct=0 #counter to keep track of exponenets
    xd = primelist(n) #all the primes less than the integer
    for i in xd: #run through the primes in the list
        while(n%i == 0): #if the prime divides the input
            ct+=1 #increase the exponent counter
            n/=i #set n equal to its value divided by i
        if(ct != 0):
            if(ct == 1):
                hi += str(i) + "*" #this prevents printing something like 3^1 (instead just prints 3)
            else:
                hi+=str(i) + "^" + str(ct) + "*" #write 5^(whatever exponent)
            ct=0 #set the counter back to 0
    return hi[:len(hi)-1]

################vHELPER FUNCTION FOR PRIME FACTORIZATIONv#########################
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
        if(isPrime(i)):
            L.append(i)
    return L
###############^HELPER FUNCTION FOR PRIME FACTORIZATION^#########################


#AIME I 2016 NUMBER 12
def letsgo():
    a=12
    while( a-11 != int(math.sqrt(a-11)) * (int(math.sqrt(a-11)) + 1) or sumExp(a) != 4):
            a+=1
    return int(math.sqrt(a-11))+1
