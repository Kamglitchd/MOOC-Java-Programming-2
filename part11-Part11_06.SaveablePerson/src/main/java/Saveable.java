/*
 * ==============================================================
 *   Project: 
 *   Author: KamGlitchd
 *   Created on: Nov 10, 2025
 * 
 *   Description: Saveable — 
 * 
 *   License: Personal / Educational Use Only
 *   (Modify and reuse freely for learning or personal work)
 * ==============================================================
 */

/**
 *
 * @author victo
 */
public interface Saveable {
    public void save();
    public void delete();
    public void load(String address);
}
