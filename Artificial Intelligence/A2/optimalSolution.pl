/* optimalSolution(+StartCity, +RoadNetwork, -OptimalCost, -Solution) 

return the optimal solution cost and path
*/

optimalSolution(StartCity, RoadNetwork, OptimalCost, SolutionPath) :-
    findall(solution(Cost, Path), solution([StartCity], RoadNetwork, Cost, Path), Solutions),
    sort(Solutions, SortedSolutions),
    SortedSolutions = [solution(OptimalCost, SolutionPath) | _].
