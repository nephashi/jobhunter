public class Test {

    static void func(Integer a) {
        a++;
        int ii = 0;
    }

    public static void main(String[] args) {
        String str = "To further illustrate the advantage of our model, we trained both\n" +
                "models by using the data of the first 24 subjects, where each subject has\n" +
                "only one sample (namely: nm-01 under 90°) in the gallery. Both models\n" +
                "are trained for 80 epochs using the RMSprop optimizer with a batch size\n" +
                "of 2. We use ReLU as the activation function and Softmax for the\n" +
                "classification. The training accuracy and the loss during the convergence\n" +
                "of both models to the local minimum are shown in Fig. 4(a)\n" +
                "and (b). Our model converged efficiently with approximately 20\n" +
                "epochs, where the typical CNN took an estimated 75 epochs.";

        System.out.println(str.replace('\n', ' '));
    }
}
