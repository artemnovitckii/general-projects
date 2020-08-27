set prompt=$G

if exist a7.exe del a7.exe
 
rem csc -r:DynamicUoA.dll a7.cs
csc -r:DynamicLinqUoA.dll a7.cs
pause

a7 < input1.txt > _output1.txt
@fc /W _output1.txt output1.txt
@echo ERRORLEVEL=%ERRORLEVEL%

a7 < input2.txt > _output2.txt
@fc /W _output2.txt output2.txt
@echo ERRORLEVEL=%ERRORLEVEL%

a7 < input3.txt > _output3.txt
@fc /W _output3.txt output3.txt
@echo ERRORLEVEL=%ERRORLEVEL%

a7 < input4.txt > _output4.txt
@fc /W _output4.txt output4.txt
@echo ERRORLEVEL=%ERRORLEVEL%

a7 < input5.txt > _output5.txt
@fc /W _output5.txt output5.txt
@echo ERRORLEVEL=%ERRORLEVEL%

a7 < input6.txt > _output6.txt
@fc /W _output6.txt output6.txt
@echo ERRORLEVEL=%ERRORLEVEL%

pause
