package test;

import java.awt.Graphics;
import java.awt.GraphicsEnvironment;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JEditorPane;
import javax.script.*;

public class JavaScriptPie {
	public static void main(String[] args) {
        String html = "<!DOCTYPEhtml><html><head><scripttype=\"text/javascript\" src=\"https://www.gstatic.com/charts/loader.js\"></script>     <script type=\"text/javascript\">       google.charts.load(\"current\", {packages:[\"corechart\"]});       google.charts.setOnLoadCallback(drawChart);       function drawChart() {         var data = google.visualization.arrayToDataTable([           ['Task', 'Hours per Day'],           ['Passed',     11],                    ['Failed', 2],           ['Skipped',    7]         ]);         var options = {           title: 'My Daily Activities',           is3D: true,         };         var chart = new google.visualization.PieChart(document.getElementById('piechart_3d'));         chart.draw(data, options);       }     </script>   </head>   <body>     <div id=\"piechart_3d\" style=\"width: 500px; height: 300px;\"></div>   </body> </html>";
        int width = 600, height = 500;
        // Create a `BufferedImage` and create the its `Graphics`
        BufferedImage image = GraphicsEnvironment.getLocalGraphicsEnvironment()
                .getDefaultScreenDevice().getDefaultConfiguration()
                .createCompatibleImage(width, height);
        Graphics graphics = image.createGraphics();
        // Create an `JEditorPane` and invoke `print(Graphics)`
        JEditorPane jep = new JEditorPane("text/html", html);
        jep.setSize(width, height);
        jep.print(graphics);
        // Output the `BufferedImage` via `ImageIO`
        try {
            ImageIO.write(image, "png", new File("/Users/jagannath/Documents/eclipse 3/com.mobile.simplilearn/ErrorScreenShot/Image.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}