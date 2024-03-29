public class Hikenite {
    private static boolean firstRun = true; // Set this to true initially

    public static void main(String[] args) {
        if (firstRun) {
            // Execute firstrun.py
            try {
                Process process = new ProcessBuilder("python", "firstrun.py").start();
                process.waitFor();
            } catch (IOException | InterruptedException e) {
                System.err.println("Error executing firstrun.py: " + e.getMessage());
            }

            // Set the variable to false after executing firstrun.py
            firstRun = false;
        } else {
            // Execute hikerload.class
            try {
                Process process = new ProcessBuilder("java", "hikerload").start();
                process.waitFor();
            } catch (IOException | InterruptedException e) {
                System.err.println("Error executing hikerload.class: " + e.getMessage());
            }
        }
    }
}
