_dirs = [(0, 1), (0, -1), (1, 0), (-1, 0)]

def minCost(self, grid: List[List[int]]) -> int:
    rows, cols = len(grid), len(grid[0])

    pq = [(0, 0, 0)]
    cost_matrix = [[float("inf")] * cols for _ in range(rows)]
    cost_matrix[0][0] = 0

    while pq:
        current_cost, x, y = heapq.heappop(pq)

        if cost_matrix[x][y] != current_cost:
            continue

        for direction, (dx, dy) in enumerate(self._dirs):
            nx, ny = x + dx, y + dy

            if 0 <= nx < rows and 0 <= ny < cols:
                new_cost = current_cost + (direction != (grid[x][y] - 1))

                if cost_matrix[nx][ny] > new_cost:
                    cost_matrix[nx][ny] = new_cost
                    heapq.heappush(pq, (new_cost, nx, ny))

    return cost_matrix[rows - 1][cols - 1]
