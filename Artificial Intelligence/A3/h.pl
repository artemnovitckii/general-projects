%% h/3 the zero heuristic
%% h/3 the zero heuristic

h(State, RoadNetwork, Hvalue) :-
    %State  = (CurrentCity,UnvisitedCities),
    state_stillToVisitCitySet(State, UnvisitedCities),
    getMinValues(RoadNetwork, UnvisitedCities, [],Value),
    sumlist(Value, Hvalue).
    %%findall(Value,sumlist(SumList,Value), Hvalue).
    %%min_list(SumList, Hvalue).

getMinValues(RoadNetwork, [H|T], CitiesListOfMinValues,FinalList) :-
    processRoadNetwork(RoadNetwork,H,[], FinalEdgeCostList),
    sort(FinalEdgeCostList,FinalEdgeCostListSorted),
    FinalEdgeCostListSorted = [MinCost|_],
    getMinValues(RoadNetwork,T,[MinCost|CitiesListOfMinValues],FinalList).
    
getMinValues(RoadNetwork, [], CitiesListOfMinValues, FinalList) :-
    FinalList = CitiesListOfMinValues.

processRoadNetwork([H|T],City,EdgeCostList, FinalEdgeCostList):-
    H = (_, AdjCities),
    (   (   
    
    member((City,Cost),AdjCities),
    processRoadNetwork(T,City,[Cost|EdgeCostList], FinalEdgeCostList)
    );
    (
    not(member((City,Cost),AdjCities)),
    processRoadNetwork(T,City,EdgeCostList, FinalEdgeCostList)
    )).

processRoadNetwork([],_,EdgeCostList, FinalEdgeCostList):-
    FinalEdgeCostList = EdgeCostList.

