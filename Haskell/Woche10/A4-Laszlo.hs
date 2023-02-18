pow :: Int -> Int -> Int
pow a 0
 | a==0      = error "undefined"
 | otherwise = 1
pow a 1 = a
pow a b
 | b>0       = a * (pow a (b-1))
 | otherwise = error "Second argument must be positive"

isDiv :: Int -> Int -> Bool
isDiv 0 b = True
isDiv a 0 = False
isDiv a b
 | remains a b == 0 = True
 | otherwise        = False

remains :: Int -> Int -> Int
remains a b
 | (absolute a)>=(absolute b) = remains (absolute(a-b)) (absolute b)
 | otherwise = a
 
absolute :: Int -> Int
absolute a
 | a>=0 = a
 | otherwise = (-a)
 
sumUp :: [Int] -> Int
sumUp [] = 0
sumUp (x:xs) = x + (sumUp xs)

multLists :: [Int] -> [Int] -> [Int]
multLists [] ys = []
multLists xs [] = []
multLists (x:xs) (y:ys) = [x*y]++ (multLists xs ys)

isEven :: Int -> Bool
isEven 0 = True
isEven n = isOdd (absolute (n-1))

isOdd :: Int -> Bool
isOdd 0 = False
isOdd n = isEven (absolute (n-1))

binRep :: Int -> (Int,[Int])
binRep n = ((sign n),(binList (absolute n)))

sign :: Int -> Int
sign 0 = 0
sign a
 | a>0 = 1
 | otherwise = -1

binList :: Int -> [Int]
binList 0 = [0]
binList 1 = [1]
binList n = binList (div n 2)++[rem n 2]
