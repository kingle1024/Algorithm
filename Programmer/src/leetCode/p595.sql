SELECT w.name, w.population, w.area
FROM World w
WHERE 1=1
   AND w.population > 25000000
   OR w.area > 3000000;