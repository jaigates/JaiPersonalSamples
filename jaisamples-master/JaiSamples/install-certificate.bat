rem set JRE_HOME=
copy *.cer C:\Program Files\Java\jre6\lib\security\*.* /y
cd C:\Program Files\Java\jre6
c:

keytool -import  -alias mycertificate -keystore cacerts -file 10.0.19.72-636-certificate.cer
keytool -import  -alias mycertificate -keystore cacerts -file 10.0.19.72-636-certificate1.cer

keytool -import -alias mycertificate -keystore cacerts -file 172.16.1.49-636-certificate.cer
keytool -import -alias mycertificate -keystore cacerts -file 172.16.1.49-636-certificate2.cer