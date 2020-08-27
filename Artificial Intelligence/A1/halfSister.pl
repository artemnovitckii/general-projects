
halfSisterOf(HalfSister,Person) :- 
parentOf(X,Person), 
parentOf(Y,Person), 
parentOf(Y,HalfSister), 
parentOf(Z,HalfSister),
Y=Y,
not(parentOf(X,HalfSister)),
not(parentOf(Z,Person)),
female(HalfSister),
not(X=Z).
