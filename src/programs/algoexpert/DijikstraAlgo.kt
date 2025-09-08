package programs.algoexpert

import java.util.PriorityQueue

private data class NodeEntry(val nodeIndex: Int, val distance: Int)

fun dijkstrasAlgorithm(start: Int, edges: List<List<List<Int>>>): List<Int> {

    val numberOfNodes = edges.size

    val distances = IntArray(numberOfNodes) { Int.MAX_VALUE }

    distances[start] = 0

    val pq = PriorityQueue(compareBy<NodeEntry> { it.distance })

    pq.add(NodeEntry(start, 0))

    while (pq.isNotEmpty()) {

        val (currentNodeIndex, currentDistance) = pq.poll()

        if (currentDistance > distances[currentNodeIndex]) {
            continue
        }

        for (edge in edges[currentNodeIndex]) {
            val destinationNode = edge[0]
            val weightToDestination = edge[1]


            val newDistance = currentDistance + weightToDestination

            if (newDistance < distances[destinationNode]) {

                distances[destinationNode] = newDistance
                pq.add(NodeEntry(destinationNode, newDistance))
            }
        }
    }

    return distances.map { if (it == Int.MAX_VALUE) -1 else it }
}


fun main() {
    val startNode = 0
    // Graph representation:
    // Node 0 -> (1, 7)
    // Node 1 -> (2, 6), (3, 20)
    // Node 2 -> (3, 2)
    // Node 3 -> (1, 3) (Note: This is a directed graph)
    // Node 4 is unreachable
    val edges = listOf(
        // Edges for node 0
        listOf(listOf(1, 7)),
        // Edges for node 1
        listOf(listOf(2, 6), listOf(3, 20)),
        // Edges for node 2
        listOf(listOf(3, 2)),
        // Edges for node 3
        listOf(listOf(1, 3)),
        // Edges for node 4
        listOf()
    )

    val shortestPaths = dijkstrasAlgorithm(startNode, edges)

    // Expected output: [0, 7, 13, 15, -1]
    // Path to 0: 0
    // Path to 1: 7 (0 -> 1)
    // Path to 2: 13 (0 -> 1 -> 2)
    // Path to 3: 15 (0 -> 1 -> 2 -> 3)
    // Path to 4: Unreachable
    println("Shortest paths from node $startNode: $shortestPaths")
}