package br.com.nicetuber;

import android.os.Bundle;

import br.com.nicetuber.base.BaseActivity;

public class MainActivity extends BaseActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void injectDagger() {

    }

    @Override
    protected int getXmlLayout() {
        return 0;
    }
    
}
