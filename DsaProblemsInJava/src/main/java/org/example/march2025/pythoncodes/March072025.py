class Solution:
    def _is_prime(self, number: int) -> bool:
        if number == 1:
            return False
        for divisor in range(2, int(number**0.5) + 1):
            if number % divisor == 0:
                return False
        return True

    def closestPrimes(self, left: int, right: int) -> list[int]:
        prime_numbers = []

        # Find all prime numbers in the given range
        for candidate in range(left, right + 1):
            if candidate % 2 == 0 and candidate > 2:
                continue
            if self._is_prime(candidate):
                # If a twin prime (or [2, 3]) is found, return immediately
                if prime_numbers and candidate <= prime_numbers[-1] + 2:
                    return [prime_numbers[-1], candidate]
                prime_numbers.append(candidate)

        # If fewer than 2 primes exist, return [-1, -1]
        if len(prime_numbers) < 2:
            return [-1, -1]

        # Find the closest prime pair
        closest_pair = [-1, -1]
        min_difference = 1e6
        for index in range(1, len(prime_numbers)):
            difference = prime_numbers[index] - prime_numbers[index - 1]
            if difference < min_difference:
                min_difference = difference
                closest_pair = [prime_numbers[index - 1], prime_numbers[index]]

        return closest_pair