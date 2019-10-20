call runcrud.bat

if "%ERRORLEVEL%" == "0" goto startDefaultBrowser
echo.
echo F**king errors
goto fail

:startDefaultBrowser
sleep 18s
start "" http://localhost:8080/crud/v1/task/getTasks
if "%ERRORLEVEL%" == "0" goto end
echo.
echo WRONG
goto fail

:fail
echo You missed something and the whole work is shitty
echo You lost... Donkey...

:end
echo No way, you`ve done that.