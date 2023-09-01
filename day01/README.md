# day01

## Create maven project in Day01

### Command to create maven project
    mvn archetype:generate -DgroupId=com.rama.data -DartifactId=simple-maven-app -DarchetypeArtifactId=maven-archetype-quickstart -DinteractiveMode=false

### Compile the project
    mvn clean install

### add dependency for unit test
    <dependencies>
    <dependency>
      <groupId>junit</groupId>
      <artifactId>junit</artifactId>
      <version>4.13.2</version>
      <scope>test</scope>
    </dependency>

### write unit test
   

### run unit test
    mvn test

### commit the code 
    git commit
    git push