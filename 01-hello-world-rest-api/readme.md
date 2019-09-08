# Hello World Rest API

Run com.in28minutes.rest.webservices.restfulwebservices.RestfulWebServicesApplication as a Java Application.

- http://localhost:8080/hello-world

```txt
Hello World
```

- http://localhost:8080/hello-world-bean

```json
{"message":"Hello World - Changed"}
```

- http://localhost:8080/hello-world/path-variable/in28minutes

```json
{"message":"Hello World, in28minutes"}
```

## CF Push

### Upload Source (Package)
```
Pushing from manifest to org currency-services / space development as ranga@in28minutes.com...
Using manifest file /in28Minutes/git/pcf-crash-course-with-spring-boot/01-hello-world-rest-api/manifest.yml
Getting app info...
Updating app with these attributes...
  name:                hello-world-rest-api
  path:                /in28Minutes/git/pcf-crash-course-with-spring-boot/01-hello-world-rest-api/target/hello-world-rest-api.jar
  disk quota:          1G
  health check type:   port
  instances:           1
  memory:              1G
  stack:               cflinuxfs3
  routes:
    hello-world-rest-api-ranga-101.cfapps.io
    hello-world-rest-api-sweet-panda.cfapps.io

Updating app hello-world-rest-api...
Mapping routes...
Comparing local files to remote cache...
Packaging files to upload...
Uploading files...
 230.92 KiB / 230.92 KiB [=============================================================================] 100.00% 2s

Waiting for API to complete processing files...
```
### Staging - Build a Droplet

```
Staging app and tracing logs...
   Downloading dotnet_core_buildpack_beta...
   Downloading nodejs_buildpack...
   Downloading staticfile_buildpack...
   Downloading python_buildpack...
   Downloading java_buildpack...
   Downloaded java_buildpack
   Downloading ruby_buildpack...
   Downloaded python_buildpack
   Downloading binary_buildpack...
   Downloaded staticfile_buildpack
   Downloading php_buildpack...
   Downloaded dotnet_core_buildpack_beta
   Downloading go_buildpack...
   Downloaded nodejs_buildpack
   Downloading dotnet_core_buildpack...
   Downloaded ruby_buildpack
   Downloaded php_buildpack
   Downloaded binary_buildpack
   Downloaded go_buildpack
   Downloaded dotnet_core_buildpack
   Cell ed03ffb6-0612-4331-a4ec-4011315b86ba creating container for instance 6e23dc97-b743-40dc-9d43-eebed08bc547
   Cell ed03ffb6-0612-4331-a4ec-4011315b86ba successfully created container for instance 6e23dc97-b743-40dc-9d43-eebed08bc547
   Downloading app package...
   Downloading build artifacts cache...
   Downloaded build artifacts cache (132B)
   Downloaded app package (14.3M)
   -----> Java Buildpack v4.20 (offline) | https://github.com/cloudfoundry/java-buildpack.git#2cd7e3e
   -----> Downloading Jvmkill Agent 1.16.0_RELEASE from https://java-buildpack.cloudfoundry.org/jvmkill/bionic/x86_64/jvmkill-1.16.0-RELEASE.so (found in cache)
   -----> Downloading Open Jdk JRE 1.8.0_222 from https://java-buildpack.cloudfoundry.org/openjdk/bionic/x86_64/openjdk-jre-1.8.0_222-bionic.tar.gz (found in cache)
          Expanding Open Jdk JRE to .java-buildpack/open_jdk_jre (1.1s)
          JVM DNS caching disabled in lieu of BOSH DNS caching
   -----> Downloading Open JDK Like Memory Calculator 3.13.0_RELEASE from https://java-buildpack.cloudfoundry.org/memory-calculator/bionic/x86_64/memory-calculator-3.13.0-RELEASE.tar.gz (found in cache)
          Loaded Classes: 11729, Threads: 250
   -----> Downloading Client Certificate Mapper 1.8.0_RELEASE from https://java-buildpack.cloudfoundry.org/client-certificate-mapper/client-certificate-mapper-1.8.0-RELEASE.jar (found in cache)
   -----> Downloading Container Security Provider 1.16.0_RELEASE from https://java-buildpack.cloudfoundry.org/container-security-provider/container-security-provider-1.16.0-RELEASE.jar (found in cache)
   -----> Downloading Spring Auto Reconfiguration 2.7.0_RELEASE from https://java-buildpack.cloudfoundry.org/auto-reconfiguration/auto-reconfiguration-2.7.0-RELEASE.jar (found in cache)
   Exit status 0
   Uploading droplet, build artifacts cache...
   Uploading droplet...
   Uploading build artifacts cache...
   Uploaded build artifacts cache (132B)
   Uploaded droplet (57.9M)
   Uploading complete
   Cell ed03ffb6-0612-4331-a4ec-4011315b86ba stopping instance 6e23dc97-b743-40dc-9d43-eebed08bc547
   Cell ed03ffb6-0612-4331-a4ec-4011315b86ba destroying container for instance 6e23dc97-b743-40dc-9d43-eebed08bc547
   Cell ed03ffb6-0612-4331-a4ec-4011315b86ba successfully destroyed container for instance 6e23dc97-b743-40dc-9d43-eebed08bc547
```
   
## Deploy the Droplet

```
Waiting for app to start...

name:              hello-world-rest-api
requested state:   started
routes:            hello-world-rest-api-sweet-panda.cfapps.io, hello-world-rest-api-ranga-101.cfapps.io
last uploaded:     Tue 03 Sep 16:28:50 IST 2019
stack:             cflinuxfs3
buildpacks:        client-certificate-mapper=1.8.0_RELEASE container-security-provider=1.16.0_RELEASE
                   java-buildpack=v4.20-offline-https://github.com/cloudfoundry/java-buildpack.git#2cd7e3e
                   java-main java-opts java-security jvmkill-agent=1.16.0_RELEASE open-jdk-...

type:            web
instances:       1/1
memory usage:    1024M
start command:   JAVA_OPTS="-agentpath:$PWD/.java-buildpack/open_jdk_jre/bin/jvmkill-1.16.0_RELEASE=printHeapHistogram=1
                 -Djava.io.tmpdir=$TMPDIR -XX:ActiveProcessorCount=$(nproc)
                 -Djava.ext.dirs=$PWD/.java-buildpack/container_security_provider:$PWD/.java-buildpack/open_jdk_jre/lib/ext
                 -Djava.security.properties=$PWD/.java-buildpack/java_security/java.security $JAVA_OPTS" &&
                 CALCULATED_MEMORY=$($PWD/.java-buildpack/open_jdk_jre/bin/java-buildpack-memory-calculator-3.13.0_RELEASE
                 -totMemory=$MEMORY_LIMIT -loadedClasses=13030 -poolType=metaspace -stackThreads=250
                 -vmOptions="$JAVA_OPTS") && echo JVM Memory Configuration: $CALCULATED_MEMORY &&
                 JAVA_OPTS="$JAVA_OPTS $CALCULATED_MEMORY" && MALLOC_ARENA_MAX=2 SERVER_PORT=$PORT eval exec
                 $PWD/.java-buildpack/open_jdk_jre/bin/java $JAVA_OPTS -cp $PWD/.
                 org.springframework.boot.loader.JarLauncher
     state     since                  cpu      memory         disk           details
#0   running   2019-09-03T10:59:11Z   136.5%   162.2M of 1G   126.4M of 1G   
```

## manifest.yml

```
applications:
- name: hello-world-rest-api
  disk_quota: 1G
  instances: 1
  memory: 1G
  path: target/hello-world-rest-api.jar
  timeout: 120
  routes:
  - route: hello-world-rest-api-sweet-panda.cfapps.io
  - route: hello-world-rest-api-ranga-101.cfapps.io
  buildpacks:
  - https://github.com/cloudfoundry/java-buildpack.git
  stack: cflinuxfs3
```

## manifest.yml - green
```
applications:
- name: hello-world-rest-api-green
  disk_quota: 1G
  instances: 1
  memory: 1G
  path: target/hello-world-rest-api.jar
  timeout: 120
  routes:
  - route: hello-world-rest-api-ranga-101-temp.cfapps.io
  buildpacks:
  - https://github.com/cloudfoundry/java-buildpack.git
  stack: cflinuxfs3
```