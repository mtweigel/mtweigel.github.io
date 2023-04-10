[Back to Portfolio](../)

Minimum Overlap Coverage
========================

-   **Class:** CSCI 315
-   **Grade:** A
-   **Language(s):** C++
-   **Source Code Repository:** [mtweigel/Minimum-Overlap](https://github.com/mtweigel/Minimum-Overlap)  
    (Please [email me](mailto:mtweigel@csustudent.net?subject=GitHub%20Access) to request access.)

## Project description

This project is a program that is able to efficiently find the minimum overlap of sets that cover all points. For example, if there are multiple group projects for a class that need to be presented at the end of the semester, the professor must grade every student at least once, but wants to minimize the number grades that must be performed. This project uses sets of digits to represent student IDs ranging from small to large sets of data and finds the minimum overlap of each set. It also records the time it takes to do so and saves the timing data as a plotted graph for viewing so that the efficiency can be measured and observed.

## How to compile and run the program

In order to run this program there are several setup steps:

1. Enable Windows Subsystem for Linux
- From the start menu, go to "Turn Windows features on or off".
- Scroll down to "Windows Subsystem for Linux" and check the box.
- Restart computer if prompted to.

2. Install a Linux Distribution
- Download Ubuntu from the Microsoft Store.
- Once downloaded, click on Ubuntu to install and choose Unix name and password.

3. More installs!
- Navigate to where the project location is in File Explorer.
- Type "wsl" into the address bar to open the project in the wsl.exe terminal.
- Run theses commands:

```bash
$ sudo apt-get update
$ sudo apt install make
$ sudo apt install g++
$ sudo apt install gnuplot
```

4. Run the program
- To run the program, run various commands from the makefile such as this one:

```bash
$ make small30
```

- Note the time that it took to find the minimum number of elements.
- To view a plot of the timing data, run this command.

```bash
$ make plot
```
- Open output.pdf to view the graph of the timing data.

5. Troubleshooting
- If you have trouble running gnuplot because of libQt5Core.so.5 "missing", try this command:

```bash
$ sudo strip --remove-section=.note.ABI-tag /usr/lib/x86_64-linux-gnu/libQt5Core.so.5
```

## UI Design

To run the program the user will make use of a makefile that simplifies the compile commands. The user is able to run the program against different sizes of data to see how well it performs. For the user can run "make small30" (See Figure 1) and then run "make plot" to plot the timing data onto a pdf graph (See Figure 2). Other more complex options include med30, large30, and large50 (See Figures 3-8). Between running the different data sets, it can be helpful to run "make clean" to reset the data plot file and delete unneeded executables (See Figure 9).

*Fig 1. AFter running make small30.*

![screenshot](/images/minimumoverlap/small30.PNG)

*Fig 2. small30 plot.*

![screenshot](/images/minimumoverlap/small30plot.PNG)

*Fig 3. After runniung make med30.*

![screenshot](/images/minimumoverlap/med30.PNG)

*Fig 4. med30 plot.*

![screenshot](/images/minimumoverlap/med30plot.PNG)

*Fig 5. After running make large30.*

![screenshot](/images/minimumoverlap/large30.PNG)

*Fig 6. large30 plot.*

![screenshot](/images/minimumoverlap/large30plot.PNG)

*Fig 7. After running make large50.*

![screenshot](/images/minimumoverlap/large50.PNG)

*Fig 8. large50 plot.*

![screenshot](/images/minimumoverlap/large50plot.PNG)

*Fig 7. Make clean.*

![screenshot](/images/minimumoverlap/clean.PNG)

## Additional Considerations

Make plot is supposed to open the pdf automatically with xdg-open, but I was unable to get it to work.

[Back to Portfolio](../)
