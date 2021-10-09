package cn.itcast.web.servlet;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

@WebServlet("/checkCodeServlet")
public class CheckCodeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int width = 95;
        int height = 30;

        //1. Create an object to represent a picture in memory (captcha image object)
        BufferedImage image = new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);

        //2. Beautify the picture
        //2.1 fill background color
        Graphics g = image.getGraphics(); //Brush object
        g.setColor(Color.PINK); //Set brush color
        g.fillRect(0,0,width,height); //Fill rectangle

        //2.2 drawing borders
        g.setColor(Color.BLUE);
        g.drawRect(0,0,width-1,height-1);

        String str = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwsyz0123456789";
        //Generate random corner
        Random r = new Random();
        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <= 4; i++) {
            int index = r.nextInt(str.length());
            //Get character
            char ch = str.charAt(index); //Random characters
            sb.append(ch);
            //Write verification code
            g.drawString(ch + "", width/5*i, height/2);
        }
        String checkCode_session = sb.toString();
        //Store the verification code into the session
        request.getSession().setAttribute("checkCode_session",checkCode_session);

        //Draw interference line
        g.setColor(Color.GREEN);
        //Randomly generated coordinate points
        for(int i = 0; i < 10; i++) {
            int x1 = r.nextInt(width);
            int x2 = r.nextInt(width);
            int y1 = r.nextInt(height);
            int y2 = r.nextInt(height);
            g.drawLine(x1, x1, y1, y2);
        }
        //3. Output the pictures to the page for display
        ImageIO.write(image,"jpg",response.getOutputStream());

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}