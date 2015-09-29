Symbol = str
List = list
Number = (int, float)	# A Scheme Number is implemented as a Python int or float
Env = dict 				# A mapping of {variable: value}

def tokenize(chars):
	"Convert a string of characters into a list of tokens"
	return chars.replace("(", " ( ").replace(")", " ) ").split()

def parse(program):
	"Read a scheme expression from a string"
	return read_from_tokens(tokenize(program))

def read_from_tokens(tokens):
	"Read an expression from a list of tokens"
	if len(tokens) == 0:
		raise SyntaxError("Cannot parse an empty expression")
	token = tokens.pop(0)
	if token == "(":
		L = []
		while (tokens[0] != ')'):
			L.append(read_from_tokens(tokens))
		tokens.pop(0)
		return L
	elif token == ")":
		raise SyntaxError("Unexpected )")
	else:
		return atom(token)

def atom(token):
	"Numbers become numbers, every other token is a symbol"
	try: return int(token)
	except ValueError:
		try: return float(token)
		except ValueError:
			return Symbol(token)

def standard_env():
	"An environment with some Scheme standard procedures"
	import math, operator as op
	env = Env()
	env.update(vars(math)) #All the math ops
	env.update({
		'+':op.add, '-':op.sub, '*':op.mul, '/':op.div,
		'>':op.gt, '<':op.lt, '>=':op.ge, '<=':op.le, '=':op.eq,
		'abs':		abs,
		'append':	op.add,
		'apply':	apply,
		'begin':	lambda *x: x[-1],
		'car':		lambda x: x[0],
		'cdr':		lambda x: x[1:],
		'cons':		lambda x,y: [x] + y,
		'eq?':		op.is_,
		'equal?':	op.eq,
		'length':	len,
		'list':		lambda *x: list(x),
		'list?': 	lambda x: isinstance(x, list),
		'map': 		map,
		'max': 		max,
		'min': 		min,
		'not': 		op.not_,
		'null?':	lambda x: x == [],
		'number?':	lambda x: isinstance(x, Number),
		"procedure?": callable,
		'round': round,
		'symbol?': lambda x: isinstance(x, Symbol),
	})
	return env

def repl(prompt="lis.py> "):
	while True:
		val = eval(parse(raw_input(prompt)))
		if val is not None:
			print schemestr(val)

def schemestr(exp):
	"Convert a Python object back into a Scheme-readable string."
	if isinstance(exp, list):
		return '(' + ' '.join(map(schemestr, exp)) + ')' 
	else:
		return str(exp)

class Procedure(object):
	def __init__(self, env, params, body):
		self.env = env
		self.params = params
		self.body = body
	def __call__(self, *args):
		return eval(self.body, Env(self.params, args, self.env))

class Env(dict):
	def __init__(self, params=(), args=(), outer=None):
		self.update(zip(params, args))
		self.outer = outer
	def find(self, var):
		return self if (var in self) else self.outer.find(var)

global_env = standard_env()

def eval(x, env=global_env):
	"Evaluate an expression in an environment"
	if isinstance(x, Symbol): #It is a variable reference
		return env.find(x)[x]
	elif not isinstance(x, List): #It is a constant literal
		return x
	elif x[0] == 'quote':
		(_, exp) = x
		return exp
	elif x[0] == 'if':
		(_, test, conseq, alt) = x
		exp = (conseq if eval(test, env) else alt)
		return eval(exp, env)
	elif x[0] == 'define':
		(_, var, exp) = x
		env[var] = eval(exp, env)
	elif x[0] == 'set!':
		(_, var, exp) = x
		env.find(var)[var] = eval(exp, env)
	elif x[0] == "lambda":
		(_, params, body) = x
		return Procedure(env, params, body)
	else:
		proc = eval(x[0], env)
		args = [eval(arg, env) for arg in x[1:]]
		return proc(*args)
		
repl()


