- Java 8(start)
- Java 19(compile as 15)
- IntelliJ Idea Community Edition
___
# Your Task
___
You are given a string S of length n that contains only the characters A and B. You need to answer q queries, each in the form of a tuple (l, r, k). For each query, you must determine the match for the k-th character in the substring S[l…r].

If the k-th character in substring S[l..r] is A and this is x-th occurrence of A in the substring, then the match will be the position for x-th occurrence of B, and vice versa if k-th character in S[l..r] is B.
If there is no match, print -1.
Task requirements
Create an executable .jar file. You can use Java version up to 18 inclusive. Please, be aware that if you use any Java version older than 15, some classes which were included into JRE in previous versions (like javafx) are not available in JRE 15. In this case the solution will fail with an exception on the first test case.
Read the input data from the file named input.txt which will be located in the current working directory. Please, access the file by name, e.g. "input.txt" not "/home/user/input.txt" so it will be resolved to the current working directory automatically.
As a result of execution, your .jar file should create a file containing the output data, named output.txt in the same folder (working directory).
Performance of your solution does not matter until it fits in time limit. Note that the time limit is set to 2s and memory limit to set to 128 MB (-Xmx128M).
The solution .jar file must also contain the source code (files with .java or .kt extension).
The solution .jar file size must be less than 10 MB. You are free to include any libraries, just make sure their usage is justified.
After you have solved the task, send it via the form in the section below (please do not publish it anywhere else). Your submission will be automatically tested, so it is required that you strictly follow the input/output data format. If your .jar file is not executable, or does not contain source code, it will not be accepted.
We value candidates who try to think over the solution before sending it as finished - please, don't send a lot of similar solutions with random changes.

# Input/Output Data Format
___
Input file
The first line of the input contains two integers n and q, where n is the length of the string S and q is the number of queries.

The second line of the input contains the string S, which consists of only the characters A and B.

The next q lines each contain a query in the form of three integers l, r, and k, representing a tuple (l, r, k).

Input values range:
n, q - 1...105
l, r - 1...n
k - 1...n
l <= r
k <= r - l + 1

Example of input file:
8 3
ABBABAAB
1 4 4
2 6 1
3 7 5
Output file
Example of output file (for this input file):

3
3
-1
Please note that it's important what you use for reading and writing. For example, using a Scanner for reading input will most likely result in your solution not passing due to bad performance.

# How to Check Your Solution
___
Before sending the solution, it is recommended to check how it works on your side. Please, follow the steps below:
Create a file input.txt with the contents described in the section Input/Output data format .
Put the input.txt into a folder with your_solution.jar file (the name of the jar file doesn't matter).
Open the command line in the same folder. Run java -Xmx128M -jar your_solution.jar. Use your file name instead of "your_solution".
Assuming your solution works correctly, output.txt file should appear in the same folder, with the contents identical to what is shown in the Input/Output data format section.

# Frequently Asked Questions
___
My solution is rejected
Please make sure your .jar file also contains source files. You can add source files to your .jar archive manually if configuring your building tool makes an issue.

Test #1 failed
Test #1 contains the example data from the task description so it should have passed, right? Please check that your solution meets all the task requirements, especially:
Compiler version
Correct paths to input/output file. Take into account that your code is executed on another machine, so the paths should not be absolute, and should be cross-platform
Some other tests failed. Can you give me some other examples of input data to check my solution?
Sorry, we do not reveal test cases. The task description tells you, more or less explicitly, everything you need to know to complete the task. You may want to build your own test cases based on the task description.

I can’t pass your performance test but I have no OutOfMemoryException on my PC
Performance is not solely limited to memory usage.

# Additional Info
___
If your solution passes the tests, its execution time will be measured. Think that you can make it better? Well, nothing stops you from sending another solution =)
Please, note that the execution time can fluctuate in the range of +- 300...400 ms for the same solution.
We also have a leaderboard, but it is mostly made for fun, and your rank does not directly affect the interview process or your chances to get hired. Your highest score solution will appear there.
Do you need any extra information to complete this task? If so - feel free to ask, email: hr@bookmap.com
___
In the terminal:
- java -Xmx128M -jar bookmap-test-portal.jar
