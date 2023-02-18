% a)
blau(sonnalm).
blau(vorkogel).
blau(arbiskogel).
blau(plattenalm).
blau(wiesenalm).
rot(isskogel).
schwarz(teufeltal).

start(sonnalm).
start(teufeltal).

endetIn(sonnalm,vorkogel).
endetIn(sonnalm,arbiskogel).
endetIn(arbiskogel, plattenalm).
endetIn(plattenalm, wiesenalm).
endetIn(teufeltal, wiesenalm).
endetIn(vorkogel,isskogel).
endetIn(wiesenalm, tal).
endetIn(isskogel, tal).

% b)
endetIn(X,wiesenalm).

% c)
gleicherStartpunkt(X,Y) :- start(X), start(Y).
gleicherStartpunkt(X,Y) :- endetIn(Z, X), endetIn(Z, Y).