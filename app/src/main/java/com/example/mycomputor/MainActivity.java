package com.example.mycomputor;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.math.BigDecimal;


public class MainActivity extends AppCompatActivity {
    private Button button_1=null;
    private Button button_2=null;
    private Button button_3=null;
    private Button button_4=null;
    private Button button_5=null;
    private Button button_6=null;
    private Button button_7=null;
    private Button button_8=null;
    private Button button_9=null;
    private Button button_0=null;
    private Button button_add=null;
    private Button button_sub=null;
    private Button button_mul=null;
    private Button button_div=null;
    private Button button_dot=null;
    private Button button_clear=null;
    private Button button_back=null;
    private Button button_result=null;
    private Button button_two=null;
    private Button button_sixteen=null;
    private String s="";//保存输入的算术表达式
    private EditText t = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button_1=findViewById(R.id.button1);
        button_2=findViewById(R.id.button2);
        button_3=findViewById(R.id.button3);
        button_4=findViewById(R.id.button4);
        button_5=findViewById(R.id.button5);
        button_6=findViewById(R.id.button6);
        button_7=findViewById(R.id.button7);
        button_8=findViewById(R.id.button8);
        button_9=findViewById(R.id.button9);
        button_0=findViewById(R.id.button0);
        button_add=findViewById(R.id.button加);
        button_sub=findViewById(R.id.button减);
        button_mul=findViewById(R.id.button乘);
        button_div=findViewById(R.id.button除);
        button_dot=findViewById(R.id.button小数点);
        button_result=findViewById(R.id.button等于);
        button_clear=findViewById(R.id.button清除);
        button_back=findViewById(R.id.button回退);
        button_two=findViewById(R.id.button二进制);
        button_sixteen=findViewById(R.id.button十六进制);
        t=findViewById(R.id.editText);
        t.setSelection(t.getText().length());
        //为按钮设置监听事件
        button_1.setOnClickListener(listener);
        button_2.setOnClickListener(listener);
        button_3.setOnClickListener(listener);
        button_4.setOnClickListener(listener);
        button_5.setOnClickListener(listener);
        button_6.setOnClickListener(listener);
        button_7.setOnClickListener(listener);
        button_8.setOnClickListener(listener);
        button_9.setOnClickListener(listener);
        button_0.setOnClickListener(listener);
        button_sub.setOnClickListener(listener);
        button_add.setOnClickListener(listener);
        button_mul.setOnClickListener(listener);
        button_div.setOnClickListener(listener);
        button_dot.setOnClickListener(listener);
        button_result.setOnClickListener(listener);
        button_clear.setOnClickListener(listener);
        button_back.setOnClickListener(listener);
        button_two.setOnClickListener(listener);
        button_sixteen.setOnClickListener(listener);
    }
    /*屏幕旋转式调用的方法*/
    /*@Override
    public void onConfigurationChanged(Configuration newConfig)
    {
        super.onConfigurationChanged(newConfig);
        //通过当前切换后的屏幕的方向,设置不同的显示视图,当前屏幕状态是否为数向
        if(newConfig.orientation== Configuration.ORIENTATION_PORTRAIT)
        {
            //当竖屏的时候提示
            //设置当前页面的布局视图为activity_hv.xml
            setContentView(R.layout.activity_main);
        }else if(newConfig.orientation==Configuration.ORIENTATION_LANDSCAPE){
            //当横屏的时候提示横屏
            setContentView(R.layout.activity_main);//设置为横向自定义的屏幕
        }
    }*/


    private View.OnClickListener listener = new View.OnClickListener()
    {
        public void onClick(View v)
        {
            switch(v.getId())
            {
                case R.id.button1:
                    s+=String.valueOf(1);
                    t.setText(s);
                    break;
                case R.id.button2:
                    s+=String.valueOf(2);
                    t.setText(s);
                    break;
                case R.id.button3:
                    s+=String.valueOf(3);
                    t.setText(s);
                    break;
                case R.id.button4:
                    s+=String.valueOf(4);
                    t.setText(s);
                    break;
                case R.id.button5:
                    s+=String.valueOf(5);
                    t.setText(s);
                    break;
                case R.id.button6:
                    s+=String.valueOf(6);
                    t.setText(s);
                    break;
                case R.id.button7:
                    s+=String.valueOf(7);
                    t.setText(s);
                    break;
                case R.id.button8:
                    s+=String.valueOf(8);
                    t.setText(s);
                    break;
                case R.id.button9:
                    s+=String.valueOf(9);
                    t.setText(s);
                    break;
                case R.id.button0:
                    s+=String.valueOf(0);
                    t.setText(s);
                    break;
                case R.id.button加:
                    s=s+"+";
                    t.setText(s);
                    break;
                case R.id.button减:
                    s=s+"-";
                    t.setText(s);
                    break;
                case R.id.button乘:
                    s=s+"*";
                    t.setText(s);
                    break;
                case R.id.button除:
                    s=s+"/";
                    t.setText(s);
                    break;
                case R.id.button小数点:
                    s=s+".";
                    t.setText(s);
                    break;
                case R.id.button清除:
                    s="";
                    t.setText("");
                    break;
                case R.id.button回退:
                    if(s.length()>=1) {
                        s = s.substring(0, s.length() - 1);
                        t.setText(s);
                    }
                    break;
                case R.id.button等于:
                    //result=compute(s);
                    t.setText(compute(s));
                    break;
                case R.id.button二进制:
                    t.setText(DtoB(s));
                    break;
                case R.id.button十六进制:
                    t.setText(DtoH(s));
                    break;
                default:
                    break;
            }
        }
    };
    private String DtoB(String s)
    {
        if(s=="")
            return "输入为空！";
        int num;
        try
        {
            num = Integer.parseInt(s);
        }
        catch(NumberFormatException e)
        {
            return "输入不合理，请输入一个整数！";
        }
        return Integer.toBinaryString(num);
    }
    private String DtoH(String s)
    {
        if(s=="")
            return "输入为空！";
        int num;
        try
        {
            num = Integer.parseInt(s);
        }
        catch(NumberFormatException e)
        {
            return "输入不合理，请输入一个整数！";
        }
        return Integer.toHexString(num);
    }
    private String compute(String s)
    {
        String s1 =s.replace("+","-");
        String[] str = s1.split("-");
        double r1=0;
        //先遍历数组，把里面的乘除结果算出来
        for(String str1:str)
        {
            if(str1.contains("*")||str1.contains("/"))
            {
                double r = 0;
                for(int i =0;i<str1.length();)
                {
                    int count =1;
                    for(int j =i+1;j<str1.length();j++)
                    {
                        char c =str1.charAt(j);
                        if(c=='*'||c=='/')
                        {
                            break;
                        }
                        else
                        {
                            count++;
                        }
                    }
                    //将数字截取出来
                    String s2 =str1.substring(i,i+count);
                    double d = Double.parseDouble(s2);
                    if(i==0)
                    {
                        r = d;
                    }
                    else
                    {
                        char c1 = str1.charAt(i-1);
                        if(c1=='*')
                        {
                            r*=d;
                        }
                        else if(c1=='/')
                        {
                            //如果除数为0
                            if(d == 0)
                                return "错误，除数不能为0！";
                            r/=d;
                        }
                    }
                    i+=count+1;
                }
                s= s.replace(str1,r+"");
            }
        }
        //进行加减运算
        for(int i =0;i<s.length();i++) {
            int count = 1;
            for (int j = i + 1; j < s.length(); j++) {
                char c = s.charAt(j);
                if (c == '+' || c == '-') {
                    break;
                } else {
                    count++;
                }
            }
            String s3 = s.substring(i, i + count);
            double d2 = Double.parseDouble(s3);
            if (i == 0) {
                r1 = d2;
            } else {
                char c = s.charAt(i - 1);
                if (c == '+') {
                    r1 += d2;
                } else if (c == '-') {
                    r1 -= d2;
                }
            }
            i += count;
        }
        BigDecimal bg=new BigDecimal(r1);
        double r2=bg.setScale(8,BigDecimal.ROUND_HALF_UP).doubleValue();
        return String.valueOf(r2);
    }
}

