class Solution:
    UNGUARDED = 0
    GUARDED = 1
    GUARD = 2
    WALL = 3

    def _mark_guarded(self, row: int, col: int, guarded_matrix: List[List[int]]) -> None:
        # Traverse upwards
        for r in range(row - 1, -1, -1):
            if guarded_matrix[r][col] == self.WALL or guarded_matrix[r][col] == self.GUARD:
                break
            guarded_matrix[r][col] = self.GUARDED

        # Traverse downwards
        for r in range(row + 1, len(guarded_matrix)):
            if guarded_matrix[r][col] == self.WALL or guarded_matrix[r][col] == self.GUARD:
                break
            guarded_matrix[r][col] = self.GUARDED

        # Traverse leftwards
        for c in range(col - 1, -1, -1):
            if guarded_matrix[row][c] == self.WALL or guarded_matrix[row][c] == self.GUARD:
                break
            guarded_matrix[row][c] = self.GUARDED

        # Traverse rightwards
        for c in range(col + 1, len(guarded_matrix[0])):
            if guarded_matrix[row][c] == self.WALL or guarded_matrix[row][c] == self.GUARD:
                break
            guarded_matrix[row][c] = self.GUARDED

    def countUnguarded(
        self, m: int, n: int, guards: List[List[int]], walls: List[List[int]]
    ) -> int:
        guarded_matrix = [[self.UNGUARDED] * n for _ in range(m)]

        # Mark guards' positions
        for guard in guards:
            guarded_matrix[guard[0]][guard[1]] = self.GUARD

        # Mark walls' positions
        for wall in walls:
            guarded_matrix[wall[0]][wall[1]] = self.WALL

        # Mark cells as guarded by traversing from each guard
        for guard in guards:
            self._mark_guarded(guard[0], guard[1], guarded_matrix)

        # Count unguarded cells
        count = 0
        for row in guarded_matrix:
            for cell in row:
                if cell == self.UNGUARDED:
                    count += 1

        return count
