{- drop_mult :: Int -> [Int] -> [Int]
drop_mult x xs = filter (\y -> mod x 2 == 0) xs

dropall :: [Int] -> [Int]
dropall (x:xs) = x : dropall (drop_mult x xs)
 -}
evenlist :: [Int]
evenlist = filter (\x -> mod x 2 == 0) (from 0)

from :: Int -> [Int]
from x = x : from (x+1)


