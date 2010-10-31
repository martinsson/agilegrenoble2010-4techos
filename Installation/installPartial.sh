workspaceDir=..

mvn install:install-file -DgroupId=org.apache.xmlbeans -DartifactId=xbeans -Dversion=2.5.0 -Dpackaging=jar -Dfile=$workspaceDir/ThirdParty/xmlBeans/lib/xbean.jar -DpomFile=$workspaceDir/ThirdParty/poms/pomXbeans.xml

mvn install:install-file -DgroupId=org.apache.xmlbeans -DartifactId=jsr-api -Dversion=2.5.0 -Dpackaging=jar -Dfile=$workspaceDir/ThirdParty/xmlBeans/lib/jsr173_1.0_api.jar -DpomFile=$workspaceDir/ThirdParty/poms/pomJsrAPI.xml
mvn install:install-file -DgroupId=org.apache.xmlbeans -DartifactId=resolver -Dversion=2.5.0 -Dpackaging=jar -Dfile=$workspaceDir/ThirdParty/xmlBeans/lib/resolver.jar -DpomFile=$workspaceDir/ThirdParty/poms/pomResolver.xml
mvn install:install-file -DgroupId=org.apache.xmlbeans -DartifactId=xbeans-xpath -Dversion=2.5.0 -Dpackaging=jar -Dfile=$workspaceDir/ThirdParty/xmlBeans/lib/xbean_xpath.jar -DpomFile=$workspaceDir/ThirdParty/poms/pomXbeansXPath.xml
mvn install:install-file -DgroupId=org.apache.xmlbeans -DartifactId=xbeans-qname -Dversion=2.5.0 -Dpackaging=jar -Dfile=$workspaceDir/ThirdParty/xmlBeans/lib/xmlbeans-qname.jar -DpomFile=$workspaceDir/ThirdParty/poms/pomXmlbeans-qname.xml
mvn install:install-file -DgroupId=org.apache.xmlbeans -DartifactId=xml-public -Dversion=2.5.0 -Dpackaging=jar -Dfile=$workspaceDir/ThirdParty/xmlBeans/lib/xmlpublic.jar -DpomFile=$workspaceDir/ThirdParty/poms/pomXmlPublic.xml
mvn install:install-file -DgroupId=org.agile4techos.nokiatest -DartifactId=questionType -Dpackaging=jar -Dfile=$workspaceDir/QuestionsType/bin/questionType-1.0.0.jar -DpomFile=$workspaceDir/QuestionsType/pom.xml
