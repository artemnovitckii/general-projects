
if exist DynamicLinqUoA.dll del DynamicLinqUoA.dll
csc /target:library /out:DynamicLinqUoA.dll DynamicLinq.cs
pause

