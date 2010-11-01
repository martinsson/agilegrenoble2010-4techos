# ***********************************
# Agile 4 techos 
# ***********************************


First, insall jdk, maven and ensure they work properly
(you can use some commented line present in install.bat)

Assumption :
Download the whole project into a working directory, as example : e:\build\workspace 

run install.bat, it will :
  * install maven dependency on your pc
  * copy dependency in the target dir of each project for eclipse

Start eclipse and use your working directory as workspace, use "import existing project" to populate eclipse.

Note : currently you need to install mysql too.


# *********************************************************
# mysqlsetup.bat
#
# This will mainly create : 
#
# E:\tools
#      |--apache-maven-2.2.1
#           |--bin
#               |--mvn
#               |--...
#      |--mysql-connector-java-5.0.8
#      |--unzip
#           |--bin
#               |--unzip
#      |--wget
#           |--bin
#               |--wget
# 
# This will finally add to %PATH% all that you need 
#
# *********************************************************
In order to install mysql (server + connector) + maven
You can use mysqlsetup.bat

In case you have a firewall activated (other than windows firewall), first deactivate it
That's to enable connection to localhost:3306 (mysql server)

run 'cmd'
run 'echo %PATH%'
ensure cygwin is not in %PATH% variable

run e:\build\worspace\Installation\mysqlsetup.bat
