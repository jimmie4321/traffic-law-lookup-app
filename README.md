# traffic-law-lookup-app
Repository to hold work for the traffic law look up application.

//clone repo
git clone https://github.com/jimmie4321/traffic-law-lookup-app.git

//Build and Deploy Locally
cd to traffic-law-lookup-app
mvn clean install
man appengine:devserver

//Push to Prod: Windows
C:\apps\google-app-engine-sdk\appengine-java-sdk-1.9.26\bin\appcfg.cmd -A trafficlawlookupapp update ~\traffic-law-lookup-app\target\trafficlawlookup-1.0-SNAPSHOT/ 

//Push to Prod: Mac
appcfg.sh -A trafficlawlookupapp update ~/traffic-law-lookup-app/target/trafficlawlookup-1.0-SNAPSHOT

//Access admin side
navigate: http://localhost:8080/login
username: jimmie
password: phish
