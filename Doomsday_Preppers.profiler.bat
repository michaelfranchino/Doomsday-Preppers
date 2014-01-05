set JAVA_HOME=C:\Program Files\Java\jre7

set CLASS_PATH=C:\Users\mfranchino\workspace\Doomsday Preppers\bin;C:\Users\mfranchino\workspace\Doomsday Preppers\lib\jars\lwjgl.jar;C:\Users\mfranchino\workspace\Doomsday Preppers\lib\jars\slick.jar;C:\Users\mfranchino\workspace\Doomsday Preppers.profiler\bin;;.;C:\Program Files\Java\jre7\lib\tools.jar;

set PATH=%PATH%;C:\AppPerfect\Profiler\approfilertools\eclipse\plugins\com.appperfect.teststudio_14.0.0.3783\lib;C:\Users\mfranchino\workspace\Doomsday Preppers\lib\natives\windows;

"%JAVA_HOME%\bin\java" -jar  -Xbootclasspath/a:"C:\AppPerfect\Profiler\approfilertools\eclipse\plugins\com.appperfect.teststudio_14.0.0.3783\lib\profiler.jar" -Djp.library.path="C:\AppPerfect\Profiler\approfilertools\eclipse\plugins\com.appperfect.teststudio_14.0.0.3783\lib" -agentlib:aptsti64=propertiesfile="C:\Users\mfranchino\workspace\Doomsday Preppers.profiler\profiler.properties" -classpath "%CLASS_PATH%" "C:\Users\mfranchino\workspace\Doomsday Preppers\doomsday_all.jar"