package tuan2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class test {
	public static void main(String[] args) {
		Node nodeS = new Node("S");
		Node nodeA = new Node("A");
		Node nodeB = new Node("B");
		Node nodeC = new Node("C");
		Node nodeD = new Node("D");
		Node nodeE = new Node("E");
		Node nodeF = new Node("F");
		Node nodeG = new Node("G");
		Node nodeH = new Node("H");
		nodeS.addEdge(nodeA, 5);
		nodeS.addEdge(nodeB, 2);
		nodeS.addEdge(nodeC, 4);
		nodeA.addEdge(nodeD, 9);
		nodeA.addEdge(nodeE, 4);
		nodeB.addEdge(nodeG, 6);
		nodeC.addEdge(nodeF, 2);
		nodeD.addEdge(nodeH, 7);
		nodeE.addEdge(nodeG, 6);
		nodeF.addEdge(nodeG, 1);
		ISearchAlgo algo1 = new BreadthFirstSearchAlgo();
		ISearchAlgo algo2 = new UCS();
		UCS usc = new UCS();
		Node result = algo1.execute(nodeS, "G");
		Node result2 = algo2.execute(nodeS,"G");
		Node result3 = algo2.execute(nodeS, "F", "G");
		int res4 = usc.getPath(nodeS, "G");
		System.out.println(result3);
//		System.out.println(res4);
//		HashMap<Edge, Double> list = new HashMap<Edge, Double>();
//		for(Edge e : nodeS.getChildren()) {
//			list.put(e, e.getWeight());
//		}
//		System.out.println(list);
//		System.out.println(nodeE.getPathCost());
	}
}
