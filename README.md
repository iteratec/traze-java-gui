# traze-java-gui

**Requires Oracle JRE**
(or icedtea for javaws.jar)

Complete gui game client written in java.

Traze GUI client based on Java with Slick2D.

After cloning the repo build the executable jar file with:
`mvn install`
  
To run the jar afterwards use:  
  
```
java -Djava.library.path=/path/to/repo/traze-java-gui/native/linux -jar /path/to/repo/traze-java-gui/target/traze-0.0.1-SNAPSHOT-jar-with-dependencies.jar
```

Make sure to adjust the path of the native library to the location you cloned the repository and change the OS name in the path to your OS.

You can choose from:
- `windows`
- `macosx`
- `solaris`
- `linux`
