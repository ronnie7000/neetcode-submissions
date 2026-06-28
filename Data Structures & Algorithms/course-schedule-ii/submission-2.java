class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];
        List<List<Integer>> graph = getGraph(numCourses, prerequisites, indegree);
        int[] ans = new int[numCourses];
        int idx = 0;
        Queue<Integer> queue = new LinkedList<>();

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
            return new int[0];
        }
        return ans;
    }

    private List<List<Integer>> getGraph(int numCourses, int[][] arr, int[] indegree) {
        List<List<Integer>> graph = new ArrayList<>();

        for(int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        for(int[] edge : arr) {
            int course = edge[0];
            int pre = edge[1];

            graph.get(pre).add(course);
            indegree[course]++;
        }

        return graph;
    }
}
