-- a)
fib :: Int -> Int
fib 0 = 0
fib 1 = 1
fib n = fib (n-2) + fib (n-1)

-- b)
prime :: Int -> Bool
prime 1 = True
prime n = isPrime n (n-1)

isPrime :: Int -> Int -> Bool
isPrime x 1 = True
isPrime x y = if rem x y == 0 then False else isPrime x (y-1)

-- c)
powersOfTwo :: Int -> Int -> [Int]
powersOfTwo i0 i1 = if i0 > i1 then [] else 2^i0 : powersOfTwo (i0+1) i1

-- d) Hier darf ich eigentlich True und False nach Aufgabenstellung nicht benutzen
intersection :: [Int] -> [Int] -> [Int]
intersection [] _ = []
intersection _ [] = []
intersection (x:xs) ys = if hasEqualInOtherArray x ys then (x: intersection xs ys) else intersection xs ys
-- Hilfsfunktion fuer d)
hasEqualInOtherArray :: Int -> [Int] -> Bool
hasEqualInOtherArray _ [] = False
hasEqualInOtherArray x (y:[]) = if x == y then True else False
hasEqualInOtherArray x (y:ys) = if x == y then True else hasEqualInOtherArray x ys

{- 
-- e)
selectKsmallest :: [Int] -> Int
selectKsmallest k xs

-- Hilfsfunktion fuer e)
sortiereAufsteigend :: [Int] -> [Int]
sortiereAufsteigend [] = []
sortiereAufsteigend x:[] = [x]
sortiereAufsteigend x:y:xs = 
-}