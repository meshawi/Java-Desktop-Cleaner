package s5;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

public class DesktopCleaner {

    public static void main(String[] args) {
        // Entry point of the program, calls the method to clean the desktop
        cleanDesktop();
    }

    // Method to clean the desktop
    public static void cleanDesktop() {
        // Specify the desktop path
        String desktopPath = System.getProperty("user.home") + "/Desktop/JP_Test";

        // Create folders for different file types
        String[] folders = {"Documents", "Images", "Videos", "Others"};

        // Loop through the array of folders and create each one
        for (String folder : folders) {
            createFolder(desktopPath, folder);
        }

        // Get a list of files on the desktop
        File desktop = new File(desktopPath);
        File[] files = desktop.listFiles();

        // Check if the list of files is not empty
        if (files != null) {
            // Iterate through each file on the desktop
            for (File file : files) {
                // Check if it's a file (not a directory)
                if (file.isFile()) {
                    // Move the file to its appropriate folder
                    moveFile(file, desktopPath);
                }
            }
            // Display a message when the cleaning process is complete
            System.out.println("Desktop cleaning complete!");
        } else {
            // Display an error message if there is an issue accessing desktop files
            System.out.println("Error accessing desktop files.");
        }
    }

    // Method to create a folder with a given name in a specified parent path
    private static void createFolder(String parentPath, String folderName) {
        File folder = new File(parentPath, folderName);
        // Check if the folder doesn't exist, then create it
        if (!folder.exists()) {
            folder.mkdir();
        }
    }

    // Method to move a file to its appropriate folder
    private static void moveFile(File file, String desktopPath) {
        // Determine the file type based on its extension
        String fileType = getFileType(file.getName());
        // Get the destination folder based on the file type
        String destinationFolder = getDestinationFolder(fileType);
        // Get the source and destination paths
        Path sourcePath = file.toPath();
        Path destinationPath = new File(desktopPath + "/" + destinationFolder + "/" + file.getName()).toPath();

        try {
            // Move the file to the destination folder
            Files.move(sourcePath, destinationPath, StandardCopyOption.REPLACE_EXISTING);
            // Display a message indicating the file movement
            System.out.println("Moved: " + file.getName() + " to " + destinationFolder);
        } catch (IOException e) {
            // Display an error message if there is an issue moving the file
            System.out.println("Error moving file: " + file.getName());
            e.printStackTrace();
        }
    }

    // Method to get the file type based on its extension
    private static String getFileType(String fileName) {
        int dotIndex = fileName.lastIndexOf('.');
        // Return the file type or "Others" if no extension is found
        return (dotIndex == -1) ? "Others" : fileName.substring(dotIndex + 1);
    }

    // Method to get the destination folder based on the file type
    private static String getDestinationFolder(String fileType) {
        // Switch statement to determine the destination folder based on file type
        switch (fileType.toLowerCase()) {
            case "txt":
            case "doc":
            case "dox":
            case "pdf":
                return "Documents";
            case "jpg":
            case "jpeg":
            case "png":
                return "Images";
            case "mp4":
            case "avi":
            case "mkv":
                return "Videos";
            default:
                return "Others";
        }
    }
}