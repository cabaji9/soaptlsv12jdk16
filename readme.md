## INVOCACION WEB SERVICE CON JAVA 1.6 Tls v1.2

Java 1.6 no tiene soporte para tls v1.2

Excepto la version 1.6.0.121 Pero esta version es pagada solo para empresas con el contrato de soporte

Como alternativa se puede subir a 1.7 o realizar las modificaciones:


- Download the latest Java 1.6 version from the Java Archive Oracle website
- Uncompress it on your preferred path and set your JAVA_HOME environment variable
- Update the JDK with the latest Java Cryptography Extension (JCE) Unlimited Strength Jurisdiction Policy Files 6
        - Esto implica ir a la carpeta del jdk 1.6 --> /home/hson/java/jdk/jdk1.6.0_45/jre/lib/security/ y copiar los archivos del zip
            

- Download the Bounce Castle files bcprov-jdk15to18-165.jar and bctls-jdk15to18-165.jar and copy them into your ${JAVA_HOME}/jre/lib/ext folder
- Modify the file ${JAVA_HOME}/jre/lib/security/java.security commenting out the providers section and adding some extra lines
  
 ```shell script

  # Original security providers (just comment it)
    # security.provider.1=sun.security.provider.Sun
    # security.provider.2=sun.security.rsa.SunRsaSign
    # security.provider.3=com.sun.net.ssl.internal.ssl.Provider
    # security.provider.4=com.sun.crypto.provider.SunJCE
    # security.provider.5=sun.security.jgss.SunProvider
    # security.provider.6=com.sun.security.sasl.Provider
    # security.provider.7=org.jcp.xml.dsig.internal.dom.XMLDSigRI
    # security.provider.8=sun.security.smartcardio.SunPCSC

    # Add the Bouncy Castle security providers with higher priority
    security.provider.1=org.bouncycastle.jce.provider.BouncyCastleProvider
    security.provider.2=org.bouncycastle.jsse.provider.BouncyCastleJsseProvider
    
    # Original security providers with different priorities
    security.provider.3=sun.security.provider.Sun
    security.provider.4=sun.security.rsa.SunRsaSign
    security.provider.5=com.sun.net.ssl.internal.ssl.Provider
    security.provider.6=com.sun.crypto.provider.SunJCE 
    security.provider.7=sun.security.jgss.SunProvider
    security.provider.8=com.sun.security.sasl.Provider
    security.provider.9=org.jcp.xml.dsig.internal.dom.XMLDSigRI
    security.provider.10=sun.security.smartcardio.SunPCSC

    # Here we are changing the default SSLSocketFactory implementation
    ssl.SocketFactory.provider=org.bouncycastle.jsse.provider.SSLSocketFactoryImpl
``` 
  
 
- Se agregan los archivos necesarios en la carpeta resources.



Luego para generar los archivos se corre el comando desde la raiz:

```shell script
 wsimport -s src/main/java/ -keep -p com.hson.sri.generated "https://celcer.sri.gob.ec/comprobantes-electronicos-ws/RecepcionComprobantesOffline?wsdl" 
```


Y se corre el test.







