<Query Kind="Statements">
  <Reference>DynamicLinqUoA.dll</Reference>
  <Namespace>System.Linq.Dynamic</Namespace>
</Query>

string[] v = { "the", "quick", "brown", "fox" };

var w1 = v .Where (x => x.Length == 3);
w1 .Dump ();

var w2 = v .AsQueryable () .Where ("Length == 3");
w2 .Dump ();

var w3 = v .AsQueryable () .Where ("Length == @0", 3);
w3 .Dump ();

var s1 = v .OrderBy (it => it);
s1 .Dump ();

var s2 = v .AsQueryable () .OrderBy ("it");
s2 .Dump ();
