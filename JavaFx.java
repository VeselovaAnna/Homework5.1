package Homework5to1;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.Random;
import java.util.Scanner;

public class JavaFx extends Application {
    private static final int WIDHT = 600;
    private static final int HEIGHT = 600;
    public static int circlesQuantity;
    public static int minRadiusCircles;
    public static int maxRadiusCircles;
    public static int nextCircles;


    @Override

    public void start(Stage primaryStage) throws Exception {

        Canvas canvas = new Canvas(WIDHT, HEIGHT);

        Pane root = new Pane();
        Scene scene = new Scene(root, WIDHT, HEIGHT);
        root.getChildren().add(canvas);
        primaryStage.show();

        final GraphicsContext graphicsContext = canvas.getGraphicsContext2D();
        drawSnowMan(graphicsContext);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void drawSnowMan(GraphicsContext gc) {
        Random random = new Random();

        for (int circlesNumbers = circlesQuantity - 1; circlesNumbers > 0; circlesNumbers--) {
            int bodyRadius = random.nextInt(maxRadiusCircles - minRadiusCircles) + minRadiusCircles;
            int drawAtCentreX = WIDHT / 2 - bodyRadius / 2;
            int drawAtCentreY = HEIGHT - bodyRadius - nextCircles;

            gc.strokeOval(drawAtCentreX, drawAtCentreY, bodyRadius, bodyRadius);
            nextCircles = nextCircles + bodyRadius;

            int R = random.nextInt(255);
            int G = random.nextInt(255);
            int B = random.nextInt(255);
            gc.setStroke(Color.rgb(R, G, B));
        }
        //draw a snowman's head
        int headRadius = 100;
        int drawAHeadCentreX = WIDHT / 2 - headRadius / 2;
        int drawAHeadCentreY = HEIGHT - headRadius - nextCircles;

        gc.strokeOval(drawAHeadCentreX, drawAHeadCentreY, headRadius, headRadius);

        int R = random.nextInt(255);
        int G = random.nextInt(255);
        int B = random.nextInt(255);
        gc.setStroke(Color.rgb(R, G, B));

        //draw a snowman's nose
        int noseRadius = 10;
        int drawANoseCentreX = WIDHT / 2 - noseRadius / 4;

        gc.strokeOval(drawANoseCentreX, HEIGHT - headRadius - nextCircles + headRadius * 0.5,
                noseRadius, noseRadius);
        gc.setStroke(Color.rgb(R, G, B));

        //draw the left eye
        int eyeLeftRadius = 10;

        gc.strokeOval(WIDHT / 2 - eyeLeftRadius / 2 - headRadius + headRadius * 0.8,
                HEIGHT - headRadius - nextCircles + headRadius * 0.2, eyeLeftRadius, eyeLeftRadius);
        gc.setStroke(Color.rgb(R, G, B));

        //draw the right eye
        int eyeRightRadius = 20;

        gc.strokeOval(WIDHT / 2 - eyeRightRadius / 2 - headRadius + headRadius * 1.2,
                HEIGHT - headRadius - nextCircles + headRadius * 0.2, eyeRightRadius, eyeRightRadius);
        gc.setStroke(Color.rgb(R, G, B));


    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(" How many circles ");
        circlesQuantity = scanner.nextInt();
        System.out.println(" Еnter the min radius of the circle ");
        minRadiusCircles = scanner.nextInt();
        System.out.println(" Еnter the max radius of the circle ");
        maxRadiusCircles = scanner.nextInt();

        launch(args);
    }
}
