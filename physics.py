import numpy as np

class Circle:
	"""A representation of a circle.

	Args:
		center_pt: A tuple of two floats, converted to a numpy array.
		radius: A float determining the radius.
		inv_mass: A float determining the inverse of the mass.
		velocity: A float representing the velocity.
		restitution: A float representing coefficient of restitution
	"""
	def __init__(self, center, radius, mass=1.0, velocity=0.0, restitution=0.5):
		self.center = np.array(center)
		self.radius = radius
		self.mass = mass
		self.inv_mass = 1 / mass
		self.velocity = velocity
		self.restitution = restitution

class Manifold:
	"""A manifold is 'a collection of points that represent an area in space.'

	   Here it means a small object that contains information about a collision
	   between two objects.

	Args:
		A: The first object in a collision.
		B: The second object in a collision.
		penetration: A float representing the amount of an impulse.
		normal: A size 2 vector representing the direction of an impulse.
	"""
	def __init__(self, A, B, penetration, normal):
		self.A = A
		self.B = B
		self.penetration = penetration
		self.normal = normal


def are_colliding(A, B):
	return (A.radius + B.radius) > np.linalg.norm(A.center - B.center)

def compute_manifold(A, B):
	direction = B.center - A.center
	distance = np.linalg.norm(B.center - A.center)
	total_radius = A.radius + B.radius

	if distance != 0:
		penetration = total_radius - distance
		normal = direction / distance
	else:
		penetration = A.radius
		normal = np.array([1, 0])
	return Manifold(A, B, penetration, normal)

def handle_collision(A, B, M):
	relative_velocity = B.center - A.center
	print relative_velocity
	velocity_along_norm = np.dot(relative_velocity, M.normal)
	print velocity_along_norm
	e = min(A.restitution, B.restitution)

	if velocity_along_norm > 0:
		print "Objects are already separating"
		return 

	j = - (1.0 + e) * velocity_along_norm
	j /= A.inv_mass + B.inv_mass

	impulse = j * M.normal
	A.velocity -= A.inv_mass * impulse
	B.velocity += B.inv_mass * impulse

def tests():
	A = Circle((1, 2), 1)
	B = Circle((1, 5), 1)
	assert are_colliding(A, B) == False

	C = Circle((1, 2), 2, 1)
	D = Circle((1, 5), 2, 1)
	assert are_colliding(C, D) == True

	M = compute_manifold(C, D)
	print "Penetration: " + str(M.penetration)
	print "Normal: " + str(M.normal)

	handle_collision(C, D, M)
	print "Velocity of C: " + str(C.velocity)
	print "Velocity of D: " + str(D.velocity)

tests()