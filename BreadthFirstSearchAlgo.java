package tuan2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class BreadthFirstSearchAlgo implements ISearchAlgo {
	@Override
	public Node execute(Node root, String goal) {
		// TODO Auto-generated method stub
		Queue<Node> queue = new LinkedList<Node>();
		Set<Node> visited = new HashSet<Node>();
		queue.add(root);
		visited.add(root);

		while (!queue.isEmpty()) {
			Node current = queue.poll();
			if (current.getLabel().equals(goal)) {
				return current;
			}

			HashMap<Edge, Double> map = new HashMap<Edge, Double>();
			for (Edge e : current.getChildren()) {
				map.put(e, e.getWeight());
//				cost = e.getWeight();
			}

//			for (Node n : current.getChildrenNodes()) {
//				if (!visited.contains(n) && !queue.contains(n)) {
//					n.setParent(current);
//					queue.add(n);
//					visited.add(n);
//
//					for (Edge e : current.getChildren()) {
//						double newPathCost = current.getPathCost() +map.get(e);
//						n.setPathCost(newPathCost);
//					}
//				}
//			}
			for(Edge e : current.getChildren()) {
				Node end = e.getEnd();
				double cost = e.getWeight();
				if(!visited.contains(end) && !queue.contains(end)) {
					end.setPathCost(cost+ current.getPathCost());
					end.setParent(current);
					queue.add(end);
					visited.add(end);
				}
			}
		}
		return null;
	}

	@Override
	public Node execute(Node root, String start, String goal) {
		// TODO Auto-generated method stub
		Queue<Node> queue = new LinkedList<Node>();
		Set<Node> visited = new HashSet<Node>();
		queue.add(root);
		visited.add(root);
		while (!queue.isEmpty()) {
			Node current = queue.poll();
			if (current.getLabel().equals(goal)) {
				return current;
			}

			for (Node n : current.getChildrenNodes()) {
				if (n.getLabel().equals(start)) {
					n.setParent(current);
					queue.clear();
					visited.clear();
					execute(n, goal);
				}
			}
		}
		return null;
	}

}
