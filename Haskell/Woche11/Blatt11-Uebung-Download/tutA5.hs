data List a = Nil | Cons a (List a) deriving Show

list :: List Int
list = Cons (-3) (Cons 14 (Cons (-6) (Cons 7 (Cons 1 Nil))))

blist :: List Int
blist = Cons 1 (Cons 1 (Cons 0 (Cons 0 Nil)))

filterList :: (a -> Bool) -> List a -> List a
filterList g Nil = Nil
filterList g (Cons x xs)
  | g x = Cons x (filterList g xs)
  | otherwise = filterList g xs

divisibleBy :: Int -> List Int -> List Int
divisibleBy x Nil = Nil
divisibleBy x (Cons y ys)
  | mod y x == 0 = Cons y (divisibleBy x ys)
  | otherwise = divisibleBy x ys

foldList :: (a -> b -> b) -> b -> List a -> b
-- foldList f c Nil = minBound
foldList f c (Cons x Nil) = f x c
foldList f c (Cons x xs) = f x (foldList f c xs)

--TODO d)
listMaximum :: List Int -> Int
listMaximum Nil = error "Geben Sie eine nicht-leere Liste an"

--TODO e)
-- mapList :: (a -> b) -> List a -> List b
-- mapList f xs = foldList filterList x xs

-- f)
zipLists :: (a -> b -> c) -> List a -> List b -> List c
zipLists f (Cons x Nil) (Cons y ys) = Cons (f x y) Nil
zipLists f (Cons x xs) (Cons y Nil) = Cons (f x y) Nil
zipLists f (Cons x xs) (Cons y ys) = Cons (f x y) (zipLists f xs ys)

-- g)
skalarprodukt :: List Int -> List Int -> Int
skalarprodukt xs ys = foldList (+) 0 sum
  where
    sum = zipLists (*) xs ys