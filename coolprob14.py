# Credit to user in problem14 forum

dp = {}

def solve(n):
    if n == 1:
        return 0
    if n in dp:
        return dp[n]
    else:
        if n % 2 == 0:
            dp[n] = 1 + solve(n / 2)
            return dp[n]
        else:
            dp[n] = 1 + solve((3 * n) + 1)
            return dp[n]


relevant = range(1, 1000001)
print max(zip(relevant, map(solve, relevant)), key = lambda x : x[1])
