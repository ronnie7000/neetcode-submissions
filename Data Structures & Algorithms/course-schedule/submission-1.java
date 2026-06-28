class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = getGraph(numCourses, prerequisites);
        boolean[] visited = new boolean[numCourses];
        boolean[] pathVisited = new boolean[numCourses];

        for(int course = 0; course < numCourses; course++) {
            if(!visited[course] && dfs(course, graph, visited, pathVisited)) {
                return false;
            }
        }
        return true;
    }

    private boolean dfs(int course, List<List<Integer>> graph, boolean[] visited, boolean[] pathVisited) {
        if(pathVisited[course]) {
            return true;
        }
        visited[course] = true;
        pathVisited[course] = true;
        
        for(int pre : graph.get(course)) {
            if(pathVisited[pre]) {
                return true;
            }
            if(!visited[pre]) {
                if(dfs(pre, graph, visited, pathVisited)) {
                    return true;
                }
            }
        }
        pathVisited[course] = false;
        return false;
    }

    private List<List<Integer>> getGraph(int numCourses, int[][] arr) {
        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0; i <= numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        for(int[] edge : arr) {
            int course = edge[0];
            int pre = edge[1];
            graph.get(course).add(pre);
        }

        return graph;
    }
}
