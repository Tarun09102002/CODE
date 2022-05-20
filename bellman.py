import sys


test_cases = int(input()) # Number of testcases
for _ in range(test_cases):
    v, e = [int(x) for x in input().split(" ")]  # Input of number of vertices and edges
    edges = []
    vertices_distance = dict()

    for i in range(e):
        edges.append(tuple(int(x) for x in input().split(" ")))  # Taking the source, destination and cost of each edge

        # Creating a dict for each vertex
        if i == 0:
            vertices_distance[edges[i][0]] = 0
            vertices_distance[edges[i][1]] = sys.maxsize # Assigning maximum value of the system to all the vertices except the source
        else:
            if edges[i][0] not in vertices_distance:
                vertices_distance[edges[i][0]] = sys.maxsize
            if edges[i][1] not in vertices_distance:
                vertices_distance[edges[i][1]] = sys.maxsize

    for _ in range(1, v):
        for i in range(len(edges)):
            source = edges[i][0]
            destination = edges[i][1]
            cost = edges[i][2]
            # Checking the condition for each source, destination pair of edges
            if vertices_distance[source] + cost < vertices_distance[destination]:
                vertices_distance[destination] = vertices_distance[source] + cost

    vertices = list(vertices_distance)
    val = list(vertices_distance.values())

    print("\nOutput: ") # Showing the output after each iteration
    for i in range(1,len(vertices_distance)):
        if val[i] == sys.maxsize:
            print(f"{vertices[i]}  -1")
        else:
            print(f"{vertices[i]}  {val[i]}")
    print("\n")