
public class Graph {
	public int size; // Graph 배열의 크기 선언
	public String[] vertices; // index에 매칭되는 알파벳 문자들이 저장되어있는 배열 생성
	public Node[] a; // 노드 배열 생성

	public Graph(String[] args) { // A B C D E
		size = args.length;
		a = new Node[size]; // args배열의 size만큼의 노드 배열 생성
		vertices = new String[size]; // 위와 동일하게 size만큼의 vertices 배열 생성
		for (int i = 0; i < size; i++) // 노드배열 a를 Node로 채움
			a[i] = new Node(i, null);
		for (int j = 0; j < size; j++) 
			vertices[j] = args[j]; // vertices 0 1 2 3 4 5 6 7-> A B C D E F G H
	}

	public void add(String v, String w) { // 해당 노드에 다음 노드를 추가 연결 
		a[index(v)].next = new Node(index(w), a[index(v)].next);
		a[index(w)].next = new Node(index(v), a[index(w)].next);
	}

	public int index(String v) { // String 값 검색
		for (int i = 0; i < size; i++)
			if (v.equals(vertices[i])) // a[i]의 vertex 값이 v와 같으면 i 반환.
				return i;
		return a.length;
	}

	public void calc_degree(int x) { // 정점에 인접한 타 정점의 수를 count 하는 메소드
		int count = 0; // count를 0으로 초기화
		Node tempNode = a[x].next; // 첫번째 temp 노드는 첫 노드는 포함 시키지 않기 위해  다음 노드부터 시작

		while (tempNode != null) { // 다음 노드가 null일때까지 반복
			tempNode = tempNode.next;
			count++;
		}
		System.out.println(vertices[x] + "	" + count); // 결과 출력
	}

	public String toStringNode(int i) {
		
		Node head = a[i].next; // 첫번째 노드는 해당 정점의 다음 노드  (인접한 정점 출력 시 자기 자신 제외하기위함.)
		Node temp = head; // while 반복문을 위한 temp 노드 선언
		String str = "";
		// 다음 노드가 없을 때까지 반복문을 실행
		// 마지막 노드는 다음 노드가 없기 때문에 아래의 구문은 마지막 노드는 제외
		while (temp.next != null) {
			str += vertices[temp.to]; // 정점의 index가 아닌 문자를 출력하기 위해 vertices 배열 사용
			temp = temp.next; // temp노드를 다음 노드로 옮기
		}
		// 마지막 노드를 출력결과에 포함
		str += vertices[temp.to];
		return str + "";
	}


	public class Node { // 노드 클래스
		int to; // 노드의 first element
		Node next; // 다음 노드

		public Node(int to, Node next) { // 노드 생성자 생성.
			this.to = to;
			this.next = next;
		}
	}

}
