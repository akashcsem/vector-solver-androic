package com.example.akash.vector;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;


public class Vector_Calculation extends ActionBarActivity {

   // String helpString = "";
    String Avector = "";
    String Bvector = "";
    String Root = "";
    double root;
    int Option;
    int a, b, c, total;
    int ax, ay, az, bx, by, bz;

    // String Formate    String.format("%.2f", root);

    EditText ax_1;
    EditText ay_1;
    EditText az_1;
    EditText bx_1;
    EditText by_1;
    EditText bz_1;
    TextView level1;
    TextView lebel2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vector__calculation);

        Option = Integer.parseInt(getIntent().getStringExtra("option").toString());

        ax_1 = (EditText)findViewById(R.id.ax1);
        ay_1 = (EditText)findViewById(R.id.ay1);
        az_1 = (EditText)findViewById(R.id.az1);
        bx_1 = (EditText)findViewById(R.id.bx1);
        by_1 = (EditText)findViewById(R.id.by1);
        bz_1 = (EditText)findViewById(R.id.bz1);
        level1 = (TextView)findViewById(R.id.level1);
        lebel2 = (TextView)findViewById(R.id.level2);

        if (Option == 5) {
            bx_1.setVisibility(View.GONE);
            by_1.setVisibility(View.GONE);
            bz_1.setVisibility(View.GONE);
            lebel2.setVisibility(View.GONE);
        }
        if (Option == 6) {
            ax_1.setVisibility(View.GONE);
            ay_1.setVisibility(View.GONE);
            az_1.setVisibility(View.GONE);
            level1.setVisibility(View.INVISIBLE);
        }
    }


    public void calculation(View v) {

        Option = Integer.parseInt(getIntent().getStringExtra("option").toString());
        inputValue();
        Intent intent = new Intent(this, Solve_Process_1.class);
        if(Option != 6)
            intent.putExtra("Avector", for_cros(ax, ay, az));
        if(Option != 5 )
            intent.putExtra("Bvector", for_cros(bx, by, bz));



        //CONDITION APPLY HERE
        if (Option == 1)
            intent.putExtra("resultAB", dotVector(1));
        else if (Option == 2)
            intent.putExtra("resultAB", dotVector(2));
        else if (Option == 3)
            intent.putExtra("resultAB", equalsDotVector());
        else if (Option == 4)
            intent.putExtra("resultAB", addVector());
        else if (Option == 8)
            intent.putExtra("resultAB", subVector(1));
        else if (Option == 9)
            intent.putExtra("resultAB", subVector(2));
        else if (Option == 7)
            intent.putExtra("resultAB", equalsSubVector());
        else if (Option == 5)
            intent.putExtra("resultAB", modeAB("A", ax, ay, az));
        else if (Option == 6)
            intent.putExtra("resultAB", modeAB("B", bx, by, bz));
        else if (Option == 10)
            intent.putExtra("resultAB", crossVector(1));
        else if (Option == 11)
            intent.putExtra("resultAB", crossVector(2));
        else if (Option == 12)
            intent.putExtra("resultAB", mode_crosgunon(1));
        else if (Option == 13)
            intent.putExtra("resultAB", mode_crosgunon(2));
        else if (Option == 14)
            intent.putExtra("resultAB", equals_mode_crosgunon());
        else if (Option == 15)
            intent.putExtra("resultAB", eata());
        else if (Option == 16)
            intent.putExtra("resultAB", modAB());
        else if (Option == 17)
            intent.putExtra("resultAB", ovikkhepAB(1));
        else if (Option == 18)
            intent.putExtra("resultAB", ovikkhepAB(2));
        else if (Option == 19)
            intent.putExtra("resultAB", angle_of_AB());
        else if (Option == 20)
            intent.putExtra("resultAB", okkher_sathe_utponno_kon());
        else if (Option == 21)
            intent.putExtra("resultAB", somantoral_ekok_vector());
        else if (Option == 22)
            intent.putExtra("resultAB", modulas_of_AB());
        else if (Option == 23)
            intent.putExtra("resultAB", ab_er_dik_borabor_ekok_vector('a'));
        else if (Option == 24)
            intent.putExtra("resultAB", ab_er_dik_borabor_ekok_vector('b'));
        else if (Option == 25)
            intent.putExtra("resultAB", upangshoAB('a'));
        else if (Option == 26)
            intent.putExtra("resultAB", upangshoAB('b'));
        startActivity(intent);
    }

    // METHOD FOR GET INPUT VALUE FROM EDIT TEXT
    private void inputValue() {
        if (Option != 6) {
            ax_1 = (EditText) findViewById(R.id.ax1);
            ay_1 = (EditText) findViewById(R.id.ay1);
            az_1 = (EditText) findViewById(R.id.az1);
            ax = Integer.parseInt(ax_1.getText().toString());
            ay = Integer.parseInt(ay_1.getText().toString());
            az = Integer.parseInt(az_1.getText().toString());
        }


        if (Option != 5) {
            bx_1 = (EditText) findViewById(R.id.bx1);
            by_1 = (EditText) findViewById(R.id.by1);
            bz_1 = (EditText) findViewById(R.id.bz1);
            bx = Integer.parseInt(bx_1.getText().toString());
            by = Integer.parseInt(by_1.getText().toString());
            bz = Integer.parseInt(bz_1.getText().toString());
        }
    }

    // METHOD FOR CALCULATE A VECTOR DOT B VECTOR A.B = ?  OPTION - 01
    String dotVector(int x) {
        String getString = "";
        String str = " A . B ";
        if(x==2)    str = " B . A ";
        swap(x);
        a = ax * bx;
        b = ay * by;
        c = az * bz;

        total = a + b + c;
        getString += str + "=  ( ";
        getString += display_AB(ax, ay, az);
        getString += ") . (";
        getString += display_AB(bx, by, bz);
        getString += ")";
        getString += "\n\n\t       =  (" + ax + " * " + bx + ") + (" + ay + " * " + by + ") + (" + az + " * " + bz + ")";
        getString += "\n\n\t       =  " + a;

        if (b >= 0)
            getString += " + " + b;
        else
            getString += " - " + -b;


        if (c >= 0)
            getString += " + " + c;
        else
            getString += " - " + -c;

        getString += "\n   .\n .   ." + str;
        if (total >= 0)
            getString += "=  " + total;
        else
            getString += "=  - " + -total;

        return getString;
    }

    // METHOD FOR CHECK A.B EQUALS B.A OR NOT
        String equalsDotVector() {
            String getString = "\n";
            getString += dotVector(1);
            getString += "\n\n";
            getString += dotVector(2);
            getString += "\n\nঅতএব A . B = B . A\n\n [নোটঃ মনে রাখবেন A.B ভেক্টর সবময়ই B.A ভেক্টরের সমান হবে]\n\n";
            return getString;
        }

    // METHOD FOR CALCULATE A VECTOR CROSS B VECTOR AxB = ?  OPTION - 02
    String crossVector(int x) {

        String str = " A x B ";
        if(x == 2) str = "B x A ";
        swap(x);
        String getString = "";

        getString += "\n                |    i     j    k  | \n";
        getString += str + " =  | ";

        getString += show_AB2(ax, ay, az);
        getString += "  |";
        getString += "\n                | ";

        getString += show_AB2(bx, by, bz);
        getString += "  |";

        getString += "\n\n   =  i * (" + ay + " * " + bz + "  -  " + by + " * " + az + ") + j * (" + bx + " * " + az + "  -  " + ax + " * " + bz + ") \n\t    + k * (" + ax + " * " + by + "  -  " + bx + " * " + ay + ")";
        getString += "\n\n   =  i * (" + ay * bz + "  -  " + by * az + ") + j * (" + bx * az + "  -  " + ax * bz + ") + k * (" + ax * by + "  -  " + bx * ay + ")";

        a = ay * bz - by * az;
        b = bx * az - ax * bz;
        c = ax * by - bx * ay;

        getString += "\n\n    .\n   . .";
        getString += str + "=";

        getString += for_cros(a, b, c);
        getString += "\n\n";
        return getString;
    }

    // METHOD FOR CALCULATE A VECTOR ADD B VECTOR A+B = ?  OPTION - 03
    String addVector() {
        a = ax + bx;
        b = ay + by;
        c = az + bz;
        String getString = "";
        getString += "\nA + B  =  ( ";

        getString += display_AB(ax, ay, az);
        getString += " ) + ( ";
        getString += display_AB(bx, by, bz);
        getString += " )";

        if (bx >= 0)
            getString += "\n\n\t    =  (" + ax + " + " + bx + ")i";
        else
            getString += "\n\n\t    =  (" + ax + " - " + -bx + ")i";

        if (by >= 0)
            getString += " + (" + ay + " + " + by + ")j";
        else
            getString += " + (" + ay + " - " + -by + ")j";

        if (bz >= 0)
            getString += " + (" + az + " + " + bz + ")k";
        else
            getString += " + (" + az + " - " + -bz + ")k";

        getString += "\n\n  .\n.   . A + B  =";
        getString += for_cros(a, b, c);
        return getString;
    }

    // METHOD FOR CALCULATE A VECTOR SUB B VECTOR A-B = ?  OPTION - 04
    String subVector(int x) {

        String str = " A - B ";
        if(x == 2) str = " B - A ";
        swap(x);
        a = ax - bx;
        b = ay - by;
        c = az - bz;

        String getString = "";

        getString += "\n      " + str + "=  ( ";
        getString += display_AB(ax, ay, az);
        getString += " ) - ( ";
        getString += display_AB(bx, by, bz);
        getString += " )";

        if (bx >= 0)
            getString += "\n\n\t           =  (" + ax + " - " + bx + ")i";
        else
            getString += "\n\n\t           =  (" + ax + " + " + -bx + ")i";

        if (by >= 0)
            getString += " + (" + ay + " - " + by + ")j";
        else
            getString += " + (" + ay + " + " + -by + ")j";

        if (bz >= 0)
            getString += " + (" + az + " - " + bz + ")k";
        else
            getString += " + (" + az + " + " + -bz + ")k";

        getString += "\n  .\n.   ." + str + "=";
        getString += for_cros(a, b, c);
        return getString;
    }

    String equalsSubVector() {
        String getString = "";
        getString += subVector(1);
        getString += "\n" + subVector(2) + "\n\n";
        if(ax-bx == bx-ax && ay-by == by-ay && az-bz == bz-az)
            getString += "ভেক্টরদয়ের বিয়োগফল পরস্পর সমান, অতএব A-B = B-A";
        else getString += "ভেক্টরদয়ের বিয়োগফল পরস্পর সমান নয়";
        getString += "\n";
        return getString;
    }
    // METHOD FOR CALCULATE MOD A VECTOR  | A | = ?
    String modeAB(String ch, int ax, int ay, int az) {

        String getString = "\n";
        if(ch == "A" || ch == "B")
            getString += "                  __________________";
        else
            getString += "                          _________________";
        getString += "\n  | " + ch + " |  =  \\/ (" + ax + superscript("2") + " + " + ay + superscript("2") + " + " + az + superscript("2") + ")";

        getString += "\n                 ______________";
        getString += "\n          =  \\/ " + ax*ax + " + " + ay*ay + " + " + az*az;

        getString += "\n                  _____";
        getString += "\n          =  \\/ " + (ax * ax + ay * ay + az * az);
        root = Math.sqrt(ax * ax + ay * ay + az * az);

        Root = String.format("%.2f", root);
        getString += "\n   .\n.    .";
        getString += "  | " + ch + " | = " + Root;

        getString += " \n";
        return getString;
    }

    // METHOD FOR CALCULATE MOD AxB VECTOR  | A x B | = ?
    String mode_crosgunon(int x) {
        String str = "A x B";
        if(x==2) str = "B x A";
        String getString = "";
        getString += crossVector(x);
        getString += modeAB(str, a, b, c);
        return getString;
    }

    String equals_mode_crosgunon() {
        String getString = "";
        getString += mode_crosgunon(1);
        double x = root;
        getString += "\n\n" + mode_crosgunon(2);
        if (x == root)
            getString += "\n ভেক্টর দুটির মান পরস্পর সমান। অর্থাৎ |AxB| = |BxA|";
        else getString += "\n ভেক্টর দুটির মান সমান নয়।";
        return getString;
    }

    // METHOD FOR CALCULATE MOD AxB VECTOR  (A x B) / | A x B | = ?
    String eata() {
        String getString = "";
        getString += mode_crosgunon(1);
        getString += "\n\n  .                                     A X B\n";
        getString += ".   . একক ভেক্টর " + "\u019E" + "  =  ----------------------\n";
        getString += "                                       | A X B |\n\n";

        getString += "                      " + for_cros(a, b, c);
        getString += "\n             = ± ------------------------------------\n";
        getString += "                             " + Root;
        return getString;
    }

    // METHOD FOR CALCULATE MOD AB VECTOR  (AB) = ?
    String modAB() {

        String getString = "";
        getString += subVector(2);
        getString += "\n\n\n | AB | =  | B - A |\n";
        getString += modeAB("AB", a, b, c);
        return getString;
    }

    // METHOD FOR CALCULATE A ভেক্টরের উপর B ভেক্টরের এবং B ভেক্টরের উপর A ভেক্টরের লম্ব অভিক্ষেপ
    String ovikkhepAB(int x) {
        String getString = "\n";
        getString += dotVector(1) + "\n";

        if(x == 2)
            getString += modeAB("B", bx, by, bz);
        else
            getString += modeAB("A", ax, ay, az);
        getString += ovikkhep(x);
        return getString;
    }

    // দুটি ভেক্টরের মধ্যকার অন্তর্ভুক্ত কোণ নির্ণয় করার মেথড
    String angle_of_AB() {
        double root1, root2, total2, theata;
        String Root1, Root2;
        String theta;
        String getString = "\n";

        getString += dotVector(1) + "\n\n";
        getString += modeAB("A", ax, ay, az) + "\n\n";
        root1 = root;       Root1 = Root;
        getString += modeAB("B", bx, by, bz) + "\n\n";
        root2 = root;       Root2 = Root;

        getString += "এখন, A . B = |A| |B| cos(ᶿ) ";
        getString += "\n\n=> |A| |B| cos(ᶿ) = A.B";
        getString += "\n\n\t\t\t          A.B\n=> cos(ᶿ) = -----------------\n\t\t\t         |A||B|";
        getString += "\n\n\t\t\t\t\t      " + total + "\n\t\t\t  = ---------------------------\n\t\t\t         " + Root1 + " x " + Root2;

        total2 = total / (root1*root2);
        theta = String.format("%.2f", total2);
        getString += "\n   .\n .    . cos(ᶿ)  =  " + theta;
        getString += "\n\nand  ᶿ = cos^-1(" + theta + ")";
        theata = Math.acos(total2)*180/3.14;
        theta = String.format("%.2f", theata);
        getString += "\n   .\n .    . ᶿ  =  " + theta + "\n";
        return getString;
    }



///  OKKHER SATHE J KONGULI UTPONNO KORE

    String okkher_sathe_utponno_kon() {
        String getString = "";
        getString += modeAB("A", ax, ay, az);
        getString += help_okkher_sathe_utponno_kon('i');
        getString += help_okkher_sathe_utponno_kon('j');
        getString += help_okkher_sathe_utponno_kon('k');
        return getString;
    }

    String help_okkher_sathe_utponno_kon(char ch) {

        String getString = "";
        double A = Math.sqrt(ax*ax + ay*ay + az*az);
        String str = String.format("%.2f", A);
        int Ax;
        String AX;
        if(ch == 'i') {
            AX = "ax";
            Ax =  ax;
        } else if(ch == 'j') {
            AX = "ay";
            Ax =  ay;
        } else {
            AX = "az";
            Ax =  az;
        }
        getString += "\n  আমরা জানি, "+ ch + " অক্ষের সাথে উৎপন্ন কোণ,";
        getString += "\n                 " + AX;
        getString += "\n    ᶿ" + ch + " = ----------------";
        getString += "\n                | A |\n";
        getString += "\n                  " + Ax;
        getString += "\n         = ----------------";
        getString += "\n               " + str;
        getString += "\n         = " + String.format("%.2f", Ax/A);
        getString += "\n\n";
        return  getString;
    }

    String somantoral_ekok_vector() {

        String getString = "";
        getString += addVector();
        getString += "\n";
        getString += modeAB("A + B", ax+bx, ay+by, az+bz);
        getString += "\n\n আমরা জানি লব্ধি ভেক্টরের সমান্তরাল একক ভেক্টর ";

        getString += "\n          A + B  ";
        getString += "\n  = -------------------";
        getString += "\n        | A + B |";

        getString += "\n\n       " + for_cros(ax+bx, ay+by, az+bz);
        getString += "\n  = -----------------------------";
        getString += "\n             " + Root + "\n\n";
        return getString;
    }

    String modulas_of_AB() {
        String getString = "";
        getString += "\n আমরা জানি, AB  = B - A\n";
        getString += "\n    .";
        getString += "\n .     . | AB | = | B - A | \n";
        getString += subVector(2);
        getString += "\n" + modeAB("B - A", bx-ax, by-ay, bz-az);
        return getString;
    }

    String ab_er_dik_borabor_ekok_vector(char ch) {

        String option = "A";
        if(ch == 'b')
            option = "B";
        String getString = "";
        if(ch == 'a')
         getString += "\n" + modeAB(option, ax, ay, az);
        else getString += "\n" + modeAB(option, bx, by, bz);
        getString += "\n" + option + " এর দিক বরাবর একক ভেক্টর  " + ch;
        getString += "\n\n                      " + option;
        getString += "\n           " + ch + " = -----------\n";
        getString += "                   | " + option + " |\n\n";

        getString += "                    ";
        if (ch == 'a')  getString += display_AB(ax, ay, az);
        else            getString += display_AB(bx, by, bz);
        getString += "\n           " + ch + " = ------------------------\n";
        getString += "                          " + Root;
        getString += "\n";
        return getString;
    }

    String upangshoAB(char ch) {

        String str, str2;
        if(ch == 'a')  {  str = "A";    str2 = "B"; }
        else           {  str = "B";    str2 = "A"; }
        String getString = "";

        getString += ab_er_dik_borabor_ekok_vector(ch);
        getString += "\n\n"+ str +" এর দিক বরাবর " + str2 +" এর উপাংশ = ("+ str2 +" . "+ ch +") "+ ch;

        getString += "\n                                (";
        if(ch == 'a')   getString += display_AB(ax, ay, az);
        else            getString += display_AB(bx, by, bz);
        getString += ")\n  = {(";
        if(ch == 'a')   getString += display_AB(bx, by, bz);
        else            getString += display_AB(ax, ay, az);
        getString += ") . ---------------------------} . "+ ch;
        getString += "\n                                      ";
        getString += Root;
        getString += "\n           ";
        getString += ax*bx;
        if(ay*by<0) getString += " - "+ -ay*by;
        else        getString += " + "+ ay*by;
        if(az*bz<0) getString += " - "+ -az*bz;
        else        getString += " + "+ az*bz;
        getString += "\n  = (---------------------------)."+ ch;
        getString += "\n             "+ Root;
        getString += "\n\n            "+ (ax*bx + ay*by + az*bz);
        getString += "\n  = (---------------)."+ ch;
        getString += "\n         "+ Root+ "\n\n";
        return getString;
    }







    //              FOR HELP THESE FOUR METHOD
    //     METHOD FOR SWAPPING A TO B
    void swap(int chooseAB) {
        if (chooseAB == 2) {
            int temp;
            temp = ax;
            ax = bx;
            bx = temp;
            temp = ay;
            ay = by;
            by = temp;
            temp = az;
            az = bz;
            bz = temp;
        }
    }

    // HELP METHOD FOR OVIKKHEP AB
    String ovikkhep(int x) {

        String getString = "";
        getString += "\n\n  .";

        if(x == 2)
            getString += "\n.    . B ভেক্টরের উপর A ভেক্টরের \n\n";
        else
            getString += "\n.    . A ভেক্টরের উপর B ভেক্টরের \n\n";
        getString += "                                 A . B \n";
        getString += " লম্ব অভিক্ষেপ =  ----------------\n\t\t\t                  | ";
        if (x == 2)
            getString += "B";
        else
            getString += "A";
        getString += " |\n\n\t                    ";

        if(total >= 0)
            getString += "  " + total;
        else
            getString += " - " + -total;

        getString += "\n\t\t         = -------------\n\t\t\t\t      " + Root;
        getString += "\n\n\t\t         =   " + String.format("%.2f", total/root);

        return getString;
    }

    // METHOD FOR DISPLAY A VECTOR AND B VECTOR                  THAT WAS show_A() and show_B()
    String display_AB(int ax, int ay, int az) {

        String getString = "";
        if (ax == 1)
            getString += "i ";
        else if (ax == -1)
            getString += "- i ";
        else if (ax > 1)
            getString += ax + "i ";
        else if (ax < -1)
            getString += "- " + -ax + "i ";

        if (ax == 0) {
            if (ay == 1)
                getString += "j ";
            else if (ay == -1)
                getString += "- j ";
            else if (ay > 1)
                getString += " + " + ay + "j ";
            else if (ay < -1)
                getString += " - " + -ay + "j ";
        } else {
            if (ay == 1)
                getString += "+ j ";
            else if (ay == -1)
                getString += "- j ";
            else if (ay > 1)
                getString += "+ " + ay + "j ";
            else if (ay < -1)
                getString += "- " + -ay + "j ";
        }


        if (ax == 0 && ay == 0) {
            if (az == 1)
                getString += "k";
            else if (az == -1)
                getString += "- k";
            else if (az > 1)
                getString += "+ " + az + "k";
            else if (az < -1)
                getString += "- " + -az + "k";
        } else {

            if (az == 1)
                getString += "+ k";
            else if (az == -1)
                getString += "- k";
            else if (az > 1)
                getString += "+ " + az + "k";
            else if (az < -1)
                getString += "- " + -az + "k";
        }
        return getString;
    }

    // METHOD FOR DISPLAY A VECTOR AND B VECTOR'S CALCULATION    THAT WAS show_A2() and show_B2()
    String show_AB2(int ax, int ay, int az) {

        String getString = "";
        if (ax >= 1 && ax <= 9)
            getString += "  " + ax;
        else if (ax <= -1 && ax >= -9)
            getString += " " + ax;
        else if (ax >= 10)
            getString += " " + ax;
        else if (ax <= -10)
            getString += "" + ax;
        else
            getString += "  0";


        if (ay >= 1 && ay <= 9)
            getString += "    " + ay;
        else if (ay <= -1 && ay >= -9)
            getString += "   " + ay;
        else if (ay >= 10)
            getString += "   " + ay;
        else if (ay <= -10)
            getString += "  " + ay;
        else
            getString += "    0";


        if (az >= 1 && az <= 9)
            getString += "    " + az;
        else if (az <= -1 && az >= -9)
            getString += "   " + az;
        else if (az >= 10)
            getString += "   " + az;
        else if (ay <= -10)
            getString += "  " + az;
        else
            getString += "    0";

        return getString;
    }

    // METHOD FOR DISPLAY A VECTOR AND B VECTOR             THAT WAS for_cros()
    String for_cros(int a, int b, int c) {

        String getString = "";
        if (a >= 2)
            getString += "  " + a + "i";
        else if (a == 1)
            getString += " i";
        else if (a == -1)
            getString += " -i";
        else if (a == 0)
            getString += "";
        else if (a <= -2)
            getString += " " + a + "i";

        if (b >= 2)
            getString += "  + " + b + "j";
        else if (b == 1)
            getString += " + j";
        else if (b == -1)
            getString += " - j";
        else if (b == 0)
            getString += "";
        else if (b <= -2)
            getString += "  - " + -b + "j";


        if (c >= 2)
            getString += "  + " + c + "k";
        else if (c == 1)
            getString += " + k";
        else if (c == -1)
            getString += " - k";
        else if (c == 0)
            getString += "";
        else if (c <= -2)
            getString += "  - " + -c + "k";
        return getString;
    }

    // METHOD FOR SUPERSCRIPT
    String superscript(String str) {
        str = str.replaceAll("0", "⁰");
        str = str.replaceAll("1", "¹");
        str = str.replaceAll("2", "²");
        str = str.replaceAll("3", "³");
        str = str.replaceAll("4", "⁴");
        str = str.replaceAll("5", "⁵");
        str = str.replaceAll("6", "⁶");
        str = str.replaceAll("7", "⁷");
        str = str.replaceAll("8", "⁸");
        str = str.replaceAll("9", "⁹");
        return str;
    }

    // METHOD FOR SUBSCRIPT
    String subscript(String str) {
        str = str.replaceAll("0", "₀");
        str = str.replaceAll("1", "₁");
        str = str.replaceAll("2", "₂");
        str = str.replaceAll("3", "₃");
        str = str.replaceAll("4", "₄");
        str = str.replaceAll("5", "₅");
        str = str.replaceAll("6", "₆");
        str = str.replaceAll("7", "₇");
        str = str.replaceAll("8", "₈");
        str = str.replaceAll("9", "₉");
        return str;
    }
}


/*


            <TextView
                android:text="১৩. ভেক্টর দুটি লম্ব হলে m বা a এর মান "
                android:layout_width="match_parent"
                android:layout_height="wrap_content"
                android:padding="16dp"
                android:onClick="option13"
                android:layout_margin="3dp"
                android:background="#ffffb1cf"
                android:textColor="#ff141414" />

            <TextView
                android:text="১৪. ভেক্টর দুটি সমান্তরাল হলে m বা a এর মান "
                android:layout_width="match_parent"
                android:layout_height="wrap_content"
                android:padding="16dp"
                android:onClick="option14"
                android:layout_margin="3dp"
                android:background="#ffffb1cf"
                android:textColor="#ff141414" />



 */