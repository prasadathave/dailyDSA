import heapq

class Solution:
    class GridCell:
        def __init__(self, height, row, col):
            self.height = height
            self.row = row
            self.col = col

        def __lt__(self, other):
            return self.height < other.height

    def _is_within_bounds(self, row, col, rows, cols):
        return 0 <= row < rows and 0 <= col < cols

    def trapRainWater(self, height_map):
        delta_row = [0, 0, -1, 1]
        delta_col = [-1, 1, 0, 0]

        rows = len(height_map)
        cols = len(height_map[0])

        marked = [[False] * cols for _ in range(rows)]

        boundary_cells = []

        for i in range(rows):
            heapq.heappush(boundary_cells, self.GridCell(height_map[i][0], i, 0))
            heapq.heappush(boundary_cells, self.GridCell(height_map[i][cols - 1], i, cols - 1))
            marked[i][0] = marked[i][cols - 1] = True

        for i in range(cols):
            heapq.heappush(boundary_cells, self.GridCell(height_map[0][i], 0, i))
            heapq.heappush(boundary_cells, self.GridCell(height_map[rows - 1][i], rows - 1, i))
            marked[0][i] = marked[rows - 1][i] = True

        total_water = 0

        while boundary_cells:
            current_cell = heapq.heappop(boundary_cells)

            curr_row = current_cell.row
            curr_col = current_cell.col
            min_boundary_height = current_cell.height

            for direction in range(4):
                neighbor_row = curr_row + delta_row[direction]
                neighbor_col = curr_col + delta_col[direction]

                if self._is_within_bounds(neighbor_row, neighbor_col, rows, cols) and not marked[neighbor_row][neighbor_col]:
                    neighbor_height = height_map[neighbor_row][neighbor_col]

                    if neighbor_height < min_boundary_height:
                        total_water += (min_boundary_height - neighbor_height)

                    heapq.heappush(boundary_cells, self.GridCell(max(neighbor_height, min_boundary_height), neighbor_row, neighbor_col))
                    marked[neighbor_row][neighbor_col] = True

        return total_water
