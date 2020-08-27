if exist SampleSerialisations.exe del SampleSerialisations.exe

csc -r:MetaLinqUoA.dll SampleSerialisations.cs
pause

SampleSerialisations.exe
pause

