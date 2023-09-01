# day01

## Create maven project in Day01

### Command to create maven project
    mvn archetype:generate -DgroupId=com.rama.data -DartifactId=simple-maven-app -DarchetypeArtifactId=maven-archetype-quickstart -DinteractiveMode=false

### Compile the project
    mvn clean install

### add property 
    <properties>
    <maven.compiler.source>1.8</maven.compiler.source>
    <maven.compiler.target>1.8</maven.compiler.target>
    <java.version>11</java.version>
  </properties>

### write unit test
   

### run unit test
    mvn test

## Add git ignore
    .gitignore

### commit the code 
    git commit
    git push