-- a)
fibInit :: Int -> Int -> Int -> Int
fibInit a0 a1 0 = a0
fibInit a0 a1 1 = a1
fibInit a0 a1 n = fibInit a0 a1 (n-2) + fibInit a0 a1 (n-1)

-- b)
fibInitL :: Int -> Int -> Int -> [Int]
fibInitL a0 a1 (-1) = []
fibInit a0 a1 0 = [a0]
fibInit a0 a1 1 = [a0, a1]
fibInitL a0 a1 n = fibInit a0 a1 n

-- fibInit2 :: Int -> Int -> Int -> Int
