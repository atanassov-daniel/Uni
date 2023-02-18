-- a)
pow :: Int -> Int -> Int
pow a 0 = 1
pow a 1 = a
pow a b = a * pow a (b - 1)

-- b)
isDiv :: Int -> Int -> Bool
isDiv 0 b = True
isDiv a 0 = False
isDiv a b = divide a b == 0

divide :: Int -> Int -> Int
divide a b
  | a >= b = if aMinusB < b then aMinusB else divide aMinusB b
  | otherwise = a
  where
    aMinusB = a - b

-- c)
sumUp :: [Int] -> Int
sumUp [] = 0
sumUp [x] = x
sumUp (x : xs) = x + sumUp xs

-- d)
multLists :: [Int] -> [Int] -> [Int]
multLists [] ys = []
multLists xs [] = []
multLists [x] (y : ys) = [x * y]
multLists (x : xs) [y] = [x * y]
multLists (x : xs) (y : ys) = (x * y) : multLists xs ys

-- e)
isEven :: Int -> Bool
isEven 0 = True
isEven 1 = False
isEven n = isOdd (n - 1)

isOdd :: Int -> Bool
isOdd 0 = False
isOdd 1 = True
isOdd n = isEven (n - 1)

-- f)
binRep :: Int -> (Int, [Int])
binRep n = (e, xs)
  where
    e
      | n == 0 = 0
      | n > 0 = 1
      | n < 0 = -1
    xs
      | n < 0 = intToBinaryList (-n)
      | otherwise = intToBinaryList n

intToBinaryList :: Int -> [Int]
intToBinaryList 0 = [0]
intToBinaryList 1 = [1]
intToBinaryList n = if div n 2 == 0 then [rem n 2] else intToBinaryList (div n 2) ++ [rem n 2]