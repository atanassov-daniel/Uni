-- a) 
f :: [[a]] -> [a] -> t -> t
f [] x y = y 
f [z:zs] x y = f [] (z:x) y

-- b) 

{- one :: Int
one = 1

g :: Num t => t -> t -> t
g x one = one
g x y = (\x -> (g x 0)) y -}

g :: (Eq t, Num t, Num a) => t -> t -> a
g x 1 = 1
g x y = (\x -> (g x 0)) y

-- c)
h (x:xs) y z = if x then h xs x (y:z) else h xs y z

-- d)
i x y z = x z y
j x = x
k = i j