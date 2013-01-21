numberutils_java
================

I have, on a few occasions, needed some utilities to convert numbers to binary, so I created a class that will do this for the various numbers in Java.

There are also a number of methods to take a number and encoded it onto an interval using steps. This allows you to compact a number into a small binary representation with some loss flexibility and/or accuracy.

I also wrote a really simple method that returns the closest prime less than or equal to any number up to 11,000. The goal was for supporting prime array sizes in hash tables. Finally there is a method to convert the sum of all numbers up to and including the number you pass in. This is a nice example of using an algorithm instead of brute force.

The test file relies on JUnit which is not included.