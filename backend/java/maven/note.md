## Concept
POM: project object model
java program lifecycle manage tool, use plugin to integrate with other tool

## Dependency management
By default, maven download all dependencies from Maven Central Repo, we can   
add more repos in pom.xml
  
```
    repositories
        repository
            id
            url
    dependencies 
        dependency
            gourpId
            artifactId
            version
            exclusions
    profiles
        profile
            id
            properties
            activation
    properties
    build
        resources
            resource
                directory
                includes
                    include

        testResource
            testResource
        plugins
            plugin
```            

### Directory architecture
```
my-app
|-- pom.xml
`-- src
    |-- main
    |   |-- java
    |   |   `-- com
    |   |       `-- mycompany
    |   |           `-- app
    |   |               `-- App.java
    |   `-- resources
    |       `-- META-INF
    |           |-- application.properties
    `-- test
        |-- java
        |   `-- com
        |       `-- mycompany
        |           `-- app
        |               `-- AppTest.java
        `-- resources
            `-- test.properties
```

### Topic
1. resource filter
2. module, parent
3. plugin 
4. dependency
5. deploy jar to remote repository
6. create document 
7. different type of projects
8. unittest
