% a)
formel(true).
formel(false).
formel(and(S1, S2)) :- formel(S1), formel(S2).
formel(or(S1, S2)) :- formel(S1), formel(S2).

% b)
istWahr(true).
istWahr(false) :- false.
istWahr(and(S1, S2)) :- formel(and(S1, S2)), istWahr(S1), istWahr(S2).
istWahr(or(S1, S2)) :- formel(or(S1, S2)), istWahr(S1); istWahr(S2).
/* TODO check this:
?- istWahr(and(true,or(true,false))).
true ;
false.
*/
% c)
benutzt(and(A, S2), A) :- formel(and(A, S2)), formel(A).
benutzt(and(S1, A), A) :- formel(and(S1, A)), formel(A).
benutzt(or(A, S2), A) :- formel(or(A, S2)), formel(A).
benutzt(or(S1, A), A) :- formel(or(S1, A)), formel(A).

% d)
teilformel(F, A) :- benutzt(F, A).
teilformel(F, A) :- benutzt(F, Y), teilformel(Y, A).
beinhaltet(FORMULA, A) :- formel(FORMULA), formel(A), teilformel(FORMULA, A).

% e) ?- formel(and(X,Y)).