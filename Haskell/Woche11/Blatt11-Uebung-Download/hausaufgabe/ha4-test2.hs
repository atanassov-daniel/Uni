-- a)
data MultTree a = Daten a | Index a a [MultTree a] deriving (Show)

t1Child1 :: MultTree Int
t1Child1 = Index 3 15 [Daten 3, Daten 11, Daten 12]

t1Child2 :: MultTree Int
t1Child2 = Index 19 42 [Daten 42, Daten 23]

t1 :: MultTree Int
t1 = Index 3 42 [t1Child1, t1Child2]

-- b)
verzweigungsgrad :: MultTree a -> Int
verzweigungsgrad (Daten x) = 0 -- verzweigungsgrad = 0 falls Datenknoten, denn sie haben keine Nachfolger
-- verzweigungsgrad gibt die maximale Anzahl an Nachfolger, die ein einzelnes Knoten hat. verzweigungsgrad ist gleich das Maximum von [a,b], wobei a=Anzahl der Nachfolger vom Wurzel-Knoten, b=die Laenge des laengsten Teilbaums beginnend von dem Wurzel-Knoten. Wenn a > b ist, dann has ist das Wurzel-Knoten das Knoten mit den meisten Nachfolger.
verzweigungsgrad (Index x y arr) = max (length arr) (maxi (map verzweigungsgrad arr))

maxi :: [Int] -> Int
maxi [] = 0
maxi [x] = x
maxi (x : y : xs) = max largerEl maxVomRest
  where
    largerEl = max x y
    maxVomRest = maxi xs

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

-- * (map (contains wert) xs) ist ein Array, woebei jedes Bool/Wert zeigt, ob das jeweilige Child-Teilbaum vom Indexknoten den gesuchten Wert enthaelt.

-- * (filter (\x -> x == True) (map (contains wert) xs)) filtert dann nur die Teilbaume raus, die den gesuchten Wert enthalten. Wenn es keine solchen gibt hat das Array length 0 und es soll False returned werden, sonst True