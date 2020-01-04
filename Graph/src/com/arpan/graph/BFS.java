package com.arpan.graph;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

//Geeks for geeks
public class BFS {
	
public static void main(String[] args) {
	Graph g = new Graph(5); 
    
    g.addEdge(1, 0); 
    g.addEdge(0, 2); 
    g.addEdge(2, 1); 
    g.addEdge(0, 3); 
    g.addEdge(1, 4);  
    g.dfsUsingStack(0);
}
}

class Graph{
	
	private int V;
	private LinkedList<Integer> adj[];
	
	public Graph(int v){
		this.V=v;
		adj=new LinkedList[v];
		for(int i=0;i<v;i++) {
			adj[i]=new LinkedList<Integer>();
		}
	}
	
	public void addEdge(int u,int w) {
		adj[u].add(w);
	}
	
public void bfsTraversal(int source) {
		
		boolean visited[]=new boolean[V];
		for(int i=0;i<V;i++) {
			visited[i]=false;
		}
		Queue<Integer> queue=new LinkedList<Integer>();
		visited[source]=true;
		queue.add(source);
		while(!queue.isEmpty()) {
			int node=queue.poll();
			System.out.println(node+" ");
			Iterator<Integer> itr=adj[node].iterator();
			while(itr.hasNext()) {
				int vertice=itr.next();
				if(visited[vertice]==false) {
					queue.add(vertice);
					visited[vertice]=true;
				}
			}
			
		}
		
		
		
	}

	public void dfs(int source) {
		boolean visited[]=new boolean[V];
		dfs(source,visited);
	}

	private void dfs(int source, boolean[] visited) {
		System.out.println(source);
		visited[source]=true;
		Iterator<Integer> itr=adj[source].iterator();
		while(itr.hasNext()) {
			int node=itr.next();
			if(visited[node]==false) {
				dfs(node,visited);
			}
		}
		
	}
	
	public void dfsUsingStack(int source) {
		boolean visited[]=new boolean[V];
		for(int i=0;i<V;i++) {
			visited[i]=false;
		}
		Stack<Integer> stack = new Stack<>();
		stack.push(source);
		visited[source]=true;
		while(!stack.isEmpty()) {
			int s=stack.pop();
			System.out.println(s+" ");
			visited[s]=true;
			
			Iterator<Integer> itr=adj[s].iterator();
			while(itr.hasNext()) {
				int node=itr.next();
				if(visited[node]==false) {
					stack.push(node);
				}
			}
		}
		
	}
	
	
	
}
