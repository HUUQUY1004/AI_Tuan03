package tuan2;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class DepthFirstSearchAlgo implements ISearchAlgo {

	@Override
	public Node execute(Node root, String goal) {
		// TODO Auto-generated method stub
		Set<Node> visited = new HashSet<Node>();
		Stack<Node> stack = new Stack<Node>();
		visited.add(root);
		stack.push(root);
		while(!stack.isEmpty()) {
			Node current = stack.pop();
			if(current.getLabel().equals(goal)) {
				return current;
			}
			for(Node  n : current.getChildrenNodes()) {
				if(!visited.contains(n) && !stack.contains(n)) {
					n.setParent(current);
					visited.add(n);
					stack.add(n);
				}
			}
		}
		return null;
	}
//	LIFO => STACK

	@Override
	public Node execute(Node root, String start, String goal) {
		// TODO Auto-generated method stub
		Stack<Node> stack = new Stack<Node>();
		Set<Node> visted = new HashSet<Node>();
		stack.push(root);
		visted.add(root);
		while(!stack.isEmpty()) {
			Node current = stack.pop();
			if(current.getLabel().equals(goal)) {
				return current;
			}
			
			for(Edge e : current.getChildren()) {
				Node end = e.getEnd();
				double cost = e.getWeight();
				if(!visted.contains(end) && !stack.contains(end)) {
					end.setPathCost(cost+ current.getPathCost());
					end.setParent(current);
					stack.add(end);
					visted.add(end);
				}
				
			}
		}
		return null;
	}

}
