package novamobile.ch;

import android.app.Activity;
import android.app.FragmentManager;
import android.os.Bundle;

public class MainActivity extends Activity implements Communicator {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    @Override
    public void respond(String data) {
        FragmentManager manager= getFragmentManager();

        // retrouver la reference du Fragement se trouvant dans le fichier xml du main
        //et avoir acces à la classe Java du Fragment en question
       FragmentB f2= (FragmentB) manager.findFragmentById(R.id.fragment2);
       f2.changeText(data);




    }
}
