/*
 * ==============================================================
 *   Project: 
 *   Author: KamGlitchd
 *   Created on: Nov 10, 2025
 * 
 *   Description: ApplicationLogic — 
 * 
 *   License: Personal / Educational Use Only
 *   (Modify and reuse freely for learning or personal work)
 * ==============================================================
 */



package mooc.logic;
import mooc.ui.UserInterface;

public class ApplicationLogic {
    private UserInterface ui;
    public ApplicationLogic(UserInterface ui) {
        this.ui = ui;    
    }

    public void execute(int times) {
        for (int i = 0; i < times; i++) {
            System.out.println("Application logic is working");
            ui.update();
        }
    }
}
