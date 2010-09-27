rem Installation script for the build platform
echo "Create destination dir"
mkdir -p e:\tools\wget
echo "copying needed tools"
copy unzip.exe e:\tools
copy wget-1.11.4-1-bin.zip e:\tools
echo "going to the tools directory"
cd e:\tools\wget
e:
"echo starting installation"
e:\tools\unzip.exe ..\wget-1.11.4-1-bin.zip
