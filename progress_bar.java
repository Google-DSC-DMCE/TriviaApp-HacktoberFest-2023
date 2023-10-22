public class ProgressBarExample {
    public static void main(String[] args) {
        int totalQuestions = 10;  // Total number of questions

        for (int question = 1; question <= totalQuestions; question++) {
            // Simulate solving a question (you can replace this with your actual logic)
            solveQuestion(question);

            // Calculate the progress percentage
            int progress = (question * 100) / totalQuestions;

            // Print the progress bar
            printProgressBar(progress);
        }
    }

    private static void solveQuestion(int questionNumber) {
        // Simulate solving a question (replace with your actual logic)
        try {
            Thread.sleep(1000);  // Simulate a delay
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Question " + questionNumber + " solved.");
    }

    private static void printProgressBar(int progress) {
        System.out.print("Progress: [");

        int totalBars = 50;  // Total number of progress bar segments
        int completedBars = (progress * totalBars) / 100;

        for (int i = 0; i < totalBars; i++) {
            if (i < completedBars) {
                System.out.print("=");
            } else {
                System.out.print(" ");
            }
        }

        System.out.print("] " + progress + "%");
        System.out.print("\r");  // Move the cursor back to the beginning of the line
    }
}
