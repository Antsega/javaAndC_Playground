z = 0;
g = 0;
s = 0;
i = 0;
while (i < 50) {
	scanf_s("%d", &t);
	s = s + t;
	if (t >= 0)
		g = g + 1;
	else
		z = z + 1;
	i = i + 1;
}