# business-card-ocr

## Motivation
This application is a solution to an [Asymmetrik programming challenge](http://asymmetrik.com/programming-challenges/) 

## Requirements
This application requires Java to run, and uses Gradle as a build tool.

## Installation
To create the Jar run
```console
foo@business-card-ocr
> ./gradlew shadowJar
```
A jar will be created in build/libs

## Running the Application
After creating the jar, to run the application simply run
```console
foo@business-card-ocr/build/libs
> java -jar BusinessCardParser-all.jar path/to/BusinessCardfile.txt
```

## Testing
In the root directory of the project run
```console
foo@business-card-ocr
> ./gradlew test
```
## Licence
[MIT License](https://github.com/NeradaXsinZ/business-card-ocr/blob/master/LICENSE)
