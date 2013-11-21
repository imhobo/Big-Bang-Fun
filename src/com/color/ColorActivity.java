package com.color;

import java.util.Random;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ColorActivity extends Activity implements OnTouchListener{
    /** Called when the activity is first created. */
	
	 	int i,rand,score=0,flag=0,zeus=0,temp=0,highscore;
	 	Button b1;
		TextView t_timer;
		TextView t_score;
		TextView t_highscore;
		LinearLayout layout,layout2;
		LinearLayout lay,hello;
		MyCounter count=new MyCounter(10000,100);
		SharedPreferences prefs;
		 
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        
        hello=(LinearLayout)findViewById(R.id.hello);
 		hello.setOnTouchListener(this);
 		b1=(Button)findViewById(R.id.button1);
 		t_timer=(TextView)findViewById(R.id.textView1);
 		t_score=(TextView)findViewById(R.id.textView2);
 		t_highscore=(TextView)findViewById(R.id.textView3);
 		layout=(LinearLayout)this.findViewById(R.id.e);
 		layout2=(LinearLayout)this.findViewById(R.id.linearLayout3);
 		prefs = this.getSharedPreferences("highScore", Context.MODE_PRIVATE);
 		highscore = prefs.getInt("highest", 0);
 		t_highscore.setText("High Score = "+highscore);
 		
         b1.setOnClickListener(new OnClickListener() {
 			
 			public void onClick(View v) {
 				// TODO Auto-generated method stub
 				
 				if(temp<2700)
 				{
 					score=0;
 					zeus=0;
 				}
 				
 				temp=0;
 				flag=1;
 				
 				t_score.setText("Your Score = "+score);
 				
 				hello.setBackgroundColor(0x00000000);	
				hello.invalidate();
				
 				layout2.setBackgroundResource(R.drawable.fabric);
 				layout2.invalidate();
 				layout.setBackgroundResource(R.drawable.wood);
 				layout.invalidate();
 				
 				t_timer.setTextColor(0xFF000000);
 				t_score.setTextColor(0xFF000000);
 				t_highscore.setTextColor(0xFF000000);

 				
 				count.start();
 				
 				
 				game();
 			}
 		});
 		
       
    
        }


		public void game() 
        {
        	
			
			zeus++;
			
			
        	layout=(LinearLayout)findViewById(R.id.a);
            layout.setBackgroundColor(0x00000000);	
            layout.invalidate();
            layout=(LinearLayout)this.findViewById(R.id.b);
            layout.setBackgroundColor(0x00000000);	
            layout.invalidate();
            layout=(LinearLayout)this.findViewById(R.id.c);
            layout.setBackgroundColor(0x00000000);	
            layout.invalidate();
            layout=(LinearLayout)this.findViewById(R.id.d);
            layout.setBackgroundColor(0x00000000);	
            layout.invalidate();
          
            
            Random random=new Random();
            rand=random.nextInt(4);
            
           
           
            
            
            if(rand==0)
            {
            	layout=(LinearLayout)this.findViewById(R.id.a);
               
               
            }	
          
            else if(rand==1)
            {
            	layout=(LinearLayout)this.findViewById(R.id.b);
                
               
            }
            else if(rand==2)
            {
            	layout=(LinearLayout)this.findViewById(R.id.c);
                
               
            }
            else
            {
            	layout=(LinearLayout)this.findViewById(R.id.d);
                
                
            }
            
            if(zeus==1)
            	 layout.setBackgroundResource(R.drawable.sheldon);
            if(zeus==2)
            	layout.setBackgroundResource(R.drawable.leonard);
            if(zeus==3)
            	layout.setBackgroundResource(R.drawable.howard);
            if(zeus==4)
            	{layout.setBackgroundResource(R.drawable.raj);
            	zeus=0;
            	}
           
            layout.invalidate();
        	
        	
        }




		public boolean onTouch(View v, MotionEvent event) {
			// TODO Auto-generated method stub
			
			if(flag==0)
			return false;
			
			
			
			
			LinearLayout hello=(LinearLayout)findViewById(R.id.a);
			LinearLayout hello2=(LinearLayout)findViewById(R.id.e);
			
			float x = event.getX();
		    float y = event.getY();
		    float height =hello.getHeight();
		    float width = hello.getWidth();
		    float height2 = hello2.getHeight();
		    
		     
		    // Only process DOWN action, so it responds as soon as the
		    // screen is touched.
		    if (event.getAction()==MotionEvent.ACTION_DOWN)
		    {
		    	if(rand==0&&x<=width&&y<=height)
		    	{
		    		score+=100;
		    		temp+=100;
		    		t_score.setText("Your Score = "+score);
		    		game();
		    		return true;
		    	}
		    	
		    	if(rand!=0&&x<=width&&y<=height)
		    	{
		    		score-=50;
		    		temp-=50;
		    		t_score.setText("Your Score = "+score);
		    		
		    		return true;
		    	}
		    	
		    	if(rand==1&&x>width&&y<=height)
		    	{
		    		score+=100;
		    		temp+=100;
		    		t_score.setText("Your Score = "+score);
		    		game();
		    		return true;
		    	}
		    	
		    	if(rand!=1&&x>width&&y<=height)
		    	{
		    		score-=50;
		    		temp-=50;
		    		t_score.setText("Your Score = "+score);
		    		
		    		return true;
		    	}
		    	
		    	if(rand==2&&x<=width&&y>height&&y<height2)
		    	{
		    		score+=100;
		    		temp+=100;
		    		t_score.setText("Your Score = "+score);
		    		game();
		    		return true;
		    	}
		    	
		    	if(rand!=2&&x<=width&&y>height&&y<height2)
		    	{
		    		
		    		score-=50;
		    		temp-=50;
		    		t_score.setText("Your Score = "+score);
		    		
		    		return true;
		    	}
		    	
		    	if(rand==3&&x>width&&y>=height&&y<height2)
		    	{
		    		score+=100;
		    		temp+=100;
		    		t_score.setText("Your Score = "+score);
		    		game();
		    		return true;
		    	}
		    	
		    	if(rand!=3&&x>width&&y>=height&&y<height2)
		    	{
		    		score-=50;
		    		temp-=50;
		    		t_score.setText("Your Score = "+score);
		    		
		    		return true;
		    	}
		    	
		    	
		    	
		    }
			
			
		    
			
			
			
		
			
			return false;
		}
		
		
		
        
		 class MyCounter extends CountDownTimer{
			
			
			
		    public MyCounter(long millisInFuture, long countDownInterval) {
		        super(millisInFuture, countDownInterval);
		    }

		    @Override
		    public void onFinish() {
		    	
		  
		    	
		    	t_score.setText("Your Score = "+score);
		    	  	
		    	if(temp<2700)
		    	{
		    		 highscore = prefs.getInt("highest", 0);
		    		if(score>=highscore)
		    		{
		    			highScore();
		    		}
		    		
		    	}
		    	
		    	flag=0;
	    		endGame();
		    	
		    }
		    

		    @Override
		    public void onTick(long millisUntilFinished) {
		    	if(millisUntilFinished<10000)
		    		t_timer.setText("00:0"+millisUntilFinished/1000);
		    	else
		    		t_timer.setText("00:"+millisUntilFinished/1000);
		    	
		    }
		    
		
		    
		   
		}

		
		
		 public void endGame()
		 	
		 {
			
			layout2.setBackgroundColor(0x00000000);	
	        layout2.invalidate();
	        layout2=(LinearLayout)this.findViewById(R.id.e);
			layout2.setBackgroundColor(0x00000000);
			layout2.invalidate();
			layout2=(LinearLayout)this.findViewById(R.id.linearLayout3);
			
			layout.setBackgroundColor(0x00000000);	
			layout=(LinearLayout)this.findViewById(R.id.hello);
			
			if(temp<2700)
			layout.setBackgroundResource(R.drawable.game_over);
			else
			layout.setBackgroundResource(R.drawable.level);
			
			layout.invalidate();
			layout=(LinearLayout)this.findViewById(R.id.e);
			
			t_timer.setTextColor(0xFFFFFFFF);
			t_score.setTextColor(0xFFFFFFFF);
			t_highscore.setTextColor(0xFFFFFFFF);
			
			t_highscore.setText("High Score = "+highscore);
		 }
       
		 public void highScore()
		 {
			
			 Editor editor = prefs.edit();
			 editor.putInt("highest", score);
			 editor.commit();	 
			 highscore = prefs.getInt("highest", 0);
		 }
      
      
           
    }
	

