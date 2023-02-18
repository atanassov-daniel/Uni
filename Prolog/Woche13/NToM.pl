fromNToM(M,M,[M]).
fromNToM(N,M,[N|XS]) :- M >= N, Nplus is N + 1, fromNToM(Nplus, M, XS).