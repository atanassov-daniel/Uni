% a)
prime(N) :- N > 1, factors(N, Factors), isPrime(N, Factors).

isPrime(El, [1, El]).

factors(X, Y) :- factorsHelp(X, 1, Y).

factorsHelp(X, X, [X]).
factorsHelp(X, N, [N|Res]) :- N < X, 0 is X mod N, SN is N + 1, factorsHelp(X, SN, Res). 
factorsHelp(X, N, Res) :- N < X, A is X mod N, A > 0, SN is N + 1, factorsHelp(X, SN, Res).

% b)
only_primes([X]) :- prime(X).
only_primes([X | XS]) :- prime(X), only_primes(XS).