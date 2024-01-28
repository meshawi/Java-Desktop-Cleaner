# Desktop Cleaner

This Java-based Desktop Cleaner is a simple utility designed to organize files on your desktop by automatically sorting them into designated folders based on their file types. It was developed as part of a college project during the 5th semester at **Imam Muhammad ibn Saud University**.

## Features

- Automatically scans and organizes desktop files into predefined folders.
- Supports sorting files into categories like:
  - **Documents** (`.txt`, `.doc`, `.docx`, `.pdf`)
  - **Images** (`.jpg`, `.jpeg`, `.png`)
  - **Videos** (`.mp4`, `.avi`, `.mkv`)
  - **Others** (any files that do not match the above categories)
- Displays progress in the console, showing the file movement process.

## How It Works

1. **Folder Creation**: When run, the program creates four folders on the desktop (or a designated path): `Documents`, `Images`, `Videos`, and `Others`.
2. **File Sorting**: It then scans the desktop for any files and moves them to the appropriate folder based on their extension.
3. **File Handling**: If a file extension does not match any of the predefined types, it is moved to the `Others` folder.

## Project Structure

- `DesktopCleaner.java`: Main source code for the project.
- `Desktop_cleaner.pdf`: Detailed explanation of the project's functionality and design choices.

## Installation and Usage

1. **Prerequisites**: Ensure you have Java installed on your machine.
   - To verify if Java is installed, run:
     ```bash
     java -version
     ```
2. **Compilation**: Open a terminal or command prompt in the folder containing the `DesktopCleaner.java` file, then compile it with:
   ```bash
   javac DesktopCleaner.java
    ```
3. **Execution**: Run the compiled Java program:
   ```bash
    java DesktopCleaner
    ```
4. **Results**: The desktop will be organized with files moved into appropriate folders, and the process will be logged in the console.

## Customization

- **Change Desktop Path**: The code currently uses a `JP_Test` folder on the desktop for testing. You can change this to your actual desktop path by modifying the `desktopPath` variable in the `cleanDesktop()` method:
  ```java
  String desktopPath = System.getProperty("user.home") + "/Desktop";
    ```
## Error Handling
- If the program encounters an error while accessing or moving files, it will print the error details in the console, ensuring that you are aware of what went wrong.

## Author
[Mohammed Aleshawi] 5th Semester Project at Imam Muhammad ibn Saud University