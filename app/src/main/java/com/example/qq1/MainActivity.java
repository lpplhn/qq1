package com.example.qq1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;


import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<Msg> msgList=new ArrayList<>();
    private MsgAdapter adapter;
    private RecyclerView recyclerView;
    private EditText inputText;
    private Button send;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initMsgs();
        inputText=findViewById(R.id.input_text);
        send=findViewById(R.id.send);
        recyclerView=findViewById(R.id.msg_recycler_view);
        LinearLayoutManager manager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(manager);
        adapter=new MsgAdapter(msgList);//传进数据
        recyclerView.setAdapter(adapter);
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String content=inputText.getText().toString();
                if(!"".equals(content)){
                    Msg msg=new Msg(content,Msg.TYPE_SENT);
                    msgList.add(msg);
                    adapter.notifyItemInserted(msgList.size()-1);//有新消息后，刷新RecyclerView中显示
                    recyclerView.scrollToPosition(msgList.size()-1);//将RecyclerView定位到最后一行
                    inputText.setText("");//清空输入框中内容
                }
            }
        });
    }
    private void initMsgs(){
        Msg msg1=new Msg("hello guy",Msg.TYPE_RECEIVED);
        msgList.add(msg1);
        Msg msg2=new Msg("hello,who is this?",Msg.TYPE_SENT);
        msgList.add(msg2);
        Msg msg3=new Msg("this is Tom.Nice to meet you!",Msg.TYPE_RECEIVED);
        msgList.add(msg3);
    }
}