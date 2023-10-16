package tuan2;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;

public class UCS implements ISearchAlgo {

	@Override
	public Node execute(Node root, String goal) {
		// TODO Auto-generated method stub
		PriorityQueue<Node> queue = new PriorityQueue<Node>(20, new Comparator<Node>() {
			@Override
			public int compare(Node o1, Node o2) {
				// TODO Auto-generated method stub
//				if(o1.getPathCost() >o2.getPathCost()) {
//					return 1;
//				}
//				else if (o2.getPathCost() > o1.getPathCost()) {
//					return -1;
//				}
//				else return 0;
				return o1.compareTo(o2);
			}
		});
		Set<Node> visited = new HashSet<Node>();
		queue.add(root);
		visited.add(root);
		while (!queue.isEmpty()) {
			Node current = queue.poll();
			if (current.getLabel().equals(goal)) {
				return current;
			}
			for (Edge e : current.getChildren()) {
				Node end = e.getEnd();
				double cost = e.getWeight();

				if (!visited.contains(end) && !queue.contains(end)) {
					end.setPathCost(cost + current.getPathCost());
					end.setParent(current);
					queue.add(end);
					visited.add(end);
				}

				else if (queue.contains(end) && end.getPathCost() > current.getPathCost() + e.getWeight()) {
					end.setPathCost(cost + current.getPathCost());
					end.setParent(current);
//					queue.remove(end);
//					queue.add(end);

				}
			}
		}
		return null;
	}
	public int getPath(Node root , String goal) {
		Node path = execute(root, goal);
		return (int) path.getPathCost();
	}
	@Override
public Node execute(Node root, String start, String goal) {
		
		PriorityQueue<Node> queue = new PriorityQueue<Node>(new NodeComparator());
		Set<Node> visited = new HashSet<Node>();
		queue.add(root);
		while (!queue.isEmpty()) {
			Node temp = queue.poll();
			if (temp.getLabel().equals(goal)) {
				return temp;
			} else {
				visited.add(temp);
				List<Edge> children = temp.getChildren();
				for (Edge chill : children) {
					Node n = chill.getEnd();
					double t = (temp.getPathCost() + chill.getWeight());
					if (!queue.contains(n) && !visited.contains(n)) {
						queue.add(n);
						n.setParent(temp);
						n.setPathCost(t);
					} else if (n.getPathCost() < (t)) {
						n.setParent(temp);
						n.setPathCost(t);
					}
				}
				for (Node node : temp.getChildrenNodes()) {
					if (node.getLabel() == start) {
						node.setParent(null);
						queue.clear();
						visited.clear();
						queue.add(node);
						node.setPathCost(node.getPathCost()+temp.getPathCost());
					}
				}
		

			}
		}
		return null;
	}
	
	class NodeComparator implements Comparator<Node> {
		@Override
		public int compare(Node o1, Node o2) {
			// TODO Auto-generated method stub
			int re = Double.compare(o1.getPathCost(), o2.getPathCost());
			if (re == 0) {
				return o1.getLabel().compareTo(o2.getLabel());
			}
			return re;
		}

	}

}
