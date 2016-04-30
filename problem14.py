def create_collatz_for(n):
    while n != 1:
        if n % 2 == 0:
            yield n
            n /= 2
        else:
            yield n
            n = (3 * n) + 1

def find_longest_collatz():
    max_len = 0
    max_len_val = -1 
    for i in range(1, 1000001):
        chain_length = 0
        collatz_gen = create_collatz_for(i)
        for val in collatz_gen:
            chain_length += 1
        if chain_length > max_len:
            max_len = chain_length
            max_len_val = i
    return (max_len, max_len_val)

print find_longest_collatz()