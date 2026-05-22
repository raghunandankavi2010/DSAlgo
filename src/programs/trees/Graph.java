/*
 * Copyright 2026 Raghunandan Kavi
 *
 * Created by Raghunandan Kavi on 22 May 2026.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package programs.trees;

import java.util.LinkedList;
import java.util.Stack;


public class Graph {

    int vertices;
    LinkedList<Integer>[] adjList;

    Graph(int vertices){
        this.vertices = vertices;
        adjList = new LinkedList[vertices];
        for(int i=0; i<vertices;i++){
            adjList[i] = new LinkedList<>();
        }
    }

    public void addEdge(int src, int dest){
        adjList[src].addFirst(dest);
    }


    public static void main(String[] args) {
        Graph graph = new Graph(6);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(3, 4);
        graph.addEdge(2, 3);
        graph.addEdge(4, 0);
        graph.addEdge(4, 1);
        graph.addEdge(4, 5);
        graph.DFS(0);
    }

    public void DFS(int startVertex){
        boolean [] visited = new boolean[vertices];
        dfs(startVertex, visited);
    }

    public void dfs(int start, boolean [] visited){
        visited[start] = true;
        System.out.print(start + " ");
        for (int i = 0; i <adjList[start].size() ; i++) {
            int destination = adjList[start].get(i);
            if(!visited[destination])
                dfs(destination,visited);
        }
    }

    public void printGraph(){
        for (int i = 0; i <vertices ; i++) {
            if(adjList[i].size()>0) {
                System.out.println("Vertex " + i + " is connected to: ");
                for (int j = 0; j < adjList[i].size(); j++) {
                    System.out.print(adjList[i].get(j) + " ");
                }
                System.out.println();
            }
        }
    }
}

