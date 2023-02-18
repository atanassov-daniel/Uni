split([],[],[]).
split([X], [X],[]).
% split([X,Y], [X], [Y]).
split([X,Y | Rest], [X|XS], [Y|YS]) :- split(Rest, XS, YS).

leq(0, 0).
leq(0,s(_)).
leq(s(_), 0) :- false.
leq(s(X), s(Y)) :- leq(X,Y).

merge([],YS,YS).
merge(XS,[],XS).
% merge([X],[Y],[X, Y]) :- leq(X,Y).
merge([X|XS], [Y|YS], [X, Y | ZS]) :- leq(X,Y), merge(XS, YS, ZS).
merge([X|XS], [Y|YS], [Y, X | ZS]) :- leq(Y,X), merge(XS, YS, ZS).