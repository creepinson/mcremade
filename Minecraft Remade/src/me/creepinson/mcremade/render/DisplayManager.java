package me.creepinson.mcremade.render;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.ContextAttribs;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.PixelFormat;

import me.creepinson.mcremade.util.UtilsMain;

public class DisplayManager {
    private static final int WIDTH = 1280;
    private static final int HEIGHT = 720;
    private static final int FPS_CAP = 120;
    public static final UtilsMain utils = new UtilsMain();
	public static void createDisplay(){
		ContextAttribs attribs = new ContextAttribs(4,4);
  attribs.withForwardCompatible(true);
  attribs.withProfileCompatibility(true);
  
		
		
		try {
		Display.setDisplayMode(new DisplayMode(WIDTH, HEIGHT));
		Display.create(new PixelFormat(), attribs);
		Display.setTitle("Minecraft Remade " + "V" + utils.VERSION);
	} catch (LWJGLException e) {
		
		e.printStackTrace();
	}
	
		
		GL11.glViewport(0, 0, WIDTH, HEIGHT);
	}
	
	
	public static void updateDisplay(){
		
		Display.sync(FPS_CAP);
		Display.update();
	}
	
	public static void closeDisplay(){
		
		Display.destroy();
		
	}
	
	
}
