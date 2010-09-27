rem Installation script for the build platform
echo "Create destination dir"
mkdir e:\tools\wget
echo "copying needed tools"
copy unzip.exe e:\tools
copy wget-1.11.4-1-bin.zip e:\tools
echo "going to the tools directory"
e:
cd e:\tools\wget
echo "starting installation"
e:\tools\unzip.exe ..\wget-1.11.4-1-bin.zip
cd e:\tools
e:\tools\wget\bin\wget.exe "http://cds.sun.com/is-bin/INTERSHOP.enfinity/WFS/CDS-CDS_Developer-Site/en_US/-/USD/VerifyItem-Start/jdk-6u21-windows-i586.exe?BundledLineItemUUID=hNyJ_hCvW_UAAAErF6IpGFJf&OrderID=P1OJ_hCvVSEAAAErDKIpGFJf&ProductID=h2iJ_hCyKS4AAAEpVrwzBGsB&FileName=/jdk-6u21-windows-i586.exe"
