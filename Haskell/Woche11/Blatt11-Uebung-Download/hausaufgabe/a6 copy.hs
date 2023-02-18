data Tree a = Node a [Tree a] | Nil deriving Show

testTree :: Tree Int
testTree =
  Node 2
    [ 
      Nil,
      Node 3
        [ 
          Node 9 [],
          Node 5 [],
          Node 10 [Node 0 []]
        ],
      Node 1
        [ 
          Node 5 [],
          Nil
        ]
    ]

-- a)
mapTree :: (a -> b) -> Tree a -> Tree b
mapTree f Nil = Nil
mapTree f (Node v []) = Node (f v) []
mapTree f (Node v [child]) = Node (f v) [mapTree f child]
mapTree f (Node v xs) = Node (f v) (map (mapTree f) xs)

-- TODO -- b)
{- mapTreeWithPath :: ([a] -> a -> b) -> Tree a -> Tree b
mapTreeWithPath f Nil = Nil
mapTreeWithPath f (Node v []) = Node (f [] v) []
-- mapTreeWithPath f (Node v [child]) = Node (f [] v) [mapTreeWithPath f child]
mapTreeWithPath f (Node v xs) = Node (f [] v) (map (mapTree (f [v])) xs) -}

-- c)
filterTree :: (a -> Bool) -> Tree a -> Tree a
filterTree f Nil = Nil
filterTree f (Node v [])
  | not (f v) = Nil
  | otherwise = Node v []
filterTree f (Node v xs)
  | not (f v) = Nil
  | otherwise = Node v (map (filterTree f) xs)

-- d)
foldTree :: (a -> [b] -> b) -> b -> Tree a -> b
foldTree f c Nil = c
foldTree f c (Node v xs) = f v (map (foldTree f c) xs)

-- e)
toOnes :: Tree a -> Tree Int
toOnes Nil = Nil
-- toOnes (Node v xs) = Node 1 (map (mapTree (\x -> 1)) xs)
toOnes tree = mapTree (\x -> 1) tree
-- TODO!! Test this function with the result of -- mapTreeWithPath (\v path -> (length path, path, v)) testTree

-- f)
numNodes :: Tree a -> Int
numNodes tree = foldTree (\c xs -> c + sum xs) 0 (toOnes tree)