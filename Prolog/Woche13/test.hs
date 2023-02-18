{- f :: Bool -> [Bool -> Bool] -> [Bool]
f w (x:y:_) | x w = [x w]
            |y w = [w, w] -}

-- i :: [Int]
i = take 4 (let x = 1 : map (+2) x in x)

f x = \a -> if a True then x else [False]