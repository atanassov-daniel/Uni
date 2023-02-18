-- von Aufgabe 6
data Tree a = Node a [Tree a] | Nil deriving Show

mapTreeWithPath :: ([a] -> a -> b) -> Tree a -> Tree b
mapTreeWithPath f = go []
  where
    go _ Nil = Nil
    go path (Node a ts) = Node (f path a) (map (go (a : path)) ts)

filterTree :: (a -> Bool) -> Tree a -> Tree a
filterTree _ Nil = Nil
filterTree p (Node a ts)
  | p a = Node a (map (filterTree p) ts)
  | otherwise = Nil

-- 8
data Bank = Here | There deriving (Show)

data River = R Bank Bank Bank Bank deriving (Show)
              -- p    c    g    w

sameBank :: Bank -> Bank -> Bool
sameBank Here Here = True
sameBank There There = True
sameBank _ _ = False

otherBank :: Bank -> Bank
otherBank Here = There
otherBank There = Here

moveCabbage :: River -> Maybe River
moveCabbage (R p c g w)
  | p `sameBank` c && not (g `sameBank` Here && w `sameBank` Here) =
      Just (R (otherBank p) (otherBank c) g w)
  | otherwise = Nothing

moveGoat :: River -> Maybe River
moveGoat (R p c g w)
  | p `sameBank` g =
      Just (R (otherBank p) c (otherBank g) w)
  | otherwise = Nothing

moveWolf :: River -> Maybe River
moveWolf (R p c g w)
  | p `sameBank` w && not (c `sameBank` Here && g `sameBank` Here) =
      Just (R (otherBank p) c g (otherBank w))
  | otherwise = Nothing

moveEmpty :: River -> Maybe River
moveEmpty (R p c g w)
  | not (p `sameBank` c && p `sameBank` g || p `sameBank` g && p `sameBank` w) =
      Just (R (otherBank p) c g w)
  | otherwise = Nothing

truncateAtLevel :: Int -> Tree a -> Tree a
truncateAtLevel i =
  mapTreeWithPath (const snd) . filterTree (\(j, _) -> j <= i) . mapTreeWithPath (\as a -> (length as, a))

allNodes :: Tree a -> [a]
allNodes Nil = []
allNodes (Node a ts) = a : go ts
  where
    isNode Nil = False
    isNode _ = True
    go ts =
      let nodes = filter isNode ts
       in map (\(Node a _) -> a) nodes ++ go (concatMap (\(Node _ ts) -> ts) nodes)

allSolutions :: Tree River -> [[River]]
allSolutions =
  map reverse . filter (\(a : _) -> isFinalState a) . allNodes . mapTreeWithPath (\p a -> a : p)
  where
    isFinalState (R There There There There) = True
    isFinalState _ = False

-- Bisher stehen die Sachen, die bereits in der Moodle-Datei enthalten waren, ab hier beginnen unsere Implementierungen fuer die Teilaufgaben von der Aufgabenstellung
-- a)
allPossMoves :: River -> [River]
allPossMoves r = arrPoss
  where
    c = moveCabbage r
    g = moveGoat r
    w = moveWolf r
    e = moveEmpty r
    arrMaybeRiversNoNothings = filter (\x -> not (isNothing x)) [c, g, w, e]
    arrPoss = map (\(Just x) -> x) arrMaybeRiversNoNothings

isNothing :: Maybe a -> Bool
isNothing Nothing = True
isNothing _ = False

-- b)
-- i)
buildTree :: (a -> [a]) -> a -> Tree a
buildTree f r = Node r (map (\x -> buildTree f x) (f r))

-- ii)
nats :: Tree Int
nats = buildTree (\i -> [2 * i + 1, 2 * i + 2]) 0

-- iii)
riverTree :: Tree River
riverTree = buildTree allPossMoves anfang
  where anfang = R Here Here Here Here