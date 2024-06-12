package org.odm;

import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.HashMap;
import java.util.Scanner;


public class Main { static HashMap<String, Circle> supportedCircles = new
        HashMap<String, Circle>();

    public static void main(String[] args) {  loadDefaultSupportedCircles();
    loadPluginCircles();
    listAllSupportedCircle();
    drawCircle(); } private static void loadDefaultSupportedCircles() {
    Circle basic = new BasicCircle();
    String name_of_basic = basic.getName();
    supportedCircles.put(name_of_basic, basic);
}

    private static void loadPluginCircles() {
        try {
            File file = new File("./library/plugins/");
            File[] plugins = file.listFiles();
            for (File plugin_jar : plugins) {
                try {
                    URL url = plugin_jar.toURI().toURL();
                    URL[] urls = new URL[] { url };

                    ClassLoader cl = new URLClassLoader(urls);
                    Class<Circle> cls = (Class<Circle>) cl.loadClass("plugins.PluginCircle");Circle circle = cls.newInstance();
                    supportedCircles.put(circle.getName(), circle);
                } catch (Exception e) {
                    System.out.println("Error while adding plugin " + plugin_jar.getName());
                }
            }} catch (Exception e) {
            System.out.println("Adding Plugins Failed Due To : " + e.toString());
        }}

    private static void listAllSupportedCircle() {
        System.out.println("Supported Circle Types");
        System.out.println("======================");

        int i=0;
        for (Object obj : supportedCircles.values().toArray()) {
            i++;
            Circle circle=(Circle)obj;
            System.out.println(i+". "+circle.getName());
        }

    }

    private static void drawCircle() {
        Scanner scanner=new Scanner(System.in);

        System.out.print("\nEnter Circle Type : ");
        String user_pref=scanner.nextLine();

        System.out.print("Enter Circle Radius : ");
        int radius=scanner.nextInt();

        scanner.close();

        Circle user_pref_circle=supportedCircles.get(user_pref);

        if (user_pref_circle==null || radius<=0) {
            System.out.println("Unsupported Circle Options");
            return;
        }

        user_pref_circle.drawCircle(radius);

    }}