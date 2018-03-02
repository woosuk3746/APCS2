Woosuk Lee
APCS2 pd8
HW12 -- __+3R|\/|1|\|4|_  1|_|_|\|3$$__
2018-3-2

Q0: What do you make of the multiple class definitions in a single .java file?
This reminds me of when we did BigSib.java and Greeting.java, where methods from BigSib.java were used in Greeting.java's main method and compiled/run. Class Boardasaurus is kind of like BigSib.java because it provides all the methods and instance variables that Demo.java can use in its main method. It is also notable that only class Demo has the keyword "public" and the file name is "Demo.java."

Q1: How are the command line arguments processed?
The keywords try/catch are used to process the command line arguments. The first string after "$java Demo" will be converted into an Integer, which will represent the board size, and the second string will represent the delay time of the numbers on the actual board. The default values are already set as 8 and 500, respectively.

Q2: What happens if no command line arguments are given?
Because the defualt values are already set to be 8 and 500, the code will run using those values.

Q3: What is the nature/purpose of the recursion? Is it necessary for the animation?
The nature of the loop is that it has the "delay" function at the time. Recursion is necessary to make delay work.

Q4: What do you expect to see when you run it?
I expect to see a board with numbers that are constantly replaced for each second.

Q5: How long do you expect it to run?
(n^2 - n) * time ====> n^2 for big n

Q6: What does ANSI stand for? (You are permitted some intertubes searching here…). What is it good for?
ANSI is the American National Standard Institute. It sets a convention/concensus for any products, services, and systems. ANSI is kind of like Interfaces because it ensures that everyone uses the agreed symbols, and there would be no discrepancies. 

Q7: How did your expectations compare to your observations?
It was exactly what I expected.

Q8: How might you adapt this framework to animate a probing for a Knight’s Tour?
I can use this code to trace down the path of the knight (by numbering the path that it took each time).

EDITED ALGO:
1. Start from a random spot
2. Move to any one of the viable paths
3. If the path gets stuck, undo the most recent move and go to the other possible route.
4. Continue until finished.