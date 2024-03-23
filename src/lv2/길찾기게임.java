package lv2;

import java.util.ArrayList;
import java.util.List;

public class 길찾기게임 {


	public static void main(String[] args) {
		int[][] nodeinfo = {{5, 3}, {11, 5}, {13, 3}, {3, 5}, {6, 1}, {1, 3}, {8, 6}, {7, 2}, {2, 2}};
		// binary search tree
		int[][] result = solution(nodeinfo);
		for (int[] ints : result) {
			for (int anInt : ints) {
				System.out.print(anInt + " ");
			}
			System.out.println();
		}
	}

	private static int index = 0;
	private static int[] preOrder;
	private static int[] postOrder;
	public static int[][] solution(int[][] nodeinfo) {// binary search tree
		List<Node> nodeList = new ArrayList<>();
		for (int i = 0; i < nodeinfo.length; i++) {
			nodeList.add(new Node(nodeinfo[i][0], nodeinfo[i][1], i + 1));
		}

		nodeList.sort(
				(a, b) -> {
					if ( a.y == b.y ) {
						return a.x - b.x;
					}
					return b.y - a.y;
				}
		);

		// make tree
		Node root = nodeList.get(0);
		for (int i = 1; i < nodeList.size(); i++) {
			Node node = nodeList.get(i);
			makeTree(root, node);
		}

		// preOrder

		preOrder = new int[nodeinfo.length];
		preOrder(root);
		// postOrder
		index = 0;
		postOrder = new int[nodeinfo.length];
		postOrder(root);

		return new int[][]{preOrder, postOrder};
	}

	private static void makeTree(Node parent, Node child) {
		if ( parent.x > child.x ) {
			if ( parent.left == null ) {
				parent.setLeft(child);
			} else {
				makeTree(parent.left, child);
			}
		} else {
			if ( parent.right == null ) {
				parent.setRight(child);
			} else {
				makeTree(parent.right, child);
			}
		}
	}

	private static void preOrder(Node node) {
		if ( node == null ) return;
		preOrder[index++] = node.idx;
		preOrder(node.left);
		preOrder(node.right);
	}

	private static void postOrder(Node node) {
		if ( node == null ) return;
		postOrder(node.left);
		postOrder(node.right);
		postOrder[index++] = node.idx;
	}
}

class Node {
	int x;
	int y;
	int idx;
	Node left;
	Node right;

	public Node(int x, int y, int idx) {
		this.x = x;
		this.y = y;
		this.idx = idx;
	}

	//setLeft
	public void setLeft(Node node) {
		this.left = node;
	}

	//setRight
	public void setRight(Node node) {
		this.right = node;
	}
}
