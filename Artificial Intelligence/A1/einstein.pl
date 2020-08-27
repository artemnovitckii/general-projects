:- use_module(library(lists)).  %% to load permutation/2

persons(persons(Nationality, HouseColor, Smoke, Drink, Pet, HouseNumber),Nationality,HouseColor, Smoke, Drink, Pet, HouseNumber).


persons_Nationality(persons(Nationality,_HouseColor,_Smoke,_Drink,_Pet,_HouseNumber),Nationality).

persons_HouseColor(persons(_Nationality,HouseColor,_Smoke,_Drink,_Pet,_HouseNumber),HouseColor).

persons_Smoke(persons(_Nationality,_HouseColor,Smoke,_Drink,_Pet,_HouseNumber),Smoke).

persons_Drink(persons(_Nationality,_HouseColor,_Smoke,Drink,_Pet, _HouseNumber),Drink).

persons_Pet(persons(_Nationality,_HouseColor,_Smoke,_Drink,Pet,_HouseNumber),Pet).

persons_HouseNumber(persons(_Nationality,_HouseColor,_Smoke,_Drink,_Pet,HouseNumber),HouseNumber).

nationality([norwegian, brit, german, sweede, dane]).
houseColor([yellow,blue,red,green,white]).
smoke([dunhill, blends, pallMall, prince, blueMaster]).
drink([water, tea, milk, coffee, beer]).
pet([cats, horses, birds, fish, dogs]).
houseNumber([1,2,3,4,5]).

ownerOfFish(Solution, X) :- 
    member(persons(X, _, _, _, fish, _), Solution),
    nationality(Y),
    member(X, Y).


solve(Solution) :-

Solution = [Norwegian, Brit, German, Sweede, Dane],

persons(Norwegian, norwegian, NorwegianHouseColor, NorwegianSmoke, NorwegianDrink, NorwegianPet, NorwegianHouseNumber),

persons(Brit, brit, BritHouseColor, BritSmoke,BritDrink, BritPet, BritHouseNumber),

persons(German, german, GermanHouseColor, GermanSmoke, GermanDrink, GermanPet, GermanHouseNumber),

persons(Sweede, sweede, SweedeHouseColor, SweedeSmoke, SweedeDrink, SweedePet,SweedeHouseNumber),

persons(Dane, dane, DaneHouseColor, DaneSmoke, DaneDrink, DanePet, DaneHouseNumber),

houseColor(HouseColor),
smoke(Smoke),
drink(Drink),
pet(Pet),
houseNumber(HouseNumber),
    
    

    
%% #1 the Brit lives in the red house
persons_Nationality(Brit,brit),
member(Brit,Solution),
persons_HouseColor(Brit,red),                                                                                                                                                                                                                                                                                                                                                                                                            
%% #2 the Swede keeps dogs as pets.
persons_Pet(Sweede, dogs),

%% #3 the Dane drinks tea.
persons_Drink(Dane,tea),

    
%% #4 the green house is on the left of the white house.
persons_HouseColor(Green,green),
member(Green,Solution),
persons_HouseNumber(Green,GreenHouseNumber),
member(GreenHouseNumber, HouseNumber),

persons_HouseColor(White,white),
member(White,Solution),
persons_HouseNumber(White,WhiteHouseNumber),


WhiteHouseNumber is GreenHouseNumber + 1,
member(WhiteHouseNumber,HouseNumber),


%% #5 the green house’s owner drinks coffee.
persons_HouseColor(Green,green),
member(Green,Solution),
persons_Drink(Green, coffee),


%% #6 The owner who smokes Pall Mall rears birds.
persons_Smoke(PallMall,pallMall),
member(PallMall,Solution),
persons_Pet(PallMall,birds),



%% #7 The owner of the yellow house smokes Dunhill.
persons_HouseColor(Yellow,yellow),
member(Yellow,Solution),
persons_Smoke(Yellow,dunhill),

%% #8 The owner living in the center house drinks milk.
persons_Drink(Milk,milk),
member(Milk,Solution),
persons_HouseNumber(Milk,3),

%% #9 The Norwegian lives in the first house.
persons_HouseNumber(Norwegian,1),

%% #10 The owner who smokes Blends lives next to the one who keeps cats.
persons_Smoke(Blends, blends),
member(Blends,Solution),
persons_HouseNumber(Blends, BlendsHouseNumber),

    
persons_Pet(Cats,cats),
member(Cats,Solution),
persons_HouseNumber(Cats,CatsHouseNumber),
member(CatsHouseNumber,HouseNumber),
    
(BlendsHouseNumber is CatsHouseNumber + 1;BlendsHouseNumber is CatsHouseNumber - 1),
member(BlendsHouseNumber, HouseNumber),

%% #11 The owner who keeps the horse lives next to the one who smokes Dunhill.
persons_Smoke(Dunhill,dunhill),
member(Dunhill,Solution),
persons_HouseNumber(Dunhill,DunhillHouseNumber),
member(DunhillHouseNumber, HouseNumber),
    
persons_Pet(Horses,horses),
member(Horses,Solution),
persons_HouseNumber(Horses,HorsesHouseNumber),

(HorsesHouseNumber is DunhillHouseNumber + 1;HorsesHouseNumber is DunhillHouseNumber - 1),
member(HorsesHouseNumber, HouseNumber),

%% #12 The owner who smokes Bluemasters drinks beer.
persons_Smoke(Bluemasters, blueMaster),
member(Bluemasters,Solution),
persons_Drink(Bluemasters,beer),

%% #13 The German smokes Prince.
persons_Nationality(German,german),
member(German,Solution),
persons_Smoke(German,prince),

%% #14 The Norwegian lives next to the blue house.
persons_HouseColor(Blue,blue),
member(Blue,Solution),
persons_HouseNumber(Blue,BlueHouseNumber),
    
persons_Nationality(Norwegian,norwegian),
member(Norwegian,Solution),
persons_HouseNumber(Norwegian, NorwegianHouseNumber),
member(NorwegianHouseNumber, HouseNumber),
    
(BlueHouseNumber is NorwegianHouseNumber + 1;BlueHouseNumber is NorwegianHouseNumber - 1),
member(BlueHouseNumber, HouseNumber),


%% #15 The owner who smokes Blends lives next to the one who drinks water
persons_Smoke(Blends,blends),
member(Blends,Solution),
persons_HouseNumber(Blends,BlendsHouseNumber),

persons_Drink(Water,water),
member(Water,Solution),
persons_HouseNumber(Water,WaterHouseNumber),
member(WaterHouseNumber, HouseNumber),

(BlendsHouseNumber is WaterHouseNumber + 1;BlendsHouseNumber is WaterHouseNumber - 1),
member(BlendsHouseNumber, HouseNumber),
    
    
%% #permutations
permutation(HouseColor,[NorwegianHouseColor, BritHouseColor, GermanHouseColor, SweedeHouseColor, DaneHouseColor]),
permutation(Smoke,[NorwegianSmoke, BritSmoke, GermanSmoke, SweedeSmoke, DaneSmoke]),
permutation(Drink,[NorwegianDrink, BritDrink, GermanDrink, SweedeDrink, DaneDrink]),
permutation(Pet,[NorwegianPet, BritPet, GermanPet, SweedePet, DanePet]),
permutation(HouseNumber,[NorwegianHouseNumber, BritHouseNumber, GermanHouseNumber, SweedeHouseNumber, DaneHouseNumber]).
