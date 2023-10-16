package tuan2;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class TreeSearch implements ISearchAlgo {
	
	Stack<Node> stack = new Stack<Node>();
	Set<Node> visited = new HashSet<Node>();
	@Override
	public Node execute(Node root, String goal) {
		// TODO Auto-generated method stub
		stack.add(root);
		visited.add(root);
		while(!stack.isEmpty()) {
			Node current = stack.pop();
			if(current.getLabel().equals(goal)) {
				return current;
			}
			for(Edge e : current.getChildren()) {
				Node child = e.getEnd();
				double cost = e.getWeight();
				if(!stack.contains(child) && !visited.contains(child)) {
					stack.add(child);
					visited.add(child);
					child.setParent(current);
					
				}
			}
		}
		return null;
	}
	@Override
	public Node execute(Node root, String start, String goal) {
		// TODO Auto-generated method stub
		return null;
	}
}
