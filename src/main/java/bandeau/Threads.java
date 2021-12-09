package bandeau;

import java.lang.reflect.Constructor;
import java.util.LinkedList;
import java.util.List;

class Threads extends Thread{
    
    private List<ScenarioElement> myElements = new LinkedList<>();
    private Bandeau monBandeau;
    
    public Threads(Bandeau b, List<ScenarioElement> pList) {
        this.monBandeau = b;
        this.myElements = pList;
    }

    public void run() {
        // Equivalent de “main” pour un thread
        synchronized(monBandeau){
        for (ScenarioElement element : myElements) {
            for (int repeats = 0; repeats < element.repeats; repeats++) {
                element.effect.playOn(monBandeau);
            }
        }}
    }
}
