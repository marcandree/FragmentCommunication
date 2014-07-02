package novamobile.ch;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by film on 23.04.14.
 */
public class FragmentB extends Fragment {
    // liaison du layout avec la classe Java

    TextView textView;
    String data;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_b,container,false);
        if(savedInstanceState==null)
        {

        }
        else
        {
            data=savedInstanceState.getString("text");
            TextView myText=(TextView) view.findViewById(R.id.textView);
            myText.setText(data);
        }
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        textView= (TextView) getActivity().findViewById(R.id.textView);
    }

    public void changeText(String data)
    {
        textView.setText(data);

    }

    // on sauve les données dans le cas d'une rotation par exemple

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("text",data);
    }
}
