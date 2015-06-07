package com.lugeek.regular;

import android.app.*;
import android.graphics.*;
import android.os.*;
import android.text.*;
import android.text.style.*;
import android.widget.*;
import java.util.regex.*;

public class MainActivity extends Activity 
{
	EditText e1;
	EditText e2;
	TextView e3;
	Pattern r;
	Matcher m;
	String lines = "";
	String pattern = "";
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
		initView();
    }
	private void initView(){
		e1 = (EditText)findViewById(R.id.e1);
		e2 = (EditText)findViewById(R.id.e2);
		e3 = (TextView)findViewById(R.id.e3);
		e1.addTextChangedListener(new TextWatcher(){

				@Override
				public void beforeTextChanged(CharSequence p1, int p2, int p3, int p4)
				{
					// TODO: Implement this method
				}

				@Override
				public void onTextChanged(CharSequence p1, int p2, int p3, int p4)
				{
					lines = p1.toString();
					process(lines, pattern);
				}

				@Override
				public void afterTextChanged(Editable p1)
				{
					// TODO: Implement this method
				}

			
		});
		e2.addTextChangedListener(new TextWatcher(){

				@Override
				public void beforeTextChanged(CharSequence p1, int p2, int p3, int p4)
				{
					// TODO: Implement this method
				}

				@Override
				public void onTextChanged(CharSequence p1, int p2, int p3, int p4)
				{
					pattern = p1.toString();
					process(lines, pattern);
				}

				@Override
				public void afterTextChanged(Editable p1)
				{
					// TODO: Implement this method
				}


			});
		
	}
	private void process(String mlines, String mpattern){
		if(mlines.equals("")||mpattern.equals("")){
			e3.setText(mlines);
			return;
		}
		SpannableStringBuilder builder = new SpannableStringBuilder(mlines);
		ForegroundColorSpan redSpan = new ForegroundColorSpan(Color.RED);
		
		try{
			r = Pattern.compile(mpattern);
			m = r.matcher(mlines);
			while(m.find()){
				builder.setSpan(redSpan, m.start(), m.end(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
			}
		}catch(Exception e){
			e3.setText(mlines);
		}
		
		
		e3.setText(builder);
	}
}
