class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses]; 
        List<List<Integer>> graph = getGraph(numCourses, prerequisites, indegree);
        Queue<Integer> queue = new LinkedList<>();
        int[] ans = new int[numCourses];
        int idx = 0;

        for(int i = 0; i < numCourses; i++) {
            if(indegree[i] == 0) {
                queue.add(i);
            }
        }

        while(!queue.isEmpty()) {
            int course = queue.poll();
            ans[idx++] = course;

            for(int next : graph.get(course)) {
                indegree[next]--;
                if(indegree[next] == 0) {
                    queue.add(next);
                }
            }
        }

        if(idx != numCourses) {
            return new int[] {};
        }
        return ans; 
    }

    private List<List<Integer>> getGraph(int numCourses, 
    int[][] prerequisites, int[] indegree) {
        List<List<Integer>> graph = new ArrayList<>();

        for(int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        for(int[] edge : prerequisites) {
            int start = edge[0];
            int end = edge[1];

            graph.get(end).add(start);
            indegree[start]++;
        }

        return graph;
    }
}
