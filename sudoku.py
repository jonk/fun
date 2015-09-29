#Units, peers, squares

def cross(A, B):
	return [a+b for a in A for b in B]

digits = "123456789"
rows = "ABCDEFGHI"
cols = digits
squares = cross(rows, cols)
unitlist = ([cross(row, cols) for row in rows] +
			[cross(rows, col) for col in cols] +
			[cross(l, d) for l in ("ABC", "DEF", "GHI") for d in ("123", "456", "789")])

units = dict((s, [u for u in unitlist if s in u]) for s in squares)

peers = dict((s, set(sum(units[s],[]))-set([s])) for s in squares)

def test():
	assert squares[0] == "A1"
	assert squares[9] == "B1"
	assert squares[10] == "B2"
	assert len(squares) == 81
	assert len(unitlist) == 27
	assert all(len(units[s]) == 3 for s in squares)
	assert all(len(peers[s]) == 20 for s in squares)
	assert units['C2'] == [['C1', 'C2', 'C3', 'C4', 'C5', 'C6', 'C7', 'C8', 'C9'],
							['A2', 'B2', 'C2', 'D2', 'E2', 'F2', 'G2', 'H2', 'I2'],
                           ['A1', 'A2', 'A3', 'B1', 'B2', 'B3', 'C1', 'C2', 'C3']]
	assert peers['C2'] == set(['A2', 'B2', 'D2', 'E2', 'F2', 'G2', 'H2', 'I2',
                               'C1', 'C3', 'C4', 'C5', 'C6', 'C7', 'C8', 'C9',
                               'A1', 'A3', 'B1', 'B3'])
	print 'All tests pass.'

def parse_grid(grid):
	values = dict((s, digits) for s in squares)
	for s,d in grid_values(grid).items():
		if d in digits and not assign(values, s, d):
			return False ## This is a failure because we couldn't assign d to s
	return values

def grid_values(grid):
	chars = [c for c in grid if c in digits or c in "0."]
	assert len(chars) == 81
	return dict(zip(squares, chars))

def assign(values, s, d):
	other_values = digits.replace(d, "")
	if all(eliminate(values, s, d2) for d2 in other_values):
		return values
	else:
		return False

def eliminate(values, s, d):
	if d not in values[s]:
		return values
	values[s] = values[s].replace(d, "")
	if len(values[s]) == 0:
		return False
	elif len(values[s]) == 1:
		d2 = values[s]
		if not all(eliminate(values, p, d2) for p in peers[s]):
			return False
	for u in units[s]:
		dplaces = [sq for sq in u if d in values[sq]]
		if len(dplaces) == 0:
			return False #We removed the last element
		elif len(dplaces) == 1:
			if not assign(values, dplaces[0], d):
				return False
	return values

def solve(grid):
	return dfs(parse_grid(grid))

def dfs(values):
	if values == False:
		return False ##Already failed
	if all(len(values[s]) == 1 for s in squares):
		return values ## We're solved!
	else:
		n, s = min((len(values[s]), s) for s in squares if len(values[s]) > 1)
		return some(dfs(assign(values.copy(), s, d)) for d in values[s])

def some(seq):
	for e in seq:
		if e:
			return e
	return False


def display(values):
    "Display these values as a 2-D grid."
    width = 1+max(len(values[s]) for s in squares)
    line = '+'.join(['-'*(width*3)]*3)
    for r in rows:
        print ''.join(values[r+c].center(width)+('|' if c in '36' else '')
                      for c in cols)
        if r in 'CF': print line
    print

grid1 = '003020600900305001001806400008102900700000008006708200002609500800203009005010300'
grid11 = '007256400400000005010030060000508000008060200000107000030070090200000004006312700'
grid2 = '4.....8.5.3..........7......2.....6.....8.4......1.......6.3.7.5..2.....1.4......'
display(solve(grid1))
display(solve(grid11))
display(solve(grid2))



