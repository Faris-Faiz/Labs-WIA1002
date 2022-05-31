package lab8.question1and2;

import java.util.ArrayList;

public class WeightedGraph <T extends Comparable<T>, N extends Comparable<N>>{
    Vertex<T, N> head;
    int size;

    public WeightedGraph(){
        head = null;
        size = 0;
    }

    /**
     * Method to return the size of the graph from a local variable called size
     * @return the size of the graph (vertices only, no edges)
     */
    public int getSize(){
        return this.size;
    }

    /**
     * Returns a boolean value by accepting a vertex as the parameter, which then returns true/false if the desired vertex exists.
     * @param v The desired vertex to check if it is present or not in the graph
     * @return True if the vertex exists, False if the vertex doesn't exist in the graph
     */
    public boolean hasVertex(T v){
        if(head == null)
            return false;
        Vertex<T, N> pointer = head;
        while (pointer != null){
            if(pointer.vertexInfo.compareTo(v) == 0) // when they're both equal
                return true;
            pointer = pointer.nextVertex;
        }
        return false;
    }

    /**
     * Retrieves the value of the in degree of a desired vertex  (how many edges are pointing towards the vertex)
     * @param v the vertex desired to check the in degree
     * @return the variable indeg (integer) that is present in the Vertex class.
     */
    public int getIndeg(T v){
        if(hasVertex(v) == true){
            Vertex<T, N> pointer = head;
            while (pointer != null){
                if(pointer.vertexInfo.compareTo(v) == 0)
                    return pointer.indeg;
                pointer = pointer.nextVertex;
            }
        }
        return -1;
    }

    /**
     * Method that returns an integer of the number of out degree of a vertex (how many edges are going out of the vertex)
     * @param v receives a vertex as a parameter
     * @return integer of the number of out degree of the desired vertex
     */
    public int getOutdeg(T v){
        if(hasVertex(v) == true){
            Vertex<T, N> pointer = head;
            while (pointer != null){
                if(pointer.vertexInfo.compareTo(v) == 0)
                    return pointer.outdeg;
                pointer = pointer.nextVertex;
            }
        }
        return -1;
    }

    /**
     * A method to add a vertex into the graph
     * @param v the desired vertex to be added
     * @return True if the vertex is successfully added, false if the vertex failed in being added
     */
    public boolean addVertex(T v){
        if(hasVertex(v) == false){ // vertex is not in the graph
            Vertex<T, N> pointer = head;
            Vertex<T, N> newVertex = new Vertex<>(v, null);
            if(head==null)
                head = newVertex;
            else {
                Vertex<T, N> previous = head;
                while (pointer != null){
                    previous = pointer;
                    pointer = pointer.nextVertex;
                }
                previous.nextVertex = newVertex; // adding vertex as the last element in the list
            }
            size++;
            return true;
        }else // vertex is in the graph
            return false;
    }

    /**
     * Method to retrieve the index of the desired vertex we want inside the graph
     * @param v the vertex we want the index to
     * @return the index of the vertex in the graph
     */
    public int getIndex(T v){
        Vertex<T, N> temp = head;
        int pos = 0;
        while(temp != null){
            if(temp.vertexInfo.compareTo(v) == 0){
                return pos;
            }
            temp = temp.nextVertex;
            pos++;
        }
        return -1; // vertex doesn't exist
    }

    /**
     * Returns the vertex object representation in the graph
     * @return a list of all the vertices in the graph
     */
    public ArrayList<T> getAllVertexObjects(){
        ArrayList<T> list = new ArrayList<>();
        Vertex<T, N> temp = head;
        while(temp != null){
            list.add(temp.vertexInfo);
            temp = temp.nextVertex;
        }
        return list;
    }

    /**
     * Method to return the vertex's index position
     * @param pos the index position of the vertex we want
     * @return the vertex at that specified index position
     */
    public T getVertex(int pos){
        if(pos > size-1 || pos < 0)
            return null;
        Vertex<T, N> temp = head;
        for (int i = 0; i < pos; i++)
            temp = temp.nextVertex;
        return temp.vertexInfo;
    }

    /**
     * For a vertex to have an edge, say Vertex 1 and Vertex 2, both vertices must have an edge connecting the two for
     * an edge to exist
     * @param source the first vertex in question (Vertex 1)
     * @param destination the second vertex in question (Vertex 2)
     * @return true if there exists an edge between the Source vertex and the Destination vertex
     */
    public boolean hasEdge(T source, T destination){
        if (head == null)
            return false;
        if (!hasVertex(source) || !hasVertex(destination)) // if the vertex doesn't exist, then return false
            return false;
        Vertex<T, N> sourceVertex = head;
        while(sourceVertex != null){ // reached the source vertex, now look at the edges of the associated vertex
            Edge<T, N> currentEdge = sourceVertex.firstEdge;
            while(currentEdge != null){
                if(currentEdge.toVertex.vertexInfo.compareTo(destination) == 0)
                    return true;
                currentEdge = currentEdge.nextEdge;
            }
            sourceVertex = sourceVertex.nextVertex;
        }
        return false;
    }

    /**
     * Uses addEdge method, and for it to be undirected, we add it in both possible scenarios whereby Vertex 1 has an
     * edge pointing towards Vertex 2, and Vertex 2 has an edge pointing towards Vertex 1. Uses the AND operator, meaning
     * both cases must succeed in order to be able to return a true value.
     * @param source the first vertex we want to add an undirected edge to
     * @param destination the second vertex we want to add an undirected edge to
     * @param weight the weight for the edges to have, if wanted
     * @return true if both conditions (adding edges in both scenarios return true), false if either one fails
     */
    public boolean addUndirectedEdge(T source, T destination, N weight){
        return addEdge(source, destination, weight) && addEdge(destination, source, weight);
    }

    /**
     * Remove edge from the two vertices we specified into the parameter of the method.
     * @param source the first vertex we want to remove their edge
     * @param destination the second vertex we want to remove their edge
     * @return true if succeeds, false if not succeeds
     */
    public boolean removeEdge(T source, T destination){
        if(!hasEdge(source, destination))
            return false;
        Vertex<T, N> temp = head;
        while(temp != null){
            if(temp.vertexInfo.equals(source)){ // if temp is equal to the source vertex
                Edge<T, N> currentEdge = temp.firstEdge;
                if(currentEdge.toVertex.vertexInfo.equals(destination)){ // first edge's destination vertex is equal to the desired destination vertex
                    temp.firstEdge = currentEdge.nextEdge; // first edge changed to the current edge's next edge
                    currentEdge.nextEdge = null; // remove current edge's reference
                }else { // for case where first edge is not the desired edge we want to remove
                    Edge<T, N> prevEdge = currentEdge; // to remove the currentEdge
                    while (currentEdge != null){ // find the destination vertex that is connected to the source vertex
                        if(currentEdge.toVertex.vertexInfo.equals(destination)){
                            prevEdge.nextEdge = currentEdge.nextEdge;
                            currentEdge.nextEdge = null;
                            break;
                        }
                        prevEdge = currentEdge;
                        currentEdge = currentEdge.nextEdge;
                    }
                    temp.outdeg--; // reduce the outdeg as the edges have been removed
                    currentEdge.toVertex.indeg--; // same thing as above
                    return true;
                }
            }
            temp = temp.nextVertex;
        }
        return false;
    }

    /**
     * Adding an edge to two vertices, alongside providing a weight between the two vertices
     * @param source the first vertex we want to add an edge to
     * @param destination the second vertex we want to add an edge to
     * @param w the weight of the edge, if desired
     * @return true if successfully added, false if not successful
     */
    public boolean addEdge(T source, T destination, N w){
        if(head == null)
            return false;
        if(!hasVertex(source) || !hasVertex(destination))
            return false;
        Vertex<T, N> sourceVertex = head;
        while(sourceVertex != null){
            if(sourceVertex.vertexInfo.compareTo(source) == 0){
                // Reached source vertex, look for destination now
                Vertex<T, N> destinationVertex = head;
                while(destinationVertex != null){
                    if(destinationVertex.vertexInfo.compareTo(destination) == 0){
                        // Reached destination vertex, add edge here
                        Edge<T, N> currentEdge = sourceVertex.firstEdge;
                        Edge<T, N> newEdge = new Edge<>(destinationVertex, w, currentEdge);
                        sourceVertex.firstEdge = newEdge;
                        sourceVertex.outdeg++;
                        destinationVertex.indeg++;
                        return true;
                    }
                    destinationVertex = destinationVertex.nextVertex;
                }
            }
            sourceVertex = sourceVertex.nextVertex;
        }
        return false;
    }

    /**
     * Returns the edge's corresponding integer value
     * @param source the first vertex we want the edge's weight to
     * @param destination the second vertex we want the edge's weight to
     * @return integer value if there is an edge, returns null if no edge is found
     */
    public N getEdgeWeight(T source, T destination){
        N notFound = null;
        if (head == null)
            return notFound;
        if(!hasVertex(source) || !hasVertex(destination))
            return notFound;
        Vertex<T, N> sourceVertex = head;
        while(sourceVertex != null){
            if(sourceVertex.vertexInfo.compareTo(source) == 0){ // found source vertex
                Edge<T, N> currentEdge = sourceVertex.firstEdge;
                while (currentEdge != null){
                    if(currentEdge.toVertex.vertexInfo.compareTo(destination) == 0)
                        return currentEdge.weight;
                    currentEdge = currentEdge.nextEdge;
                }
            }
            sourceVertex = sourceVertex.nextVertex;
        }
        return notFound;
    }

    /**
     * Returns an ArrayList that contains all the vertex's neighbors (ex: Neighbors of Kuching: [Tawau, Melaka])
     * @param v the vertex in question
     * @return an arraylist that contains all the vertex's neighbors
     */
    public ArrayList<T> getNeighbors (T v){
        if(!hasVertex(v))
            return null;
        ArrayList<T> list = new ArrayList<>();
        Vertex<T, N> temp = head;
        while (temp != null){
            if(temp.vertexInfo.compareTo(v) == 0){
                Edge<T, N> currentEdge = temp.firstEdge;
                while (currentEdge != null){
                    list.add(currentEdge.toVertex.vertexInfo);
                    currentEdge = currentEdge.nextEdge;
                }
            }
            temp = temp.nextVertex;
        }
        return list;
    }

    /**
     * equivalent to a toString() method
     */
    public void printEdges(){
        Vertex<T, N> temp = head;
        while (temp != null){
            System.out.println("# " + temp.vertexInfo + " : ");
            Edge<T, N> currentEdge = temp.firstEdge;
            while(currentEdge != null){
                System.out.println("[" + temp.vertexInfo + ","
                        + currentEdge.toVertex.vertexInfo + "] ");
                currentEdge = currentEdge.nextEdge;
            }
            System.out.println();
            temp = temp.nextVertex;
        }
    }
}
