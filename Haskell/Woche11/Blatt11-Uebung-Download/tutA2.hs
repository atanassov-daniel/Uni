data Mobile a = Stern | Seepferdchen | Elefant (Mobile a) | Kanguru a (Mobile a) (Mobile a) deriving Show

mobileLinks :: Mobile Int
mobileLinks = Kanguru 1 (Elefant (Kanguru 2 Stern (Kanguru 3 Seepferdchen Stern))) Seepferdchen

mobileRechts :: Mobile Int
mobileRechts = Elefant (Kanguru 1 (Elefant Stern) (Elefant Seepferdchen))

count :: Mobile a -> Int
count (Elefant child) = 1 + count child
count (Kanguru wert child1 child2) = 1 + count child1 + count child2
count _ = 1

liste :: Mobile a -> [a]
liste (Kanguru wert child1 child2) = [wert] ++ liste child1 ++ liste child2
liste (Elefant child) = liste child
liste _ = []

greife :: Mobile a -> Int -> Mobile a
greife mobile 1 = mobile
greife (Elefant child) n
  | n < 1 || n > count (Elefant child) = error "Invalider Index"
  | otherwise = greife child (n-1)
greife (Kanguru wert child1 child2) n
  | n < 1 || n > count (Kanguru wert child1 child2) = error "Invalider Index"
  | otherwise = --TODO
greife _ _ = error "Invalider Index"

{- greife mobile n
  | n < 1 || n > count mobile = error "Invalider Index"
  | otherwise = mobile -}
