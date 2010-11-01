@echo off

rem Installation script for the build platform
set workspaceDir=E:\build\workspace

echo "The workspace dir shoud contains Installation, ThirdParty, NokiaFE, and QuestionsType directories from svn"
echo "Starting installation"

rem ################INIT###################

rem global data
set TOOLS_FOLDER=E:\tools
set DATA_FOLDER=E:\data
set MYSQL_FOLDER=E:\MySQL
set WGET_FOLDER=E:\tools\wget
set UNZIP_FOLDER=E:\tools\unzip

rem mysql data
set MySQLSERVER_InstallDIR=E:\MySQL\Server 5.1\
set MySQLSERVER_BinDIR=E:\MySQL\Server 5.1\bin\
set MySQLSERVER_DataDIR=E:\data\MySQL\
set MySQLSERVER_LogFile=E:\tools\mysql.log
set MySQLSERVER_ServiceName=mysql
set MySQLSERVER_MyINI_FilePath_1=E:\build\workspace\Installation\configuration\version_1.0\mysqld-5.1.50\my.ini
set MySQLSERVER_MyINI_FilePath_2=E:\MySQL\Server 5.1\my.ini
set MySQLSERVER_URL=http://downloads.mysql.com/archives/mysql-5.1/mysql-5.1.50-win32.msi
set MySQLSERVER_MSI=mysqlserver-5.1.50-win32.msi
set MySQLSERVER_TMP_MSI=mysql-5.1.50-win32.msi

set MySQLSERVER_USER=root
set MySQLSERVER_PASSWD=agilent123

rem mysql connector data
set MySQL_Con_URL=http://dev.mysql.com/get/Downloads/Connector-J/mysql-connector-java-5.0.8.zip/from/http://artfiles.org/mysql/
set MySQL_Con_ZIP=mysql-connector-java-5.0.8.zip


rem unzip data
set UNZIP_BINDIR=E:\tools\unzip\bin

rem wget data
set WGET_BINDIR=E:\tools\wget\bin
set WGET_BINZIP=wget-1.11.4-1-bin.zip
set WGET_DEPZIP=wget-1.11.4-1-dep.zip

rem maven data
set MAVEN_URL=http://mirror.mkhelif.fr/apache//maven/binaries/apache-maven-2.2.1-bin.zip
set MAVEN_ZIP=apache-maven-2.2.1-bin.zip
set M2_HOME=E:\tools\apache-maven-2.2.1
set M2=%M2_HOME%/bin
set MAVEN_OPTS=-Xms256m -Xmx512m

rem ################INIT###################


echo ***************************************************************
echo INSTALLATION OF BASIC STUFF 
echo ***************************************************************
echo.
echo "Stopping first %MySQLSERVER_ServiceName% if existing"
net stop %MySQLSERVER_ServiceName%

echo.
echo "Disabling Windows Firewall first if enabled"
netsh firewall set opmode disable

echo.
echo "Cleaning MySQL + Tools folders"
rmdir /Q /S %TOOLS_FOLDER%
rmdir /Q /S %DATA_FOLDER%
rmdir /Q /S %MYSQL_FOLDER%
rmdir /Q /S %UNZIP_FOLDER%

echo.
echo "Creating MySQL + Maven + Tools folders"
mkdir %TOOLS_FOLDER%
mkdir %WGET_FOLDER%
mkdir %UNZIP_FOLDER%
mkdir %UNZIP_BINDIR%

echo.
echo "Copying needed tools (unzip)"
copy unzip.exe %UNZIP_BINDIR%
echo "According Global PATH variable for unzip"
set PATH=%PATH%;%UNZIP_BINDIR%

echo.
echo "Copying needed tools (wget)"
copy %WGET_BINZIP% %TOOLS_FOLDER%
copy %WGET_DEPZIP% %TOOLS_FOLDER%

echo.
echo "Going to the tools (wget) directory"
e:
cd %WGET_FOLDER%

echo.
echo "Installing wget command"
unzip -qq ..\%WGET_BINZIP%
unzip -qq ..\%WGET_DEPZIP%

echo.
echo "According Global PATH variable for wget"
set PATH=%PATH%;%WGET_BINDIR%

echo.
echo "Going to the tools directory"
cd "%TOOLS_FOLDER%"


echo ***************************************************************
echo INSTALLATION OF MYSQL (server)
echo ***************************************************************
echo.
echo "Catching mysql server msi package"
wget.exe %MySQLSERVER_URL%
move "%MySQLSERVER_TMP_MSI%" "%MySQLSERVER_MSI%"

echo.
echo "Installing mysql server msi package (%MySQLSERVER_MSI% - log is %MySQLSERVER_LogFile%)"
msiexec /i "%MySQLSERVER_MSI%" /l* "%MySQLSERVER_LogFile%" INSTALLDIR="%MySQLSERVER_InstallDIR%" DATADIR="%MySQLSERVER_DataDIR%" /qn

echo.
echo "Copying my.ini (myssql server customized configuration file)"
copy "%MySQLSERVER_MyINI_FilePath_1%" "%MySQLSERVER_InstallDIR%"

echo.
echo "Starting %MySQLSERVER_ServiceName%"
cd "%MySQLSERVER_BinDIR%"
mysqld --install %MySQLSERVER_ServiceName% --defaults-file="%MySQLSERVER_MyINI_FilePath_2%"
net start %MySQLSERVER_ServiceName%
mysqladmin -u %MySQLSERVER_USER% password %MySQLSERVER_PASSWD%

echo.
echo "According Global PATH variable"
set PATH=%PATH%;%MySQLSERVER_BinDIR%


echo ***************************************************************
echo INSTALLATION OF MYSQL (connector)
echo ***************************************************************
echo.
echo "Installing mysql connector"
cd "%TOOLS_FOLDER%"
wget.exe %MySQL_Con_URL%
unzip -qq %MySQL_Con_ZIP%


echo ***************************************************************
echo INSTALLATION MAVEN
echo ***************************************************************
echo.
echo "Installing maven binaries"
cd "%TOOLS_FOLDER%"
wget.exe %MAVEN_URL%
unzip -qq %MAVEN_ZIP%
echo "According Global PATH variable for maven"
set PATH=%PATH%;%M2%


echo ***************************************************************
echo FINAL CLEAN UP
echo ***************************************************************
echo.
echo "Removing zip files"
del "%TOOLS_FOLDER%\*.zip"

echo.
echo "Removing msi files"
del "%TOOLS_FOLDER%\*.msi"

cd "e:\build\workspace\Installation"