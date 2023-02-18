% a)
userDefinedList(nil).
userDefinedList(cons) :- false.
userDefinedList(cons(_, XS)) :- userDefinedList(XS).

% b)
asPrologList([X | XS], Y) :- userDefinedList(Y), areEqual([X | XS], Y).

areEqual([], nil).
areEqual([X | XS], cons(X, YS)) :- areEqual(XS, YS).

% c)
maximum(X, 0, X).
maximum(0, Y, Y).
maximum(s(X), s(Y), s(Z)) :- maximum(X, Y, Z).
/*//TODO
?- maximum(s(0), 0, s(0)).
true ;
false.
*/

maximumList([], _) :- false.
maximumList([X], X).
maximumList([X, Y | XS], Z) :- maximum(X, Y, MAXXY), maximumList([MAXXY | XS], Z).
/* //TODO
?- maximumList([s(0),s(s(0)),s(0),0,s(s(s(0)))], s(s(s(0)))).
true ;
false.
*/

% d)
remove([X], X, []).
remove([X | XS], X, XS).
remove([X | XS], Y, [X | YS]) :- remove(XS, Y, YS).

% e)
sortList([], []). 
sortList([X], [X]). 
sortList(XS, [MaxXS | Res]) :- maximumList(XS, MaxXS), remove(XS, MaxXS, YS), sortList(YS, Res). 

/* isZermelo([]).
isZermelo([[]]).
isZermelo([[X], Y]) :- isZermelo(X), isZermelo(Y). */
%//TODO f) funktioniert nur mit bis zu 2 = [[[]], []]
isZermelo([]).
isZermelo([[]]).
isZermelo([[X] | [XS]]) :- isZermelo([X]), isZermelo([XS]).
isZermelo([[X] | XS]) :- isZermelo([X]), isZermelo(XS).

%//TODO g) funktioniert nur mit bis zu 2 = [[[]], []]
numberChange([], 0).
numberChange([X], s(Y)) :- isZermelo([X]), numberChange(X, Y).
numberChange([X | XS], s(Y)) :- isZermelo([X]), numberChange(X, Y), numberChange(XS, Y).
%//TODO h) 
zermeloPlus([], [], []).
zermeloPlus([], [[]], [[]]).
zermeloPlus([[]], [], [[]]).
zermeloPlus([X], [Y], YS) :- isZermelo([X]), isZermelo([Y]).


%//TODO i) 
/* flattenConsecutive([[]], [[]]).
flattenConsecutive([[X | XS] | YS], [X, XS | ZS]) :- flattenConsecutive(YS, ZS). */

% j)
% Der Funktionssymbol leaf(Wert) stellt ein Blatt von dem Baum dar, der den Wert in sich speichert. Der Funktionssymbol node(wert, [X | XS]) stellt ein Node des Mehrwegbaums dar, der den Wert wert in sich speichert und beliebig viele Kinder hat, die in der Liste im zweiten Argument gespeichert werden
leaf(Wert).
node(Wert, [X | XS]).


append([], YS, YS).
append([X|XS], YS, [X|RS]) :- append(XS, YS, RS).

flattenConsecutiveTree(leaf([X | XS]), [X | XS]).
flattenConsecutiveTree(node([X | XS], [Ch1 | CHs]), YS) :- flattenConsecutiveTree(Ch1, Res), append([X | XS], Res, Res1), flattenConsecutiveTree(node([X | XS], CHs), Res2), append(Res1, Res2, YS).