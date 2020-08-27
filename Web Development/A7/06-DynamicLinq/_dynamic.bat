
if exist DynamicUoA.dll del DynamicUoA.dll
csc /target:library /out:DynamicUoA.dll Dynamic.cs
pause

