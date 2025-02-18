import java.util.*;

public class CourseSchedule {

    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        // Build the graph and in-degree array.
        List<List<Integer>> graph = new ArrayList<>();
        int[] inDegree = new int[numCourses];
        
        // Initialize graph with empty lists.
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }
        
        // Fill graph and in-degree.
        for (int[] pre : prerequisites) {
            int course = pre[0];
            int prerequisite = pre[1];
            graph.get(prerequisite).add(course);
            inDegree[course]++;
        }
        
        // Use a queue to perform BFS (Kahn's Algorithm for topological sort)
        Queue<Integer> queue = new LinkedList<>();
        
        // Add courses with no prerequisites to the queue.
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }
        
        int count = 0;  // Count of courses that can be finished
        
        while (!queue.isEmpty()) {
            int course = queue.poll();
            count++;
            
            // For each course dependent on the current course, decrease its in-degree.
            for (int nextCourse : graph.get(course)) {
                inDegree[nextCourse]--;
                if (inDegree[nextCourse] == 0) {
                    queue.offer(nextCourse);
                }
            }
        }
        
        // If we were able to process all courses, then it's possible to finish.
        return count == numCourses;
    }

    public static void main(String[] args) {
        int numCourses1 = 2;
        int[][] prerequisites1 = { {1, 0} };
        System.out.println("Can finish courses (Example 1): " + canFinish(numCourses1, prerequisites1)); // Expected: true

        int numCourses2 = 2;
        int[][] prerequisites2 = { {1, 0}, {0, 1} };
        System.out.println("Can finish courses (Example 2): " + canFinish(numCourses2, prerequisites2)); // Expected: false
    }
}
