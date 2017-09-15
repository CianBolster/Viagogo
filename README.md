# Viagogo
Coding challange for Viagogo

Instructions for use:
Programmed in the IntelliJ ide. Simply use Intellj's inbuilt github pull feature and then say yes to the prompt about setting up using the
IDEA after that just press the play button in at the top. After that click in the newly opened window on the bottom and enter your
coordinates and press enter.
Another way to run it is to use the jre and jdk by compiling the three classes and the running the Main file while they are all located in 
the same folder

One assumption was made in that the user would input the data in the format asked and in the range asked.

Larger world?
The possiblty of larger world size is taken into account with the variables worldSizeX and worldSizeY. Assigning these a different value 
will increase the size of your world. If this also meant that there was going to be a larger number of events then a different sorting
algorithim maybe looked into. However in some cases bubble sort may be the most efficient.

Multiple Events in the same location?
Changing the 2d array into a normal array in the AreaOfEvents class along with the check for freeCoord in the assignCoord method will allow 
for events to occur in the same location. Along with any references to the 2d array in the getSortedEventsList method to the newly created
array and the program will run smoothly.

