
import javax.sound.sampled.*;

/*
 * SourceDataLine = Input
 * TargetDataline = Ouput
 */
public class Main {
    static Mixer micInput;
    static TargetDataLine line;
    
    public static void main(String[] args) throws LineUnavailableException {

        final AudioFormat format = new AudioFormat(44100,16,1,true,true);

        final Window WINDOW = new Window((Mixer newMix) -> {
            micInput = newMix; 
            // get SourceDataLine

            try {
                line = AudioSystem.getTargetDataLine(format);
            } catch (LineUnavailableException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

            System.out.println(line.available());

            System.out.println("updated selected input to " + newMix.getMixerInfo().getName());
            // System.out.println(line.available());
        });

        System.out.println("Ready");
        
        // for(Mixer.Info m : AudioSystem.getMixerInfo()){
        //     System.out.println(m.getName());
        // }



    }

}
