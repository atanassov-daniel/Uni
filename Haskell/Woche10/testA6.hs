-- 1.
{- f :: Num t => t -> (t -> Bool) -> (t -> Bool) -> t
f x y z = if y x then x else 0
f x y z = f x z y -}
zero :: Int
zero = 0
f :: Int -> (Int -> Bool) -> (Int -> Bool) -> Int
f x y z = if y x then x else zero
f x y z = f x z y

-- 2.
g = g -- g :: t
h :: p -> [a]
h _ = []
h _ = g
h _ = g g

-- 3.
{- i :: Num a => [p -> a] -> ((p -> a) -> p -> a) -> t
i [] y = i ((\_ -> 0):[]) y
i (x:xs) y = i (y x:xs) y -}
i :: [p -> Int] -> ((p -> Int) -> p -> Int) -> t
i [] y = i ((\_ -> zero):[]) y
i (x:xs) y = i (y x:xs) y

-- 4.
j :: [a] -> a -> [a] -> [[a]]
j x y z = [y:z]
j (x:xs) y z = (\(x:xs) -> [y:xs]) xs

-- 5.
l :: (t1 -> t2) -> (t3 -> t1) -> t3 -> t2
l f g = \x -> f (g x)
m :: (t1 -> t2) -> (t4 -> t5 -> t1) -> t4 -> t5 -> t2
m = l l l