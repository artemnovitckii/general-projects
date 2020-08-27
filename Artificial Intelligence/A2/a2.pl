last(X,[X]).
last(X,[_|Z]) :- last(X,Z).



solution([Start], RoadNetwork, Cost, Path) :-
    length(RoadNetwork, Len),
    
    (Len = 1,
        Cost is 0,
        append([Start],[Start],Path),
        member((Start,[]),RoadNetwork)
    );
    
    (
    	findall((CompletePath, Cost), recursive_call(Start,RoadNetwork, 0, Cost, [Start], CompletePath), Paths),
        member((P, C),Paths),
        valid_end(Start, RoadNetwork, P, C, Path, Cost)
    ).


valid_end(StartCity, RoadNetwork, Path, Cost, FinalPath, FinalCost) :-
    last(LastCity, Path),
    member((LastCity,AdjCities),RoadNetwork),
	member((StartCity,LastCost), AdjCities),
    append(Path,[StartCity],FinalPath),
   	FinalCost is Cost + LastCost.

	
    

recursive_call(City, RoadNetwork, CurrentCost, TotalCost, Path, FinalPath) :-
    
    (
    	length(RoadNetwork, L),
		length(Path, L),
		FinalPath = Path,
        TotalCost is CurrentCost

	);
	
	(
		member((City,AdjCities),RoadNetwork),
		member((AdjCity,AdjCost), AdjCities),
		not(member(AdjCity,Path)),
		NewCost is AdjCost + CurrentCost,
		append(Path, [AdjCity], NewPath),
		recursive_call(AdjCity,RoadNetwork, NewCost,TotalCost, NewPath, FinalPath)
    ).
    
        
   





    
    

    

   
	



