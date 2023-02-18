package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

public class calculator_activity extends AppCompatActivity {

    Button b1,b2,b3,b4,b5,b6,b7,b8,b9,b0,bplus,bmul,bminus,bdiv,bmod,bclear,bequal,bback,bdot;
    TextView t1,t2;
    Animation anb;
    String s,op,a,cha,s1;
    double a1,a2,c;
    boolean flago;
    int ind;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calculator);

                flago=false;
                b1=(Button) findViewById(R.id.calc_button_one);
                b2=(Button) findViewById(R.id.calc_button_two);
                b3=(Button) findViewById(R.id.calc_button_three);
                b4=(Button) findViewById(R.id.calc_button_four);
                b5=(Button) findViewById(R.id.calc_button_five);
                b6=(Button) findViewById(R.id.calc_button_six);
                b7=(Button) findViewById(R.id.calc_button_seven);
                b8=(Button) findViewById(R.id.calc_button_eight);
                b9=(Button) findViewById(R.id.calc_button_nine);
                b0=(Button) findViewById(R.id.calc_button_zero);
                bdot=(Button) findViewById(R.id.calc_button_dot);

                bplus=(Button) findViewById(R.id.calc_button_plus);
                bminus=(Button) findViewById(R.id.calc_button_min);
                bmul=(Button) findViewById(R.id.calc_button_mul);
                bdiv=(Button) findViewById(R.id.calc_button_div);
                bmod=(Button) findViewById(R.id.calc_button_mod);
                bclear=(Button) findViewById(R.id.calc_button_ac);
                bequal=(Button) findViewById(R.id.calc_button_equal);
                bback=(Button) findViewById(R.id.calc_button_c);

                t1=(TextView) findViewById(R.id.calc_t2);
                t2=(TextView) findViewById(R.id.calc_t1);



                anb= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.slidedown);



                b1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                            s=t1.getText().toString();
                            s=s+1;
                            t1.setText(s);
                    }
                });
                b2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                            s=t1.getText().toString();
                            s=s+2;
                            t1.setText(s);
                    }
                });
                b3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                            s=t1.getText().toString();
                            s=s+3;
                            t1.setText(s);

                    }
                });
                b4.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                            s=t1.getText().toString();
                            s=s+4;
                            t1.setText(s);
                    }
                });
                b5.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                            s=t1.getText().toString();
                            s=s+5;
                            t1.setText(s);

                    }
                });
                b6.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                            s=t1.getText().toString();
                            s=s+6;
                            t1.setText(s);
                    }
                });
                b7.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                            s=t1.getText().toString();
                            s=s+7;
                            t1.setText(s);
                    }
                });
                b8.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                            s=t1.getText().toString();
                            s=s+8;
                            t1.setText(s);
                    }
                });
                b9.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                            s=t1.getText().toString();
                            s=s+9;
                            t1.setText(s);
                    }
                });
                b0.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                            s=t1.getText().toString();
                            s=s+0;
                            t1.setText(s);
                    }
                });
                bdot.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                            s=t1.getText().toString();
                            if(s.indexOf(".")==-1) {
                                t1.setText(s + ".");
                            }
                    }
                });



                bplus.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        s = t1.getText().toString();
                        if(s.length() > 0) {
                            if (flago == false) {
                                flago = true;
                                op = "plus";
                                a1 = Double.parseDouble(s);
                                t1.setText(s + "+");
                            }
                        }
                    }
                });
                bminus.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        s = t1.getText().toString();
                        if(s.length() > 0) {
                            if (flago == false) {
                                flago = true;
                                op = "minus";
                                a1 = Double.parseDouble(s);
                                t1.setText(s + "-");
                            }
                        }

                    }
                });
                bmul.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        s = t1.getText().toString();
                        if(s.length() > 0) {
                            if (flago == false) {
                                flago = true;
                                op = "mul";
                                a1 = Double.parseDouble(s);
                                t1.setText(s + "x");
                            }
                        }
                    }
                });
                bdiv.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        s = t1.getText().toString();
                        if (s.length() > 0) {
                            if (flago == false) {
                                flago = true;
                                op = "div";
                                a1 = Double.parseDouble(s);
                                t1.setText(s + "/");
                            }
                        }
                    }
                });
                bmod.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        s = t1.getText().toString();
                        if (s.length() > 0) {
                            if (flago == false) {
                                flago = true;
                                op = "mod";
                                a1 = Double.parseDouble(s);
                                t1.setText(s + "%");
                            }
                        }
                    }
                });



                bback.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        s=t1.getText().toString();
                        if((s != null) && (s.length() > 0)) {

                            cha = s.substring(s.length() - 1);
                            if ((cha.equals("+"))||(cha.equals("-"))||(cha.equals("x"))||(cha.equals("/"))||(cha.equals("%"))) {
                                op = "";
                                flago = false;
                            }

                            s = s.substring(0, s.length() - 1);
                            t1.setText(s);
                        }
                    }
                });
                bclear.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        flago=false;
                        t1.setText(null);
                        t2.setText(null);
                        op="";
                    }
                });



                bequal.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View view) {

                        s=t1.getText().toString();
                        String an;
                        if(op=="plus")
                        {
                            ind=s.indexOf("+");
                            a=s.substring(ind+1);
                            if(a.length()>0) {
                                a2 = Double.parseDouble(a);
                                c = a1 + a2;
                                an = Double.toString(c);
                                s1 = t1.getText().toString();
                                t1.startAnimation(anb);
                                t2.setText(s1);
                                t1.setText(an);
                                flago=false;
                                op="";
                            }
                        }
                        else if(op=="minus")
                        {
                            ind=s.indexOf("-");
                            a=s.substring(ind+1);
                            if(a.length()>0) {
                                a2 = Double.parseDouble(a);
                                c = a1 - a2;
                                an = Double.toString(c);
                                s1 = t1.getText().toString();
                                t1.startAnimation(anb);
                                t2.setText(s1);
                                t1.setText(an);
                                flago=false;
                                op="";
                            }
                        }
                        else if(op=="mul")
                        {
                            ind=s.indexOf("x");
                            a=s.substring(ind+1);
                            if(a.length()>0) {
                                a2 = Double.parseDouble(a);
                                c = a1 * a2;
                                an = Double.toString(c);
                                s1 = t1.getText().toString();
                                t1.startAnimation(anb);
                                t2.setText(s1);
                                t1.setText(an);
                                flago=false;
                                op="";
                            }
                        }
                        else if(op=="div")
                        {
                            ind=s.indexOf("/");
                            a=s.substring(ind+1);
                            if(a.length()>0) {
                                a2 = Double.parseDouble(a);
                                c = a1 / a2;
                                an = Double.toString(c);
                                s1 = t1.getText().toString();
                                t1.startAnimation(anb);
                                t2.setText(s1);
                                t1.setText(an);
                                flago=false;
                                op="";
                            }
                        }
                        else if(op=="mod")
                        {
                            ind=s.indexOf("%");
                            a=s.substring(ind+1);
                            if(a.length()>0) {
                                a2 = Double.parseDouble(a);
                                c = a1 % a2;
                                an = Double.toString(c);
                                s1 = t1.getText().toString();
                                t1.startAnimation(anb);
                                t2.setText(s1);
                                t1.setText(an);
                                flago=false;
                                op="";
                            }
                        }
                        else if (s.length()==0)
                        {
                            t1.setText("0");
                        }
                        else {
                            s1=t1.getText().toString();
                            t1.startAnimation(anb);
                            t2.setText(s1);
                        }
                    }
                });
    }
}
