<div align="center">
    <img src="readmeResources/clown-logo.svg" alt="clown-logo" width="110">
  <h3 align="center">Bozo's Revenge</h3>
  

[![Arduino](https://img.shields.io/static/v1?label=&message=Arduino&color=377F83&logo=arduino&logoColor=white)](https://www.arduino.cc)
[![C++](https://img.shields.io/static/v1?label=&message=C%2B%2B&color=3F78A9&logo=cplusplus)](https://www.cplusplus.com)
[![Java](https://img.shields.io/static/v1?label=&message=Java&color=important&logo=data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAADIAAAAyCAMAAAAp4XiDAAACiFBMVEUAAAD///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////9GjYEZAAAA13RSTlMAAQIDBAUGBwgJCgsMDQ4PEBESExUWFxgZGhwdHh8gISIjJCYnKSorLC0uLzAyMzY3ODk6Oz0+P0BBQkNERUdISUpLTE1QU1RVVllaW1xeX2BjZGVnaGlqa2xtb3BxcnN0dXZ4eXt8fX+AgYOEhYaHiImKi4yNjo+QkpOVlpeZm5ydnp+goqOkpaipqquur7CxsrO0tba4ubu8vb6/wMHCw8TFyMnKy8zNzs/R0tPU1dbX2Nna29zd3uDh4uTl5ufo6err7O3u7/Dx8vP09fb3+Pn6+/z9/oRmv3cAAAPISURBVHjalJMDm+RAFEVPKkn32rZt27Zt27Zt27Ztjd3d9+esMTvMnA/hKbz7igwwLB+OS1ZwWPUeTNaU2aqLTRYwbNUwHLJCtsealyUlG12k2ThZMfyPpR7eFeMn70UprBCW52LR5JWiNBXX520aH8yUInUaY4HlySh+QaEo3SsIjBrpwXFpEKb4OF3PR66Bn5LaYGduNJdig9oLfe7rVl6czI3KCYqRZpP/iLQF/GSCBVcVJfWmbpi0HHweyjtIsUpqRb2QtBEvSVpcUbx6kueJdBcvfWwoHC7dteijKA3GjxelaKR03WWmYtUPFy+Yh9LrAoxXnC56S95hhRJUm44KBDQWH5ljU1VBDSHfayUoqqSnijksk/bBOMUnaooXBRvnlj6WgtOK+q5aFpDRnixj29kp91lDoOhbaddPxXZtY7ukBsvns3/NU13P8TFNGoz7e4ZUqSZ7lbOI61AlvhfM0G0HG4dcnWZtXFoPkzpEWszYdSss4m4NclOuKjxWNfwWFH8mSeqPk9IodUnSs5kNc/OLyg8qAWSrX6xmi6lvpUDJFGvzsVIRgZjp9WtVq1y5UqVq1Wu079Zu6OR1lwMvigPlP4Q0Bn+K1NtKCkpSQnxcXFx88Oe9IubkwnWys0laj5tyZY0ORug/Ym+v7ugHg02259ISfKn3X6Rur91Htx89evTg9nVzh7YuBZDdxtisVqLqpG4F26XMtkel+UeeZh3AcmCapAmpDQz54xS2YnTPDq1bd+gxfM628y9D2lYEWCzF98eQCgv7pFKxibKXFb66FLZFagzWqMvvQ/pF6Mv9o0t7V83OwesDioKT2vjTr8Vb9pk0a/aUYd0bl/sVg8kBOAbSUfLPfzSWv5TMi2vA+G3Swrg+f06WSPHH10wd3LfvsMX7b8c9ag2WbYFJLTm/g52jQFB/CUp7/zS/SR2jW7pxjxnNWB6jZESfGWWwjWPlyYVJYTTd8Sigp4c6QYnuc3eeu/P02eNrBxb1rAi2DdDhlt9KnqRLV0knKyZ/5Vr8pXDjiW9UEZK98jNDEUmvDy8f0b5GibzZzJ/X+UtWa9Zz0voLYZL606k4Jtm6cv+JPRj+8t6lsyePHDlx7tLdF2G/Y706PKezQf8dMQOdt9z6GFIqvtzZM61NISrMC2gMToqKQYlv0/UtKiyuqqquq2+oqyzNjA90s9CUl9F0r94JjK0gBkZsEaO2aPWO3ds3rFq2cPasmTNmzlm88RDE5iXJEqD6HLNoZWMTN/TNbJ2z4QDciftWTSoPtZQGBysUAADdv7ejz5nomQAAAABJRU5ErkJggg==)](https://www.java.com/en)
[![Eclipse](https://img.shields.io/static/v1?label=&message=Eclipse&color=2C2255&logo=eclipse&logoColor=white)](https://www.eclipse.org/ide)
  
  A group project game that utilizes Java-Arduino communication through Zigbee wireless technology. The premise of the game is to test the player's reaction speed to auditory and visual cues, with the cues representing the strikes of Bozo the clown
</div>

## :joystick: Hardware Requirements 
Three main devices work together in sync to make the game work:
#### A. Game Box
This is where the player inserts their hand; it is where Bozo strikes. Attached to the box:
1. Lilypad Microcontroller
2. Xbee Breakout Board
3. Battery Pack
4. Lilypad Buzzer
5. Lilypad LED
6. Lilypad Button

#### B. Glove
This is the glove worn by the player. Attached to the glove:
1. Lilypad Microcontroller
2. Xbee Breakout Board
3. Battery Pack
4. Lilypad Accelerometer

#### C. Computer running the Java code
This is where the Java code would be running. Attached to the computer would be:
1. Xbee Explorer

#### All hardware required in total
1.	Xbee Breakout Board (x2)
2.	Lilypad Microcontroller (x2)
3.	Battery Pack (x2) 
4.	XBee Explorer
5.	Lilypad Buzzer 
6.	Lilypad LED
7.	Lilypad Button
8.	Lilypad Accelerometer
9.	A computer running Java code

#### Hardware diagram:
<i>Note: Dark mode would make some parts of the images hard to view. If that is the case then click the desired image to view it raw (Transparent background replaced with chessboard pattern)</i>

<div align="center">

Hardware Diagram for the glove
    
<img src="readmeResources/Glove Diagram.svg" alt="Glove Hardware Diagram" width="500">
<br>
    
Hardware Diagram for the game box 
    
<img src="readmeResources/Box Diagram.svg" alt="Box Hardware Diagram" width="500">
    
<br>
    
Hardware diagram for the computer running the Java code
    
<img src="readmeResources/Computer Diagram.svg" alt="Computer Hardware Diagram" width="500">
    
<br>
</div>

[Video with the hardware being used](https://www.youtube.com/watch?v=EYyUOU9vF-Y)


## :flight_departure: How To Run
#### Multi-platform:
1. Install [Eclipse](https://www.eclipse.org/downloads/) on your computer
2. In Eclipse, go to Help --> Install New Software --> In "work with", paste `https://download.eclipse.org/egit/updates` --> Select the git packages --> Wait for installation to finish
3. Open Eclipse preferences, filter with "git", go to configurations, add 2 entries:  
     Key: email, Value: <Your GitHub Email>  
     Key: name, Value: <Your GitHub Username>  
4. File --> Import --> Git --> Project from Git --> Clone URL -->  
    URL: `https://www.github.com/ElixirForge/bozos-revenge`  
    connection: `https`  
    authentication: `your details`  
5. Add `jssc-2.9.0.jar` to path by right clicking it from the list of files in the Eclipse project and adding it to path. This is necessary to access jssc.SerialPort & jssc.SerialPortException
6. Install [Arduino IDE](https://www.arduino.cc/en/software) on your computer
7. Connect the glove's Lilypad microcontroller to the computer, upload the `glove.ino` code to the microcontroller and run it. You can now disconnect the microcontroller since it saves the code and keeps running it
8. Connect the box's Lilypad microcontroller to the computer, upload the `microcontroller.ino` code to the microcontroller and run it. You can now disconnect the microcontroller since it saves the code and keeps running it
9. Confirm that the glove and the box are have their microcontrollers running (Connected to a power source like the battery packs)
10. Run the java program on eclipse
11. Play!

## :question: How To Play:
#### 1. Choose your difficulty
Once everything is running according to the How To Run section, the Java code will show
```
Please enter the number corresponding to your desired difficulty level:
1. Easy
2. Medium
3. Hard
```
Type in the number into the Java console and press enter. The game will then commence and the player must hold the button connected to the box's microcontroller.

#### 2. Avoid Bozo's strikes
A. The LED on top of the box will be switching between green & red at fixed intervals. Only during the time in which the LED is red is there a possibility for an attack; a swing sound plays to indicate that  
B. Once the swing sound plays, the player has a small grace period in which they can unpress the button. The speed at which the hand moves after the button is unpressed indicates the amount of points earned; the accelerometer on the glove is responsible for checking said metric  
C. As more points are earned, the faster the LED switches colors and the harder the game becomes  
D. If the player fails to remove their hand in time to avoid a strike from Bozo (After a sound cue during a red LED cycle), they lose the game  
E. If the player takes away their hand unncessarily, unpressing the button, they also lose the game

#### 3. Game Over
At the end of the game, the player can view their score and may choose their desired difficulty level to play again.

## :jigsaw: Design Patterns
The main aim of this project was to gain experience with numerous design patterns, multithreading, and message-based architecture. The following design patterns were used:
1. State Pattern --> `microcontroller.ino` `glove.ino` `State.java` `Running.java` `Stopped.java` `StartState.java`  
    Used in both the Arduino & Java code
2. Strategy pattern --> `microcontroller.ino`  
    Used solely in the Arduino code
3. Template Pattern --> `StartGame.java` `StartGameEasy.java` `StartGameMedium.java` `StartGameHard.java`  
    Used solely in the Java code
4. Observer Pattern --> `Observer.java` `Proxy.java` `Subject.java` `Dispatcher.java`  
    Used solely in the Java code

The detailed implementation details behind the design patterns can be found in the comments within the code.
