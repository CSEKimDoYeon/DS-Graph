
public class TestGraph { 
	public static void main(String[] args) {
		Graph g = new Graph(new String[] { "A", "B", "C", "D", "E", "F", "G", "H" });// Graph의 정점 입력.
		// ----입력부---- //
		g.add("A", "B"); // 그래프 연결
		g.add("A", "E");
		g.add("B", "C");
		g.add("B", "F");
		g.add("C", "D");
		g.add("C", "H");
		g.add("D", "H");
		g.add("E", "F");
		g.add("F", "G");
		// ----입력부 종료---- //
		
		// ----출력부---- //
		System.out.print("{ ");
		for (int i = 0; i < g.size; i++) { // 그래프의 정점의 수만큼 반복
			System.out.print(g.vertices[i] + ":"); // index와 일치하는 정점의 문자 출력
			System.out.print(g.toStringNode(i) + " "); // 정점에 인접한 모든 문자 출력
		}
		System.out.println("}");
		System.out.println("정점	인접한 정점 수");
		for (int i = 0; i < g.size; i++) {
			g.calc_degree(i); // 각 정점에 인접한 다른 정점의 수 count
		}
		// ----출력부 종료---- //
	}
}
