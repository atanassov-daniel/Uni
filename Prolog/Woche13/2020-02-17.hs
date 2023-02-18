removeLast [] = []
removeLast [x] = []
removeLast (x : xs) = [x] ++ (removeLast xs)
