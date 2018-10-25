package my.edu.tarc.lab2intent;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    public static final String REPLY_TAG = "my.edu.tarc.lab2intent.REPLY";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        TextView textViewMessage;
        textViewMessage = findViewById(R.id.textViewMessage);
        //Obtain an instance of the Intent
        Intent intent = getIntent();//who called me?
        if(intent.hasExtra(MainActivity.MESSAGE_TAG)){
            String stringMsg = intent.getStringExtra(MainActivity.MESSAGE_TAG);
            //E.g. int age = intent.getIntExtra("TaG_NAME",0);
            textViewMessage.setText(stringMsg);
        }
    }

    public void sendReply(View view){
        EditText editTextReply;
        editTextReply = findViewById(R.id.editTextReply);
        if(TextUtils.isEmpty(editTextReply.getText())){
            editTextReply.setError(getString(R.string.error_reply));
            return;
        }
        //Create an instance of Intent, put extra to the intent
        //set result to OK
        Intent intent =new Intent();
        String stringReply = editTextReply.getText().toString();
        intent.putExtra(REPLY_TAG, stringReply);
        setResult(RESULT_OK,intent);
        finish();
    }


}
