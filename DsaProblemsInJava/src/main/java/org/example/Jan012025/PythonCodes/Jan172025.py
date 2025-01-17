def doesValidArrayExist(self, derived: List[int]) -> bool:
    result = 0
    for elem in derived:
        result = elem ^ result

    return result == 0