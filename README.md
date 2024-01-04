We are using VSCode as our IDE for this application

Video Reference:
<br>Link: https://youtu.be/H67COH9F718?feature=shared

For the setup of application, you will need:
1) Java SDK (jdk-21)
2) JavaFx SDK
   <br>Link: https://download2.gluonhq.com/openjfx/21.0.1/openjfx-21.0.1_windows-x64_bin-sdk.zip
3) VSCode IDE
   <br>Link: https://code.visualstudio.com/
4) VSCode Extension - "Extension Pack for Java"
5) VSCode Extension - "JavaFx Support"

**Steps:**
1) Install and Setup VSCode IDE <br/><br/>
2) In VSCode, click on "Extensions", search and install the below extensions
   <br>&emsp;- Extension Pack for Java
   <br>&emsp;- JavaFx Support
   <br/><br/>
4) Download source code from the link provided: source_code_link <br/><br/>
5) In VSCode, click on "File" -> "Open Folder", and select the downloaded source code <br/><br/>
6) In source code, go to _.vscode_ sub directory, and open _launch.json_ file <br/><br/>
7) In _launch.json_ file, find "vmArgs" under "configurations", change the address path to the address path of your javafx-sdk/lib, following the example below
   <br>_"vmArgs": "--module-path **\"C:/address/path/to/your/javafx-sdk/lib\"** --add-modules javafx.controls,javafx.fxml"_ <br/><br/>
8) In source code, go to _.vscode_ sub directory, and open _settings.json_ file <br/><br/>
9) In _settings.json_, find "java.project.referencedLibraries", change the address path to the address path of your javafx-sdk .jar file, following the example below
   <br>&emsp;_"lib/**/*.jar"_,
   <br>&emsp;_"c:\\address\\path\\to\\this\\javafx-jar-file\\javafx.base.jar"_,
   <br>&emsp;_"c:\\address\\path\\to\\this\\javafx-jar-file\\javafx.controls.jar"_,
   <br>&emsp;_"c:\\address\\path\\to\\this\\javafx-jar-file\\javafx.fxml.jar"_,
   <br>&emsp;_"c:\\address\\path\\to\\this\\javafx-jar-file\\javafx.graphics.jar"_,
   <br>&emsp;_"c:\\address\\path\\to\\this\\javafx-jar-file\\javafx.media.jar"_,
   <br>&emsp;_"c:\\address\\path\\to\\this\\javafx-jar-file\\javafx.swing.jar"_,
   <br>&emsp;_"c:\\address\\path\\to\\this\\javafx-jar-file\\javafx.web.jar"_,
   <br>&emsp;_"c:\\address\\path\\to\\this\\javafx-jar-file\\javafx-swt.jar"_ <br/><br/>
10) In VSCode, click on "Run" -> "Run without debugging" to run the code
