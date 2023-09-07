package src.main.java;

import javax.sound.sampled.*;

public class Main {
    
    public static void main(String[] args) throws LineUnavailableException {

        final Window WINDOW = new Window();

        System.out.println();
        
        for(Mixer.Info m : AudioSystem.getMixerInfo()){
            System.out.println(m.getName());
        }

    }

}
