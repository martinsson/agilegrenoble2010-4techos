rem Installation script for the build platform
echo off 
set workspaceDir=E:\build\workspace
echo "the workspace dir shoud contains Installation,ThirdParty,NokiaFE, and QuestionsType directories from svn"
set /P INPUT=Type input [%workspaceDir%]: %=%
echo "Create destination dir %workspaceDir%"
pushd . 



rem ***************************************************************
rem INSTALLATION BASIC STUFF 
rem ***************************************************************

rem mkdir e:\tools\wget
rem echo "copying needed tools"
rem copy unzip.exe e:\tools
rem copy wget-1.11.4-1-bin.zip e:\tools
rem copy wget-1.11.4-1-dep.zip e:\tools
rem echo "going to the tools directory"
e:
rem cd e:\tools\wget
rem echo "starting installation"
rem e:\tools\unzip.exe ..\wget-1.11.4-1-bin.zip
rem e:\tools\unzip.exe ..\wget-1.11.4-1-dep.zip
cd e:\tools

rem ***************************************************************
rem INSTALLATION JDK
rem ***************************************************************
rem e:\tools\wget\bin\wget.exe "http://cds.sun.com/is-bin/INTERSHOP.enfinity/WFS/CDS-CDS_Developer-Site/en_US/-/USD/VerifyItem-Start/jdk-6u21-windows-i586.exe?BundledLineItemUUID=hNyJ_hCvW_UAAAErF6IpGFJf&OrderID=P1OJ_hCvVSEAAAErDKIpGFJf&ProductID=h2iJ_hCyKS4AAAEpVrwzBGsB&FileName=/jdk-6u21-windows-i586.exe"
rem move "jdk-6u21-windows-i586*" "jdk-6u21-windows-i586.exe"
rem  "jdk-6u21-windows-i586.exe" /l* java.log INSTALLDIR=e:\java\jdk1.6.0_21 /qn


rem ***************************************************************
rem INSTALLATION MYSQL (server)
rem ***************************************************************
rem e:\tools\wget\bin\wget.exe http://10.190.200.129:8081/artifactory/ext-releases-local/com/oracle/mysql/mysqlserver/5.1.50/mysqlserver-5.1.50-win32.msi
rem msiexec /i mysqlserver-5.1.50-win32.msi /l* mysql.log INSTALLDIR="E:\MySQL\Server 5.1\" DATADIR="E:\data\MySQL\" /qn
rem ***************************************************************
rem INSTALLATION MYSQL (connector)
rem ***************************************************************
rem e:\tools\wget\bin\wget.exe http://dev.mysql.com/get/Downloads/Connector-J/mysql-connector-java-5.0.8.zip/from/http://artfiles.org/mysql/
rem unzip mysql-connector-java-5.0.8.zip

rem ***************************************************************
rem INSTALLATION Log4J , sqqldb
rem ***************************************************************
rem e:\tools\wget\bin\wget.exe http://sourceforge.net/projects/hsqldb/files/hsqldb/hsqldb_2_0/hsqldb-2.0.0.zip/download
rem e:\tools\wget\bin\wget.exe http://mir2.ovh.net/ftp.apache.org/dist//logging/log4j/1.2.16/apache-log4j-1.2.16.zip

rem ***************************************************************
rem Installation pom of 3rd party locally to avoid maven fetch
rem ***************************************************************


rem questionType : should be done at compile time ...
echo "installing initial version of questionType"
cmd /c mvn install:install-file -DgroupId=org.agile4techos.nokiatest -DartifactId=questionType -Dversion=1.0.0 -Dpackaging=jar -Dfile=%workspaceDir%\QuestionsType\src\questionType-1.0.0.jar -DpomFile=%workspaceDir%\QuestionsType\pom.xml

rem hsqldb, mysqlconnector, log4j
echo "installing hdsqldb, mysql, log4j"
cmd /c mvn install:install-file -DgroupId=org.mysql.connector -DartifactId=mysqlconnector -Dversion=5.0.8 -Dpackaging=jar -Dfile=%workspaceDir%\ThirdParty\mysql-connector-java-5.0.8\mysql-connector-java-5.0.8-bin.jar -DpomFile=%workspaceDir%\ThirdParty\poms\pomMysqlConnector.xml
cmd /c mvn install:install-file -DgroupId=org.apache.log4j -DartifactId=log4j -Dversion=1.2.16 -Dpackaging=jar -Dfile=%workspaceDir%\ThirdParty\apache-log4j-1.2.16\log4j-1.2.16.jar -DpomFile=%workspaceDir%\ThirdParty\poms\pomLog4j.xml
cmd /c mvn install:install-file -DgroupId=org.hsqldb.db -DartifactId=hsqldb -Dversion=2.0.0 -Dpackaging=jar -Dfile=%workspaceDir%\ThirdParty\hsqldb\lib\hsqldb.jar -DpomFile=%workspaceDir%\ThirdParty\poms\pomHsqldb.xml
cmd /c mvn install:install-file -DgroupId=org.hsqldb.db -DartifactId=sqltools -Dversion=2.0.0 -Dpackaging=jar -Dfile=%workspaceDir%\ThirdParty\hsqldb\lib\sqltool.jar -DpomFile=%workspaceDir%\ThirdParty\poms\pomSqlTools.xml

rem xmlbeans.*
echo "installing xmlbeans"
cmd /c mvn install:install-file -DgroupId=org.apache.xmlbeans -DartifactId=xbeans -Dversion=2.5.0 -Dpackaging=jar -Dfile=%workspaceDir%\ThirdParty\xmlBeans\lib\xbean.jar -DpomFile=%workspaceDir%\ThirdParty\poms\pomXbeans.xml
cmd /c mvn install:install-file -DgroupId=org.apache.xmlbeans -DartifactId=jsr-api -Dversion=2.5.0 -Dpackaging=jar -Dfile=%workspaceDir%\ThirdParty\xmlBeans\lib\jsr173_1.0_api.jar -DpomFile=%workspaceDir%\ThirdParty\poms\pomJsrAPI.xml
cmd /c mvn install:install-file -DgroupId=org.apache.xmlbeans -DartifactId=resolver -Dversion=2.5.0 -Dpackaging=jar -Dfile=%workspaceDir%\ThirdParty\xmlBeans\lib\resolver.jar -DpomFile=%workspaceDir%\ThirdParty\poms\pomResolver.xml
cmd /c mvn install:install-file -DgroupId=org.apache.xmlbeans -DartifactId=xbeans-xpath -Dversion=2.5.0 -Dpackaging=jar -Dfile=%workspaceDir%\ThirdParty\xmlBeans\lib\xbean_xpath.jar -DpomFile=%workspaceDir%\ThirdParty\poms\pomXbeansXPath.xml
cmd /c mvn install:install-file -DgroupId=org.apache.xmlbeans -DartifactId=xbeans-qname -Dversion=2.5.0 -Dpackaging=jar -Dfile=%workspaceDir%\ThirdParty\xmlBeans\lib\xmlbeans-qname.jar -DpomFile=%workspaceDir%\ThirdParty\poms\pomXbeans-qname.xml
cmd /c mvn install:install-file -DgroupId=org.apache.xmlbeans -DartifactId=xml-public -Dversion=2.5.0 -Dpackaging=jar -Dfile=%workspaceDir%\ThirdParty\xmlBeans\lib\xmlpublic.jar -DpomFile=%workspaceDir%\ThirdParty\poms\pomXPublic.xml

rem Create a repository with all dependencies to be imported into eclispe 
echo "uploading dependencies in eclipse layout"
cmd /c mvn  -f %workspaceDir%\QuestionsType\pom.xml dependency:copy-dependencies

cmd /c mvn  -f %workspaceDir%\QuestionStorage\pom.xml dependency:copy-dependencies jar:jar
cmd /c mvn install:install-file -DgroupId=org.agile4techos.nokiatest -DartifactId=questionStorage -Dversion=1.0-SNAPSHOT -Dpackaging=jar -Dfile=%workspaceDir%\QuestionStorage\target\questionStorage-1.0-SNAPSHOT.jar -DpomFile=%workspaceDir%\QuestionStorage\pom.xml 

cmd /c mvn  -f %workspaceDir%\StorageServer\pom.xml dependency:copy-dependencies
cmd /c mvn  -f %workspaceDir%\StorageClient\pom.xml dependency:copy-dependencies

cmd /c mvn  -f %workspaceDir%\NokiaTest_FE\pom.xml dependency:copy-dependencies
popd 


