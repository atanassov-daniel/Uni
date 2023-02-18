data Cell = C Cell Cell | N deriving Show

data Movement = R | D

c1 :: Cell
c1 = C (C (C N N) N) N

c2 :: Cell
c2 = C (C N c3) (C c3 N) where c3 = C N N

c4 :: Cell
c4 = C (C N (C N N)) (C N N)

move c [] = c
move N (x : xs) = N
move (C c1 c2) (D : xs) = move c1 xs
move (C c1 c2) (R : xs) = move c2 xs

