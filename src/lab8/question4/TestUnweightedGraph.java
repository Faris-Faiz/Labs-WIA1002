package lab8.question4;
import lab8.question3.unweightedGraph;

public class TestUnweightedGraph {
    public static void main(String[] args) {
        unweightedGraph<String> graph1 = new unweightedGraph<>();
        String[] cities = {"Alor Setar", "Kuching", "Langkawi", "Melaka", "Penang", "Tawau"};
        for (String i : cities)
            graph1.addVertex(i);

        System.out.println("The number of vertices in the graph1: " + graph1.getSize());

        System.out.println("Cities and their vertices ");
        for (int i = 0; i < graph1.getSize(); i++)
            System.out.print(i + ": " + graph1.getVertex(i) + "\t");
        System.out.println();

        System.out.println("Is Melaka in the Graph? " + graph1.hasVertex("Melaka"));
        System.out.println("Is Ipoh in the Graph? " + graph1.hasVertex("Ipoh"));
        System.out.println();

        System.out.println("Kuching at index " + graph1.getIndex("Kuching"));
        System.out.println("Ipoh at index " + graph1.getIndex("Ipoh"));
        System.out.println();

        System.out.println("add edge Kuching - Melaka: " + graph1.addEdge("Kuching", "Melaka"));
        System.out.println("add edge Langkawi - Penang: " + graph1.addEdge("Langkawi", "Penang"));
        System.out.println("add edge Melaka - Penang: " + graph1.addEdge("Melaka", "Penang"));
        System.out.println("add edge Alor Setar - Kuching: " + graph1.addEdge("Alor Setar", "Kuching"));
        System.out.println("add edge Tawau - Alor Setar: " + graph1.addEdge("Tawau","Alor Setar"));
        System.out.println("add edge Kuching - Tawau: " + graph1.addEdge("Kuching", "Tawau"));
        System.out.println("add edge Langkawi - Ipoh: " + graph1.addEdge("Langkawi", "Ipoh"));
        System.out.println();

        System.out.println("has edge from Kuching to Melaka? " + graph1.hasEdge("Kuching", "Melaka"));
        System.out.println("has edge from Melaka to Langkawi? " + graph1.hasEdge("Melaka", "Langkawi"));
        System.out.println("has edge from Ipoh to Langkawi? " + graph1.hasEdge("Ipoh", "Langkawi"));
        System.out.println();

        System.out.println("In and out degree for Kuching is " + graph1.getIndeg("Kuching") + " and " + graph1.getOutdeg("Kuching"));
        System.out.println("In and out degree for Kuching is " + graph1.getIndeg("Kuching") + " and " + graph1.getOutdeg("Kuching"));
        System.out.println("In and out degree for Kuching is " + graph1.getIndeg("Kuching") + " and " + graph1.getOutdeg("Kuching"));
        System.out.println();

        System.out.println("Neighbors of Kuching: " + graph1.getNeighbors("Kuching"));
        System.out.println("\nPrint Edge: ");
        graph1.printEdges();
    }
}
