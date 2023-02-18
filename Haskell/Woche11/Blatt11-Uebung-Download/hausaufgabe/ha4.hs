-- a)
data MultTree a = Daten a | Index a a [MultTree a] deriving Show

t1Child1 :: MultTree Int
t1Child1 = Index 3 15 [Daten 3, Daten 11, Daten 12]
t1Child2 :: MultTree Int
t1Child2 = Index 19 42 [Daten 42, Daten 23]
t1 :: MultTree Int
t1 = Index 3 42 [t1Child1, t1Child2]

-- b)
verzweigungsgrad :: MultTree a -> Int
verzweigungsgrad (Daten _) = 0
verzweigungsgrad (Index _ _ []) = 0
verzweigungsgrad (Index _ _ xs) = findMax (length xs : map verzweigungsgrad xs)

findMax :: [Int] -> Int
findMax [] = 0
findMax [x] = x
findMax (x : y : xs) = max (max x y) (findMax xs)

-- c)
datenListe :: MultTree a -> [a]
datenListe (Daten x) = [x]
datenListe (Index _ _ []) = []
datenListe (Index _ _ [x]) = datenListe x
datenListe (Index _ _ xs) = joinDatenArrays (map datenListe xs)

joinDatenArrays :: [[a]] -> [a]
joinDatenArrays [x] = x
joinDatenArrays [x, y] = x ++ y
joinDatenArrays (x : y : xs) = x ++ y ++ joinDatenArrays xs

-- d)
contains :: Int -> MultTree Int -> Bool
contains wert (Daten x) = x == wert
contains wert (Index x y []) = x == wert || y == wert
contains wert (Index x y xs) = x == wert || y == wert || containedInTeilbaum
  where
    containedInTeilbaum
      | not (wert >= x && wert <= y) = False
      | otherwise = length (filter (\x -> x == True) (map (contains wert) xs)) > 0
-- *(map (contains wert) xs) ist ein Array, wobei jedes Bool/Wert zeigt, ob das jeweilige Child-Teilbaum vom Indexknoten den gesuchten Wert enthaelt.
-- *(filter (\x -> x == True) (map (contains wert) xs)) filtert dann nur die Teilbaueme raus, die den gesuchten Wert enthalten. Wenn es keine solchen gibt, dann hat das Array length 0 und es soll False returned werden, sonst True.