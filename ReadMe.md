The game "The Path Of The Traveler" is a fantasy survival game. You will have to go through different locations, making a 
choice, literally, between life and death. The penultimate location will not give you a choice at all, but will determine your 
participation. There may be two endings to the game. All characters and events are completely fictional. Any coincidences with real life are PSYOP. 😉

LAUNCHING:

I used Tomcat 10.1.41 to run it.
JAVA version: Openjdk-23 project SDK

BASIC CONFIGURATIONS:
- Application server: Tomcat 10.1.41
- URL               : http://localhost:8080/
- HTTP port         : 8080

- DEPLOYMENT TAB:
- Deploy at the server startup: Final_project_for_module_3:war exploded
- Application context         : /


If there is no **Final_project_for_module_3:war exploded**, try running <span style="color:green">mvn clean install</span> in the maven console.
In the **Deploy at the server startup** field, click **+**, select **Artifact...**, then select **Final_project_for_module_3:war exploded**.
