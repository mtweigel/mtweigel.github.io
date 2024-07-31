[Back to Portfolio](../)

FlickFix Video Editor
===============

-   **Class:** CSCI 497, 498, 499
-   **Grade:** A
-   **Language(s):** C++
-   **Source Code Repository:** [mtweigel/FlickFix](https://github.com/mtweigel/FlickFix)  
    (Please [email me](mailto:matthew.t.weigel@gmail.com?subject=GitHub%20Access) to request access.)
    
## Project description

FlickFix is a free video editing desktop application emphasizing simplicity and ease of use. FlickFix aims to offer an intuitive and user-friendly video editing experience by streamlining the platform to include only the essential features. This approach allows even novice editors to edit videos without feeling intimidated or overwhelmed. Users can access several common features such as video trimming, intro and outro creation, and audio dubbing, all within a user-friendly GUI.

## How to run the program

Get FFmpeg
1. Download FFmpeg: https://www.gyan.dev/ffmpeg/builds/packages/ffmpeg-6.0-essentials_build.zip
2. Extract and move contents to a new directory C:\ffmpeg
3. Go to 'Edit the system environment variables' in Windows.
4. Click on 'Advanced system settings'.
5. Under 'System variables', click 'Path'.
6. Click 'Edit' and 'New'.
7. Add the path C:\ffmpeg\bin

Get K-Lite Codec Pack
1. Download K-Lite Codec Basic: https://codecguide.com/download_k-lite_codec_pack_basic.htm
2. Install with default options.

Install FlickFix
1. Download installer: https://github.com/mtweigel/CSU-Senior-Project/blob/master/FlickFix.exe
2. Install and Run

Note: This is being detected as unsafe by Windows Defender, so you will need to temporarily disable real time virus detection to install. Sketchy, I know but this happens because I have not purchased a digital certificate. 

You should be able to run FlickFix at this point. If not, please contact me with your issue.

## UI Design

Once FlickFix has been opened, users are greeted with a simple, yet clean user interface (UI). See Fig 1.

*Fig 1. The main user interface of FlickFix.*

![screenshot](/images/flickfix/ui.PNG)

### Importing a Video

To import a new video you have several different options. You can import from the menu bar by clicking 'File' -> 'Import', clicking on the center video player, dragging and dropping the video file into the video player, or clicking either the ‘Append Video’ or ‘Prepend Video’ buttons.

Once you have initiated an import, the standard select video file window pops up allowing you to select which video file you want to import. After choosing a file, the program loads the video into the player. See Fig 2.

*Fig 2. After a video has been imported.*

![screenshot](/images/flickfix/FlickFix.PNG)

The application carefully ensures that only valid files can be imported – only mp4, avi, mkv, mov, and wmv video files are accepted by FlickFix. If you attempt to import an invalid file type, you will receive a warning, and the file is not imported. See Fig 3.

*Fig 3. Warning after trying to import an invalid file.*

![screenshot](/images/flickfix/invalidfile.PNG)

In addition to FlickFix being able to import videos of different file types, it can import videos of different resolutions. It can do both because when it imports a video, it automatically converts it to mp4, 1080p for editing within the program. This keeps things consistent and makes the job easier for FFmpeg which handles the editing processes.

### Video Player Controls

FlickFix utilizes standard video controls for its video player which helps to add familiarity to the user interface. See Fig 4. For precise editing, the Seek Forward and Backward buttons are designed to advance or reverse the video by 0.1 seconds with each click. If these buttons are held down, they continuously progress or rewind the video. The video duration slider enables quick adjustments to the video's position, while the volume slider offers control over the audio playback volume. Additionally, the mute button is available to toggle the sound on or off during video playback.

*Fig 4. Video player controls.*

![screenshot](/images/flickfix/playercontrols.PNG)

### Adding New Videos

Adding a new video to a project in FlickFix is very simple. To add a new video after the existing video, you would press the ‘Append Video’ button and choose a video to add. See Fig 5. To add a new video before, you would press ‘Prepend Video’ and do the same. The adding video process adheres to the same file validity checks as when importing a video.

*Fig 5. Window for Importing or Adding new video.*

![screenshot](/images/flickfix/addingvideo.PNG)

### Saving the Project

To perform an initial save on a video project, you can either click 'File' -> 'Save As' or 'File' -> 'Save' in the menu bar. Doing so will pop up a save window where you can choose the location and name of your saved video. After saving and making a new change, pressing 'File' -> 'Save' or 'Ctrl + S' will overwrite the save. If you forget to save and try to close the application, you receive a warning that you have unsaved changes. See Fig 5. Selecting ‘Cancel’ will cancel the exit, ‘Discard’ closes without saving, and ‘Save’ prompts the same save process as before. This same process also happens if you try to import a new video while a video has already been imported.

*Fig 6. Unsaved changes warning.*

![screenshot](/images/flickfix/unsavedchanges.PNG)

### Trimming the Video

To trim the video, press the ‘Trim Video’ button to bring up the trim controls. See Fig 7. Then choose a start point in the video and press the ‘Start Point’ button. Next, choose an end point in the video with the ‘End Point’ button. Then you have the option to either save or remove the selection. Pressing ‘Save’ will keep only the selection and remove the rest of the video, while pressing ‘Remove’ will remove the selection and keep the rest of the video.

*Fig 7. Video trim controls.*

![screenshot](/images/flickfix/trimcontrols.PNG)

### Loading Bar

Any time you perform an edit such as adding a new video or trimming the video, a simple loading bar will pop up to let you know that the edit is processing. See Fig 8. 

*Fig 8. Loading bar.*

![screenshot](/images/flickfix/loadingbar.PNG)

### Undoing and Redoing Changes

Any time you make a change that you want to revert, you can either press 'Edit' -> 'Undo' or 'Ctrl + Z' to undo the edit. To redo an edit that you have undone, press 'Edit' -> 'Redo' or 'Ctrl + Y' to redo the edit. 

### Adding Audio

The process of adding audio starts by pressing the ‘Add Audio’ button. This brings up the controls to add audio. See Fig 9. To choose the point where you want the audio to begin, press the ‘Start Point’ button. Then press the second ‘Add Audio’ button to bring up the window to choose an audio file. Only mp3 files are accepted by this window.

*Fig 9. Add audio controls.*

![screenshot](/images/flickfix/addaudio.PNG)

### Add Intro/Outro

You also have the option to add a simple intro or outro to your video. To do so press either the ‘Add Intro’ or ‘Add Outro’ button, the only difference being that it adds it to either the beginning or end of the video. Pressing one of these buttons will bring up an intro/outro creator. See Fig 10. This creator allows you to change the text, font style and size, text color, background color, and duration in seconds. Any changes that you make are shown in real time in a preview on the right.

*Fig 10. Intro/Outro creator.*

![screenshot](/images/flickfix/addaudio.PNG)

### Taking a Screenshot

Another feature that FlickFix provides is the ability to take a screenshot of a video. To do so, press the ‘Take Screenshot' button and choose a name and location for the screenshot. Pressing ‘Save’ saves a PNG of the still image from the video.

### Dark/Light Mode

FlickFix has one theme customization option, the ability to change the user interface to Dark mode or back to Light mode. To do so, press 'Options' -> 'Theme' -> 'Dark mode' or 'Light mode'. See Fig 11. This change updates all of the UI including the loading bar and Intro/Outro creator and is persistent even after closing the application.

*Fig 11. Intro/Outro creator.*

![screenshot](/images/flickfix/introcreator.PNG)

### The Tutorial

There is also a FlickFix tutorial available for people who would like to know how to use each feature of the application. To view it press 'Help' -> 'Tutorial'. This brings up a separate tutorial window with a side menu bar for each feature. See Fig 12. Pressing the various features in the side menu brings up the tutorial for each one.

*Fig 11. The FlickFix tutorial.*

![screenshot](/images/flickfix/tutorial.PNG)

## Additional Considerations

- The loading bar is not directly connected to the progress of the process, but instead, simply progresses while the process is running and either finishes when the process finishes or hangs at 99% if it reaches the end before the process finishes. In the future, I will make the loading bar more accurate to the actual process.
- To keep track of previous edits to undo and redo, the program creates a new temp video file every time an edit is made and numbers them. This allows it to easily recall previous edits. Once the video has been discarded or the program closes, these temp files are deleted.
- In the future, I plan to add the ability to accept more audio file formats than mp3 and an audio end point button since currently, it adds in the entire audio file or until the video ends.

[Back to Portfolio](../)
