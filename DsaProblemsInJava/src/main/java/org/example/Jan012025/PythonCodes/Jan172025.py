def doesValidArrayExist(self, derived):
    result = 0
    for elem in derived:
        result = elem ^ result

    return result == 0