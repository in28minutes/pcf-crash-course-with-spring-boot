# PCF Crash Course for Java, Spring and Spring Boot Developers

## Deploy REST API, Web Applications, Full Stack Applications and Microservices to Pivotal Cloud Foundry (PCF) 

Spring Boot is the No 1 Java Framework to develop REST API and Microservices. Pivotal Cloud Foundry (PCF) provides a great cloud native platform to deploy Spring Boot Applications.

How about learning Pivotal Cloud Foundry (PCF) by deploying Spring Boot Docker Containers to PCF?

## Getting Started
- [Video - Docker in 5 Steps](https://youtu.be/Rt5G5Gj7RP0)
- [Video - Spring in 10 Steps](https://www.youtube.com/watch?v=edgZo2g-LTM)
- [Video - Spring Boot in 10 Steps](https://www.youtube.com/watch?v=pcdpk3Yd1EA)
- [Video - JPA/Hibernate in 10 Steps](https://www.youtube.com/watch?v=MaI0_XdpdP8)
- [Video - React in 10 Steps](https://www.youtube.com/watch?v=SWXuXhZkNQc&t=110s)
- [Article - Getting started with React and Spring Boot - Full Stack](https://www.springboottutorial.com/spring-boot-react-full-stack-crud-maven-application)
- [Article - Using Spring Security and JWT with React and Spring Boot](https://www.springboottutorial.com/spring-boot-react-full-stack-with-spring-security-basic-and-jwt-authentication)

## Installation Guides

#### Required Tools

- Node v8+ for npm
- Visual Studio Code - Latest Version
- Java 8+
- Eclipse - Oxygen+ - (Embedded Maven From Eclipse)
- Git
- Docker
- ELB CLI

#### Installing Guides

- [Playlist - Installing Java, Eclipse & Embedded Maven](https://www.youtube.com/playlist?list=PLBBog2r6uMCSmMVTW_QmDLyASBvovyAO3)
- [Playlist - Installing Node Js (npm) & Visual Studio Code](https://www.youtube.com/playlist?list=PLBBog2r6uMCQN4X3Aa_jM9qVjgMCHMWx6)

#### Troubleshooting Installations
- Node JS and NPM 
  - https://docs.npmjs.com/common-errors
  - https://docs.npmjs.com/getting-started/troubleshooting
- Visual Studio Code
  - https://code.visualstudio.com/docs/supporting/errors
  - https://code.visualstudio.com/docs/supporting/FAQ
- Eclipse and Embedded Maven
  - Troubleshooting Guide : https://github.com/in28minutes/in28minutes-initiatives/tree/master/The-in28Minutes-TroubleshootingGuide-And-FAQ#tip--troubleshooting-embedded-maven-in-eclipse
  - PDF : https://github.com/in28minutes/SpringIn28Minutes/blob/master/InstallationGuide-JavaEclipseAndMaven_v2.pdf
  - GIT Repository For Installation : https://github.com/in28minutes/getting-started-in-5-steps

## Course Overview

In this course, we deploy a variety of Spring Boot Applications to the Cloud:
- REST APIs - Hello World and Todo - Jar
- Todo Web Application War
- Full Stack Application with React and Spring Boot
- Single Container with REST API
- Multi Container with Todo REST API talking to MySQL

This course would be a perfect first step as an introduction to PCF and the Cloud.


You will be using deploying a variety of projects to Pivotal Cloud Foundry (PCF) . These projects are created with  React (Frontend Framework), Spring Boot (REST API Framework), Spring (Dependency Management), Spring Security (Authentication and Authorization - Basic and JWT), BootStrap (Styling Pages), Maven (dependencies management), Node (npm), Visual Studio Code (TypeScript IDE), Eclipse (Java IDE) and Tomcat Embedded Web Server. We will help you set up each one of these.

## What you'll learn
- You will Learn the Fundamentals of Amazon Web Services from Zero, no previous experience required
- You will learn to deploy Spring Boot REST API to AWS with AWS Elastic Beanstalk
- You will learn to deploy Java, Spring Boot Full Stack Applications to AWS with AWS Elastic Beanstalk and S3
- You will be using a number of AWS Services - EC2, S3, AWS CodePipeLine, AWS CodeBuild, SQS, IAM, CloudWatch. 
- You will learn to deploy containerized Java Spring Boot applications to AWS
- You will learn to create a continuous delivery pipeline with AWS Code Pipeline
- You will learn how to Auto Scale applications based on load as well as deploy multiple instances behind a load balancer using Elastic Beanstalk.
- You will Join 250,000 Learners having AMAZING LEARNING Experiences with in28Minutes

## Requirements
- You have an attitude to learn while having fun :)
- You have some programming experience with Java, Spring and Spring Boot
- You have a valid debit or credit card to create a AWS Account
- You DO NOT need to have any experience with AWS (Amazon Web Services)


## Step By Step Details



```sh
for file in *; do mv "${file}" "${file//-/ }"; done
for file in *; do mv "${file}" "${file//   / - }"; done
for file in *; do mv "${file}" "${file//01 Step/Step}"; done
```

  
### Useful Links
- [Our Website](http://www.in28minutes.com)
- [Facebook](http://facebook.com/in28minutes)
- [Twitter](http://twitter.com/in28minutes)
- [Google Plus](https://plus.google.com/u/3/110861829188024231119)

## Diagrams

- Courtesy http://viz-js.com/

```
graph architecture {

node[style=filled,color="#59C8DE"]
//node [style=filled,color="#D14D28", fontcolor=white];
rankdir = TB;
node[shape=record]

IAM -- Console
Console -- UserID
Console -- Password
IAM -- Application
Application -- AccessKeyID
Application -- SecretAccessKey

IAM[label=<IAM User>]
AccessKeyID[label=<Access Key Id>]
UserID[label=<User Id>]
SecretAccessKey[label=<Secret Access Key>]
Console[label=<Management Console>]
Application[label=<APIs>]
}


graph architecture {

node[style=filled,color="#59C8DE"]
//node [style=filled,color="#D14D28", fontcolor=white];
rankdir = TB;
node[shape=record]

Users -- RootUser
Users -- IAM

RootUser[label=<Root User>]
IAM[label=<IAM User>]

}



graph architecture {

node[style=filled,color="#59C8DE"]
//node [style=filled,color="#D14D28", fontcolor=white];
rankdir = TB
node[shape=record, width=2]
edge [width=0]
graph [pad=".75", ranksep="0.05", nodesep="0.25"];

Applications -- Software [style=invis]
Software -- OS [style=invis]
OS -- Hardware [style=invis]

}


graph architecture {

node[style=filled,color="#59C8DE"]
//node [style=filled,color="#D14D28", fontcolor=white];
rankdir = TB
node[shape=record, width=3]

Containers, LocalImages [height=1]

DockerClient -- Daemon
Daemon -- Containers 
Daemon -- LocalImages
Daemon -- ImageRegistry

DockerClient[label=<Docker Client>]
ImageRegistry[label=<Image Registry <BR /><FONT POINT-SIZE="10">nginx<BR />mysql<BR />eureka<BR />your-app<BR /><BR /></FONT>>];
Daemon[label=<Docker Daemon>]


}


graph architecture {

node[style=filled,color="#59C8DE"]
//node [style=filled,color="#D14D28", fontcolor=white];
rankdir = TB
node[shape=record, width=2]
Hypervisor,HostOS, Hardware[shape=record, width=6.5, style=filled,color="#D14D28", fontcolor=white]
edge [width=0]
graph [pad=".75", ranksep="0.05", nodesep="0.25"];

Application1 -- Software1 [style=invis]
Application2 -- Software2 [style=invis]
Application3 -- Software3 [style=invis]

Software1 -- GuestOS1 [style=invis]
Software2 -- GuestOS2 [style=invis]
Software3 -- GuestOS3 [style=invis]
GuestOS1 -- Hypervisor [style=invis]
GuestOS2 -- Hypervisor [style=invis]
GuestOS3 -- Hypervisor [style=invis]
Hypervisor -- HostOS [style=invis]
HostOS -- Hardware [style=invis]

}


graph architecture {

node[style=filled,color="#59C8DE"]
//node [style=filled,color="#D14D28", fontcolor=white];
rankdir = TB
node[shape=record, width=2]
HostOS, CloudInfrastructure, DockerEngine[shape=record, width=6.5, style=filled,color="#D14D28", fontcolor=white]
edge [width=0]
graph [pad=".75", ranksep="0.05", nodesep="0.25"];
Container1,Container2,Container3[height=2]

Container1 -- DockerEngine [style=invis]
Container2 -- DockerEngine [style=invis]
Container3 -- DockerEngine [style=invis]
DockerEngine -- HostOS [style=invis]
HostOS -- CloudInfrastructure [style=invis]

}
```

## Todo
- Course Creation
  - Containers DONE
  - Auto Scaling DONE
  - JDK 11 DONE
  - Concepts : Droplets, Build Pack, Routes, Revisions, Tasks DONE
  - --nostart TODO 
  - Log Levels at Runtime  TODO
  - Routing -- Several Apps One Route, Context Path Routing DONE
  - Route Service - API Gateway - Authentication DONE
  - Resilience DONE
  - Health Checks DONE
  - Blue Green and Canary Deployments DONE
  - PDF Documentation
  - Book on Safari
  - Course on Safari Online
- Post Course Creation
  - Course Promotion Emails/Posts
    - 1 Emails on Udemy
    - 1 Emails to Email List
  - Create YouTube Course Preview Video
    - Add YouTube Course Preview Video as End Video for all videos
    - Make it the YouTube Default Video
  - Release atleast 20 small videos - one a day on Youtube
  - Do atleast 3 Youtube live sessions
  - After a Month
    - UFB and Packt

## Next Steps


## All Notes

https://docs.cloudfoundry.org/cf-cli/
https://docs.cloudfoundry.org/cf-cli/install-go-cli.html

cf install-plugin cfdev

cf dev start -f /Users/rangakaranam/Downloads/pcfdev-v1.2.0-darwin.tgz -s scs

cf dev suspend
cf dev resume

cf dev destroy
cf dev stop
cf dev status

https://network.pivotal.io/products/pcfdev


API endpoint: https://api.local.pcfdev.io
Apps Manager URL: https://apps.local.pcfdev.io
An Admin user with the Email: admin and Password: admin
A Regular user with the Email: user and Password: pass
An Org for apps to be named: pcfdev-org
With a Space for deploying the apps to be named pcfdev-space

cf login -a https://api.local.pcfdev.io --skip-ssl-validation 

cf target -o ORG -s SPACE

cf set-org-role John cf-my-first-org OrgManager

cf set-space-role John cf-my-first-org development SpaceDeveloper

cf marketplace


/Library/Java/JavaVirtualMachines/jdk-10.0.2.jdk/Contents/Home

 312  cf login
  313  cf status
  314  cf
  315  cf config
  316  cf -v
  317* cf help
  318  cf routes
  319  cf apps
  320  cf spaces
  321  cf
  322  cf marketplace
  323  cf marketplace -s mysql
  324  cf marketplace -s cleardb
  325  cf apps
  326   cf delete -r in28minutes-restful-web-services
  327   cf delete -r restful-web-services
  328  cf
  
  343  cf push hello-world-rest-api -p target/01-hello-world-rest-api-0.0.1-SNAPSHOT.jar
  344  cf create-app-manifest hello-world-rest-api
  345  cf apps
  349  cf routes
  350  mvn cf:push
  354  mvn cf:login -Dcf.username=mailranga@gmail.com -Dcf.password=fjlsdfjklas@sdjfklasjd
  360  cf push -t target/01-hello-world-rest-api-0.0.1-SNAPSHOT.jar
  361  clear
  365  mvn clean install -DskipTests
  366  cf push

   cf set-env help
  320  cf set-env currency-conversion-service CURRENCY_EXCHANGE_URI https://currency-exchange-service-h2.cfapps.io
  321  cf restage currency-conversion-service
    318  cf env currency-conversion-service

    314  mvn clean install -DskipTests -Ddockerfile.skip
  315  cf push

    317  cf scale --help
  318  cf scale currency-exchange-service -i 2
  319  cf scale currency-exchange-service -i 1

  cf set-env currency-conversion-service CURRENCY_EXCHANGE_URI https://currency-exchange-service-h2.cfapps.io

  brew install springboot

    370  mvn clean install -DskipTests -Ddockerfile.skip; cf push;
  371  cf scale currency-conversion-service 2
  372  cf scale currency-conversion-service -i 2

342  cf set-env currency-conversion-service CURRENCY_EXCHANGE_URI currency-exchange-microservice
343  cf restage currency-exchange-service

327  cf set-env currency-conversion-service CURRENCY_EXCHANGE_URI //CURRENCY-EXCHANGE-MICROSERVICE

cf set-env currency-exchange-service spring.cloud.services.registrationMethod direct

cf add-network-policy currency-conversion-service --destination-app currency-exchange-service

cf network-policies

watch -n 0.1 curl  https://currency-conversion-service-h2.cfapps.io/currency-converter/from/EUR/to/INR/quantity/10

cf remove-network-policy currency-conversion-service --destination-app currency-exchange-service --protocol tcp --port 8080

cf set-env currency-conversion-service hystrix.command.default.circuitBreaker.requestVolumeThreshold 2

cf create-service p-config-server trial in28minutes-config-server -c create-config-server.json

{  
  "git":{  
    "uri":"https://github.com/in28minutes/dev-config-server-test.git",
    "label":"master",
    "searchPaths":"currency-exchange-service"
  }
}

{ "count":1, "git":{  "uri":"https://github.com/in28minutes/dev-config-server-test.git", "label":"master", "searchPaths":"currency-exchange-service" }}


cf update-service config-server -c  '{ "count":1, "git":{  "uri":"https://github.com/in28minutes/dev-config-server-test.git", "label":"master", "searchPaths":"currency-exchange-service" }}'

cf service config-server

Refresh

https://currency-conversion-service-h2.cfapps.io/manage/refresh

https://community.pivotal.io/s/question/0D50P00003tGPOlSAO/is-it-possible-to-connect-rabbitmq-spring-cloud-bus-with-pcf-config-server-from-market-place-not-the-spring-cloud-config-server-as-a-application-i-want-to-have-refresh-of-config-client

cf push todo-rest-api --docker-image in28min/docker-in-5-steps-todo-rest-api-h2:1.0.0.RELEASE

http://todo-rest-api.cfapps.io/jpa/users/in28minutes/todos

CF App Autoscaler CLI

cf install-plugin ~/Downloads/autoscaler-for-pcf-cliplugin-macosx64-binary-2.0.199
watch cf autoscaling-events todo-rest-api


todo-rest-api

spring-boot-route-service

cf create-user-provided-service spring-boot-route-service -r https://spring-boot-route-service.cfapps.io/

cf bind-route-service cfapps.io --hostname todo-rest-api spring-boot-route-service

cf set-health-check currency-exchange-service http --endpoint /manage/health-error

cf map-route hello-world-rest-api-v2 cfapps.io --hostname hello-world-rest-api

cf unmap-route hello-world-rest-api cfapps.io --hostname hello-world-rest-api

cf v3-droplets currency-exchange-service


cf uups my-logging-service -l syslog-tls://logs2.papertrailapp.com:24066
cf bind-service currency-exchange-service my-logging-service
cf start currency-exchange-service
