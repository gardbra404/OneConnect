This application is built through the use of the tool Gradle. If you do not have Gradle installed, the instructions can be found here: https://gradle.org/install/
Once Gradle has been installed, you can start the application in one of two ways.
Option 1: Command Line Interface
	Open a terminal or command prompt and navigate to the product folder (OneConnect).
	
	Once in the folder, enter gradle bootrun, this will start the application and the Tomcat server
	
	Once the application has started (please note, the execution loading bar in the terminal will not hit 100%, it is running at 
	approximately 75%) enter https://localhost:8443 into your preferred browser
	
	Use the app as you please.
	
	To close the app, kill the process in the terminal
Option 2: intelliJ
	In intelliJ, select import project (file > new > project from existing source)
	Open the Gradle task bar on the right side of the screen and then click the execute task button on the window that appears (the 
	button looks like an elephant)
	
	In the text box that appears, type bootRun and then click enter, this will start the application (note, once this has been done, 
	the application can be later started by clicking the green start button on the top of the screen)
	
	Once the application is running (once again, it will not finish), enter https://localhost:8443 into the browser of your choice.
	
	To kill the process, simply close the run window at the bottom on the screen

Notes regarding the use of this application:
	Because this utilizes HTTPS, on boot up the browser will most likely warn you that this site may not be safe due to an 
	unrecognized security key, simply tell it you wish to continue.
	
	Due to how security is handled in this application, the use of the back and forward buttons in the browser is not advised, 
	instead use the in app links for navigation.
	
	Login info for an account with student and admin roles:  username: "gard6748", password: "Hello123"
	Login info for an account with teacher and parent roles: username: "asdf2222", password: "test"
	
	All user information to access the application is contained in /src/main/resources/Database/Login.json
	
	
