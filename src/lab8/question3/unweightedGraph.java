package lab8.question3;

import lab8.question1and2.WeightedGraph;

public class unweightedGraph<T extends Comparable<T>> extends WeightedGraph<T, Integer> {


    /**
     * Overloads the super class's addEdge method. Uses 1 as a dummy value
     * @param source the first vertex
     * @param destination the second vertex
     * @return true if we could add, false if cannot add
     */
    public boolean addEdge(T source, T destination) {
        return super.addEdge(source, destination, 1); // we use super because question said use the framework from
                                                         // the WeightedGraph class, 1 is a dummy value
    }

    /**
     * Overloads the super class's addUndirectedEdge method. Uses 1 as a dummy value
     * @param vertex1 the first vertex
     * @param vertex2 the second vertex
     * @return true if we could add, false if cannot add
     */
    public boolean addUndirectedEdge(T vertex1, T vertex2){
        return super.addUndirectedEdge(vertex1, vertex2, 1); // we use super because question said use the framework from
                                                                    // the WeightedGraph class, 1 is a dummy value
    }
}
