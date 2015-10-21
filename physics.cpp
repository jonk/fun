#include <iostream>
#include <vector>

using namespace std;


struct AABB
{
	vector<double> min (2);
	vector<double> max (2);
};

struct Circle
{
	float radius;
	Vec position;
};

bool checkAABBIntersection( AABB a, AABB, b)
{
	//Exit with no intersection because we found a separating axis
	if (a.min.x > b.max.x or a.max.x < b.min.x) return false;
	if (a.min.y > b.max.y or a.max.y < b.min.y) return false;

	return true;
}

float checkCircleIntersection(Circle a, Circle b)
{
	float r = (a.radius + b.radius);
	r *= r;
	return (a.x - b.x)^2 + (a.y - b.y)^2 > r;
}

void resolveColision(Object A, Object B)
{

	float normal = 1
	//Calculate relative velocity
	Vec2 rv = B.velocity - A.velocity;

	float velAlongNormal = dotProduct(rv, normal);

	if (velAlongNormal > 0)
		return;

	//Calculate restitution
	float e = min(A.restitution, B.restitution);

	float j = -(1 + e) * velAlongNormal;
	j /= 1 / A.mass + 1 / B.mass

	Vec2 impulse = j * normal
	A.velocity -= 1 / A.mass * impulse;
	B.velocity += 1 / B.mass * impulse;

}