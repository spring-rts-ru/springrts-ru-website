set CLASSPATH=%CD%\lib\postgresql-9.4.1212.jre7.jar
@echo off
set database=local
rem database=prod

if "%database%" == "local" (
set URL=jdbc:postgresql://localhost:5432/springrtsru
set USER=local
set PASS=local
) else ( if "$database" == "prod" (
set URL=jdbc:postgresql://localhost:5432/springrtsru
set USER=
set PASS=
    )
)

@echo =========================================================================

java -jar %CD%\lib\liquibase-core-3.5.3.jar --driver=org.postgresql.Driver --classpath=%CLASSPATH% --changeLogFile=%CD%\db.changelog.xml  --url="%URL%"  --logLevel=info --username=%USER%  --password=%PASS%  updateSQL

@echo Using database %database%
@echo  URL: %URL%
@echo  User: %USER%
@echo =========================================================================
@echo Continue ? (y/N)
set /P answer=


if "%answer%" == "y" (
@echo Updating...
java -jar %CD%\lib\liquibase-core-3.5.3.jar --driver=org.postgresql.Driver --classpath=%CLASSPATH% --changeLogFile=%CD%\db.changelog.xml --url="%URL%" --logLevel=info --username=%USER% --password=%PASS% update
) else (
@echo Abort
)


