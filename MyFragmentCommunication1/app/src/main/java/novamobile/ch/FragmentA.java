package novamobile.ch;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by film on 23.04.14.
 */
public class FragmentA extends Fragment implements View.OnClickListener{

    Button button;
    int counter=0;

    // access a l'interface
    Communicator comm;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState==null)
        {
            counter=0;
        }
        else
        {
          counter= savedInstanceState.getInt("counter",0);
        }
    }

    // liaison du layout avec la classe Java
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_a,container,false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        button= (Button) getActivity().findViewById(R.id.button);

        //creation de la reference a la classe mainActivity contenant
        // la méthode de l'interface implémentée
        comm = (Communicator) getActivity();

        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        counter++;
        comm.respond("The button was clicked"+counter+"time");

    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        outState.putInt("counter",counter);
        super.onSaveInstanceState(outState);
    }
}
