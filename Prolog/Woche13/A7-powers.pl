powers(Num, Power, Res) :- Num > 0, Power > 0, toPowersList(Num, Power, Res).

toPower(Num, 1, Num).
toPower(Num, Pow, Res) :- Pow > 1, Res1 is Num, Pow1 is Pow - 1, toPower(Num, Pow1, Res2), Res is Res1 * Res2.

toPowersList(Num, 1, [Num]).
toPowersList(Num, Pow, [X | XS]) :- toPower(Num, Pow, X), Pow1 is Pow - 1, Pow1 > 0, toPowersList(Num, Pow1, XS).