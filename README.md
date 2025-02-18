# Course-Schedule
There are numCourses courses labeled from 0 to numCourses - 1. You are given an array prerequisites where prerequisites[i] = [a, b] indicates that you must take course b before taking course a. 
Explanation:
Graph Construction & In-Degree Calculation:

We construct an adjacency list graph where for each prerequisite relation [a, b], course a is added to the list of courses dependent on b.
Simultaneously, we update the inDegree array which tracks how many prerequisites each course has.
BFS & Topological Sorting (Kahn's Algorithm):

Initialize a queue with courses having 0 in-degree (i.e., courses that can be taken immediately).
Process the queue: for each course taken, decrease the in-degree of its dependent courses. If any dependent course's in-degree becomes 0, add it to the queue.
Keep a count of how many courses can be taken.
Cycle Detection:

If there is a cycle, some courses will never have an in-degree of 0, and the count will be less than numCourses.
If the count equals numCourses, then all courses can be completed.
